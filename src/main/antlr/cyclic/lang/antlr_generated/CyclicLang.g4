grammar CyclicLang;

@header{
package cyclic.lang.antlr_generated;
}

file: packageDecl? imports classDecl EOF;

packageDecl: PACKAGE id SEMICOLON;

imports: importDecl*;
importDecl: IMPORT STATIC? id (DOT STAR)? SEMICOLON;

classDecl: annotation* modifiers objectType idPart genericTypeDefs? recordComponents? objectExtends? objectImplements? objectPermits? (LBRACE member* RBRACE | SEMICOLON);

objectExtends: EXTENDS type (COMMA type)*; // interfaces can have many
objectImplements: IMPLEMENTS type (COMMA type)*;
objectPermits: PERMITS type (COMMA type)*;

genericTypeDefs: LESSER genericTypeDef (COMMA genericTypeDef)* GREATER;
genericTypeDef: (IN | OUT)? CLASS? idPart (EXTENDS type)?;

objectType
    : CLASS
    | INTERFACE
    | ENUM
    | AT INTERFACE
    | ANNOTATION
    | RECORD
    | SINGLE
    ;

recordComponents: LPAREN (parameter (COMMA parameter)*)? RPAREN;

member
    : function
    | constructor
    | varDecl SEMICOLON
    | classDecl
    | init
    | SEMICOLON
    ;

constructor: annotation* modifiers idPart LPAREN parameters RPAREN (block | SEMICOLON | DASHARROW statement);
init: STATIC? block;

function: annotation* modifiers genericTypeDefs? type idPart LPAREN parameters RPAREN (functionBlock | functionArrow);

functionBlock: (block | SEMICOLON);
functionArrow: DASHARROW (valueOrStatement);

varDecl: annotation* modifiers typeOrInferred idPart (ASSIGN value | LPAREN arguments RPAREN)?;
parameter: FINAL? type ELIPSES? idPart (ASSIGN value)?;
parameters: (parameter (COMMA parameter)*)?;

block: LBRACE statement* RBRACE;

// to avoid ambiguities between "-> statement" and "-> value;", we need to split "value;" statements from everything else

statement
    : valueStatement SEMICOLON
    | unitStatement
    ;

valueOrStatement
	: value SEMICOLON
	| unitStatement
	;

unitStatement
	: block
    | returnStatement SEMICOLON
    | assertStatement SEMICOLON
    | throwStatement SEMICOLON
    | varDecl SEMICOLON
    | ifStatement
    | whileStatement
    | forStatement
    | foreachStatement
    | doWhileStatement
    | tryStatement
    | switchStatement
    | yieldStatement
    | breakStatement
    | continueStatement
    | ctorCall SEMICOLON
    | SEMICOLON
    ;

valueStatement
	: varAssignment
	| ((value | SUPER) DOT)? call
	| initialisation
	| varIncrement
	;

annotation: AT id (LPAREN (annotationArg (COMMA annotationArg)* | value)? RPAREN)?;
annotationArg: idPart ASSIGN value;

typeOrInferred: type | inferType;

type
    : annotation* rawType (genericTypeUses)?
    | type annotation* LSQUAR RSQUAR
    ;

genericTypeUses: LESSER genericTypeUse (COMMA genericTypeUse)* GREATER;
genericTypeUse: (QUESTION (EXTENDS | SUPER))? type;

rawType
    : primitiveType
    | id
    ;

primitiveType
    : BOOL
    | BYTE
    | SHORT
    | CHAR
    | INT
    | LONG
    | FLOAT
    | DOUBLE
    | VOID
    ;

inferType
    : VAR
    | VAL
    ;

modifiers: modifier*;

value
    : value DOT call                            #functionValue // can't merge due to recursive rules
    | value EXCLAMATION? INSTANCEOF type        #instanceCheckValue
    | array=value LSQUAR index=value RSQUAR     #arrayIndexValue
    | value DOT idPart                          #varValue
    | prefixop value                            #prefixOpValue
    | value postfixop                           #postfixOpValue
    | left=value binaryop? ASSIGN right=value   #inlineAssignValue // can't use varAssignment due to recursive rules
    | left=value binaryop right=value           #binaryOpValue
    | LPAREN value RPAREN                       #parenValue
    | (SUPER DOT)? call                         #functionValue
    | DO statement                              #doValue
    | initialisation                            #initialisationValue
    | switchStatement                           #switchValue
    | id DOT CLASS                              #classValue
    | primitiveType DOT CLASS                   #primitiveClassValue
    | cast                                      #castValue
    | newArray                                  #newArrayValue
    | newListedArray                            #newListedArrayValue
    | THIS                                      #thisValue
    | DECLIT                                    #decLit
    | INTLIT                                    #intLit
    | STRLIT                                    #strLit
    | CHARLIT                                   #charLit
    | BOOLLIT                                   #boolLit
    | NULL                                      #nullLit
    | idPart                                    #varValue
    ;

initialisation: NEW type LPAREN arguments RPAREN;
cast: LPAREN type RPAREN value;
varAssignment: value binaryop? ASSIGN value;
call: idPart LPAREN arguments RPAREN;
ctorCall: (THIS | SUPER) LPAREN arguments RPAREN;
newArray: NEW type LSQUAR value RSQUAR;
newListedArray: NEW type LSQUAR RSQUAR LBRACE (value (COMMA value)*)? RBRACE;

arguments: (value (COMMA value)*)?;

returnStatement: RETURN value?;
assertStatement: ASSERT value (COLON STRLIT)?;
throwStatement: THROW value;

ifStatement: IF LPAREN value RPAREN statement elseStatement?;
elseStatement: ELSE statement;

whileStatement: WHILE LPAREN value RPAREN statement;
forStatement: FOR LPAREN start=statement? cond=value SEMICOLON end=statement? RPAREN action=statement;
foreachStatement: FOR LPAREN FINAL? typeOrInferred idPart COLON value RPAREN statement;
doWhileStatement: DO statement WHILE LPAREN value RPAREN SEMICOLON;

tryStatement: TRY block catchBlock* finallyBlock?;
catchBlock: CATCH LPAREN type idPart RPAREN block;
finallyBlock: FINALLY block;

breakStatement: BREAK /*(idPart)?*/ SEMICOLON;
continueStatement: CONTINUE /*(idPart)?*/ SEMICOLON;

switchStatement: SWITCH LPAREN value RPAREN LBRACE caseClause* defaultClause? RBRACE;
caseClause: CASE value DASHARROW (statement | value SEMICOLON);
defaultClause: DEFAULT DASHARROW (statement | value SEMICOLON);
yieldStatement: YIELD value SEMICOLON;

varIncrement
    : value (PLUSPLUS | MINUSMINUS)
    ;

binaryop
    : SLASH
    | STAR
    | PLUS
    | MINUS
    | PERCENT
    | BITAND
    | BITOR
    | AND
    | OR
    | UP
    | EQUAL
    | INEQUAL
    | GREATEREQ
    | LESSEREQ
    | GREATER
    | LESSER
    | LSHIFT
    | RSHIFT
    | ULSHIFT
    | URSHIFT
    | PASS
    ;

prefixop
    : PLUS
    | MINUS
    | EXCLAMATION
    | PLUSPLUS
    | MINUSMINUS
    ;

postfixop
    : PLUSPLUS
    | MINUSMINUS
    ;

id: idPart (DOT idPart)*;
// contextual keywords are valid identifiers
idPart
    : ID
    | ANNOTATION
    | IN
    | OUT
    | SEALED
    | PERMITS
    ;

modifier
    : PUBLIC
    | STATIC
    | PROTECTED
    | FINAL
    | PRIVATE
    | ABSTRACT
    | SYNCHRONISED
    | NATIVE
    | STRICTFP
    | VOLATILE
    | SEALED
    | NONSEALED
    ;

PROTECTED: 'protected';
PRIVATE: 'private';
PUBLIC: 'public';

SYNCHRONISED: 'synchronised';
ABSTRACT: 'abstract';
NATIVE: 'native';
STATIC: 'static';
FINAL: 'final';

STRICTFP: 'strictfp';
VOLATILE: 'volatile';

INSTANCEOF: 'instanceof';
RETURN: 'return';
ASSERT: 'assert';
NEW: 'new';
THROW: 'throw';

CLASS: 'class';
INTERFACE: 'interface';
ENUM: 'enum';
RECORD: 'record';
SINGLE: 'single';
ANNOTATION: 'annotation';

IMPORT: 'import';
PACKAGE: 'package';
EXTENDS: 'extends';
IMPLEMENTS: 'implements';

THIS: 'this';
SUPER: 'super';

IN: 'in';
OUT: 'out';

SEALED: 'sealed';
PERMITS: 'permits';
NONSEALED: 'non-sealed';

DEFAULT: 'default';
SWITCH: 'switch';
WHILE: 'while';
CASE: 'case';
ELSE: 'else';
FOR: 'for';
DO: 'do';
IF: 'if';

TRY: 'try';
CATCH: 'catch';
FINALLY: 'finally';

BREAK: 'break';
CONTINUE: 'continue';
YIELD: 'yield';

DECLIT: MINUS? DIGIT* DOT DIGIT+ ('f' | 'd')?;
INTLIT: MINUS? DIGIT+ ('f' | 'd' | 'l')?;
STRLIT: QUOTE (ESCAPE_QUOTE | (~[\r\n"]))*? (QUOTE);
CHARLIT: APOSTRAPHE (ESCAPE_APOSTRAPHE | ~[\r\n']) APOSTRAPHE;
BOOLLIT: TRUE | FALSE;
NULL: 'null';

AND: '&&';
OR: '||';
PLUSPLUS: '++';
MINUSMINUS: '--';

BITAND: '&';
BITOR: '|';
UP: '^';

STAR: '*';
SLASH: '/';
PLUS: '+';
MINUS: '-';
PERCENT: '%';
AT: '@';

LSHIFT: '<<';
RSHIFT: '>>';
ULSHIFT: '<<<';
URSHIFT: '>>>';

EQUAL: '==';
INEQUAL: '!=';
GREATEREQ: '>=';
LESSEREQ: '<=';
GREATER: '>';
LESSER: '<';

ASSIGN: '=';
PASS: '|>';

LBRACE: '{';
RBRACE: '}';
LPAREN: '(';
RPAREN: ')';
LSQUAR: '[';
RSQUAR: ']';

COLON: ':';
SEMICOLON: ';';
DOT: '.';
COMMA: ',';
EXCLAMATION: '!';
QUESTION: '?';
ELIPSES: '...';

ESCAPE_QUOTE: '\\"';
QUOTE: '"';
ESCAPE_APOSTRAPHE: '\\\'';
APOSTRAPHE: '\'';

DASHARROW: '->';
EQARROW: '=>'; // Unused

BOOL: 'boolean';
BYTE: 'byte';
SHORT: 'short';
CHAR: 'char';
INT: 'int';
LONG: 'long';
FLOAT: 'float';
DOUBLE: 'double';
VOID: 'void';

VAR: 'var';
VAL: 'val';

TRUE: 'true';
FALSE: 'false';

ID: NONDIGIT (DIGIT | NONDIGIT)*;
DIGIT: [0-9];
NONDIGIT: [a-zA-Z_$£#];

SING_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
WS: [ \n\r\t] -> channel(HIDDEN);

UNMATCHED: . ; //Should make an error
grammar CyclicLang;

file: packageDecl? imports classDecl EOF;

packageDecl: PACKAGE id SEMICOLON;

imports: importDecl*;
importDecl: IMPORT STATIC? id (DOT STAR)? SEMICOLON;

classDecl: modifiers objectType ID objectExtends? objectImplements? (LBRACE annotation* member* RBRACE | SEMICOLON);

objectExtends: EXTENDS type;
objectImplements: IMPLEMENTS type (COMMA type)*;

objectType
    : CLASS
    | INTERFACE
    | ENUM
    | AT INTERFACE
    | RECORD
    | SINGLE
    ;

member
    : function
    | constructor
    | varDecl SEMICOLON
    | classDecl
    | init
    | SEMICOLON
    ;

constructor: modifiers type LPAREN parameters RPAREN (block | SEMICOLON | DASHARROW statement);
init: STATIC? block;

function: modifiers type ID LPAREN parameters RPAREN (functionBlock | functionArrow);

functionBlock: (block | SEMICOLON);
functionArrow: DASHARROW (value SEMICOLON | statement);

varDecl: modifiers type ID (ASSIGN value)?;
parameters: (varDecl (COMMA varDecl)*)?;

block: LBRACE statement* RBRACE;

statement
    : block
    | returnStatement SEMICOLON
    | assertStatement SEMICOLON
    | varDecl SEMICOLON
    | varAssignment SEMICOLON
    | initialisation SEMICOLON
    | ifStatement
    | whileStatement
    | forStatement
    | foreachStatement
    | switchStatement
    | doWhile
    | yieldStatement
    | (value DOT)? call SEMICOLON
    | SEMICOLON
    ;

annotation: AT id;

type
    : annotation* rawType (LESSER type (COMMA type)* GREATER)?
    | type LSQUAR RSQUAR
    ;

rawType
    : INT                      #intType
    | DEC                      #decType
    | BYTE                     #byteType
    | BOOL                     #boolType
    | VOID                     #voidType
    | VAR                      #inferType
    | VAL                      #inferFinalType
    | id                       #idType
    ;

id: ID (DOT ID)*;

modifiers: modifier*;

value
    : left=value binaryop right=value     #binaryOpValue
    | value DOT call                      #functionValue
    | call                                #functionValue
    | value EXCLAMATION? INSTANCEOF type  #instanceCheckValue
    | value DOT ID            #varValue // ID after another value
    | DO statement            #doValue
    | initialisation          #initialisationValue
    | LPAREN value RPAREN     #parenValue
    | varDecl                 #inlineDecleration
    | switchStatement         #switchValue
    | id DOT CLASS            #classValue
    | cast                    #castValue
    | unaryop value           #unaryOpValue
    | newArray                #newArrayValue
    | newListedArray          #newListedArrayValue
    | THIS                    #thisValue
    | DECLIT                  #decLit
    | INTLIT                  #intLit
    | STRLIT                  #strLit
    | BOOLLIT                 #boolLit
    | NULL                    #nullLit
    | ID                      #varValue
    ;

initialisation: NEW type LPAREN arguments RPAREN;
cast: LPAREN type RPAREN value;
varAssignment: value ASSIGN value;
call: ID LPAREN arguments RPAREN;
newArray: NEW type LSQUAR value RSQUAR;
newListedArray: NEW type LSQUAR RSQUAR LBRACE (value (COMMA value)*)? RBRACE;

arguments: (value (COMMA value)*)?;

returnStatement: RETURN value?;
assertStatement: ASSERT value (COLON STRLIT)?;

ifStatement: IF LPAREN value RPAREN statement elseStatement?;
elseStatement: ELSE statement;

whileStatement: WHILE LPAREN value RPAREN statement;
forStatement: FOR LPAREN varDecl SEMICOLON value SEMICOLON value RPAREN statement;
foreachStatement: FOR LPAREN type ID COLON value RPAREN statement;
doWhile: DO block WHILE LPAREN value RPAREN SEMICOLON;

switchStatement: SWITCH LPAREN value RPAREN LBRACE caseClause* defaultClause? RBRACE;
caseClause: CASE value DASHARROW (statement | value SEMICOLON);
defaultClause: DEFAULT DASHARROW (statement | value SEMICOLON);
yieldStatement: YIELD value SEMICOLON;

binaryop
    : SLASH
    | STAR
    | PLUS
    | MINUS
    | PERCENT
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
    | ASSIGN // can't use varAssign as a value because it's left-recursive with value, but its effectively a binary op anyways
    | PASS
    ;

unaryop
    : PLUS
    | MINUS
    | EXCLAMATION
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

CLASS: 'class';
INTERFACE: 'interface';
ENUM: 'enum';
RECORD: 'record';
SINGLE: 'single';

IMPORT: 'import';
PACKAGE: 'package';
EXTENDS: 'extends';
IMPLEMENTS: 'implements';

THIS: 'this';

DEFAULT: 'default';
SWITCH: 'switch';
WHILE: 'while';
YIELD: 'yield';
CASE: 'case';
ELSE: 'else';
FOR: 'for';
DO: 'do';
IF: 'if';

DECLIT: MINUS? DIGIT* DOT DIGIT+ ('f' | 'd')?;
INTLIT: MINUS? DIGIT+ ('f' | 'd')?;
STRLIT: QUOTE (~'"')*? QUOTE;
BOOLLIT: TRUE | FALSE;
NULL: 'null';

AND: '&&';
OR: '||';

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
QUOTE: '"';
DOT: '.';
COMMA: ',';
EXCLAMATION: '!';
QUESTION: '?';

DASHARROW: '->';
EQARROW: '=>'; // Unused

INT: 'int';
DEC: 'float';
BYTE: 'byte';
BOOL: 'boolean';
VOID: 'void';

VAR: 'var';
VAL: 'val';

TRUE: 'true';
FALSE: 'false';

ID: NONDIGIT (DIGIT | NONDIGIT)*;
DIGIT: [0-9];
NONDIGIT: [a-zA-Z_~$£#];

SING_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
WS: [ \n\r\t] -> channel(HIDDEN);
UNMATCHED: . ; //Should make an error
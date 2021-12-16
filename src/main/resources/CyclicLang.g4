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

constructor: modifiers type LPAREN parameters RPAREN (block | DASHARROW statement);
init: STATIC? block;

function: modifiers type id LPAREN parameters RPAREN (functionBlock | functionArrow);

functionBlock: (block | SEMICOLON);
functionArrow: DASHARROW (value SEMICOLON | statement);

varDecl: modifiers type id (ASSIGN value)?;
parameters: (varDecl (COMMA varDecl)*)?;

block: LBRACE statement* RBRACE;

statement
    : block
    | varDecl SEMICOLON
    | varAssignment SEMICOLON
    | returnStatement SEMICOLON
    | assertStatement SEMICOLON
    | initialisation SEMICOLON
    | ifStatement
    | whileStatement
    | forStatement
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
    | varAssignment           #inlineAssignment
    | switchStatement         #switchValue
    | id DOT CLASS            #classValue
    | cast                    #castValue
    | invert                  #inverseValue
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
invert: EXCLAMATION value;
varAssignment: id ASSIGN value;
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
doWhile: DO block WHILE LPAREN value RPAREN SEMICOLON;

switchStatement: SWITCH LPAREN value RPAREN LBRACE caseClause* defaultClause? RBRACE;
caseClause: CASE value DASHARROW (statement | value SEMICOLON);
defaultClause: DEFAULT DASHARROW (statement | value SEMICOLON);
yieldStatement: YIELD value;

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

INTERFACE: 'interface';
SINGLE: 'single';
CLASS: 'class';
ENUM: 'enum';

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

DECLIT: MINUS? DIGIT+? DOT DIGIT+;
INTLIT: MINUS? DIGIT+;
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

EQUAL: '==';
INEQUAL: '!=';
GREATEREQ: '>=';
LESSEREQ: '<=';
GREATER: '>';
LESSER: '<';

ASSIGN: '=';

LBRACE: '{';
RBRACE: '}';
LPAREN: '(';
RPAREN: ')';
LSQUAR: '[';
RSQUAR: ']';

COLON: ':'; // Unused
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
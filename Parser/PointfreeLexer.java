package Parser;

// $ANTLR 3.0.1 Pointfree2.g 2008-07-11 02:47:22

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PointfreeLexer extends Lexer {
    public static final int OPERADOR=6;
    public static final int ID=4;
    public static final int Tokens=25;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int NUM=7;
    public static final int WS=9;
    public static final int NEWLINE=8;
    public static final int OPEQ=5;
    public static final int T10=10;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T15=15;
    public static final int T16=16;
    public static final int T17=17;
    public static final int T18=18;
    public static final int T19=19;
    public PointfreeLexer() {;} 
    public PointfreeLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "Pointfree2.g"; }

    // $ANTLR start T10
    public final void mT10() throws RecognitionException {
        try {
            int _type = T10;
            // Pointfree2.g:3:5: ( ':' )
            // Pointfree2.g:3:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T10

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // Pointfree2.g:4:5: ( ':=' )
            // Pointfree2.g:4:7: ':='
            {
            match(":="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // Pointfree2.g:5:5: ( '--' )
            // Pointfree2.g:5:7: '--'
            {
            match("--"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // Pointfree2.g:6:5: ( '&' )
            // Pointfree2.g:6:7: '&'
            {
            match('&'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // Pointfree2.g:7:5: ( '=' )
            // Pointfree2.g:7:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // Pointfree2.g:8:5: ( '.' )
            // Pointfree2.g:8:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // Pointfree2.g:9:5: ( '(' )
            // Pointfree2.g:9:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // Pointfree2.g:10:5: ( ')' )
            // Pointfree2.g:10:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // Pointfree2.g:11:5: ( '(|' )
            // Pointfree2.g:11:7: '(|'
            {
            match("(|"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // Pointfree2.g:12:5: ( '|)' )
            // Pointfree2.g:12:7: '|)'
            {
            match("|)"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // Pointfree2.g:13:5: ( '[(' )
            // Pointfree2.g:13:7: '[('
            {
            match("[("); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // Pointfree2.g:14:5: ( ')]' )
            // Pointfree2.g:14:7: ')]'
            {
            match(")]"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // Pointfree2.g:15:5: ( '[|' )
            // Pointfree2.g:15:7: '[|'
            {
            match("[|"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // Pointfree2.g:16:5: ( ',' )
            // Pointfree2.g:16:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // Pointfree2.g:17:5: ( '|]' )
            // Pointfree2.g:17:7: '|]'
            {
            match("|]"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start OPEQ
    public final void mOPEQ() throws RecognitionException {
        try {
            int _type = OPEQ;
            // Pointfree2.g:170:9: ( ( '<=>' | '=>' | '<=' ) )
            // Pointfree2.g:170:11: ( '<=>' | '=>' | '<=' )
            {
            // Pointfree2.g:170:11: ( '<=>' | '=>' | '<=' )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='<') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='=') ) {
                    int LA1_3 = input.LA(3);

                    if ( (LA1_3=='>') ) {
                        alt1=1;
                    }
                    else {
                        alt1=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("170:11: ( '<=>' | '=>' | '<=' )", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0=='=') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("170:11: ( '<=>' | '=>' | '<=' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // Pointfree2.g:170:12: '<=>'
                    {
                    match("<=>"); 


                    }
                    break;
                case 2 :
                    // Pointfree2.g:170:20: '=>'
                    {
                    match("=>"); 


                    }
                    break;
                case 3 :
                    // Pointfree2.g:170:27: '<='
                    {
                    match("<="); 


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OPEQ

    // $ANTLR start NUM
    public final void mNUM() throws RecognitionException {
        try {
            int _type = NUM;
            // Pointfree2.g:172:9: ( ( '0' .. '9' )+ )
            // Pointfree2.g:172:11: ( '0' .. '9' )+
            {
            // Pointfree2.g:172:11: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Pointfree2.g:172:12: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NUM

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // Pointfree2.g:174:9: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '+' | '-' | '_' )* )
            // Pointfree2.g:174:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '+' | '-' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // Pointfree2.g:174:33: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '+' | '-' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='+'||LA3_0=='-'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Pointfree2.g:
            	    {
            	    if ( input.LA(1)=='+'||input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start OPERADOR
    public final void mOPERADOR() throws RecognitionException {
        try {
            int _type = OPERADOR;
            // Pointfree2.g:176:10: ( ( '\\\\/' | '/\\\\' | '-|-' | '><' ) )
            // Pointfree2.g:176:12: ( '\\\\/' | '/\\\\' | '-|-' | '><' )
            {
            // Pointfree2.g:176:12: ( '\\\\/' | '/\\\\' | '-|-' | '><' )
            int alt4=4;
            switch ( input.LA(1) ) {
            case '\\':
                {
                alt4=1;
                }
                break;
            case '/':
                {
                alt4=2;
                }
                break;
            case '-':
                {
                alt4=3;
                }
                break;
            case '>':
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("176:12: ( '\\\\/' | '/\\\\' | '-|-' | '><' )", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // Pointfree2.g:176:13: '\\\\/'
                    {
                    match("\\/"); 


                    }
                    break;
                case 2 :
                    // Pointfree2.g:176:21: '/\\\\'
                    {
                    match("/\\"); 


                    }
                    break;
                case 3 :
                    // Pointfree2.g:176:29: '-|-'
                    {
                    match("-|-"); 


                    }
                    break;
                case 4 :
                    // Pointfree2.g:176:37: '><'
                    {
                    match("><"); 


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OPERADOR

    // $ANTLR start NEWLINE
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            // Pointfree2.g:178:9: ( ( '\\r' )? '\\n' )
            // Pointfree2.g:178:11: ( '\\r' )? '\\n'
            {
            // Pointfree2.g:178:11: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Pointfree2.g:178:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            skip();

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NEWLINE

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // Pointfree2.g:180:9: ( ( ' ' | '\\t' )+ )
            // Pointfree2.g:180:12: ( ' ' | '\\t' )+
            {
            // Pointfree2.g:180:12: ( ' ' | '\\t' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Pointfree2.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            skip();

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // Pointfree2.g:1:8: ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | OPEQ | NUM | ID | OPERADOR | NEWLINE | WS )
        int alt7=21;
        switch ( input.LA(1) ) {
        case ':':
            {
            int LA7_1 = input.LA(2);

            if ( (LA7_1=='=') ) {
                alt7=2;
            }
            else {
                alt7=1;}
            }
            break;
        case '-':
            {
            int LA7_2 = input.LA(2);

            if ( (LA7_2=='|') ) {
                alt7=19;
            }
            else if ( (LA7_2=='-') ) {
                alt7=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | OPEQ | NUM | ID | OPERADOR | NEWLINE | WS );", 7, 2, input);

                throw nvae;
            }
            }
            break;
        case '&':
            {
            alt7=4;
            }
            break;
        case '=':
            {
            int LA7_4 = input.LA(2);

            if ( (LA7_4=='>') ) {
                alt7=16;
            }
            else {
                alt7=5;}
            }
            break;
        case '.':
            {
            alt7=6;
            }
            break;
        case '(':
            {
            int LA7_6 = input.LA(2);

            if ( (LA7_6=='|') ) {
                alt7=9;
            }
            else {
                alt7=7;}
            }
            break;
        case ')':
            {
            int LA7_7 = input.LA(2);

            if ( (LA7_7==']') ) {
                alt7=12;
            }
            else {
                alt7=8;}
            }
            break;
        case '|':
            {
            int LA7_8 = input.LA(2);

            if ( (LA7_8==')') ) {
                alt7=10;
            }
            else if ( (LA7_8==']') ) {
                alt7=15;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | OPEQ | NUM | ID | OPERADOR | NEWLINE | WS );", 7, 8, input);

                throw nvae;
            }
            }
            break;
        case '[':
            {
            int LA7_9 = input.LA(2);

            if ( (LA7_9=='|') ) {
                alt7=13;
            }
            else if ( (LA7_9=='(') ) {
                alt7=11;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | OPEQ | NUM | ID | OPERADOR | NEWLINE | WS );", 7, 9, input);

                throw nvae;
            }
            }
            break;
        case ',':
            {
            alt7=14;
            }
            break;
        case '<':
            {
            alt7=16;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt7=17;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt7=18;
            }
            break;
        case '/':
        case '>':
        case '\\':
            {
            alt7=19;
            }
            break;
        case '\n':
        case '\r':
            {
            alt7=20;
            }
            break;
        case '\t':
        case ' ':
            {
            alt7=21;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | OPEQ | NUM | ID | OPERADOR | NEWLINE | WS );", 7, 0, input);

            throw nvae;
        }

        switch (alt7) {
            case 1 :
                // Pointfree2.g:1:10: T10
                {
                mT10(); 

                }
                break;
            case 2 :
                // Pointfree2.g:1:14: T11
                {
                mT11(); 

                }
                break;
            case 3 :
                // Pointfree2.g:1:18: T12
                {
                mT12(); 

                }
                break;
            case 4 :
                // Pointfree2.g:1:22: T13
                {
                mT13(); 

                }
                break;
            case 5 :
                // Pointfree2.g:1:26: T14
                {
                mT14(); 

                }
                break;
            case 6 :
                // Pointfree2.g:1:30: T15
                {
                mT15(); 

                }
                break;
            case 7 :
                // Pointfree2.g:1:34: T16
                {
                mT16(); 

                }
                break;
            case 8 :
                // Pointfree2.g:1:38: T17
                {
                mT17(); 

                }
                break;
            case 9 :
                // Pointfree2.g:1:42: T18
                {
                mT18(); 

                }
                break;
            case 10 :
                // Pointfree2.g:1:46: T19
                {
                mT19(); 

                }
                break;
            case 11 :
                // Pointfree2.g:1:50: T20
                {
                mT20(); 

                }
                break;
            case 12 :
                // Pointfree2.g:1:54: T21
                {
                mT21(); 

                }
                break;
            case 13 :
                // Pointfree2.g:1:58: T22
                {
                mT22(); 

                }
                break;
            case 14 :
                // Pointfree2.g:1:62: T23
                {
                mT23(); 

                }
                break;
            case 15 :
                // Pointfree2.g:1:66: T24
                {
                mT24(); 

                }
                break;
            case 16 :
                // Pointfree2.g:1:70: OPEQ
                {
                mOPEQ(); 

                }
                break;
            case 17 :
                // Pointfree2.g:1:75: NUM
                {
                mNUM(); 

                }
                break;
            case 18 :
                // Pointfree2.g:1:79: ID
                {
                mID(); 

                }
                break;
            case 19 :
                // Pointfree2.g:1:82: OPERADOR
                {
                mOPERADOR(); 

                }
                break;
            case 20 :
                // Pointfree2.g:1:91: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 21 :
                // Pointfree2.g:1:99: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}
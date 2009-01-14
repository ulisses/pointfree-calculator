package Parser;

// $ANTLR 3.0.1 Pointfree2.g 2008-07-11 02:47:22
import Calculador.*;
import Types.*;
import java.util.HashMap;
import java.util.ArrayList;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class PointfreeParser extends Parser {

    public static final String[] tokenNames = new String[]{
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "OPEQ", "OPERADOR", "NUM", "NEWLINE", "WS", "':'", "':='", "'--'", "'&'", "'='", "'.'", "'('", "')'", "'(|'", "'|)'", "'[('", "')]'", "'[|'", "','", "'|]'"
    };
    public static final int WS = 9;
    public static final int NEWLINE = 8;
    public static final int OPEQ = 5;
    public static final int OPERADOR = 6;
    public static final int ID = 4;
    public static final int EOF = -1;
    public static final int NUM = 7;

    public PointfreeParser(TokenStream input) {
        super(input);
        ruleMemo = new HashMap[25 + 1];
    }

    public String[] getTokenNames() {
        return tokenNames;
    }

    public String getGrammarFileName() {
        return "Pointfree2.g";
    }
    private HashMap<Expressao, ArrayList<Expressao>> hm = new HashMap<Expressao, ArrayList<Expressao>>();
    private HashMap<String, ArrayList<String>> params = new HashMap<String, ArrayList<String>>();
    private ArrayList<Regra> ar = new ArrayList<Regra>();
    private ArrayList<String> as = new ArrayList<String>();
    private ArrayList<String> listaNomeConcreta = new ArrayList<String>();
    private boolean eCata = false;
    private int contTipo = 1;

    private void repoem() {
        if (this.eCata) {
            this.eCata = false;
        }
    }

    public ArrayList<String> getListaNomesConcreta() {
        try {
            ArrayList<String> a = new ArrayList<String>();

            for (String s : this.definicoesNome()) {
                if (s != null) {
                    a.add(s);
                }
            }

            return a;
        } catch (Exception e) {
            ;
        }
        return null;
    }

    public ArrayList<Regra> getRegras() {
        try {
            ArrayList<Regra> a = new ArrayList<Regra>();

            for (Regra s : this.regras()) {
                if (s != null) {
                    a.add(s);
                }
            }

            return a;
        } catch (Exception e) {
            ;
        }
        return null;
    }

    public void setDefinicoes(ArrayList<String> ln) {
        this.listaNomeConcreta = ln;
        this.listaNomeConcreta.add("fst");
        this.listaNomeConcreta.add("snd");
        this.listaNomeConcreta.add("inl");
        this.listaNomeConcreta.add("inr");
        this.listaNomeConcreta.add("id");
    }
    // $ANTLR start definicoesNome
    // Pointfree2.g:80:1: definicoesNome returns [ArrayList<String> arr] : d1= definicaoNome (d2= definicaoNome )* ;
    public final ArrayList<String> definicoesNome() throws RecognitionException {
        ArrayList<String> arr = null;

        String d1 = null;

        String d2 = null;


        try {
            // Pointfree2.g:81:9: (d1= definicaoNome (d2= definicaoNome )* )
            // Pointfree2.g:81:11: d1= definicaoNome (d2= definicaoNome )*
            {
                pushFollow(FOLLOW_definicaoNome_in_definicoesNome57);
                d1 = definicaoNome();
                _fsp--;
                if (failed) {
                    return arr;
                }
                if (backtracking == 0) {
                    as.add(d1);
                    arr = as;
                }
                // Pointfree2.g:82:11: (d2= definicaoNome )*
                loop1:
                do {
                    int alt1 = 2;
                    int LA1_0 = input.LA(1);

                    if ((LA1_0 == ID)) {
                        alt1 = 1;
                    }


                    switch (alt1) {
                        case 1:
                            // Pointfree2.g:82:12: d2= definicaoNome
                             {
                                pushFollow(FOLLOW_definicaoNome_in_definicoesNome75);
                                d2 = definicaoNome();
                                _fsp--;
                                if (failed) {
                                    return arr;
                                }
                                if (backtracking == 0) {
                                    as.add(d2);
                                    arr = as;
                                }

                            }
                            break;

                        default:
                            break loop1;
                    }
                } while (true);

                if (backtracking == 0) {
                    arr = as;
                }

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return arr;
    }
    // $ANTLR end definicoesNome
    // $ANTLR start definicaoNome
    // Pointfree2.g:86:1: definicaoNome returns [String as] : (nome= ID ':' conc= ID ':=' e= exp | nome= ID ':' e1= exp OPEQ e2= exp | nome= ID ':' e1= exp );
    public final String definicaoNome() throws RecognitionException {
        String as = null;

        Token nome = null;
        Token conc = null;
        Expressao e = null;

        Expressao e1 = null;

        Expressao e2 = null;


        try {
            // Pointfree2.g:87:9: (nome= ID ':' conc= ID ':=' e= exp | nome= ID ':' e1= exp OPEQ e2= exp | nome= ID ':' e1= exp )
            int alt2 = 3;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1:
                    // Pointfree2.g:87:11: nome= ID ':' conc= ID ':=' e= exp
                     {
                        nome = (Token) input.LT(1);
                        match(input, ID, FOLLOW_ID_in_definicaoNome138);
                        if (failed) {
                            return as;
                        }
                        match(input, 10, FOLLOW_10_in_definicaoNome140);
                        if (failed) {
                            return as;
                        }
                        conc = (Token) input.LT(1);
                        match(input, ID, FOLLOW_ID_in_definicaoNome144);
                        if (failed) {
                            return as;
                        }
                        match(input, 11, FOLLOW_11_in_definicaoNome146);
                        if (failed) {
                            return as;
                        }
                        pushFollow(FOLLOW_exp_in_definicaoNome150);
                        e = exp();
                        _fsp--;
                        if (failed) {
                            return as;
                        }
                        if (backtracking == 0) {
                            as = new String(conc.getText());
                        }

                    }
                    break;
                case 2:
                    // Pointfree2.g:88:11: nome= ID ':' e1= exp OPEQ e2= exp
                     {
                        nome = (Token) input.LT(1);
                        match(input, ID, FOLLOW_ID_in_definicaoNome168);
                        if (failed) {
                            return as;
                        }
                        match(input, 10, FOLLOW_10_in_definicaoNome170);
                        if (failed) {
                            return as;
                        }
                        pushFollow(FOLLOW_exp_in_definicaoNome174);
                        e1 = exp();
                        _fsp--;
                        if (failed) {
                            return as;
                        }
                        match(input, OPEQ, FOLLOW_OPEQ_in_definicaoNome177);
                        if (failed) {
                            return as;
                        }
                        pushFollow(FOLLOW_exp_in_definicaoNome182);
                        e2 = exp();
                        _fsp--;
                        if (failed) {
                            return as;
                        }
                        if (backtracking == 0) {
                            ;
                        }

                    }
                    break;
                case 3:
                    // Pointfree2.g:89:11: nome= ID ':' e1= exp
                     {
                        nome = (Token) input.LT(1);
                        match(input, ID, FOLLOW_ID_in_definicaoNome198);
                        if (failed) {
                            return as;
                        }
                        match(input, 10, FOLLOW_10_in_definicaoNome200);
                        if (failed) {
                            return as;
                        }
                        pushFollow(FOLLOW_exp_in_definicaoNome204);
                        e1 = exp();
                        _fsp--;
                        if (failed) {
                            return as;
                        }
                        if (backtracking == 0) {
                            ;
                        }

                    }
                    break;

            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return as;
    }
    // $ANTLR end definicaoNome
    // $ANTLR start regras
    // Pointfree2.g:92:1: regras returns [ArrayList<Regra> arr] : r1= regra (r2= regra )* ;
    public final ArrayList<Regra> regras() throws RecognitionException {
        ArrayList<Regra> arr = null;

        Regra r1 = null;

        Regra r2 = null;


        try {
            // Pointfree2.g:93:9: (r1= regra (r2= regra )* )
            // Pointfree2.g:93:11: r1= regra (r2= regra )*
            {
                pushFollow(FOLLOW_regra_in_regras251);
                r1 = regra();
                _fsp--;
                if (failed) {
                    return arr;
                }
                if (backtracking == 0) {
                    ar.add(r1);
                    arr = ar;
                }
                // Pointfree2.g:94:11: (r2= regra )*
                loop3:
                do {
                    int alt3 = 2;
                    int LA3_0 = input.LA(1);

                    if ((LA3_0 == ID || LA3_0 == 12)) {
                        alt3 = 1;
                    }


                    switch (alt3) {
                        case 1:
                            // Pointfree2.g:94:12: r2= regra
                             {
                                pushFollow(FOLLOW_regra_in_regras269);
                                r2 = regra();
                                _fsp--;
                                if (failed) {
                                    return arr;
                                }
                                if (backtracking == 0) {
                                    ar.add(r2);
                                    arr = ar;
                                }

                            }
                            break;

                        default:
                            break loop3;
                    }
                } while (true);

                if (backtracking == 0) {
                    arr = ar;
                }

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return arr;
    }
    // $ANTLR end regras
    // $ANTLR start regra
    // Pointfree2.g:97:1: regra returns [Regra r] : ( '--' ( . )* | nome= ID ':' conc= ID ':=' e= exp | nome= ID ':' e1= exp OPEQ e2= exp | nome= ID ':' e1= exp );
    public final Regra regra() throws RecognitionException {
        Regra r = null;

        Token nome = null;
        Token conc = null;
        Token OPEQ1 = null;
        Expressao e = null;

        Expressao e1 = null;

        Expressao e2 = null;


        try {
            // Pointfree2.g:98:9: ( '--' ( . )* | nome= ID ':' conc= ID ':=' e= exp | nome= ID ':' e1= exp OPEQ e2= exp | nome= ID ':' e1= exp )
            int alt5 = 4;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1:
                    // Pointfree2.g:98:11: '--' ( . )*
                     {
                        match(input, 12, FOLLOW_12_in_regra321);
                        if (failed) {
                            return r;
                        // Pointfree2.g:98:16: ( . )*
                        }
                        loop4:
                        do {
                            int alt4 = 2;
                            switch (input.LA(1)) {
                                case 12:
                                     {
                                        int LA4_1 = input.LA(2);

                                        if ((synpred5())) {
                                            alt4 = 1;
                                        }


                                    }
                                    break;
                                case ID:
                                     {
                                        int LA4_2 = input.LA(2);

                                        if ((synpred5())) {
                                            alt4 = 1;
                                        }


                                    }
                                    break;
                                case OPEQ:
                                case OPERADOR:
                                case NUM:
                                case NEWLINE:
                                case WS:
                                case 10:
                                case 11:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                     {
                                        alt4 = 1;
                                    }
                                    break;

                            }

                            switch (alt4) {
                                case 1:
                                    // Pointfree2.g:0:0: .
                                     {
                                        matchAny(input);
                                        if (failed) {
                                            return r;
                                        }
                                    }
                                    break;

                                default:
                                    break loop4;
                            }
                        } while (true);

                        if (backtracking == 0) {
                            ;
                        }

                    }
                    break;
                case 2:
                    // Pointfree2.g:99:11: nome= ID ':' conc= ID ':=' e= exp
                     {
                        nome = (Token) input.LT(1);
                        match(input, ID, FOLLOW_ID_in_regra340);
                        if (failed) {
                            return r;
                        }
                        match(input, 10, FOLLOW_10_in_regra342);
                        if (failed) {
                            return r;
                        }
                        conc = (Token) input.LT(1);
                        match(input, ID, FOLLOW_ID_in_regra346);
                        if (failed) {
                            return r;
                        }
                        match(input, 11, FOLLOW_11_in_regra348);
                        if (failed) {
                            return r;
                        }
                        pushFollow(FOLLOW_exp_in_regra352);
                        e = exp();
                        _fsp--;
                        if (failed) {
                            return r;
                        }
                        if (backtracking == 0) {
                            Expressao esq = new Expressao(new Concreta(conc.getText(), 0, contTipo++, contTipo++));
                            r = new Regra(esq, e, nome.getText(), ":=");

                        }

                    }
                    break;
                case 3:
                    // Pointfree2.g:102:11: nome= ID ':' e1= exp OPEQ e2= exp
                     {
                        nome = (Token) input.LT(1);
                        match(input, ID, FOLLOW_ID_in_regra369);
                        if (failed) {
                            return r;
                        }
                        match(input, 10, FOLLOW_10_in_regra371);
                        if (failed) {
                            return r;
                        }
                        pushFollow(FOLLOW_exp_in_regra375);
                        e1 = exp();
                        _fsp--;
                        if (failed) {
                            return r;
                        }
                        OPEQ1 = (Token) input.LT(1);
                        match(input, OPEQ, FOLLOW_OPEQ_in_regra378);
                        if (failed) {
                            return r;
                        }
                        pushFollow(FOLLOW_exp_in_regra382);
                        e2 = exp();
                        _fsp--;
                        if (failed) {
                            return r;
                        }
                        if (backtracking == 0) {
                            r = new Regra(e1, e2, nome.getText(), OPEQ1.getText());
                        }

                    }
                    break;
                case 4:
                    // Pointfree2.g:103:11: nome= ID ':' e1= exp
                     {
                        nome = (Token) input.LT(1);
                        match(input, ID, FOLLOW_ID_in_regra398);
                        if (failed) {
                            return r;
                        }
                        match(input, 10, FOLLOW_10_in_regra400);
                        if (failed) {
                            return r;
                        }
                        pushFollow(FOLLOW_exp_in_regra404);
                        e1 = exp();
                        _fsp--;
                        if (failed) {
                            return r;
                        }
                        if (backtracking == 0) {
                            r = new Regra(e1.getRamos().get(0), e1.getRamos().get(1), nome.getText(), "=");
                        }

                    }
                    break;

            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return r;
    }
    // $ANTLR end regra
    // $ANTLR start exp
    // Pointfree2.g:105:1: exp returns [Expressao e] : t1= equal ( '&' t2= equal )? ;
    public final Expressao exp() throws RecognitionException {
        Expressao e = null;

        Expressao t1 = null;

        Expressao t2 = null;


        try {
            // Pointfree2.g:106:9: (t1= equal ( '&' t2= equal )? )
            // Pointfree2.g:106:11: t1= equal ( '&' t2= equal )?
            {
                pushFollow(FOLLOW_equal_in_exp449);
                t1 = equal();
                _fsp--;
                if (failed) {
                    return e;
                }
                if (backtracking == 0) {
                    e = t1;
                }
                // Pointfree2.g:107:11: ( '&' t2= equal )?
                int alt6 = 2;
                int LA6_0 = input.LA(1);

                if ((LA6_0 == 13)) {
                    alt6 = 1;
                }
                switch (alt6) {
                    case 1:
                        // Pointfree2.g:107:12: '&' t2= equal
                         {
                            match(input, 13, FOLLOW_13_in_exp469);
                            if (failed) {
                                return e;
                            }
                            pushFollow(FOLLOW_equal_in_exp473);
                            t2 = equal();
                            _fsp--;
                            if (failed) {
                                return e;
                            }
                            if (backtracking == 0) {
                                Expressao ex = new Expressao(new Operador("&", 2), t1, t2);
                                e = ex;

                            }

                        }
                        break;

                }


            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return e;
    }
    // $ANTLR end exp
    // $ANTLR start equal
    // Pointfree2.g:112:1: equal returns [Expressao e] : t1= ops ( '=' t2= ops )? ;
    public final Expressao equal() throws RecognitionException {
        Expressao e = null;

        Expressao t1 = null;

        Expressao t2 = null;


        try {
            // Pointfree2.g:113:9: (t1= ops ( '=' t2= ops )? )
            // Pointfree2.g:113:11: t1= ops ( '=' t2= ops )?
            {
                pushFollow(FOLLOW_ops_in_equal518);
                t1 = ops();
                _fsp--;
                if (failed) {
                    return e;
                }
                if (backtracking == 0) {
                    e = t1;
                }
                // Pointfree2.g:114:11: ( '=' t2= ops )?
                int alt7 = 2;
                int LA7_0 = input.LA(1);

                if ((LA7_0 == 14)) {
                    alt7 = 1;
                }
                switch (alt7) {
                    case 1:
                        // Pointfree2.g:114:12: '=' t2= ops
                         {
                            match(input, 14, FOLLOW_14_in_equal538);
                            if (failed) {
                                return e;
                            }
                            pushFollow(FOLLOW_ops_in_equal542);
                            t2 = ops();
                            _fsp--;
                            if (failed) {
                                return e;
                            }
                            if (backtracking == 0) {
                                Expressao ex = new Expressao(new Operador("=", 2), t1, t2);
                                e = ex;

                            }

                        }
                        break;

                }


            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return e;
    }
    // $ANTLR end equal
    // $ANTLR start ops
    // Pointfree2.g:119:1: ops returns [Expressao e] : t1= apos ( OPERADOR t2= apos )? ;
    public final Expressao ops() throws RecognitionException {
        Expressao e = null;

        Token OPERADOR2 = null;
        Expressao t1 = null;

        Expressao t2 = null;


        try {
            // Pointfree2.g:120:9: (t1= apos ( OPERADOR t2= apos )? )
            // Pointfree2.g:120:11: t1= apos ( OPERADOR t2= apos )?
            {
                pushFollow(FOLLOW_apos_in_ops587);
                t1 = apos();
                _fsp--;
                if (failed) {
                    return e;
                }
                if (backtracking == 0) {
                    e = t1;
                }
                // Pointfree2.g:121:11: ( OPERADOR t2= apos )?
                int alt8 = 2;
                int LA8_0 = input.LA(1);

                if ((LA8_0 == OPERADOR)) {
                    alt8 = 1;
                }
                switch (alt8) {
                    case 1:
                        // Pointfree2.g:121:12: OPERADOR t2= apos
                         {
                            OPERADOR2 = (Token) input.LT(1);
                            match(input, OPERADOR, FOLLOW_OPERADOR_in_ops612);
                            if (failed) {
                                return e;
                            }
                            pushFollow(FOLLOW_apos_in_ops616);
                            t2 = apos();
                            _fsp--;
                            if (failed) {
                                return e;
                            }
                            if (backtracking == 0) {
                                Expressao ex = new Expressao(new Operador(OPERADOR2.getText(), 2), t1, t2);
                                e = ex;

                            }

                        }
                        break;

                }


            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return e;
    }
    // $ANTLR end ops
    // $ANTLR start apos
    // Pointfree2.g:126:1: apos returns [Expressao e] : f1= factor ( '.' f2= factor )* ;
    public final Expressao apos() throws RecognitionException {
        Expressao e = null;

        Expressao f1 = null;

        Expressao f2 = null;


        try {
            // Pointfree2.g:127:9: (f1= factor ( '.' f2= factor )* )
            // Pointfree2.g:127:11: f1= factor ( '.' f2= factor )*
            {
                pushFollow(FOLLOW_factor_in_apos661);
                f1 = factor();
                _fsp--;
                if (failed) {
                    return e;
                }
                if (backtracking == 0) {
                    ArrayList<Expressao> exx = new ArrayList<Expressao>();
                    exx.add(f1);
                    hm.put(f1, exx);

                }
                // Pointfree2.g:131:11: ( '.' f2= factor )*
                loop9:
                do {
                    int alt9 = 2;
                    int LA9_0 = input.LA(1);

                    if ((LA9_0 == 15)) {
                        alt9 = 1;
                    }


                    switch (alt9) {
                        case 1:
                            // Pointfree2.g:131:12: '.' f2= factor
                             {
                                match(input, 15, FOLLOW_15_in_apos676);
                                if (failed) {
                                    return e;
                                }
                                pushFollow(FOLLOW_factor_in_apos680);
                                f2 = factor();
                                _fsp--;
                                if (failed) {
                                    return e;
                                }
                                if (backtracking == 0) {
                                    if (f1.getNodo().getNome().equals(".")) { // ((f . g) . h) fica a ser igual a: (f . g . h)
                                        ArrayList<Expressao> as = f1.getRamos();
                                        as.add(f2);
                                        hm.put(f1, as);
                                    } else {
                                        ArrayList<Expressao> as = hm.get(f1);
                                        as.add(f2);
                                        hm.put(f1, as);
                                    }

                                }

                            }
                            break;

                        default:
                            break loop9;
                    }
                } while (true);

                if (backtracking == 0) {
                    ArrayList<Expressao> as = hm.get(f1);
                    e = new Expressao(new Operador(new String("."), as.size()), as);

                }

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return e;
    }
    // $ANTLR end apos
    // $ANTLR start factor
    // Pointfree2.g:146:1: factor returns [Expressao e] : ( ID | '(' ee= exp ')' | '(|' ee= exp '|)' | '[(' ee= exp ')]' | '[|' e1= exp ',' e2= exp '|]' );
    public final Expressao factor() throws RecognitionException {
        Expressao e = null;

        Token ID3 = null;
        Expressao ee = null;

        Expressao e1 = null;

        Expressao e2 = null;


        try {
            // Pointfree2.g:147:9: ( ID | '(' ee= exp ')' | '(|' ee= exp '|)' | '[(' ee= exp ')]' | '[|' e1= exp ',' e2= exp '|]' )
            int alt10 = 5;
            switch (input.LA(1)) {
                case ID:
                     {
                        alt10 = 1;
                    }
                    break;
                case 16:
                     {
                        alt10 = 2;
                    }
                    break;
                case 18:
                     {
                        alt10 = 3;
                    }
                    break;
                case 20:
                     {
                        alt10 = 4;
                    }
                    break;
                case 22:
                     {
                        alt10 = 5;
                    }
                    break;
                default:
                    if (backtracking > 0) {
                        failed = true;
                        return e;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("146:1: factor returns [Expressao e] : ( ID | '(' ee= exp ')' | '(|' ee= exp '|)' | '[(' ee= exp ')]' | '[|' e1= exp ',' e2= exp '|]' );", 10, 0, input);

                    throw nvae;
            }

            switch (alt10) {
                case 1:
                    // Pointfree2.g:147:11: ID
                     {
                        ID3 = (Token) input.LT(1);
                        match(input, ID, FOLLOW_ID_in_factor725);
                        if (failed) {
                            return e;
                        }
                        if (backtracking == 0) {
                            if (listaNomeConcreta.contains(ID3.getText())) {
                                e = new Expressao(new Concreta(ID3.getText(), 0, contTipo++, contTipo++));
                            } else {
                                e = new Expressao(new Geral(ID3.getText(), 0, contTipo++, contTipo++));
                            //System.out.println("ttiippoo :: " + e);
                            }

                        }

                    }
                    break;
                case 2:
                    // Pointfree2.g:155:11: '(' ee= exp ')'
                     {
                        match(input, 16, FOLLOW_16_in_factor751);
                        if (failed) {
                            return e;
                        }
                        pushFollow(FOLLOW_exp_in_factor755);
                        ee = exp();
                        _fsp--;
                        if (failed) {
                            return e;
                        }
                        match(input, 17, FOLLOW_17_in_factor757);
                        if (failed) {
                            return e;
                        }
                        if (backtracking == 0) {
                            e = ee;
                        }

                    }
                    break;
                case 3:
                    // Pointfree2.g:156:11: '(|' ee= exp '|)'
                     {
                        match(input, 18, FOLLOW_18_in_factor773);
                        if (failed) {
                            return e;
                        }
                        pushFollow(FOLLOW_exp_in_factor777);
                        ee = exp();
                        _fsp--;
                        if (failed) {
                            return e;
                        }
                        match(input, 19, FOLLOW_19_in_factor779);
                        if (failed) {
                            return e;
                        }
                        if (backtracking == 0) {
                            ArrayList<Expressao> ramos = new ArrayList<Expressao>();
                            ramos.add(ee);
                            e = new Expressao(new Geral("cata", 1, contTipo++, contTipo++), ramos);

                        }

                    }
                    break;
                case 4:
                    // Pointfree2.g:160:11: '[(' ee= exp ')]'
                     {
                        match(input, 20, FOLLOW_20_in_factor793);
                        if (failed) {
                            return e;
                        }
                        pushFollow(FOLLOW_exp_in_factor797);
                        ee = exp();
                        _fsp--;
                        if (failed) {
                            return e;
                        }
                        match(input, 21, FOLLOW_21_in_factor799);
                        if (failed) {
                            return e;
                        }
                        if (backtracking == 0) {
                            ArrayList<Expressao> ramos = new ArrayList<Expressao>();
                            ramos.add(ee);
                            e = new Expressao(new Geral("ana", 1, contTipo++, contTipo++), ramos);

                        }

                    }
                    break;
                case 5:
                    // Pointfree2.g:164:11: '[|' e1= exp ',' e2= exp '|]'
                     {
                        match(input, 22, FOLLOW_22_in_factor813);
                        if (failed) {
                            return e;
                        }
                        pushFollow(FOLLOW_exp_in_factor817);
                        e1 = exp();
                        _fsp--;
                        if (failed) {
                            return e;
                        }
                        match(input, 23, FOLLOW_23_in_factor819);
                        if (failed) {
                            return e;
                        }
                        pushFollow(FOLLOW_exp_in_factor823);
                        e2 = exp();
                        _fsp--;
                        if (failed) {
                            return e;
                        }
                        match(input, 24, FOLLOW_24_in_factor825);
                        if (failed) {
                            return e;
                        }
                        if (backtracking == 0) {
                            ArrayList<Expressao> ramos = new ArrayList<Expressao>();
                            ramos.add(e1);
                            ramos.add(e2);
                            e = new Expressao(new Geral("hylo", 1, contTipo++, contTipo++), ramos);

                        }

                    }
                    break;

            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
        }
        return e;
    }
    // $ANTLR end factor

    // $ANTLR start synpred3
    public final void synpred3_fragment() throws RecognitionException {
        // Pointfree2.g:88:11: ( ID ':' exp OPEQ exp )
        // Pointfree2.g:88:11: ID ':' exp OPEQ exp
        {
            match(input, ID, FOLLOW_ID_in_synpred3168);
            if (failed) {
                return;
            }
            match(input, 10, FOLLOW_10_in_synpred3170);
            if (failed) {
                return;
            }
            pushFollow(FOLLOW_exp_in_synpred3174);
            exp();
            _fsp--;
            if (failed) {
                return;
            }
            match(input, OPEQ, FOLLOW_OPEQ_in_synpred3177);
            if (failed) {
                return;
            }
            pushFollow(FOLLOW_exp_in_synpred3182);
            exp();
            _fsp--;
            if (failed) {
                return;
            }
        }
    }
    // $ANTLR end synpred3

    // $ANTLR start synpred5
    public final void synpred5_fragment() throws RecognitionException {
        // Pointfree2.g:98:16: ( . )
        // Pointfree2.g:98:16: .
        {
            matchAny(input);
            if (failed) {
                return;
            }
        }
    }
    // $ANTLR end synpred5

    // $ANTLR start synpred8
    public final void synpred8_fragment() throws RecognitionException {
        // Pointfree2.g:102:11: ( ID ':' exp OPEQ exp )
        // Pointfree2.g:102:11: ID ':' exp OPEQ exp
        {
            match(input, ID, FOLLOW_ID_in_synpred8369);
            if (failed) {
                return;
            }
            match(input, 10, FOLLOW_10_in_synpred8371);
            if (failed) {
                return;
            }
            pushFollow(FOLLOW_exp_in_synpred8375);
            exp();
            _fsp--;
            if (failed) {
                return;
            }
            match(input, OPEQ, FOLLOW_OPEQ_in_synpred8378);
            if (failed) {
                return;
            }
            pushFollow(FOLLOW_exp_in_synpred8382);
            exp();
            _fsp--;
            if (failed) {
                return;
            }
        }
    }
    // $ANTLR end synpred8
    public final boolean synpred5() {
        backtracking++;
        int start = input.mark();
        try {
            synpred5_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed = false;
        return success;
    }

    public final boolean synpred8() {
        backtracking++;
        int start = input.mark();
        try {
            synpred8_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed = false;
        return success;
    }

    public final boolean synpred3() {
        backtracking++;
        int start = input.mark();
        try {
            synpred3_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed = false;
        return success;
    }
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA2_eotS =
            "\u0097\uffff";
    static final String DFA2_eofS =
            "\3\uffff\1\15\13\uffff\1\15\4\uffff\1\15\4\uffff\1\15\4\uffff\1" +
            "\15\12\uffff\1\15\4\uffff\1\15\4\uffff\1\15\4\uffff\1\15\4\uffff" +
            "\1\15\4\uffff\1\15\10\uffff\1\15\4\uffff\1\15\4\uffff\1\15\4\uffff" +
            "\1\15\5\uffff\1\15\34\uffff\1\15\4\uffff\1\15\4\uffff\1\15\16\uffff" +
            "\1\15";
    static final String DFA2_minS =
            "\1\4\1\12\2\4\4\0\1\uffff\4\4\2\uffff\1\4\4\0\1\4\4\0\1\4\4\0\1" +
            "\4\4\0\7\4\4\0\1\4\4\0\1\4\4\0\1\4\4\0\1\4\4\0\1\4\4\0\5\4\4\0\1" +
            "\4\4\0\1\4\4\0\1\4\4\0\6\4\1\6\4\0\1\6\4\0\1\6\4\0\1\6\10\0\1\4" +
            "\4\0\1\4\4\0\1\4\4\0\1\4\1\6\10\0\1\4";
    static final String DFA2_maxS =
            "\1\4\1\12\1\26\1\17\4\0\1\uffff\4\26\2\uffff\1\17\4\0\1\17\4\0\1" +
            "\17\4\0\1\17\4\0\6\26\1\17\4\0\1\17\4\0\1\17\4\0\1\17\4\0\1\17\4" +
            "\0\1\17\4\0\4\26\1\17\4\0\1\17\4\0\1\17\4\0\1\17\4\0\1\26\1\17\4" +
            "\26\1\21\4\0\1\23\4\0\1\25\4\0\1\27\10\0\1\17\4\0\1\17\4\0\1\17" +
            "\4\0\1\26\1\30\10\0\1\17";
    static final String DFA2_acceptS =
            "\10\uffff\1\1\4\uffff\1\3\1\2\u0088\uffff";
    static final String DFA2_specialS =
            "\4\uffff\1\135\1\6\1\60\1\56\10\uffff\1\30\1\7\1\67\1\46\1\uffff" +
            "\1\31\1\10\1\70\1\47\1\uffff\1\27\1\5\1\66\1\45\1\uffff\1\130\1" +
            "\141\1\102\1\106\7\uffff\1\23\1\13\1\65\1\44\1\uffff\1\22\1\12\1" +
            "\71\1\50\1\uffff\1\24\1\14\1\72\1\51\1\uffff\1\132\1\136\1\103\1" +
            "\107\1\uffff\1\133\1\137\1\104\1\110\1\uffff\1\42\1\32\1\33\1\15" +
            "\5\uffff\1\25\1\11\1\73\1\57\1\uffff\1\134\1\142\1\105\1\112\1\uffff" +
            "\1\43\1\26\1\34\1\0\1\uffff\1\120\1\111\1\101\1\121\7\uffff\1\131" +
            "\1\4\1\64\1\55\1\uffff\1\21\1\127\1\63\1\54\1\uffff\1\20\1\3\1\143" +
            "\1\53\1\uffff\1\17\1\2\1\62\1\140\1\126\1\117\1\100\1\41\1\uffff" +
            "\1\125\1\116\1\77\1\40\1\uffff\1\124\1\115\1\76\1\37\1\uffff\1\123" +
            "\1\114\1\75\1\36\2\uffff\1\16\1\1\1\61\1\52\1\122\1\113\1\74\1\35" +
            "\1\uffff}>";
    static final String[] DFA2_transitionS = {
        "\1\1",
        "\1\2",
        "\1\3\13\uffff\1\4\1\uffff\1\5\1\uffff\1\6\1\uffff\1\7",
        "\1\15\1\16\1\12\4\uffff\1\10\1\uffff\1\14\1\13\1\11",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "",
        "\1\17\13\uffff\1\20\1\uffff\1\21\1\uffff\1\22\1\uffff\1\23",
        "\1\24\13\uffff\1\25\1\uffff\1\26\1\uffff\1\27\1\uffff\1\30",
        "\1\31\13\uffff\1\32\1\uffff\1\33\1\uffff\1\34\1\uffff\1\35",
        "\1\36\13\uffff\1\37\1\uffff\1\40\1\uffff\1\41\1\uffff\1\42",
        "",
        "",
        "\1\15\1\16\1\12\6\uffff\1\14\1\13\1\11",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\7\uffff\1\14\1\13\1\43",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\1\45\6\uffff\1\14\1\uffff\1\44",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\1\47\7\uffff\1\50\1\46",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\51\13\uffff\1\52\1\uffff\1\53\1\uffff\1\54\1\uffff\1\55",
        "\1\56\13\uffff\1\57\1\uffff\1\60\1\uffff\1\61\1\uffff\1\62",
        "\1\63\13\uffff\1\64\1\uffff\1\65\1\uffff\1\66\1\uffff\1\67",
        "\1\70\13\uffff\1\71\1\uffff\1\72\1\uffff\1\73\1\uffff\1\74",
        "\1\75\13\uffff\1\76\1\uffff\1\77\1\uffff\1\100\1\uffff\1\101",
        "\1\102\13\uffff\1\103\1\uffff\1\104\1\uffff\1\105\1\uffff\1" +
        "\106",
        "\1\15\1\16\7\uffff\1\14\1\13\1\43",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\1\45\6\uffff\1\14\1\uffff\1\44",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\7\uffff\1\14\1\uffff\1\107",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\1\47\7\uffff\1\50\1\46",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\10\uffff\1\50\1\110",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\1\112\10\uffff\1\111",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\113\13\uffff\1\114\1\uffff\1\115\1\uffff\1\116\1\uffff\1" +
        "\117",
        "\1\120\13\uffff\1\121\1\uffff\1\122\1\uffff\1\123\1\uffff\1" +
        "\124",
        "\1\125\13\uffff\1\126\1\uffff\1\127\1\uffff\1\130\1\uffff\1" +
        "\131",
        "\1\132\13\uffff\1\133\1\uffff\1\134\1\uffff\1\135\1\uffff\1" +
        "\136",
        "\1\15\1\16\7\uffff\1\14\1\uffff\1\107",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\10\uffff\1\50\1\110",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\1\112\10\uffff\1\111",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\11\uffff\1\137",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\140\13\uffff\1\141\1\uffff\1\142\1\uffff\1\143\1\uffff\1" +
        "\144",
        "\1\15\1\16\11\uffff\1\137",
        "\1\145\13\uffff\1\146\1\uffff\1\147\1\uffff\1\150\1\uffff\1" +
        "\151",
        "\1\152\13\uffff\1\153\1\uffff\1\154\1\uffff\1\155\1\uffff\1" +
        "\156",
        "\1\157\13\uffff\1\160\1\uffff\1\161\1\uffff\1\162\1\uffff\1" +
        "\163",
        "\1\164\13\uffff\1\165\1\uffff\1\166\1\uffff\1\167\1\uffff\1" +
        "\170",
        "\1\172\6\uffff\1\174\1\173\1\171\1\uffff\1\175",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\177\6\uffff\1\u0081\1\u0080\1\176\3\uffff\1\u0082",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\u0084\6\uffff\1\u0086\1\u0085\1\u0083\5\uffff\1\u0087",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\u0089\6\uffff\1\u008b\1\u008a\1\u0088\7\uffff\1\u008c",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\11\uffff\1\137",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\11\uffff\1\137",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\11\uffff\1\137",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\u008d\13\uffff\1\u008e\1\uffff\1\u008f\1\uffff\1\u0090\1" +
        "\uffff\1\u0091",
        "\1\u0093\6\uffff\1\u0095\1\u0094\1\u0092\10\uffff\1\u0096",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\15\1\16\11\uffff\1\137"
    };
    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;
    

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }

        public String getDescription() {
            return "86:1: definicaoNome returns [String as] : (nome= ID ':' conc= ID ':=' e= exp | nome= ID ':' e1= exp OPEQ e2= exp | nome= ID ':' e1= exp );";
        }

        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
            int _s = s;
            switch (s) {
                case 0:
                    int LA2_89 = input.LA(1);


                    int index2_89 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_89);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 1:
                    int LA2_143 = input.LA(1);


                    int index2_143 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_143);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 2:
                    int LA2_118 = input.LA(1);


                    int index2_118 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_118);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 3:
                    int LA2_113 = input.LA(1);


                    int index2_113 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_113);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 4:
                    int LA2_103 = input.LA(1);


                    int index2_103 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_103);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 5:
                    int LA2_27 = input.LA(1);


                    int index2_27 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_27);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 6:
                    int LA2_5 = input.LA(1);


                    int index2_5 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_5);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 7:
                    int LA2_17 = input.LA(1);


                    int index2_17 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_17);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 8:
                    int LA2_22 = input.LA(1);


                    int index2_22 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_22);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 9:
                    int LA2_77 = input.LA(1);


                    int index2_77 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_77);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 10:
                    int LA2_48 = input.LA(1);


                    int index2_48 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_48);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 11:
                    int LA2_43 = input.LA(1);


                    int index2_43 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_43);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 12:
                    int LA2_53 = input.LA(1);


                    int index2_53 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_53);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 13:
                    int LA2_70 = input.LA(1);


                    int index2_70 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_70);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 14:
                    int LA2_142 = input.LA(1);


                    int index2_142 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_142);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 15:
                    int LA2_117 = input.LA(1);


                    int index2_117 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_117);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 16:
                    int LA2_112 = input.LA(1);


                    int index2_112 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_112);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 17:
                    int LA2_107 = input.LA(1);


                    int index2_107 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_107);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 18:
                    int LA2_47 = input.LA(1);


                    int index2_47 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_47);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 19:
                    int LA2_42 = input.LA(1);


                    int index2_42 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_42);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 20:
                    int LA2_52 = input.LA(1);


                    int index2_52 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_52);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 21:
                    int LA2_76 = input.LA(1);


                    int index2_76 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_76);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 22:
                    int LA2_87 = input.LA(1);


                    int index2_87 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_87);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 23:
                    int LA2_26 = input.LA(1);


                    int index2_26 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_26);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 24:
                    int LA2_16 = input.LA(1);


                    int index2_16 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_16);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 25:
                    int LA2_21 = input.LA(1);


                    int index2_21 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_21);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 26:
                    int LA2_68 = input.LA(1);


                    int index2_68 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_68);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 27:
                    int LA2_69 = input.LA(1);


                    int index2_69 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_69);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 28:
                    int LA2_88 = input.LA(1);


                    int index2_88 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_88);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 29:
                    int LA2_149 = input.LA(1);


                    int index2_149 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_149);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 30:
                    int LA2_139 = input.LA(1);


                    int index2_139 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_139);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 31:
                    int LA2_134 = input.LA(1);


                    int index2_134 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_134);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 32:
                    int LA2_129 = input.LA(1);


                    int index2_129 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_129);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 33:
                    int LA2_124 = input.LA(1);


                    int index2_124 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_124);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 34:
                    int LA2_67 = input.LA(1);


                    int index2_67 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_67);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 35:
                    int LA2_86 = input.LA(1);


                    int index2_86 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_86);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 36:
                    int LA2_45 = input.LA(1);


                    int index2_45 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_45);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 37:
                    int LA2_29 = input.LA(1);


                    int index2_29 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_29);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 38:
                    int LA2_19 = input.LA(1);


                    int index2_19 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_19);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 39:
                    int LA2_24 = input.LA(1);


                    int index2_24 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_24);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 40:
                    int LA2_50 = input.LA(1);


                    int index2_50 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_50);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 41:
                    int LA2_55 = input.LA(1);


                    int index2_55 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_55);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 42:
                    int LA2_145 = input.LA(1);


                    int index2_145 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_145);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 43:
                    int LA2_115 = input.LA(1);


                    int index2_115 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_115);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 44:
                    int LA2_110 = input.LA(1);


                    int index2_110 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_110);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 45:
                    int LA2_105 = input.LA(1);


                    int index2_105 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_105);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 46:
                    int LA2_7 = input.LA(1);


                    int index2_7 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_7);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 47:
                    int LA2_79 = input.LA(1);


                    int index2_79 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_79);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 48:
                    int LA2_6 = input.LA(1);


                    int index2_6 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_6);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 49:
                    int LA2_144 = input.LA(1);


                    int index2_144 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_144);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 50:
                    int LA2_119 = input.LA(1);


                    int index2_119 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_119);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 51:
                    int LA2_109 = input.LA(1);


                    int index2_109 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_109);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 52:
                    int LA2_104 = input.LA(1);


                    int index2_104 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_104);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 53:
                    int LA2_44 = input.LA(1);


                    int index2_44 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_44);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 54:
                    int LA2_28 = input.LA(1);


                    int index2_28 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_28);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 55:
                    int LA2_18 = input.LA(1);


                    int index2_18 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_18);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 56:
                    int LA2_23 = input.LA(1);


                    int index2_23 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_23);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 57:
                    int LA2_49 = input.LA(1);


                    int index2_49 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_49);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 58:
                    int LA2_54 = input.LA(1);


                    int index2_54 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_54);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 59:
                    int LA2_78 = input.LA(1);


                    int index2_78 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_78);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 60:
                    int LA2_148 = input.LA(1);


                    int index2_148 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_148);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 61:
                    int LA2_138 = input.LA(1);


                    int index2_138 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_138);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 62:
                    int LA2_133 = input.LA(1);


                    int index2_133 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_133);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 63:
                    int LA2_128 = input.LA(1);


                    int index2_128 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_128);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 64:
                    int LA2_123 = input.LA(1);


                    int index2_123 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_123);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 65:
                    int LA2_93 = input.LA(1);


                    int index2_93 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_93);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 66:
                    int LA2_33 = input.LA(1);


                    int index2_33 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_33);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 67:
                    int LA2_59 = input.LA(1);


                    int index2_59 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_59);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 68:
                    int LA2_64 = input.LA(1);


                    int index2_64 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_64);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 69:
                    int LA2_83 = input.LA(1);


                    int index2_83 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_83);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 70:
                    int LA2_34 = input.LA(1);


                    int index2_34 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_34);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 71:
                    int LA2_60 = input.LA(1);


                    int index2_60 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_60);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 72:
                    int LA2_65 = input.LA(1);


                    int index2_65 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_65);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 73:
                    int LA2_92 = input.LA(1);


                    int index2_92 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_92);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 74:
                    int LA2_84 = input.LA(1);


                    int index2_84 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_84);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 75:
                    int LA2_147 = input.LA(1);


                    int index2_147 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_147);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 76:
                    int LA2_137 = input.LA(1);


                    int index2_137 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_137);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 77:
                    int LA2_132 = input.LA(1);


                    int index2_132 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_132);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 78:
                    int LA2_127 = input.LA(1);


                    int index2_127 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_127);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 79:
                    int LA2_122 = input.LA(1);


                    int index2_122 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_122);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 80:
                    int LA2_91 = input.LA(1);


                    int index2_91 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_91);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 81:
                    int LA2_94 = input.LA(1);


                    int index2_94 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_94);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 82:
                    int LA2_146 = input.LA(1);


                    int index2_146 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_146);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 83:
                    int LA2_136 = input.LA(1);


                    int index2_136 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_136);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 84:
                    int LA2_131 = input.LA(1);


                    int index2_131 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_131);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 85:
                    int LA2_126 = input.LA(1);


                    int index2_126 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_126);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 86:
                    int LA2_121 = input.LA(1);


                    int index2_121 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_121);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 87:
                    int LA2_108 = input.LA(1);


                    int index2_108 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_108);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 88:
                    int LA2_31 = input.LA(1);


                    int index2_31 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_31);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 89:
                    int LA2_102 = input.LA(1);


                    int index2_102 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_102);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 90:
                    int LA2_57 = input.LA(1);


                    int index2_57 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_57);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 91:
                    int LA2_62 = input.LA(1);


                    int index2_62 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_62);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 92:
                    int LA2_81 = input.LA(1);


                    int index2_81 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_81);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 93:
                    int LA2_4 = input.LA(1);


                    int index2_4 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_4);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 94:
                    int LA2_58 = input.LA(1);


                    int index2_58 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_58);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 95:
                    int LA2_63 = input.LA(1);


                    int index2_63 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_63);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 96:
                    int LA2_120 = input.LA(1);


                    int index2_120 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_120);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 97:
                    int LA2_32 = input.LA(1);


                    int index2_32 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_32);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 98:
                    int LA2_82 = input.LA(1);


                    int index2_82 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_82);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 99:
                    int LA2_114 = input.LA(1);


                    int index2_114 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred3())) {
                        s = 14;
                    } else if ((true)) {
                        s = 13;
                    }


                    input.seek(index2_114);
                    if (s >= 0) {
                        return s;
                    }
                    break;
            }
            if (backtracking > 0) {
                failed = true;
                return -1;
            }
            NoViableAltException nvae =
                    new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA5_eotS =
            "\u0098\uffff";
    static final String DFA5_eofS =
            "\4\uffff\1\16\13\uffff\1\16\4\uffff\1\16\4\uffff\1\16\4\uffff\1" +
            "\16\12\uffff\1\16\4\uffff\1\16\4\uffff\1\16\4\uffff\1\16\4\uffff" +
            "\1\16\4\uffff\1\16\10\uffff\1\16\4\uffff\1\16\4\uffff\1\16\4\uffff" +
            "\1\16\5\uffff\1\16\34\uffff\1\16\4\uffff\1\16\4\uffff\1\16\16\uffff" +
            "\1\16";
    static final String DFA5_minS =
            "\1\4\1\uffff\1\12\2\4\4\0\1\uffff\4\4\2\uffff\1\4\4\0\1\4\4\0\1" +
            "\4\4\0\1\4\4\0\7\4\4\0\1\4\4\0\1\4\4\0\1\4\4\0\1\4\4\0\1\4\4\0\5" +
            "\4\4\0\1\4\4\0\1\4\4\0\1\4\4\0\6\4\1\6\4\0\1\6\4\0\1\6\4\0\1\6\10" +
            "\0\1\4\4\0\1\4\4\0\1\4\4\0\1\4\1\6\10\0\1\4";
    static final String DFA5_maxS =
            "\1\14\1\uffff\1\12\1\26\1\17\4\0\1\uffff\4\26\2\uffff\1\17\4\0\1" +
            "\17\4\0\1\17\4\0\1\17\4\0\6\26\1\17\4\0\1\17\4\0\1\17\4\0\1\17\4" +
            "\0\1\17\4\0\1\17\4\0\4\26\1\17\4\0\1\17\4\0\1\17\4\0\1\17\4\0\1" +
            "\26\1\17\4\26\1\21\4\0\1\23\4\0\1\25\4\0\1\27\10\0\1\17\4\0\1\17" +
            "\4\0\1\17\4\0\1\26\1\30\10\0\1\17";
    static final String DFA5_acceptS =
            "\1\uffff\1\1\7\uffff\1\2\4\uffff\1\4\1\3\u0088\uffff";
    static final String DFA5_specialS =
            "\5\uffff\1\136\1\3\1\70\1\45\10\uffff\1\22\1\14\1\71\1\57\1\uffff" +
            "\1\23\1\15\1\72\1\56\1\uffff\1\21\1\13\1\67\1\55\1\uffff\1\131\1" +
            "\143\1\101\1\120\7\uffff\1\20\1\2\1\63\1\44\1\uffff\1\17\1\4\1\64" +
            "\1\46\1\uffff\1\24\1\5\1\65\1\47\1\uffff\1\132\1\137\1\105\1\115" +
            "\1\uffff\1\133\1\140\1\106\1\116\1\uffff\1\43\1\32\1\16\1\7\5\uffff" +
            "\1\31\1\6\1\73\1\50\1\uffff\1\134\1\141\1\102\1\117\1\uffff\1\34" +
            "\1\33\1\35\1\10\1\uffff\1\104\1\114\1\103\1\121\7\uffff\1\130\1" +
            "\12\1\62\1\54\1\uffff\1\30\1\127\1\66\1\53\1\uffff\1\27\1\1\1\142" +
            "\1\52\1\uffff\1\26\1\11\1\61\1\135\1\126\1\113\1\100\1\42\1\uffff" +
            "\1\125\1\112\1\77\1\41\1\uffff\1\124\1\111\1\76\1\40\1\uffff\1\123" +
            "\1\110\1\75\1\37\2\uffff\1\25\1\0\1\60\1\51\1\122\1\107\1\74\1\36" +
            "\1\uffff}>";
    static final String[] DFA5_transitionS = {
        "\1\2\7\uffff\1\1",
        "",
        "\1\3",
        "\1\4\13\uffff\1\5\1\uffff\1\6\1\uffff\1\7\1\uffff\1\10",
        "\1\16\1\17\1\13\4\uffff\1\11\1\16\1\15\1\14\1\12",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "",
        "\1\20\13\uffff\1\21\1\uffff\1\22\1\uffff\1\23\1\uffff\1\24",
        "\1\25\13\uffff\1\26\1\uffff\1\27\1\uffff\1\30\1\uffff\1\31",
        "\1\32\13\uffff\1\33\1\uffff\1\34\1\uffff\1\35\1\uffff\1\36",
        "\1\37\13\uffff\1\40\1\uffff\1\41\1\uffff\1\42\1\uffff\1\43",
        "",
        "",
        "\1\16\1\17\1\13\5\uffff\1\16\1\15\1\14\1\12",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\6\uffff\1\16\1\15\1\14\1\44",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\1\46\5\uffff\1\16\1\15\1\uffff\1\45",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\1\50\5\uffff\1\16\1\uffff\1\51\1\47",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\52\13\uffff\1\53\1\uffff\1\54\1\uffff\1\55\1\uffff\1\56",
        "\1\57\13\uffff\1\60\1\uffff\1\61\1\uffff\1\62\1\uffff\1\63",
        "\1\64\13\uffff\1\65\1\uffff\1\66\1\uffff\1\67\1\uffff\1\70",
        "\1\71\13\uffff\1\72\1\uffff\1\73\1\uffff\1\74\1\uffff\1\75",
        "\1\76\13\uffff\1\77\1\uffff\1\100\1\uffff\1\101\1\uffff\1\102",
        "\1\103\13\uffff\1\104\1\uffff\1\105\1\uffff\1\106\1\uffff\1" +
        "\107",
        "\1\16\1\17\6\uffff\1\16\1\15\1\14\1\44",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\1\46\5\uffff\1\16\1\15\1\uffff\1\45",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\6\uffff\1\16\1\15\1\uffff\1\110",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\1\50\5\uffff\1\16\1\uffff\1\51\1\47",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\6\uffff\1\16\1\uffff\1\51\1\111",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\1\113\5\uffff\1\16\2\uffff\1\112",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\114\13\uffff\1\115\1\uffff\1\116\1\uffff\1\117\1\uffff\1" +
        "\120",
        "\1\121\13\uffff\1\122\1\uffff\1\123\1\uffff\1\124\1\uffff\1" +
        "\125",
        "\1\126\13\uffff\1\127\1\uffff\1\130\1\uffff\1\131\1\uffff\1" +
        "\132",
        "\1\133\13\uffff\1\134\1\uffff\1\135\1\uffff\1\136\1\uffff\1" +
        "\137",
        "\1\16\1\17\6\uffff\1\16\1\15\1\uffff\1\110",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\6\uffff\1\16\1\uffff\1\51\1\111",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\1\113\5\uffff\1\16\2\uffff\1\112",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\6\uffff\1\16\2\uffff\1\140",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\141\13\uffff\1\142\1\uffff\1\143\1\uffff\1\144\1\uffff\1" +
        "\145",
        "\1\16\1\17\6\uffff\1\16\2\uffff\1\140",
        "\1\146\13\uffff\1\147\1\uffff\1\150\1\uffff\1\151\1\uffff\1" +
        "\152",
        "\1\153\13\uffff\1\154\1\uffff\1\155\1\uffff\1\156\1\uffff\1" +
        "\157",
        "\1\160\13\uffff\1\161\1\uffff\1\162\1\uffff\1\163\1\uffff\1" +
        "\164",
        "\1\165\13\uffff\1\166\1\uffff\1\167\1\uffff\1\170\1\uffff\1" +
        "\171",
        "\1\173\6\uffff\1\175\1\174\1\172\1\uffff\1\176",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\u0080\6\uffff\1\u0082\1\u0081\1\177\3\uffff\1\u0083",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\u0085\6\uffff\1\u0087\1\u0086\1\u0084\5\uffff\1\u0088",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\u008a\6\uffff\1\u008c\1\u008b\1\u0089\7\uffff\1\u008d",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\6\uffff\1\16\2\uffff\1\140",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\6\uffff\1\16\2\uffff\1\140",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\6\uffff\1\16\2\uffff\1\140",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\u008e\13\uffff\1\u008f\1\uffff\1\u0090\1\uffff\1\u0091\1" +
        "\uffff\1\u0092",
        "\1\u0094\6\uffff\1\u0096\1\u0095\1\u0093\10\uffff\1\u0097",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\uffff",
        "\1\16\1\17\6\uffff\1\16\2\uffff\1\140"
    };
    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;
    

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }

        public String getDescription() {
            return "97:1: regra returns [Regra r] : ( '--' ( . )* | nome= ID ':' conc= ID ':=' e= exp | nome= ID ':' e1= exp OPEQ e2= exp | nome= ID ':' e1= exp );";
        }

        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
            int _s = s;
            switch (s) {
                case 0:
                    int LA5_144 = input.LA(1);


                    int index5_144 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_144);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 1:
                    int LA5_114 = input.LA(1);


                    int index5_114 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_114);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 2:
                    int LA5_44 = input.LA(1);


                    int index5_44 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_44);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 3:
                    int LA5_6 = input.LA(1);


                    int index5_6 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_6);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 4:
                    int LA5_49 = input.LA(1);


                    int index5_49 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_49);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 5:
                    int LA5_54 = input.LA(1);


                    int index5_54 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_54);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 6:
                    int LA5_78 = input.LA(1);


                    int index5_78 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_78);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 7:
                    int LA5_71 = input.LA(1);


                    int index5_71 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_71);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 8:
                    int LA5_90 = input.LA(1);


                    int index5_90 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_90);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 9:
                    int LA5_119 = input.LA(1);


                    int index5_119 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_119);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 10:
                    int LA5_104 = input.LA(1);


                    int index5_104 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_104);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 11:
                    int LA5_28 = input.LA(1);


                    int index5_28 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_28);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 12:
                    int LA5_18 = input.LA(1);


                    int index5_18 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_18);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 13:
                    int LA5_23 = input.LA(1);


                    int index5_23 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_23);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 14:
                    int LA5_70 = input.LA(1);


                    int index5_70 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_70);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 15:
                    int LA5_48 = input.LA(1);


                    int index5_48 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_48);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 16:
                    int LA5_43 = input.LA(1);


                    int index5_43 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_43);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 17:
                    int LA5_27 = input.LA(1);


                    int index5_27 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_27);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 18:
                    int LA5_17 = input.LA(1);


                    int index5_17 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_17);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 19:
                    int LA5_22 = input.LA(1);


                    int index5_22 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_22);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 20:
                    int LA5_53 = input.LA(1);


                    int index5_53 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_53);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 21:
                    int LA5_143 = input.LA(1);


                    int index5_143 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_143);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 22:
                    int LA5_118 = input.LA(1);


                    int index5_118 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_118);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 23:
                    int LA5_113 = input.LA(1);


                    int index5_113 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_113);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 24:
                    int LA5_108 = input.LA(1);


                    int index5_108 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_108);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 25:
                    int LA5_77 = input.LA(1);


                    int index5_77 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_77);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 26:
                    int LA5_69 = input.LA(1);


                    int index5_69 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_69);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 27:
                    int LA5_88 = input.LA(1);


                    int index5_88 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_88);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 28:
                    int LA5_87 = input.LA(1);


                    int index5_87 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_87);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 29:
                    int LA5_89 = input.LA(1);


                    int index5_89 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_89);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 30:
                    int LA5_150 = input.LA(1);


                    int index5_150 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_150);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 31:
                    int LA5_140 = input.LA(1);


                    int index5_140 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_140);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 32:
                    int LA5_135 = input.LA(1);


                    int index5_135 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_135);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 33:
                    int LA5_130 = input.LA(1);


                    int index5_130 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_130);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 34:
                    int LA5_125 = input.LA(1);


                    int index5_125 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_125);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 35:
                    int LA5_68 = input.LA(1);


                    int index5_68 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_68);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 36:
                    int LA5_46 = input.LA(1);


                    int index5_46 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_46);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 37:
                    int LA5_8 = input.LA(1);


                    int index5_8 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_8);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 38:
                    int LA5_51 = input.LA(1);


                    int index5_51 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_51);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 39:
                    int LA5_56 = input.LA(1);


                    int index5_56 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_56);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 40:
                    int LA5_80 = input.LA(1);


                    int index5_80 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_80);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 41:
                    int LA5_146 = input.LA(1);


                    int index5_146 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_146);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 42:
                    int LA5_116 = input.LA(1);


                    int index5_116 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_116);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 43:
                    int LA5_111 = input.LA(1);


                    int index5_111 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_111);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 44:
                    int LA5_106 = input.LA(1);


                    int index5_106 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_106);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 45:
                    int LA5_30 = input.LA(1);


                    int index5_30 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_30);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 46:
                    int LA5_25 = input.LA(1);


                    int index5_25 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_25);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 47:
                    int LA5_20 = input.LA(1);


                    int index5_20 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_20);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 48:
                    int LA5_145 = input.LA(1);


                    int index5_145 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_145);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 49:
                    int LA5_120 = input.LA(1);


                    int index5_120 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_120);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 50:
                    int LA5_105 = input.LA(1);


                    int index5_105 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_105);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 51:
                    int LA5_45 = input.LA(1);


                    int index5_45 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_45);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 52:
                    int LA5_50 = input.LA(1);


                    int index5_50 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_50);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 53:
                    int LA5_55 = input.LA(1);


                    int index5_55 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_55);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 54:
                    int LA5_110 = input.LA(1);


                    int index5_110 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_110);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 55:
                    int LA5_29 = input.LA(1);


                    int index5_29 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_29);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 56:
                    int LA5_7 = input.LA(1);


                    int index5_7 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_7);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 57:
                    int LA5_19 = input.LA(1);


                    int index5_19 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_19);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 58:
                    int LA5_24 = input.LA(1);


                    int index5_24 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_24);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 59:
                    int LA5_79 = input.LA(1);


                    int index5_79 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_79);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 60:
                    int LA5_149 = input.LA(1);


                    int index5_149 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_149);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 61:
                    int LA5_139 = input.LA(1);


                    int index5_139 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_139);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 62:
                    int LA5_134 = input.LA(1);


                    int index5_134 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_134);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 63:
                    int LA5_129 = input.LA(1);


                    int index5_129 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_129);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 64:
                    int LA5_124 = input.LA(1);


                    int index5_124 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_124);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 65:
                    int LA5_34 = input.LA(1);


                    int index5_34 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_34);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 66:
                    int LA5_84 = input.LA(1);


                    int index5_84 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_84);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 67:
                    int LA5_94 = input.LA(1);


                    int index5_94 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_94);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 68:
                    int LA5_92 = input.LA(1);


                    int index5_92 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_92);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 69:
                    int LA5_60 = input.LA(1);


                    int index5_60 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_60);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 70:
                    int LA5_65 = input.LA(1);


                    int index5_65 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_65);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 71:
                    int LA5_148 = input.LA(1);


                    int index5_148 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_148);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 72:
                    int LA5_138 = input.LA(1);


                    int index5_138 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_138);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 73:
                    int LA5_133 = input.LA(1);


                    int index5_133 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_133);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 74:
                    int LA5_128 = input.LA(1);


                    int index5_128 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_128);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 75:
                    int LA5_123 = input.LA(1);


                    int index5_123 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_123);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 76:
                    int LA5_93 = input.LA(1);


                    int index5_93 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_93);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 77:
                    int LA5_61 = input.LA(1);


                    int index5_61 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_61);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 78:
                    int LA5_66 = input.LA(1);


                    int index5_66 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_66);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 79:
                    int LA5_85 = input.LA(1);


                    int index5_85 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_85);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 80:
                    int LA5_35 = input.LA(1);


                    int index5_35 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_35);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 81:
                    int LA5_95 = input.LA(1);


                    int index5_95 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_95);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 82:
                    int LA5_147 = input.LA(1);


                    int index5_147 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_147);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 83:
                    int LA5_137 = input.LA(1);


                    int index5_137 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_137);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 84:
                    int LA5_132 = input.LA(1);


                    int index5_132 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_132);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 85:
                    int LA5_127 = input.LA(1);


                    int index5_127 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_127);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 86:
                    int LA5_122 = input.LA(1);


                    int index5_122 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_122);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 87:
                    int LA5_109 = input.LA(1);


                    int index5_109 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_109);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 88:
                    int LA5_103 = input.LA(1);


                    int index5_103 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_103);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 89:
                    int LA5_32 = input.LA(1);


                    int index5_32 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_32);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 90:
                    int LA5_58 = input.LA(1);


                    int index5_58 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_58);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 91:
                    int LA5_63 = input.LA(1);


                    int index5_63 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_63);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 92:
                    int LA5_82 = input.LA(1);


                    int index5_82 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_82);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 93:
                    int LA5_121 = input.LA(1);


                    int index5_121 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_121);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 94:
                    int LA5_5 = input.LA(1);


                    int index5_5 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_5);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 95:
                    int LA5_59 = input.LA(1);


                    int index5_59 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_59);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 96:
                    int LA5_64 = input.LA(1);


                    int index5_64 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_64);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 97:
                    int LA5_83 = input.LA(1);


                    int index5_83 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_83);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 98:
                    int LA5_115 = input.LA(1);


                    int index5_115 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_115);
                    if (s >= 0) {
                        return s;
                    }
                    break;
                case 99:
                    int LA5_33 = input.LA(1);


                    int index5_33 = input.index();
                    input.rewind();
                    s = -1;
                    if ((synpred8())) {
                        s = 15;
                    } else if ((true)) {
                        s = 14;
                    }


                    input.seek(index5_33);
                    if (s >= 0) {
                        return s;
                    }
                    break;
            }
            if (backtracking > 0) {
                failed = true;
                return -1;
            }
            NoViableAltException nvae =
                    new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    public static final BitSet FOLLOW_definicaoNome_in_definicoesNome57 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_definicaoNome_in_definicoesNome75 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ID_in_definicaoNome138 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_definicaoNome140 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_definicaoNome144 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_definicaoNome146 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_definicaoNome150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_definicaoNome168 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_definicaoNome170 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_definicaoNome174 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEQ_in_definicaoNome177 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_definicaoNome182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_definicaoNome198 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_definicaoNome200 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_definicaoNome204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regra_in_regras251 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_regra_in_regras269 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_12_in_regra321 = new BitSet(new long[]{0x0000000001FFFFF2L});
    public static final BitSet FOLLOW_ID_in_regra340 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_regra342 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_regra346 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_regra348 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_regra352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_regra369 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_regra371 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_regra375 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEQ_in_regra378 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_regra382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_regra398 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_regra400 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_regra404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equal_in_exp449 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_exp469 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_equal_in_exp473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ops_in_equal518 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_equal538 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_ops_in_equal542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_apos_in_ops587 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_OPERADOR_in_ops612 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_apos_in_ops616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_apos661 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_apos676 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_factor_in_apos680 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ID_in_factor725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_factor751 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_factor755 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_factor757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_factor773 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_factor777 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_factor779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_factor793 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_factor797 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_factor799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_factor813 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_factor817 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_factor819 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_factor823 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_factor825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_synpred3168 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_synpred3170 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_synpred3174 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEQ_in_synpred3177 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_synpred3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_synpred8369 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_synpred8371 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_synpred8375 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_OPEQ_in_synpred8378 = new BitSet(new long[]{0x0000000000550010L});
    public static final BitSet FOLLOW_exp_in_synpred8382 = new BitSet(new long[]{0x0000000000000002L});
}
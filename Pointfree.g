/*
                                                                              Ulisses Costa, Joao Moura - 2008
  Gramatica tradutora de Expressoes do calculador point-free

  Com esta gramatica e possivel passar de texto:
  (fst \/ snd) >< (f . g . h)
  para um tipo de dados em Java.

  Esta gramatica suporta quatro operadores point-free binarios: (><), (-|-), (/\), (\/)
  e o operador n-ario composicao: (.)
*/

grammar Pointfree2;

options {
        backtrack=true;
}

@header {
        import Calculador.*;
        import java.util.HashMap;
        import java.util.ArrayList;
}

@members {
        private HashMap<Expressao,ArrayList<Expressao>> hm = new HashMap<Expressao,ArrayList<Expressao>>();
        private HashMap<String,ArrayList<String>> params = new HashMap<String,ArrayList<String>>();
        private ArrayList<Regra> ar = new ArrayList<Regra>();
        private ArrayList<String> as = new ArrayList<String>();
        private ArrayList<String> listaNomeConcreta = new ArrayList<String>();
        private boolean eCata = false;

        private void repoem() {
                if(this.eCata)
                        this.eCata = false;
        }

        public ArrayList<String> getListaNomesConcreta() {
                try {
                        ArrayList<String> a = new ArrayList<String>();

                        for(String s : this.definicoesNome()) {
                                if(s != null) {
                                        a.add(s);
                                }
                        }

                        return a;
                } catch (Exception e) { ; }
                return null;
        }

        public ArrayList<Regra> getRegras() {
                try {
                        ArrayList<Regra> a = new ArrayList<Regra>();

                        for(Regra s : this.regras()) {
                                if(s != null) {
                                        a.add(s);
                                }
                        }

                        return a;
                } catch (Exception e) { ; }
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
}

definicoesNome returns [ArrayList<String> arr]
        : d1=definicaoNome  { as.add(d1); arr = as; }
          (d2=definicaoNome { as.add(d2); arr = as; }
          )*                { arr = as; }
        ;

definicaoNome returns [String as]
        : nome=ID ':' conc=ID ':=' e=exp   { as = new String($conc.text); }
        | nome=ID ':' e1=exp  OPEQ  e2=exp { ; }
        | nome=ID ':' e1=exp               { ; }
        ;

regras returns [ArrayList<Regra> arr]
        : r1=regra  { ar.add(r1); arr = ar; }
          (r2=regra { ar.add(r2); arr = ar; }
          )*        { arr = ar; }
        ;
private regra returns [Regra r]
        : '--' .* { ; }
        | nome=ID ':' conc=ID ':=' e=exp  { Expressao esq = new Expressao(new Concreta($conc.text,0));
                                            r = new Regra(esq,e,$nome.text,":=");
                                          }
        | nome=ID ':' e1=exp  OPEQ e2=exp { r = new Regra(e1,e2,$nome.text,$OPEQ.text); }
        | nome=ID ':' e1=exp              { r = new Regra(e1.getRamos().get(0),e1.getRamos().get(1),$nome.text,"="); }
        ;
exp returns [Expressao e]
        : t1=equal      { e = t1; }
          ('&' t2=equal { Expressao ex = new Expressao(new Operador("&",2), t1, t2);
                          e = ex;
                        }
          )?
        ;
equal returns [Expressao e]
        : t1=ops      { e = t1; }
          ('=' t2=ops { Expressao ex = new Expressao(new Operador("=",2), t1, t2);
                        e = ex;
                      }
          )?
        ;
ops returns [Expressao e]
        : t1=apos           { e = t1; }
          (OPERADOR t2=apos { Expressao ex = new Expressao(new Operador($OPERADOR.text,2), t1, t2);
                               e = ex;
                            }
          )?
        ;
apos returns [Expressao e]
        : f1=factor { ArrayList<Expressao> exx = new ArrayList<Expressao>();
                      exx.add(f1);
                      hm.put(f1,exx);
                    }
          ('.' f2=factor { if(f1.getNodo().getNome().equals(".")) { // ((f . g) . h) fica a ser igual a: (f . g . h)
                                ArrayList<Expressao> as = f1.getRamos();
                                as.add(f2);
                                hm.put(f1,as);
                           }
                           else {
                                ArrayList<Expressao> as = hm.get(f1);
                                as.add(f2);
                                hm.put(f1,as);
                           }
                         }
          )* { ArrayList<Expressao> as = hm.get(f1);
               e = new Expressao(new Operador(new String("."),as.size()), as);
             }
        ;
factor returns [Expressao e]
        : ID             { if(listaNomeConcreta.contains($ID.text))
                                e = new Expressao(new Concreta($ID.text, 0));
                           else {
                                e = new Expressao(new Geral($ID.text, 0));
                           }
                         }
        | '(' ee=exp ')'   { e = ee; }
        | '(|' ee=exp '|)' { ArrayList<Expressao> ramos = new ArrayList<Expressao>();
                          ramos.add(ee);
                          e = new Expressao(new Geral("cata", 1), ramos);
                        }
        | '[(' ee=exp ')]' { ArrayList<Expressao> ramos = new ArrayList<Expressao>();
                          ramos.add(ee);
                          e = new Expressao(new Geral("ana", 1), ramos);
                        }
        | '[|' e1=exp ',' e2=exp '|]' { ArrayList<Expressao> ramos = new ArrayList<Expressao>();
                                        ramos.add(e1);
                                        ramos.add(e2);
                                        e = new Expressao(new Geral("hylo", 1), ramos);
                                      }
        ;
OPEQ    : ('<=>' | '=>' | '<=')
        ;
NUM     : ('0'..'9')+
        ;
ID      : ('a'..'z' | 'A'..'Z') ('0'..'9' | 'a'..'z' | 'A'..'Z' | '+' | '-' | '_')*
        ;
OPERADOR : ('\\/' | '/\\' | '-|-' | '><')
         ;
NEWLINE : '\r'? '\n' {skip();}
        ;
WS      :  (' ' | '\t')+ {skip();}
        ;

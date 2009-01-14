package Calculador;

import java.util.HashMap;
import static java.lang.System.out;

/**
 * Class Regra
 */
public class Regra {

    //
    // Fields
    //
    private Expressao esquerda;
    private Expressao direita;
    private String nome;
    private String op;    // auxilar de aplica
    private Expressao resultado;
    HashMap<String, Expressao> assocGeralExp; // nome geral -> Expressao
    private Path path;
    //
    // Constructors
    //
    public Regra() {
        this.esquerda = new Expressao();
        this.direita = new Expressao();
        this.nome = "null";
        this.assocGeralExp = new HashMap<String, Expressao>();
        this.path = new Path();
        this.resultado = this.direita.clone();
    }
    ;

    public Regra(Expressao esquerda, Expressao direita, String nome) {
        this.esquerda = esquerda.clone();
        this.direita = direita.clone();
        this.nome = nome;
        assocGeralExp = new HashMap<String, Expressao>();
        this.path = new Path();
        this.resultado = this.direita.clone();
    }

    public Regra(Expressao esq, Expressao e, String nome, String op) {
        this.esquerda = esq.clone();
        this.direita = e.clone();
        this.nome = nome;
        assocGeralExp = new HashMap<String, Expressao>();
        this.path = new Path();
        this.resultado = this.direita.clone();
        this.op = op;
    }
    //
    // Methods
    //
    //
    // Accessor methods
    //
    /**
     * Set the value of esquerda
     * @param newVar the new value of esquerda
     */
    public void setEsquerda(Expressao newVar) {
        esquerda = newVar.clone();
    }

    /**
     * Get the value of esquerda
     * @return the value of esquerda
     */
    public Expressao getEsquerda() {
        return esquerda.clone();
    }

    /**
     * Set the value of direita
     * @param newVar the new value of direita
     */
    public void setDireita(Expressao newVar) {
        direita = newVar.clone();
    }

    /**
     * Get the value of direita
     * @return the value of direita
     */
    public Expressao getDireita() {
        return direita.clone();
    }

    /**
     * Set the value of nome
     * @param newVar the new value of nome
     */
    public void setNome(String newVar) {
        nome = newVar;
    }

    /**
     * Get the value of nome
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    public boolean aplicavel(Expressao exp) {
        this.assocGeralExp = new HashMap<String, Expressao>();
        return (recAplicavel(exp, this.esquerda));

    }
    //
    // Other methods
    //
    /**
     * Metodo interno recursivo para ver se é aplicavel
     */
    private boolean recAplicavel(Expressao expressao, Expressao lado) {

        //System.out.println("lado: " + lado.getNodo().toString() + " expressao: " + expressao.getNodo().toString() + " " + lado.getNodo().getClass().getCanonicalName());
        if (lado.getNodo() instanceof Geral) {
            if (assocGeralExp.containsKey(lado.getNodo().getNome())) {
                return expressao.equals2(assocGeralExp.get(lado.getNodo().getNome()));
            }
            assocGeralExp.put(lado.getNodo().getNome(), expressao.clone());
            return true;
        }


        if (expressao.getNodo().getAridade() != lado.getNodo().getAridade()) {
            return false;
        }
        if (!lado.getNodo().getNome().equals(expressao.getNodo().getNome())) {
            return false;
        }
        if (lado.getNodo().getAridade() == 0) {
            return true;
        }
        for (int i = 0; i < lado.getNodo().getAridade(); i++) {
            if (!this.recAplicavel(expressao.getRamos().get(i), lado.getRamos().get(i))) {
                return false;
            }
        }

        return true;

    }

    public Expressao aplica(Expressao exp) {
        /*if(!this.aplicavel(exp))
        return exp;*/

        //getExpGerais(this.esquerda, exp);
        recAplica(this.direita);
        //this.assocGeralExp = null;
        return this.resultado.clone();
    }

    private void recAplica(Expressao lado) {
        if (lado.getNodo() instanceof Geral && path.empty()) {
            Expressao sub = this.assocGeralExp.get(lado.getNodo().getNome());
            resultado = sub;
        }

        for (int i = 0; i < lado.getNodo().getAridade(); i++) {
            path.push(new Integer(i));
            if (lado.getRamos().get(i).getNodo() instanceof Geral) {
                Expressao sub = this.assocGeralExp.get(lado.getRamos().get(i).getNodo().getNome());
                out.println("HASH: " + this.assocGeralExp);
                out.println("FUI EM BUSCA DE: " + lado.getRamos().get(i).getNodo().getNome() + " LEVEI COM " + sub);
                resultado.insert(path, sub);
            } else {
                recAplica(lado.getRamos().get(i));
            }
            path.pop();
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append(this.nome + " -> ");
        sb.append(this.esquerda.toString() + " = ");
        sb.append(this.direita.toString() + ";");

        return sb.toString();
    }

    public Regra clone() {
        return new Regra(this.esquerda, this.direita, this.nome);
    }

    public boolean containsAssoc(String geral) {
        return this.assocGeralExp.containsKey(geral);
    }

    public void insertAssoc(String geral, Expressao exp) {
        this.assocGeralExp.put(geral, exp.clone());
    }
}

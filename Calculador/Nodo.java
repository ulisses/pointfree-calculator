package Calculador;

import Types.TypeT;
import Types.VarT;

public class Nodo {

    private String nome;
    private int aridade;
    private TypeT tipo;

    public Nodo() {
        this.nome = null;
        this.aridade = -1;
        this.tipo = new TypeT();
    }

    public Nodo(String label, int aridade) {
        nome = label;
        this.aridade = aridade;
    }

    public Nodo(String label, int aridade, TypeT tipo) {
        this.nome = label;
        this.aridade = aridade;
        this.tipo = tipo;
    }

    //
    // Methods
    //
    public void setTipo(TypeT tipo) {
        this.tipo = tipo;
    }

    public TypeT getTipo() {
        return tipo;
    }

    @Override
    public Nodo clone() {
        Nodo novo = new Nodo(this.nome, this.aridade);
        return novo;
    }

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

    //
    // Other methods
    //
    /**
     * Set the value of aridade
     * @param newVar the new value of aridade
     */
    public void setAridade(int newVar) {
        aridade = newVar;
    }

    /**
     * Get the value of aridade
     * @return the value of aridade
     */
    public int getAridade() {
        return aridade;
    }
    /*
    public String showTipo() {
    if (this.getAridade() == 0) {
    StringBuffer sb = new StringBuffer();
    sb.append(this + ":: " + this.tipo.getEsq());
    sb.append(" -> ");
    sb.append(this.tipo.getDir() + "\n");
    return sb.toString();
    }
    StringBuffer sb = new StringBuffer();
    for (Iterator it = this.ramos.iterator(); it.hasNext();) {
    sb.append(((Expressao) it.next()).showTipo());
    if (it.hasNext()) {
    sb.append(" -> ");
    }
    }
    return sb.toString();
    }
     */

    @Override
    public String toString() {
        return (this.nome);
    }

    public boolean equals2(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Nodo) {
            Nodo n = (Nodo) obj;
            return (n.nome.equals(this.nome) && n.aridade == this.aridade);
        }

        return false;
    }
}

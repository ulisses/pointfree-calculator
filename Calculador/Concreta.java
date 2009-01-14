package Calculador;

import Types.TypeT;

public class Concreta extends Nodo {

    private Expressao definicao;
    private String nomeDefinicao;

    public Concreta(Expressao definicao, String nomeDefinicao, String nome, int aridade) {
        super(nome, aridade);

        if (definicao != null) {
            this.definicao = definicao.clone();
        } else {
            this.definicao = null;
        }
        this.nomeDefinicao = nomeDefinicao;
    }

    public Concreta(String nome, int aridade, TypeT tipo) {
        super(nome, aridade, tipo);
    }
    
    public Concreta(String nome, int aridade, int esq, int dir) {
        super(nome, aridade, new TypeT(esq, dir));
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setDefinicao(Expressao definicao) {
        this.definicao = definicao.clone();
    }

    public Expressao getDefinicao() {

        if (definicao == null) {
            return null;
        }
        return definicao.clone();
    }

    public void setNomeDefinicao(String nomeDefinicao) {
        this.nomeDefinicao = nomeDefinicao;
    }

    public String getNomeDefinicao() {
        return nomeDefinicao;
    }

    @Override
    public Concreta clone() {
        return new Concreta(this.definicao, this.nomeDefinicao, this.getNome(), this.getAridade());
    }

    public boolean equals2(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Concreta) {
            Concreta n = (Concreta) obj;
            if (super.equals2(n) && this.nomeDefinicao == n.nomeDefinicao && this.definicao == n.definicao) {
                return true;
            }
            return (super.equals2(n) && this.nomeDefinicao.equals(n.getNomeDefinicao()) && this.definicao.equals2(n.getDefinicao()));
        }

        return false;
    }
}

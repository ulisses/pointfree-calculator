package Calculador;

import Types.TypeT;

public class Geral extends Nodo {

    public Geral(String label, int aridade, TypeT tipo) {
        super(label, aridade, tipo);
    }

    public Geral(String label, int aridade, int esq, int dir) {
        super(label, aridade, new TypeT(esq, dir));
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    @Override
    public Geral clone() {
        return new Geral(this.getNome(), this.getAridade(), this.getTipo());
    }

    @Override
    public boolean equals2(Object obj) {
        if (!(obj instanceof Geral)) {
            return false;
        }
        return (this.getAridade() == ((Geral) obj).getAridade() && this.getNome().equals(((Geral) obj).getNome()));
    }
}

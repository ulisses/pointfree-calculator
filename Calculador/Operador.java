package Calculador;

public class Operador extends Nodo {

    public Operador(String label, int aridade) {
        super(label, aridade);
    }

    @Override
    public String toString() {

        if (this.getNome().equals("/\\")) {
            return ("Δ");
        }
        if (this.getNome().equals("\\/")) {
            return ("∇");
        }
        if (this.getNome().equals("-|-")) {
            return ("+");
        }
        if (this.getNome().equals(".")) {
            return ("◦");
        }
        if (this.getNome().equals("><")) {
            return "×";
        }
        if (this.getNome().equals("&")) {
            return "∧";
        }
        if (this.getNome().equals(":=:")) {
            return "=";
        }
        return this.getNome();
    }

    public Operador clone() {
        return new Operador(this.getNome(), this.getAridade());
    }
}

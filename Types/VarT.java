package Types;

/**
 * 
 * @author ulisses
 * 
 */
public class VarT {

    private int tipo;

    public int getTipo() {
        return tipo;
    }

    public VarT() {
        this.tipo = -1;
    }

    public VarT(int nome) {
        this.tipo = nome;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("t" + this.tipo);
        return sb.toString();
    }
}

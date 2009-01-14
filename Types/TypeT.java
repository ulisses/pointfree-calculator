package Types;

public class TypeT {

    private int contador;
    private VarT esq;
    private VarT dir;

    public TypeT() {
        this.contador = -1;
        this.esq = new VarT();
        this.dir = new VarT();
    }

    public TypeT(int esq, int dir) {
        this.esq = new VarT(esq);
        this.dir = new VarT(dir);
    }

    public TypeT(VarT esq, VarT dir) {
        this.esq = esq;
        this.dir = dir;
    }

    /*
    public TypeT(Expressao exp) {
    if (exp.getNodo().getNome().equals(".")) {
    ArrayList<Expressao> ramos = exp.getRamos();
    this.esq = ramos.get(ramos.size()-1).getNodo().getEsq();
    this.dir = ramos.get(0).getNodo().getDir();
    } else {
    this.esq = null;
    this.dir = null;
    }
    }
     */
    public int getContador() {
        return contador;
    }

    public VarT getDir() {
        return dir;
    }

    public VarT getEsq() {
        return esq;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void setDir(VarT dir) {
        this.dir = dir;
    }

    public void setEsq(VarT esq) {
        this.esq = esq;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("(" + esq.toString());
        sb.append(" -> " + dir.toString() + ")");

        return sb.toString();
    }
}

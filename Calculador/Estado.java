package Calculador;

import java.util.ArrayList;

public class Estado {

    private ArrayList<Concreta> ac;
    private ArrayList<Regra> ar;

    public Estado(ArrayList<Concreta> ac, ArrayList<Regra> ar) {
        this.ac = ac;
        this.ar = ar;
    }

    public ArrayList<Concreta> getAc() {
        return ac;
    }

    public ArrayList<Regra> getAr() {
        return ar;
    }

    public void setAc(ArrayList<Concreta> ac) {
        this.ac = ac;
    }

    public void setAr(ArrayList<Regra> ar) {
        this.ar = ar;
    }
}

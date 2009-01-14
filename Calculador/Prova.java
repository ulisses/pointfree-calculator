package Calculador;

import static java.lang.System.out;

public class Prova {

    private Expressao prova;
    private Path pos;

    public Prova() {
        this.prova = new Expressao();
        this.pos = new Path();
    }

    public Prova(Expressao esq, Expressao dir) {
        Nodo root = new Operador(":=:", 2);
        this.prova = new Expressao(root, esq, dir);
        this.pos = new Path();
    }

    public Prova(Prova p) {
        this.prova = p.prova.clone();
        this.pos = p.pos.clone();

    }

    public Prova clone() {
        return new Prova(this);
    }

    @Override
    public String toString() {
        return prova.toString();
    }

    public String toString2(Path pos) {
        return prova.toString2(pos);
    }

    public Path getPos() {
        return this.pos.clone();
    }

    public Expressao getExpPos() {
        return this.prova.getSubExp(pos);
    }

    public void shift() {

        out.print(this.pos + " => ");

        if (!pos.getFilhos().isEmpty()) {
            int ari = this.getAridade();
            int size = pos.getFilhos().size();
            int i = pos.getFilhoN(size - 1) + 1;

            if (i < ari) {
                pos.pushFilho(i);
            }
        }

        out.println(this.pos);
    }

    public void down() {
        out.print(this.pos + " => ");

        if (!pos.getFilhos().isEmpty() && prova.getSubExp(pos).getAridade() > 0) {
            int i = pos.getFilhos().get(0);
            pos.newFilhos();
            pos.push(i);
        }

        out.println(this.pos);
    }

    public void up() {
        out.print(this.pos + " => ");
        
        /* decomentar codigo para repor algoritmo do rel */

     /*  if (!pos.getFilhos().isEmpty()) {
            pos.newFilhos();
        } else {*/
            if (!pos.empty()) {
                int i = pos.pop();
                
                /* Quitanços */
                pos.newFilhos();
                pos.pushFilho(i);
                /* fim de quitanços */
            }
        //}

        out.println(this.pos);
    }

    public void right() {
        out.print(this.pos + "=>");

        int ari = this.getAridade();
        if (pos.getFilhos().isEmpty()) {
            pos.pushFilho(0);
        } else {
            int i = pos.getFilhoN(0) + 1;
            if (i < ari) {
                pos.newFilhos();
                pos.pushFilho(i);
            }
        }

        out.println(this.pos);
    }

    public void left() {
        out.print(this.pos + "=>");

        if (pos.getFilhos().isEmpty()) {
            pos.pushFilho(0);
        } else {
            int i = pos.getFilhoN(0) - 1;
            pos.newFilhos();
            pos.pushFilho(0);
            if (i >= 0) {
                pos.newFilhos();
                pos.pushFilho(i);
            }

        }

        out.println(this.pos);
    }

    private int getAridade() {
        Path fresh = this.pos.clone();
        fresh.newFilhos();
        return this.prova.getSubExp(fresh).getAridade();

    }

    public void aplicaRegra(Regra r) {
        
        Expressao exp = r.aplica(prova.getSubExp(pos));

        if (!pos.empty() || !pos.getFilhos().isEmpty()) {
            this.prova.insert(pos, exp);
        } else {
            prova = exp.clone();
            this.pos = new Path();
        }

        this.pos = new Path();
    }

    public void aplicaConcreta(Concreta c) {
        Expressao exp = c.getDefinicao();

        if (!pos.empty() || !pos.getFilhos().isEmpty()) {
            this.prova.insert(pos, exp);
        } else {
            prova = exp.clone();
            this.pos = new Path();
        }

        this.pos = new Path();

    }
    
    public Expressao getSubExp(Path pos)
    {
        return prova.getSubExp(pos);
    }
    
}

package Calculador;

import Types.TypeT;
import Types.VarT;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Class Expressao
 */
public class Expressao {

    private ArrayList<Expressao> ramos;
    private ArrayList<String> gerais;
    private Nodo nodo;
    private TypeT tipo;

    public Expressao() {
        this.ramos = new ArrayList<Expressao>();
        this.nodo = new Nodo();
        this.tipo = new TypeT();
    }

    public Expressao(Nodo nodo) {
        this.nodo = nodo.clone();
        this.ramos = new ArrayList<Expressao>();
    //this.tipo = new TypeT(this);
    }

    public Expressao(Nodo nodo, Expressao esq, Expressao dir) {
        this.nodo = nodo.clone();
        this.ramos = new ArrayList<Expressao>();
        this.ramos.add(esq.clone()); // dir.clone()
        this.ramos.add(dir.clone()); // dir.clone()
    //this.tipo = new TypeT(this);
    }

    public Expressao(Nodo nodo, ArrayList<Expressao> ramos, TypeT tipo) {
        this.nodo = nodo.clone();
        this.setRamos(ramos);
        this.tipo = tipo;
    }

    public Expressao(Nodo nodo, ArrayList<Expressao> ramos) {
        this.nodo = nodo.clone();
        this.setRamos(ramos);
    //this.tipo = new TypeT(this);
    }

    @Override
    public Expressao clone() {
        return new Expressao(this.nodo, this.ramos);
    }

    public void setRamos(ArrayList<Expressao> newVar) {
        ArrayList<Expressao> fresh = new ArrayList<Expressao>();
        for (Expressao e : newVar) {
            fresh.add(e.clone());
        }

        this.ramos = fresh;
    //this.ramos = newVar;
    }

    public void setRamo(int i, Expressao exp) {
        this.ramos.set(i, exp.clone());
    }

    public ArrayList<Expressao> getRamos() {
        ArrayList<Expressao> tmp = new ArrayList<Expressao>();
        for (Expressao e : this.ramos) {
            tmp.add(e.clone());
        }
        return tmp;
    }

    public void setNodo(Nodo newVar) {
        this.nodo = newVar.clone();
    }

    public Nodo getNodo() {
        return nodo.clone();
    }

    public void setGerais(ArrayList<String> gerais) {
        this.gerais = gerais;
    }

    public void setTipo(TypeT tipo) {
        this.tipo = tipo;
    }

    public TypeT getTipo() {
        return tipo;
    }

    public Expressao getSubExp(Path path) {

        Expressao exp = this;

        if (!path.empty()) {
            Stack<Integer> p = path.clone().reverse();
            exp = this.ramos.get(p.pop());

            while (!p.empty()) {
                exp = exp.ramos.get(p.pop().intValue());
            }
        }

        // Path quer o pai
        if (path.getFilhos().isEmpty()) {
            return exp.clone();
        }

        // Path quer um filho
        if (path.getFilhos().size() == 1) {
            return exp.ramos.get(path.getFilhoN(0));
        }

        // Path quer n filhos
        ArrayList<Expressao> retRamos = new ArrayList<Expressao>();

        for (Integer f : path.getFilhos()) {
            retRamos.add(exp.ramos.get(f).clone());
        }

        Nodo n = exp.getNodo();
        n.setAridade(retRamos.size());
        Expressao ret = new Expressao(n, retRamos);

        return ret;
    }

    public int getAridade() {
        return this.nodo.getAridade();
    }

    public void insert(Path p, Expressao nova) {
        ArrayList<Expressao> newramos = new ArrayList<Expressao>();
        Expressao exp = this;
        Path path = p.clone();

        if (path.empty() && !path.getFilhos().isEmpty()) {
            int primeiro = path.getFilhoN(0);

            for (int i = 0; i < this.ramos.size(); i++) {
                if (!path.getFilhos().contains(i)) {
                    newramos.add(this.ramos.get(i).clone());
                }
                if (i == primeiro) {
                    newramos.add(nova.clone());
                }
            }

            this.setRamos(newramos);

        } else if (!path.empty()) {

            Stack<Integer> pathrev = path.reverse();

            while (pathrev.size() > 1) {
                int i = pathrev.pop();
                exp = exp.ramos.get(i);
            }

            if (path.getFilhos().isEmpty()) {
                int i = pathrev.pop();
                exp.setRamo(i, nova.clone());
                return;
            }

            int primeiro = path.getFilhoN(0);

            exp = exp.ramos.get(pathrev.pop());


            for (int i = 0; i < exp.ramos.size(); i++) {
                if (!path.getFilhos().contains(i)) {
                    newramos.add(exp.ramos.get(i).clone());
                }
                if (i == primeiro) {
                    newramos.add(nova.clone());
                }
            }

            exp.ramos = newramos;
            exp.setAridade(newramos.size());
        }


    }

    public void setAridade(int ari) {
        this.nodo.setAridade(ari);
    }

    public boolean equals2(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Expressao) {
            Expressao n = (Expressao) obj;

            boolean flag = nodo.equals2(n.getNodo());

            for (int i = 0; i < this.getAridade() && flag; i++) {
                flag = flag && n.ramos.get(i).equals2(this.ramos.get(i));
            }
            return flag;
        }

        return false;
    }

    public String showTipo() {
        if (this.nodo.getAridade() == 0) {
            StringBuffer sb = new StringBuffer();
            sb.append(this.nodo + ":: " + this.nodo.getTipo().getEsq());
            sb.append(" -> ");
            sb.append(this.nodo.getTipo().getDir() + "\n");
            return sb.toString();
        }
        StringBuffer sb = new StringBuffer();
        for (Iterator it = this.ramos.iterator() ; it.hasNext() ; ) {
            sb.append(((Expressao) it.next()).showTipo());
            if(it.hasNext())
                sb.append(" -> ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        //funcao
        if (this.nodo.getAridade() == 0) {
            return this.nodo.toString();
        }
        //operador binario
        if (this.nodo.getAridade() == 2) {
            StringBuffer sb = new StringBuffer();
            sb.append("(");
            //imprime lado esquerdo
            sb.append(this.ramos.get(0).toString() + " ");
            // imprime o nodo em si
            sb.append(this.nodo.toString() + " ");
            //imprime lado direito
            sb.append(this.ramos.get(1).toString() + " ");
            sb.append(")");
            return sb.toString();
        }
        //else -> operador n-ario
        StringBuffer sb = new StringBuffer();
        //   sb.append("(");
        for (Iterator it = this.ramos.iterator(); it.hasNext();) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(" " + this.nodo.toString() + " ");
            }
        }
        //sb.append(")");
        return sb.toString();
    }

    public String toString2(Path path) {


        ArrayList<Expressao> lista = new ArrayList<Expressao>();
        Expressao subexp = this;

        if (!path.empty()) {
            Stack<Integer> pathr = path.reverse();


            while (!pathr.empty()) {
                subexp = subexp.ramos.get(pathr.pop().intValue());
            }
        }

        if (path.getFilhos().isEmpty()) {
            lista.add(subexp);
            return recToString(lista);
        }

        for (Integer i : path.getFilhos()) {
            lista.add(subexp.ramos.get(i));
        }

        return recToString(lista);


    }

    private String recToString(ArrayList<Expressao> lista) {

        if (lista.contains(this)) {
            return ("\r" + this.toString() + "\r");
        }

        //funcao
        if (this.nodo.getAridade() == 0) {
            return this.nodo.toString();
        }

        //operador binario
        if (this.nodo.getAridade() == 2) {
            StringBuffer sb = new StringBuffer();
            sb.append("(");
            //imprime lado esquerdo
            sb.append(this.ramos.get(0).recToString(lista) + " ");
            // imprime o nodo em si
            sb.append(this.nodo.toString() + " ");
            //imprime lado direito
            sb.append(this.ramos.get(1).recToString(lista) + " ");
            sb.append(")");
            return sb.toString();
        }
        //else -> operador n-ario
        StringBuffer sb = new StringBuffer();
        sb.append("(");
        for (Iterator it = this.ramos.iterator(); it.hasNext();) {
            Expressao exp = (Expressao) it.next();
            sb.append(exp.recToString(lista).toString());
            if (it.hasNext()) {
                sb.append(" " + this.nodo.toString() + " ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public ArrayList<String> getGerais() {
        this.gerais = new ArrayList<String>();
        recGetGerais(this);
        return this.gerais;
    }

    private void recGetGerais(Expressao exp) {
        if (exp.getNodo() instanceof Geral) {
            this.gerais.add(exp.getNodo().getNome());
            return;
        }

        for (int i = 0; i < exp.getAridade(); i++) {
            this.recGetGerais(exp.getRamos().get(i));
        }
    }
}

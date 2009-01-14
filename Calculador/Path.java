package Calculador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Class Path. O nivel é uma stack, logo o array com o caminho está ao contrário, daí o metodo reverse
 */
public class Path {

    private Stack<Integer> nivel;
    private ArrayList<Integer> filhos;

    public Path() {
        nivel = new Stack<Integer>();
        this.filhos = new ArrayList<Integer>();
    }

    @Override
    public Path clone() {
        Path p = new Path();
        p.setNivel(this.nivel);
        p.setFilhos(this.filhos);
        return p;
    }

    public void setFilhos(ArrayList<Integer> filhos) {
        this.filhos = new ArrayList<Integer>();
        for (Integer f : filhos) {
            this.filhos.add(f);
        }
    }

    public ArrayList<Integer> getFilhos() {
        ArrayList<Integer> fresh = new ArrayList<Integer>();
        for (Integer i : this.filhos) {
            fresh.add(i);
        }

        return fresh;
    }
    
    public void newFilhos()
    {
        this.filhos = new ArrayList<Integer>();
    }
    
    public int getFilhoN(int i)
    {
        return this.filhos.get(i).intValue();
    }
    
     
    public void pushFilho(int i)
    {
        this.filhos.add(i);
    }
    
    public void popFilho(int i)
    {
        if(!this.filhos.isEmpty())
            this.filhos.remove(i);
    }

    public void setNivel(Stack<Integer> newVar) {
        this.nivel = new Stack<Integer>();

        for (Integer i : newVar) {
            this.nivel.add(i);
        }
    }

    public Stack<Integer> getNivel() {
        Stack<Integer> novo = new Stack<Integer>();

        for (Integer i : this.nivel) {
            novo.add(i);
        }

        return novo;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Path show = this.clone();
        Stack<Integer> path = show.reverse();
        sb.append("/");

        while (!path.empty())
            sb.append(path.pop() + "/");

        sb.append("[");
        for (Integer f : this.filhos)
            sb.append(f);
        sb.append("]");
        
        return sb.toString();
    }
    
    public Stack<Integer> reverse() {
        Stack<Integer> aux = new Stack<Integer>();
        Stack<Integer> auxp = this.clone().getNivel();

        while (!auxp.empty()) {
            aux.push(auxp.pop());
        }
        auxp = null;
        return aux;
    }

    public void push(int i) {
        this.nivel.push(new Integer(i));
    }

    public Integer pop() {
        return this.nivel.pop();
    }

    public boolean empty() {
        return this.nivel.empty();
    }

    public int size() {
        return this.nivel.size();
    }
}

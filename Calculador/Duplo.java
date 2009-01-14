package Calculador;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author geko
 */
public class Duplo<T,E> {
    private T a;
    private E b;
    
    public T getfst() {
        return a;
    }

    public E getsnd() {
        return b;
    }

    public void setfst(T f) {
        this.a = f;
    }

    public void setsnd(E s) {
        this.b = s;
    }
}

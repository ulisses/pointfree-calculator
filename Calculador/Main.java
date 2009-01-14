package Calculador;

import Parser.MainParser;
import Types.TypeT;

public class Main {

    public static void main(String[] args) throws Exception {
        String regras = new String("/home/ulisses/Desktop/Calculator/src/testeRegras");
        MainParser parser = new MainParser(regras);
        /*for (Regra r : parser.getRegras()) {
            System.out.println(r.getNome());
        }*/
        Expressao e = parser.getExpressao("id -|- l . k");
        System.out.println("EXP: " + e);
        System.out.println("TIPO: " + e.showTipo());
        //System.out.println("EXP: " + e);
        //new TypeT();
        
        //new GUI(parser);
    }
}

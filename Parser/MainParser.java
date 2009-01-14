package Parser;

import Calculador.Expressao;
import Calculador.Regra;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

public class MainParser {

    private String pathRegras;
    private PointfreeParser parser;

    public MainParser(String pathRegras) {
        this.pathRegras = pathRegras;
        PointfreeParser Parser1 = this.getParser(pathRegras);
        ArrayList<String> ln = Parser1.getListaNomesConcreta();

        PointfreeParser parser2 = this.getParser(pathRegras);
        parser2.setDefinicoes(ln);
        this.parser = parser2;
    }

    public Expressao getExpressao(String exp) {
        PointfreeParser pfp = this.getParserExp(exp);
        try {
            return pfp.exp();
        } catch (RecognitionException ex) {
        }
        return null;
    }

    public ArrayList<Regra> getRegras() {
        return this.parser.getRegras();
    }

    private PointfreeParser getParser(String s) {
        FileInputStream fin = null;
        ANTLRInputStream input = null;
        PointfreeLexer lexer = null;
        CommonTokenStream tokens = null;
        PointfreeParser parser2 = null;

        try {
            fin = new FileInputStream(s);
            input = new ANTLRInputStream(fin);
            lexer = new PointfreeLexer(input);
            tokens = new CommonTokenStream(lexer);
            parser2 = new PointfreeParser(tokens);
            fin.close();
        } catch (Exception e) {
        }

        return parser2;
    }

    private PointfreeParser getParserExp(String s) {
        ANTLRStringStream input = null;
        PointfreeLexer lexer = null;
        CommonTokenStream tokens = null;
        PointfreeParser parser2 = null;

        try {
            input = new ANTLRStringStream(s);
            lexer = new PointfreeLexer(input);
            tokens = new CommonTokenStream(lexer);
            parser2 = new PointfreeParser(tokens);
        } catch (Exception e) {
        }

        return parser2;
    }
}

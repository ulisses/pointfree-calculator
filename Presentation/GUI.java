package Calculador;

import Parser.MainParser;
import static java.lang.System.out;
import Presentation.Highlighting;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;
import javax.swing.JOptionPane;

public class GUI extends javax.swing.JFrame {

    MainParser parser;
    Prova prova;
    Stack<Duplo<Prova, String>> historico;
    Highlighting hl = new Highlighting();

    public void save() {

    }

    public void load() {

    }

    public void export() {

    }
/*
    private void showAridades(Expressao e) {
        out.println(e.getNodo().getNome() + " " + e.getNodo().getAridade());

        for (Expressao exp : e.getRamos()) {
            showAridades(exp);
        }
    }
*/
    private void aplica() {
        int index = jList1.getSelectedIndex();
        if (index > -1) {
            Regra r = getRegra(s[index]);
            Concreta c = getConcreta(s[index]);
            Duplo<Prova, String> duplo = new Duplo<Prova, String>();
            duplo.setfst(prova.clone());

            if (c == null) {
                duplo.setsnd(r.getNome());

                if (!r.aplicavel(prova.getSubExp(prova.getPos()))) {
                    return;
                }

                for (String geral : r.getDireita().getGerais()) {
                    if (!r.containsAssoc(geral)) {
                        String expS = JOptionPane.showInputDialog(null, "Insere " + geral + " de " + r.toString());
                        Expressao exp = parser.getExpressao(expS);
                        r.insertAssoc(geral, exp);
                    }
                }

                prova.aplicaRegra(r);
            } else { // aplica definicao
                duplo.setsnd(c.getNomeDefinicao());
                prova.aplicaConcreta(c.clone());
            }

            historico.push(duplo);
        }


    }

    private String showHist() {
        StringBuffer sb = new StringBuffer();
        for (Duplo<Prova, String> dp : this.historico) {
            sb.append(dp.getfst().toString() + "\n<=> { " + dp.getsnd() + " }" + "\n");
        }
        return sb.toString();
    }

    public void keyHandler(KeyEvent e) {
        boolean flag = false;

        switch (e.getKeyCode()) {

            case KeyEvent.VK_RIGHT:
                j = 0;
                prova.right();
                break;
            case KeyEvent.VK_LEFT:
                j = 0;
                prova.left();
                break;
            case KeyEvent.VK_DOWN:
                j = 0;
                prova.down();
                break;
            case KeyEvent.VK_UP:
                j = 0;
                prova.up();
                break;
            case KeyEvent.VK_SPACE:
                j = 0;
                aplica();
                break;
            case KeyEvent.VK_BACK_SPACE:
                j = 0;
                if (!historico.empty()) {
                    prova = historico.pop().getfst();
                }
                break;
            case KeyEvent.VK_SHIFT:
                j = 0;
                prova.shift();
                out.println("SHITF: " + prova.getExpPos());
                //       s = aplicaveis(prova.getExpPos());
                // jList1.setListData(s);
                break;
            case KeyEvent.VK_PAGE_DOWN:
                flag = true;
                if (j >= jList1.getModel().getSize()) {
                    j = 0;
                }
                jList1.setSelectedIndex(j++);
                break;
            case KeyEvent.VK_PAGE_UP:
                flag = true;
                if (j <= 0) {
                    j = jList1.getModel().getSize();
                }
                jList1.setSelectedIndex(--j);
                break;
            }

        if (!flag) {
            s = aplicaveis(prova.getExpPos());
            jList1.setListData(s);
        }

        jTextArea1.setText(showHist() + prova.toString2(prova.getPos()));

        hl.removeHighlights(jTextArea1);
        hl.highlight(jTextArea1, "\r" + prova.getExpPos() + "\r");

    }

    public GUI(MainParser parser) {
        this.parser = parser;
        this.historico = new Stack<Duplo<Prova, String>>();
        setVisible(true);
        initComponents();
    }

    public String[] aplicaveis(Expressao exp) {
        StringBuilder buffer = new StringBuilder();
        for (Regra r : this.parser.getRegras()) {
            if (r.aplicavel(exp)) {
                buffer.append(r.getNome());
                buffer.append(" ");
            }
        }

/*        for (Concreta c : this.parser.getDefinicoes2()) {

            if (c.getNome().equals(exp.getNodo().getNome())) {
                buffer.append(c.getNomeDefinicao());
                buffer.append(" ");
            }

        }
*/        return buffer.toString().split(" ");
    }

    public Regra getRegra(String nome) {
        for (Regra r : this.parser.getRegras()) {
            if (r.getNome().equals(nome)) {
                return r;
            }
        }

        return null;
    }

    public Concreta getConcreta(String nome) {
/*        for (Concreta r : this.parser.getDefinicoes2()) {
            if (r.getNomeDefinicao().equals(nome)) {
                return r;
            }
        }
*/
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Dialog", 1, 14));
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextArea1);
        KeyListener mouseListener = new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                keyHandler(e);
            }
        };

        jTextArea1.addKeyListener (mouseListener);

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(jList1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("swap . swap = id\n\n");
        jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(jTextArea2);
        KeyListener keyListener = new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode()==KeyEvent.VK_ENTER){

                    jTextArea2.removeAll();
                    String exps[] = jTextArea2.getText().split("=");
                    prova = new Prova(parser.getExpressao(exps[0]), parser.getExpressao(exps[1]));
                    jTextArea1.setText(prova.toString());
                    transferFocus();

                }
                //if(e.getKeyCode()==KeyEvent.VK_LEFT)

            }
        };

        jTextArea2.addKeyListener(keyListener);

        jMenu1.setText("File");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Save");
        jMenu1.add(jMenuItem3);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Load");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Sair");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setText("Regras");
        jMenu2.add(jMenuItem5);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Export");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private int i = 0;
    private int j = 0;
    private String s[];
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}

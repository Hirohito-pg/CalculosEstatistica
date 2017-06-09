import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sobre extends JFrame {
    private JLabel jLabel_Curso;
    private JLabel jLabel_Faculdade;
    private JLabel jLabel_Heitor;
    private JLabel jLabel_Hirohito;
    private JLabel jLabel_Ludimilla;
    private JLabel jLabel_Periodo;
    private JLabel jLabel_VersaoData;
    private JLabel jLabel_VersaoTexto;
    private JPanel jPanel_Nomes;
    private JPanel jPanel_Programador;
    private JPanel jPanel_Sistema;

    public Sobre() {
        initComponents();
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (Exception e) {
            Logger.getLogger(CalculosEstatisticaPrincipal.class.getName()).log(Level.SEVERE, null, e);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sobre().setVisible(true);
            }
        });
    }

    private void initComponents() {
        this.jPanel_Programador = new JPanel();
        this.jLabel_Faculdade = new JLabel();
        this.jLabel_Curso = new JLabel();
        this.jLabel_Periodo = new JLabel();
        this.jPanel_Nomes = new JPanel();
        this.jLabel_Hirohito = new JLabel();
        this.jLabel_Heitor = new JLabel();
        this.jLabel_Ludimilla = new JLabel();
        this.jPanel_Sistema = new JPanel();
        this.jLabel_VersaoTexto = new JLabel();
        this.jLabel_VersaoData = new JLabel();
        setTitle("Sobre");
        setBackground(new Color(255, 255, 255));
        setLocationByPlatform(true);
        setName("Sobre");
        setResizable(false);
        this.jPanel_Programador.setBorder(BorderFactory.createTitledBorder(null, "Programadores", 0, 0, new Font("Times New Roman", 1, 14)));
        this.jPanel_Programador.setFont(new Font("Times New Roman", 0, 14));
        this.jLabel_Faculdade.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_Faculdade.setText("FACTO");
        this.jLabel_Faculdade.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel_Faculdade.setMaximumSize(new Dimension(50, 50));
        this.jLabel_Faculdade.setMinimumSize(new Dimension(50, 50));
        this.jLabel_Faculdade.setPreferredSize(new Dimension(50, 50));
        this.jLabel_Curso.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_Curso.setText("Sistemas de Informação");
        this.jLabel_Curso.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel_Curso.setMaximumSize(new Dimension(50, 50));
        this.jLabel_Curso.setMinimumSize(new Dimension(50, 50));
        this.jLabel_Curso.setPreferredSize(new Dimension(50, 50));
        this.jLabel_Periodo.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_Periodo.setText("3º Período");
        this.jLabel_Periodo.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel_Periodo.setMaximumSize(new Dimension(50, 50));
        this.jLabel_Periodo.setMinimumSize(new Dimension(50, 50));
        this.jLabel_Periodo.setPreferredSize(new Dimension(50, 50));
        this.jPanel_Nomes.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel_Hirohito.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_Hirohito.setText("Hirohito Pereira;");
        this.jLabel_Heitor.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_Heitor.setText("Heitor Vinicius;");
        this.jLabel_Ludimilla.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_Ludimilla.setText("Ludimilla Cantareli.");
        GroupLayout jPanel_NomesLayout = new GroupLayout(this.jPanel_Nomes);
        this.jPanel_Nomes.setLayout(jPanel_NomesLayout);
        jPanel_NomesLayout.setHorizontalGroup(jPanel_NomesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel_NomesLayout.createSequentialGroup().addGroup(jPanel_NomesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel_Hirohito, -1, 189, 32767).addComponent(this.jLabel_Heitor, -1, 189, 32767).addComponent(this.jLabel_Ludimilla, -1, 189, 32767)).addContainerGap()));
        jPanel_NomesLayout.setVerticalGroup(jPanel_NomesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_NomesLayout.createSequentialGroup().addComponent(this.jLabel_Hirohito).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_Heitor).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_Ludimilla).addContainerGap()));
        GroupLayout jPanel_ProgramadorLayout = new GroupLayout(this.jPanel_Programador);
        this.jPanel_Programador.setLayout(jPanel_ProgramadorLayout);
        jPanel_ProgramadorLayout.setHorizontalGroup(jPanel_ProgramadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel_ProgramadorLayout.createSequentialGroup().addGroup(jPanel_ProgramadorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel_Periodo, -1, 203, 32767).addComponent(this.jLabel_Curso, -1, 203, 32767).addComponent(this.jLabel_Faculdade, -1, 203, 32767).addComponent(this.jPanel_Nomes, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        jPanel_ProgramadorLayout.setVerticalGroup(jPanel_ProgramadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_ProgramadorLayout.createSequentialGroup().addComponent(this.jPanel_Nomes, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_Faculdade, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_Curso, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_Periodo, -2, 30, -2).addContainerGap(-1, 32767)));
        this.jPanel_Sistema.setBorder(BorderFactory.createTitledBorder(null, "Sistema", 0, 0, new Font("Times New Roman", 1, 14)));
        this.jLabel_VersaoTexto.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_VersaoTexto.setText("Ultima versão em :");
        this.jLabel_VersaoTexto.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel_VersaoTexto.setMaximumSize(new Dimension(50, 50));
        this.jLabel_VersaoTexto.setMinimumSize(new Dimension(50, 50));
        this.jLabel_VersaoTexto.setPreferredSize(new Dimension(50, 50));
        this.jLabel_VersaoData.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_VersaoData.setText("Quarta, 07 de março de 2012");
        this.jLabel_VersaoData.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel_VersaoData.setMaximumSize(new Dimension(50, 50));
        this.jLabel_VersaoData.setMinimumSize(new Dimension(50, 50));
        this.jLabel_VersaoData.setPreferredSize(new Dimension(50, 50));
        GroupLayout jPanel_SistemaLayout = new GroupLayout(this.jPanel_Sistema);
        this.jPanel_Sistema.setLayout(jPanel_SistemaLayout);
        jPanel_SistemaLayout.setHorizontalGroup(jPanel_SistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel_VersaoTexto, -1, 239, 32767).addComponent(this.jLabel_VersaoData, -1, 239, 32767));
        jPanel_SistemaLayout.setVerticalGroup(jPanel_SistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_SistemaLayout.createSequentialGroup().addComponent(this.jLabel_VersaoTexto, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_VersaoData, -2, 38, -2).addGap(0, 0, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel_Programador, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel_Sistema, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel_Sistema, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel_Programador, GroupLayout.Alignment.LEADING, -2, -1, -2)).addContainerGap()));
        pack();
        setLocationRelativeTo(null);
    }

    public JLabel getjLabel_Curso() {
        return this.jLabel_Curso;
    }

    public void setjLabel_Curso(JLabel jLabel_Curso) {
        this.jLabel_Curso = jLabel_Curso;
    }

    public JLabel getjLabel_Faculdade() {
        return this.jLabel_Faculdade;
    }

    public void setjLabel_Faculdade(JLabel jLabel_Faculdade) {
        this.jLabel_Faculdade = jLabel_Faculdade;
    }

    public JLabel getjLabel_Heitor() {
        return this.jLabel_Heitor;
    }

    public void setjLabel_Heitor(JLabel jLabel_Heitor) {
        this.jLabel_Heitor = jLabel_Heitor;
    }

    public JLabel getjLabel_Hirohito() {
        return this.jLabel_Hirohito;
    }

    public void setjLabel_Hirohito(JLabel jLabel_Hirohito) {
        this.jLabel_Hirohito = jLabel_Hirohito;
    }

    public JLabel getjLabel_Ludimilla() {
        return this.jLabel_Ludimilla;
    }

    public void setjLabel_Ludimilla(JLabel jLabel_Ludimilla) {
        this.jLabel_Ludimilla = jLabel_Ludimilla;
    }

    public JLabel getjLabel_Periodo() {
        return this.jLabel_Periodo;
    }

    public void setjLabel_Periodo(JLabel jLabel_Periodo) {
        this.jLabel_Periodo = jLabel_Periodo;
    }

    public JLabel getjLabel_VersaoData() {
        return this.jLabel_VersaoData;
    }

    public void setjLabel_VersaoData(JLabel jLabel_VersaoData) {
        this.jLabel_VersaoData = jLabel_VersaoData;
    }

    public JLabel getjLabel_VersaoTexto() {
        return this.jLabel_VersaoTexto;
    }

    public void setjLabel_VersaoTexto(JLabel jLabel_VersaoTexto) {
        this.jLabel_VersaoTexto = jLabel_VersaoTexto;
    }

    public JPanel getjPanel_Nomes() {
        return this.jPanel_Nomes;
    }

    public void setjPanel_Nomes(JPanel jPanel_Nomes) {
        this.jPanel_Nomes = jPanel_Nomes;
    }

    public JPanel getjPanel_Programador() {
        return this.jPanel_Programador;
    }

    public void setjPanel_Programador(JPanel jPanel_Programador) {
        this.jPanel_Programador = jPanel_Programador;
    }

    public JPanel getjPanel_Sistema() {
        return this.jPanel_Sistema;
    }

    public void setjPanel_Sistema(JPanel jPanel_Sistema) {
        this.jPanel_Sistema = jPanel_Sistema;
    }
}
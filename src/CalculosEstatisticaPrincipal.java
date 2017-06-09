import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculosEstatisticaPrincipal extends JFrame {
    private final JLabel jLabel_FinalizarDados = new JLabel();
    private AtributosEstatistico atributos_estatistico = new AtributosEstatistico();
    private LESCalculos les_calculos = new LESCalculos();
    private Sobre sobre = new Sobre();
    private Tutorial tutorial = new Tutorial();
    private boolean erro_inicial = false;
    private JScrollPane JScrollPane_Tabela;
    private JButton jButton_Calcular;
    private JButton jButton_GerarTabela;
    private JLabel jLabel_AmplitudeTotal;
    private JLabel jLabel_CoeficienteVariacao;
    private JLabel jLabel_DesvioAbsoluto;
    private JLabel jLabel_DesvioPadraoPopulacional;
    private JLabel jLabel_Indice;
    private JLabel jLabel_Intervalo;
    private JLabel jLabel_LimiteInferiorClasse;
    private JLabel jLabel_MediaAritmetica;
    private JLabel jLabel_MediaClasse;
    private JLabel jLabel_QuantidadeClasses;
    private JLabel jLabel_SomaFi;
    private JLabel jLabel_VariaciaPopulacional;
    private JLabel jLabel_Xmax;
    private JLabel jLabel_Xmin;
    private JLayeredPane jLayeredPane_Resultados;
    private JLayeredPane jLayeredPane_Tabela;
    private JMenu jMenu1;
    private JMenuBar jMenuBar;
    private JMenuItem jMenuItemAcoes_DesvioAbsoluto;
    private JMenuItem jMenuItemAcoes_Intervalo;
    private JMenuItem jMenuItemAcoes_MediaAritmetica;
    private JMenuItem jMenuItemAcoes_MediaClasses;
    private JMenuItem jMenuItemAcoes_SomaFi;
    private JMenuItem jMenuItemAcoes_Variacia;
    private JMenuItem jMenuItemArquivo_Novo;
    private JMenuItem jMenuItemArquivo_Sair;
    private JMenuItem jMenuItemEditar_ApagarDadosFi;
    private JMenu jMenu_Acoes;
    private JMenu jMenu_Ajuda;
    private JMenu jMenu_Arquivo;
    private JMenu jMenu_Editar;
    private JPanel jPanel_RecebeDados;
    private JPanel jPanel_Resultados;
    private JPanel jPanel_Tabela;
    private JTabbedPane jTabbedPaneDados;
    private JTable jTable_Tabela;
    private JTextField jText_Indice;
    private JTextField jText_Xmax;
    private JTextField jText_Xmin;

    public CalculosEstatisticaPrincipal() {
        initComponents();
        bloqueiarAbaInicial();
        this.jTable_Tabela.setSelectionMode(1);
        this.jText_Xmin.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == '.') {
                    if ("".equals(CalculosEstatisticaPrincipal.this.getjText_Xmin().getText())) e.consume();
                    else {
                        for (int painel = CalculosEstatisticaPrincipal.this.getjText_Xmin().getText().length(); painel > 0; painel--) {
                            Character ponto = Character.valueOf(CalculosEstatisticaPrincipal.this.getjText_Xmin().getText().charAt(painel - 1));
                            if (".".equals(ponto.toString())) {
                                e.consume();
                            }
                        }
                    }
                }
                if ((!Character.isDigit(c)) && (c != '.')) e.consume();
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });
        this.jText_Xmax.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == '.') {
                    if ("".equals(CalculosEstatisticaPrincipal.this.getjText_Xmax().getText())) e.consume();
                    else {
                        for (int painel = CalculosEstatisticaPrincipal.this.getjText_Xmax().getText().length(); painel > 0; painel--) {
                            Character ponto = Character.valueOf(CalculosEstatisticaPrincipal.this.getjText_Xmax().getText().charAt(painel - 1));
                            if (".".equals(ponto.toString())) {
                                e.consume();
                            }
                        }
                    }
                }
                if ((!Character.isDigit(c)) && (c != '.')) e.consume();
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });
        this.jText_Indice.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) e.consume();
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });
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
                new CalculosEstatisticaPrincipal().setVisible(true);
            }
        });
    }

    private void bloqueiarAbaInicial() {
        getjTabbedPaneDados().setEnabledAt(0, true);
        getjTabbedPaneDados().setEnabledAt(1, false);
        getjTabbedPaneDados().setEnabledAt(2, false);
        getjMenuItemEditar_ApagarDadosFi().setEnabled(false);
        getjMenuItemAcoes_Intervalo().setEnabled(false);
        getjMenuItemAcoes_MediaClasses().setEnabled(false);
        getjMenuItemAcoes_SomaFi().setEnabled(false);
        getjMenuItemAcoes_MediaAritmetica().setEnabled(false);
        getjMenuItemAcoes_Variacia().setEnabled(false);
        getjMenuItemAcoes_DesvioAbsoluto().setEnabled(false);
    }

    public void verificarErros() {
        if ("".equals(getjText_Xmax().getText())) {
            setErro_inicial(true);
        }
        if ("".equals(getjText_Xmin().getText())) {
            setErro_inicial(true);
        }
        if ("".equals(getjText_Indice().getText())) {
            setErro_inicial(true);
        }
        if (isErro_inicial() != true) {
            setAtributos_estatistico(new AtributosEstatistico());
            getAtributos_estatistico().setMaximo(Float.valueOf(Float.parseFloat(getjText_Xmax().getText())));
            getAtributos_estatistico().setMinimo(Float.valueOf(Float.parseFloat(getjText_Xmin().getText())));
            getAtributos_estatistico().setTamanho(Integer.valueOf(Integer.parseInt(getjText_Indice().getText())));
            if (getAtributos_estatistico().getMinimo().floatValue() >= getAtributos_estatistico().getMaximo().floatValue()) {
                JOptionPane.showMessageDialog(null, "Valor de Xmáximo deve ser maior que Xmínimo!", "Erro", 0);
                setErro_inicial(true);
            } else if (getAtributos_estatistico().getTamanho().intValue() < 1) {
                JOptionPane.showMessageDialog(null, "Valor da quantidade de classes deve ser maior que 0!", "Erro", 0);
                setErro_inicial(true);
            }
        } else if (isErro_inicial() == true) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!", "Erro", 0);
        }
    }

    public void verificarFi() {
        boolean erro_fi = true;
        while (erro_fi == true) {
            erro_fi = false;
            for (int i = 0; i < getAtributos_estatistico().getTamanho().intValue(); i++) {
                if ((getjTable_Tabela().getValueAt(i, 2) == null) || (Integer.parseInt(getjTable_Tabela().getValueAt(i, 2).toString()) <= 0)) {
                    erro_fi = true;
                }
            }
            if (erro_fi == true) {
                break;
            }
        }
        if (erro_fi == true) {
            for (int v = 0; v < getAtributos_estatistico().getTamanho().intValue(); v++) {
                getjTable_Tabela().setValueAt(null, v, 3);
                getjTable_Tabela().setValueAt(null, v, 4);
                getjTable_Tabela().setValueAt(null, v, 5);
                getjTable_Tabela().setValueAt(null, v, 6);
                getjTable_Tabela().setValueAt(null, v, 7);
                getjTable_Tabela().setValueAt(null, v, 8);
                getjTable_Tabela().setValueAt(null, v, 9);
            }
            getjTabbedPaneDados().setEnabledAt(0, false);
            getjTabbedPaneDados().setEnabledAt(1, true);
            getjTabbedPaneDados().setEnabledAt(2, false);
            getjMenuItemAcoes_Intervalo().setEnabled(true);
            getjMenuItemAcoes_MediaClasses().setEnabled(false);
            getjMenuItemAcoes_SomaFi().setEnabled(false);
            getjMenuItemAcoes_MediaAritmetica().setEnabled(false);
            getjMenuItemAcoes_Variacia().setEnabled(false);
            getjMenuItemAcoes_DesvioAbsoluto().setEnabled(false);
            JOptionPane.showMessageDialog(null, "Campos de fi faltando ou\ndados de fi preenchidos incorretamente!", "Erro", 0);
        } else if (!erro_fi) {
            for (int i = 0; i < getAtributos_estatistico().getTamanho().intValue(); i++) {
                getLes_calculos().getVetor()[i].setFi(Integer.valueOf(Integer.parseInt(getjTable_Tabela().getValueAt(i, 2).toString())));
            }
            AtributosEstatistico ref_atributos_estatistico = getAtributos_estatistico();
            LESCalculos ref_les_calculos = getLes_calculos();
            getLes_calculos().calcularMedia(ref_atributos_estatistico, ref_les_calculos, getjTable_Tabela());
            getLes_calculos().calcularEstatistica(ref_atributos_estatistico, ref_les_calculos, getjTable_Tabela());
            for (int v = 0; v < getAtributos_estatistico().getTamanho().intValue(); v++) {
                getjTable_Tabela().setValueAt(getLes_calculos().getVetor()[v].getFac(), v, 3);
                getjTable_Tabela().setValueAt(getLes_calculos().getVetor()[v].getPonto_medio(), v, 4);
                getjTable_Tabela().setValueAt(getLes_calculos().getVetor()[v].getMedia_aritmetica(), v, 5);
                getjTable_Tabela().setValueAt(getLes_calculos().getVetor()[v].getDesvio_absoluto_parte(), v, 6);
                getjTable_Tabela().setValueAt(getLes_calculos().getVetor()[v].getDesvio_absoluto(), v, 7);
                getjTable_Tabela().setValueAt(getLes_calculos().getVetor()[v].getVariancia_parte(), v, 8);
                getjTable_Tabela().setValueAt(getLes_calculos().getVetor()[v].getVariancia(), v, 9);
            }
            getjLabel_QuantidadeClasses().setText("Quantidade de Classes:                        " + getAtributos_estatistico().getTamanho());
            getjLabel_LimiteInferiorClasse().setText("Limite Inferior da Primeira Classe:       " + getLes_calculos().getVetor()[0].getMinimo());
            getjLabel_Intervalo().setText("Amplitude das Classes:                        " + getAtributos_estatistico().getIntervalo());
            getjLabel_MediaClasse().setText("Média das Classes:                              " + getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getMedia_classe());
            getjLabel_SomaFi().setText("Soma dos fi:                                        " + getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getSoma_fi());
            getjLabel_MediaAritmetica().setText("Média Aritmetica:                                " + getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getMedia_aritmetica_total());
            getjLabel_VariaciaPopulacional().setText("Variância Populacional:                        " + getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getVariancia_total() + "²");
            getjLabel_DesvioPadraoPopulacional().setText("Desvio Padrão Populacional:                 " + getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getDesvio_padrao_total());
            float at = getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getMaximo().floatValue() - getLes_calculos().getVetor()[0].getMinimo().floatValue();
            getjLabel_AmplitudeTotal().setText("Amplitude Total:                                  " + at);
            getjLabel_CoeficienteVariacao().setText("Coeficiente de Variação:                       " + getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getCoeficiente_variacao_total() + "%");
            getjLabel_DesvioAbsoluto().setText("Desvio Absoluto Médio:                        " + getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getDesvio_absoluto_total());
            getjTabbedPaneDados().setEnabledAt(0, false);
            getjTabbedPaneDados().setEnabledAt(1, true);
            getjTabbedPaneDados().setEnabledAt(2, true);
            getjMenuItemAcoes_Intervalo().setEnabled(true);
            getjMenuItemAcoes_MediaClasses().setEnabled(true);
            getjMenuItemAcoes_SomaFi().setEnabled(true);
            getjMenuItemAcoes_MediaAritmetica().setEnabled(true);
            getjMenuItemAcoes_Variacia().setEnabled(true);
            getjMenuItemAcoes_DesvioAbsoluto().setEnabled(true);
        }
    }

    public void receberDados() {
        setErro_inicial(false);
        verificarErros();
        if (!isErro_inicial()) {
            DefaultTableModel model = (DefaultTableModel) getjTable_Tabela().getModel();
            Object valores = null;
            float total = (getAtributos_estatistico().getMaximo().floatValue() - getAtributos_estatistico().getMinimo().floatValue()) / getAtributos_estatistico().getTamanho().intValue();
            getAtributos_estatistico().setIntervalo(Float.valueOf(total));
            getLes_calculos().alterarDadoslTabela(getAtributos_estatistico());
            getjTabbedPaneDados().setEnabledAt(0, false);
            getjTabbedPaneDados().setEnabledAt(1, true);
            getjTabbedPaneDados().setEnabledAt(2, false);
            getjMenuItemEditar_ApagarDadosFi().setEnabled(true);
            getjMenuItemAcoes_Intervalo().setEnabled(true);
            getjTabbedPaneDados().setSelectedIndex(1);
            for (int i = getjTable_Tabela().getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            for (int i = 0; i < getAtributos_estatistico().getTamanho().intValue(); i++) {
                Object[] linha = (Object[]) valores;
                model.addRow(linha);
                getjTable_Tabela().setValueAt(Integer.valueOf(i + 1), i, 0);
                getjTable_Tabela().setValueAt(getLes_calculos().getVetor()[i].getMinimo() + " - " + getLes_calculos().getVetor()[i].getMaximo(), i, 1);
            }
            JOptionPane.showMessageDialog(null, "Preencha todos os valores de fi!", "Atenção", 1);
        }
    }

    private void initComponents() {
        this.jTabbedPaneDados = new JTabbedPane();
        this.jPanel_RecebeDados = new JPanel();
        this.jLabel_Xmin = new JLabel();
        this.jText_Xmax = new JTextField();
        this.jLabel_Xmax = new JLabel();
        this.jText_Xmin = new JTextField();
        this.jLabel_Indice = new JLabel();
        this.jText_Indice = new JTextField();
        this.jButton_GerarTabela = new JButton();
        this.jPanel_Tabela = new JPanel();
        this.jLayeredPane_Tabela = new JLayeredPane();
        this.JScrollPane_Tabela = new JScrollPane();
        this.jTable_Tabela = new JTable();
        this.jButton_Calcular = new JButton();
        this.jPanel_Resultados = new JPanel();
        this.jLayeredPane_Resultados = new JLayeredPane();
        this.jLabel_QuantidadeClasses = new JLabel();
        this.jLabel_MediaClasse = new JLabel();
        this.jLabel_VariaciaPopulacional = new JLabel();
        this.jLabel_DesvioAbsoluto = new JLabel();
        this.jLabel_SomaFi = new JLabel();
        this.jLabel_MediaAritmetica = new JLabel();
        this.jLabel_LimiteInferiorClasse = new JLabel();
        this.jLabel_Intervalo = new JLabel();
        this.jLabel_AmplitudeTotal = new JLabel();
        this.jLabel_CoeficienteVariacao = new JLabel();
        this.jLabel_DesvioPadraoPopulacional = new JLabel();
        this.jMenuBar = new JMenuBar();
        this.jMenu_Arquivo = new JMenu();
        this.jMenuItemArquivo_Novo = new JMenuItem();
        this.jMenuItemArquivo_Sair = new JMenuItem();
        this.jMenu_Editar = new JMenu();
        this.jMenuItemEditar_ApagarDadosFi = new JMenuItem();
        this.jMenu_Acoes = new JMenu();
        this.jMenuItemAcoes_Intervalo = new JMenuItem();
        this.jMenuItemAcoes_MediaClasses = new JMenuItem();
        this.jMenuItemAcoes_SomaFi = new JMenuItem();
        this.jMenuItemAcoes_MediaAritmetica = new JMenuItem();
        this.jMenuItemAcoes_Variacia = new JMenuItem();
        this.jMenuItemAcoes_DesvioAbsoluto = new JMenuItem();
        this.jMenu1 = new JMenu();
        this.jMenu_Ajuda = new JMenu();
        setDefaultCloseOperation(3);
        setTitle("Cálculos Estatísticos - Com Classe");
        setBackground(new Color(255, 255, 255));
        setBounds(new Rectangle(0, 0, 0, 0));
        setCursor(new Cursor(0));
        setFont(new Font("Times New Roman", 0, 18));
        setForeground(new Color(0, 0, 0));
        setName("jFrame");
        setResizable(false);
        this.jLabel_Xmin.setBackground(new Color(255, 255, 255));
        this.jLabel_Xmin.setFont(new Font("Times New Roman", 1, 24));
        this.jLabel_Xmin.setText("Entre com o valor de Xmínimo:");
        this.jLabel_Xmin.setMaximumSize(new Dimension(323, 22));
        this.jLabel_Xmin.setMinimumSize(new Dimension(323, 22));
        this.jLabel_Xmin.setPreferredSize(new Dimension(323, 22));
        this.jText_Xmax.setFont(new Font("Times New Roman", 1, 36));
        this.jText_Xmax.setMaximumSize(new Dimension(6, 28));
        this.jText_Xmax.setPreferredSize(new Dimension(24, 28));
        this.jLabel_Xmax.setBackground(new Color(255, 255, 255));
        this.jLabel_Xmax.setFont(new Font("Times New Roman", 1, 24));
        this.jLabel_Xmax.setText("Entre com o valor de Xmáximo:");
        this.jLabel_Xmax.setMaximumSize(new Dimension(323, 22));
        this.jLabel_Xmax.setMinimumSize(new Dimension(323, 22));
        this.jLabel_Xmax.setPreferredSize(new Dimension(323, 22));
        this.jText_Xmin.setFont(new Font("Times New Roman", 1, 36));
        this.jText_Xmin.setMaximumSize(new Dimension(6, 28));
        this.jText_Xmin.setPreferredSize(new Dimension(24, 28));
        this.jLabel_Indice.setBackground(new Color(255, 255, 255));
        this.jLabel_Indice.setFont(new Font("Times New Roman", 1, 24));
        this.jLabel_Indice.setText("Entre com a Quantidade de Classes (Índice):");
        this.jText_Indice.setFont(new Font("Times New Roman", 1, 36));
        this.jText_Indice.setMaximumSize(new Dimension(6, 28));
        this.jText_Indice.setPreferredSize(new Dimension(24, 28));
        this.jButton_GerarTabela.setBackground(new Color(255, 255, 255));
        this.jButton_GerarTabela.setFont(new Font("Times New Roman", 0, 24));
        this.jButton_GerarTabela.setText("Gerar Tabela");
        this.jButton_GerarTabela.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosEstatisticaPrincipal.this.jButton_GerarTabelaActionPerformed(evt);
            }
        });
        GroupLayout jPanel_RecebeDadosLayout = new GroupLayout(this.jPanel_RecebeDados);
        this.jPanel_RecebeDados.setLayout(jPanel_RecebeDadosLayout);
        jPanel_RecebeDadosLayout.setHorizontalGroup(jPanel_RecebeDadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_RecebeDadosLayout.createSequentialGroup().addContainerGap().addGroup(jPanel_RecebeDadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_RecebeDadosLayout.createSequentialGroup().addGroup(jPanel_RecebeDadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel_Xmax, -1, -1, 32767).addComponent(this.jLabel_Xmin, -1, -1, 32767).addComponent(this.jLabel_Indice, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel_RecebeDadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jText_Xmax, -1, 400, 32767).addComponent(this.jText_Indice, -1, 400, 32767).addComponent(this.jText_Xmin, -1, 400, 32767))).addComponent(this.jButton_GerarTabela)).addContainerGap(344, 32767)));
        jPanel_RecebeDadosLayout.setVerticalGroup(jPanel_RecebeDadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_RecebeDadosLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel_RecebeDadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel_RecebeDadosLayout.createSequentialGroup().addComponent(this.jText_Xmin, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jText_Xmax, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jText_Indice, -2, 62, -2)).addGroup(jPanel_RecebeDadosLayout.createSequentialGroup().addComponent(this.jLabel_Xmin, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_Xmax, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_Indice, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_GerarTabela, -2, 44, -2))).addContainerGap(316, 32767)));
        this.jTabbedPaneDados.addTab("Informar Dados Iniciais", this.jPanel_RecebeDados);
        this.jLayeredPane_Tabela.setEnabled(false);
        this.jLayeredPane_Tabela.setFont(new Font("Times New Roman", 0, 18));
        this.JScrollPane_Tabela.setFocusable(false);
        this.JScrollPane_Tabela.setFont(new Font("Times New Roman", 0, 14));
        this.JScrollPane_Tabela.setMinimumSize(new Dimension(100, 100));
        this.jTable_Tabela.setModel(new DefaultTableModel(new Object[0][], new String[]{"i", "Classes", "fi", "Fac", "P.M.", "fi * P.M", "P.M - Média", "(P.M - Média) * fi", "(P.M - Média) ^ 2", "((P.M - Média) ^ 2) * fi"}) {
            Class[] types = {String.class, String.class, Integer.class, Integer.class, Float.class, Float.class, Float.class, Float.class, Float.class, Float.class};
            boolean[] canEdit = {false, false, true, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.jTable_Tabela.setToolTipText("fi recebe apenas numeros inteiros");
        this.jTable_Tabela.setColumnSelectionAllowed(true);
        this.jTable_Tabela.setMaximumSize(new Dimension(130, 0));
        this.jTable_Tabela.getTableHeader().setReorderingAllowed(false);
        this.JScrollPane_Tabela.setViewportView(this.jTable_Tabela);
        this.jTable_Tabela.getColumnModel().getSelectionModel().setSelectionMode(0);
        if (this.jTable_Tabela.getColumnModel().getColumnCount() > 0) {
            this.jTable_Tabela.getColumnModel().getColumn(0).setMinWidth(20);
            this.jTable_Tabela.getColumnModel().getColumn(0).setMaxWidth(50);
            this.jTable_Tabela.getColumnModel().getColumn(1).setMinWidth(50);
            this.jTable_Tabela.getColumnModel().getColumn(1).setMaxWidth(200);
            this.jTable_Tabela.getColumnModel().getColumn(2).setMinWidth(20);
            this.jTable_Tabela.getColumnModel().getColumn(2).setMaxWidth(100);
            this.jTable_Tabela.getColumnModel().getColumn(3).setMinWidth(20);
            this.jTable_Tabela.getColumnModel().getColumn(3).setMaxWidth(100);
            this.jTable_Tabela.getColumnModel().getColumn(4).setMinWidth(50);
            this.jTable_Tabela.getColumnModel().getColumn(4).setMaxWidth(150);
            this.jTable_Tabela.getColumnModel().getColumn(5).setMinWidth(50);
            this.jTable_Tabela.getColumnModel().getColumn(5).setMaxWidth(150);
            this.jTable_Tabela.getColumnModel().getColumn(6).setMinWidth(50);
            this.jTable_Tabela.getColumnModel().getColumn(6).setMaxWidth(150);
            this.jTable_Tabela.getColumnModel().getColumn(7).setMinWidth(50);
            this.jTable_Tabela.getColumnModel().getColumn(7).setMaxWidth(150);
            this.jTable_Tabela.getColumnModel().getColumn(8).setMinWidth(50);
            this.jTable_Tabela.getColumnModel().getColumn(8).setMaxWidth(150);
            this.jTable_Tabela.getColumnModel().getColumn(9).setMinWidth(50);
            this.jTable_Tabela.getColumnModel().getColumn(9).setMaxWidth(150);
        }
        this.jLayeredPane_Tabela.add(this.JScrollPane_Tabela);
        this.JScrollPane_Tabela.setBounds(10, 60, 1200, 500);
        this.jButton_Calcular.setFont(new Font("Times New Roman", 0, 18));
        this.jButton_Calcular.setText("Calcular");
        this.jButton_Calcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosEstatisticaPrincipal.this.jButton_CalcularActionPerformed(evt);
            }
        });
        this.jLayeredPane_Tabela.add(this.jButton_Calcular);
        this.jButton_Calcular.setBounds(920, 10, 180, 40);
        this.jLabel_FinalizarDados.setFont(new Font("Times New Roman", 1, 18));
        this.jLabel_FinalizarDados.setText("Ao informar os valores de fi manualmente na coluna abaixo, clique em Calcular logo à frente");
        this.jLayeredPane_Tabela.add(this.jLabel_FinalizarDados);
        this.jLabel_FinalizarDados.setBounds(10, 20, 724, 22);
        GroupLayout jPanel_TabelaLayout = new GroupLayout(this.jPanel_Tabela);
        this.jPanel_Tabela.setLayout(jPanel_TabelaLayout);
        jPanel_TabelaLayout.setHorizontalGroup(jPanel_TabelaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLayeredPane_Tabela, -1, 1220, 32767));
        jPanel_TabelaLayout.setVerticalGroup(jPanel_TabelaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLayeredPane_Tabela, -1, 575, 32767));
        this.jTabbedPaneDados.addTab("Tabela de Dados", this.jPanel_Tabela);
        this.jLayeredPane_Resultados.setEnabled(false);
        this.jLayeredPane_Resultados.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_QuantidadeClasses.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_QuantidadeClasses.setText("Label 01");
        this.jLayeredPane_Resultados.add(this.jLabel_QuantidadeClasses);
        this.jLabel_QuantidadeClasses.setBounds(0, 0, 1000, 50);
        this.jLabel_MediaClasse.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_MediaClasse.setText("Label 04");
        this.jLayeredPane_Resultados.add(this.jLabel_MediaClasse);
        this.jLabel_MediaClasse.setBounds(0, 150, 1000, 50);
        this.jLabel_VariaciaPopulacional.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_VariaciaPopulacional.setText("Label 07");
        this.jLayeredPane_Resultados.add(this.jLabel_VariaciaPopulacional);
        this.jLabel_VariaciaPopulacional.setBounds(0, 302, 1000, 50);
        this.jLabel_DesvioAbsoluto.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_DesvioAbsoluto.setText("Label 11");
        this.jLayeredPane_Resultados.add(this.jLabel_DesvioAbsoluto);
        this.jLabel_DesvioAbsoluto.setBounds(0, 500, 1000, 50);
        this.jLabel_SomaFi.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_SomaFi.setText("Label 05");
        this.jLayeredPane_Resultados.add(this.jLabel_SomaFi);
        this.jLabel_SomaFi.setBounds(0, 202, 1000, 50);
        this.jLabel_MediaAritmetica.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_MediaAritmetica.setText("Label 06");
        this.jLayeredPane_Resultados.add(this.jLabel_MediaAritmetica);
        this.jLabel_MediaAritmetica.setBounds(0, 252, 1000, 50);
        this.jLabel_LimiteInferiorClasse.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_LimiteInferiorClasse.setText("Label 02");
        this.jLayeredPane_Resultados.add(this.jLabel_LimiteInferiorClasse);
        this.jLabel_LimiteInferiorClasse.setBounds(0, 50, 1000, 50);
        this.jLabel_Intervalo.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_Intervalo.setText("Label 03");
        this.jLayeredPane_Resultados.add(this.jLabel_Intervalo);
        this.jLabel_Intervalo.setBounds(0, 100, 1000, 50);
        this.jLabel_AmplitudeTotal.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_AmplitudeTotal.setText("Label 09");
        this.jLayeredPane_Resultados.add(this.jLabel_AmplitudeTotal);
        this.jLabel_AmplitudeTotal.setBounds(0, 402, 1000, 50);
        this.jLabel_CoeficienteVariacao.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_CoeficienteVariacao.setText("Label 10");
        this.jLayeredPane_Resultados.add(this.jLabel_CoeficienteVariacao);
        this.jLabel_CoeficienteVariacao.setBounds(0, 450, 1000, 50);
        this.jLabel_DesvioPadraoPopulacional.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_DesvioPadraoPopulacional.setText("Label 08");
        this.jLayeredPane_Resultados.add(this.jLabel_DesvioPadraoPopulacional);
        this.jLabel_DesvioPadraoPopulacional.setBounds(0, 352, 1000, 50);
        GroupLayout jPanel_ResultadosLayout = new GroupLayout(this.jPanel_Resultados);
        this.jPanel_Resultados.setLayout(jPanel_ResultadosLayout);
        jPanel_ResultadosLayout.setHorizontalGroup(jPanel_ResultadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLayeredPane_Resultados, -1, 1220, 32767));
        jPanel_ResultadosLayout.setVerticalGroup(jPanel_ResultadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLayeredPane_Resultados, -1, 575, 32767));
        this.jTabbedPaneDados.addTab("Resultados", this.jPanel_Resultados);
        this.jPanel_Resultados.getAccessibleContext().setAccessibleParent(this.jTabbedPaneDados);
        this.jMenu_Arquivo.setText("Arquivos");
        this.jMenuItemArquivo_Novo.setAccelerator(KeyStroke.getKeyStroke(78, 10));
        this.jMenuItemArquivo_Novo.setText("Novo");
        this.jMenuItemArquivo_Novo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosEstatisticaPrincipal.this.jMenuItemArquivo_NovoActionPerformed(evt);
            }
        });
        this.jMenu_Arquivo.add(this.jMenuItemArquivo_Novo);
        this.jMenuItemArquivo_Sair.setText("Sair");
        this.jMenuItemArquivo_Sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosEstatisticaPrincipal.this.jMenuItemArquivo_SairActionPerformed(evt);
            }
        });
        this.jMenu_Arquivo.add(this.jMenuItemArquivo_Sair);
        this.jMenuBar.add(this.jMenu_Arquivo);
        this.jMenu_Editar.setText("Editar");
        this.jMenuItemEditar_ApagarDadosFi.setAccelerator(KeyStroke.getKeyStroke(65, 10));
        this.jMenuItemEditar_ApagarDadosFi.setText("Apagar Dados de fi");
        this.jMenuItemEditar_ApagarDadosFi.setEnabled(false);
        this.jMenuItemEditar_ApagarDadosFi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosEstatisticaPrincipal.this.jMenuItemEditar_ApagarDadosFiActionPerformed(evt);
            }
        });
        this.jMenu_Editar.add(this.jMenuItemEditar_ApagarDadosFi);
        this.jMenuBar.add(this.jMenu_Editar);
        this.jMenu_Acoes.setText("Ações");
        this.jMenuItemAcoes_Intervalo.setAccelerator(KeyStroke.getKeyStroke(73, 10));
        this.jMenuItemAcoes_Intervalo.setText("Exibir Amplitude das Classes");
        this.jMenuItemAcoes_Intervalo.setEnabled(false);
        this.jMenuItemAcoes_Intervalo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosEstatisticaPrincipal.this.jMenuItemAcoes_IntervaloActionPerformed(evt);
            }
        });
        this.jMenu_Acoes.add(this.jMenuItemAcoes_Intervalo);
        this.jMenuItemAcoes_MediaClasses.setAccelerator(KeyStroke.getKeyStroke(67, 10));
        this.jMenuItemAcoes_MediaClasses.setText("Exibir Média das Classes");
        this.jMenuItemAcoes_MediaClasses.setEnabled(false);
        this.jMenuItemAcoes_MediaClasses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosEstatisticaPrincipal.this.jMenuItemAcoes_MediaClassesActionPerformed(evt);
            }
        });
        this.jMenu_Acoes.add(this.jMenuItemAcoes_MediaClasses);
        this.jMenuItemAcoes_SomaFi.setAccelerator(KeyStroke.getKeyStroke(70, 10));
        this.jMenuItemAcoes_SomaFi.setText("Exibir Soma de fi");
        this.jMenuItemAcoes_SomaFi.setEnabled(false);
        this.jMenuItemAcoes_SomaFi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosEstatisticaPrincipal.this.jMenuItemAcoes_SomaFiActionPerformed(evt);
            }
        });
        this.jMenu_Acoes.add(this.jMenuItemAcoes_SomaFi);
        this.jMenuItemAcoes_MediaAritmetica.setAccelerator(KeyStroke.getKeyStroke(77, 10));
        this.jMenuItemAcoes_MediaAritmetica.setText("Exibir Média Aritmética");
        this.jMenuItemAcoes_MediaAritmetica.setEnabled(false);
        this.jMenuItemAcoes_MediaAritmetica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosEstatisticaPrincipal.this.jMenuItemAcoes_MediaAritmeticaActionPerformed(evt);
            }
        });
        this.jMenu_Acoes.add(this.jMenuItemAcoes_MediaAritmetica);
        this.jMenuItemAcoes_Variacia.setAccelerator(KeyStroke.getKeyStroke(86, 10));
        this.jMenuItemAcoes_Variacia.setText("Exibir Variância Populacional");
        this.jMenuItemAcoes_Variacia.setEnabled(false);
        this.jMenuItemAcoes_Variacia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosEstatisticaPrincipal.this.jMenuItemAcoes_VariaciaActionPerformed(evt);
            }
        });
        this.jMenu_Acoes.add(this.jMenuItemAcoes_Variacia);
        this.jMenuItemAcoes_DesvioAbsoluto.setAccelerator(KeyStroke.getKeyStroke(68, 10));
        this.jMenuItemAcoes_DesvioAbsoluto.setText("Exibir Desvio Absoluto");
        this.jMenuItemAcoes_DesvioAbsoluto.setEnabled(false);
        this.jMenuItemAcoes_DesvioAbsoluto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosEstatisticaPrincipal.this.jMenuItemAcoes_DesvioAbsolutoActionPerformed(evt);
            }
        });
        this.jMenu_Acoes.add(this.jMenuItemAcoes_DesvioAbsoluto);
        this.jMenuBar.add(this.jMenu_Acoes);
        this.jMenu1.setText("Sobre");
        this.jMenu1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                CalculosEstatisticaPrincipal.this.jMenu1MouseClicked(evt);
            }
        });
        this.jMenuBar.add(this.jMenu1);
        this.jMenu_Ajuda.setText("Ajuda");
        this.jMenu_Ajuda.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                CalculosEstatisticaPrincipal.this.jMenu_AjudaMouseClicked(evt);
            }
        });
        this.jMenuBar.add(this.jMenu_Ajuda);
        setJMenuBar(this.jMenuBar);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPaneDados, -1, 1225, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jTabbedPaneDados, -2, 600, -2)));
        pack();
        setLocationRelativeTo(null);
    }

    private void jButton_GerarTabelaActionPerformed(ActionEvent evt) {
        int resposta = JOptionPane.showConfirmDialog(null, "Todos os valores foram inseridos corretamente?", "Confirmação", 1);
        if (resposta == 0) {
            receberDados();
        } else if (resposta == 1) {
            getjText_Xmin().setText("");
            getjText_Xmax().setText("");
            getjText_Indice().setText("");
        }
    }

    private void jButton_CalcularActionPerformed(ActionEvent evt) {
        verificarFi();
    }

    private void jMenuItemArquivo_NovoActionPerformed(ActionEvent evt) {
        getjMenuItemEditar_ApagarDadosFi().setEnabled(false);
        getjMenuItemAcoes_Intervalo().setEnabled(false);
        getjMenuItemAcoes_MediaClasses().setEnabled(false);
        getjMenuItemAcoes_SomaFi().setEnabled(false);
        getjMenuItemAcoes_MediaAritmetica().setEnabled(false);
        getjMenuItemAcoes_Variacia().setEnabled(false);
        getjMenuItemAcoes_DesvioAbsoluto().setEnabled(false);
        getjTabbedPaneDados().setEnabledAt(0, true);
        getjTabbedPaneDados().setEnabledAt(1, false);
        getjTabbedPaneDados().setEnabledAt(2, false);
        getjTabbedPaneDados().setSelectedIndex(0);
    }

    private void jMenuItemEditar_ApagarDadosFiActionPerformed(ActionEvent evt) {
        for (int l = 0; l < getAtributos_estatistico().getTamanho().intValue(); l++) ;
        getjTabbedPaneDados().setEnabledAt(0, false);
        getjTabbedPaneDados().setEnabledAt(1, true);
        getjTabbedPaneDados().setEnabledAt(2, false);
        getjTabbedPaneDados().setSelectedIndex(1);
        JOptionPane.showMessageDialog(null, "Preencha todos os valores de fi!", "Atenção", 1);
        getjMenuItemAcoes_Intervalo().setEnabled(true);
        getjMenuItemAcoes_MediaClasses().setEnabled(false);
        getjMenuItemAcoes_SomaFi().setEnabled(false);
        getjMenuItemAcoes_MediaAritmetica().setEnabled(false);
        getjMenuItemAcoes_Variacia().setEnabled(false);
        getjMenuItemAcoes_DesvioAbsoluto().setEnabled(false);
        this.jTable_Tabela.setToolTipText("Fi recebe apenas numeros inteiros");
    }

    private void jMenuItemAcoes_IntervaloActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, getAtributos_estatistico().getIntervalo().toString(), "Valor do intervalo", 1);
    }

    private void jMenuItemAcoes_MediaClassesActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getMedia_classe().toString(), "Média das classes", 1);
    }

    private void jMenuItemAcoes_SomaFiActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getSoma_fi().toString(), "Soma dos fi", 1);
    }

    private void jMenuItemAcoes_MediaAritmeticaActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getMedia_aritmetica_total().toString(), "Média aritmetica", 1);
    }

    private void jMenuItemAcoes_VariaciaActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getVariancia_total().toString() + "²", "Variância", 1);
    }

    private void jMenuItemAcoes_DesvioAbsolutoActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, getLes_calculos().getVetor()[(getAtributos_estatistico().getTamanho().intValue() - 1)].getDesvio_absoluto_total().toString(), "Desvio absoluto", 1);
    }

    private void jMenuItemArquivo_SairActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void jMenu_AjudaMouseClicked(MouseEvent evt) {
        getTutorial().show();
    }

    private void jMenu1MouseClicked(MouseEvent evt) {
        getSobre().show();
    }

    public AtributosEstatistico getAtributos_estatistico() {
        return this.atributos_estatistico;
    }

    public void setAtributos_estatistico(AtributosEstatistico atributos_estatistico) {
        this.atributos_estatistico = atributos_estatistico;
    }

    public LESCalculos getLes_calculos() {
        return this.les_calculos;
    }

    public void setLes_calculos(LESCalculos les_calculos) {
        this.les_calculos = les_calculos;
    }

    public Sobre getSobre() {
        return this.sobre;
    }

    public void setSobre(Sobre sobre) {
        this.sobre = sobre;
    }

    public Tutorial getTutorial() {
        return this.tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }

    public boolean isErro_inicial() {
        return this.erro_inicial;
    }

    public void setErro_inicial(boolean erro_inicial) {
        this.erro_inicial = erro_inicial;
    }

    public JScrollPane getJScrollPane_Tabela() {
        return this.JScrollPane_Tabela;
    }

    public void setJScrollPane_Tabela(JScrollPane JScrollPane_Tabela) {
        this.JScrollPane_Tabela = JScrollPane_Tabela;
    }

    public JButton getjButton_Calcular() {
        return this.jButton_Calcular;
    }

    public void setjButton_Calcular(JButton jButton_Calcular) {
        this.jButton_Calcular = jButton_Calcular;
    }

    public JButton getjButton_GerarTabela() {
        return this.jButton_GerarTabela;
    }

    public void setjButton_GerarTabela(JButton jButton_GerarTabela) {
        this.jButton_GerarTabela = jButton_GerarTabela;
    }

    public JLabel getjLabel_AmplitudeTotal() {
        return this.jLabel_AmplitudeTotal;
    }

    public void setjLabel_AmplitudeTotal(JLabel jLabel_AmplitudeTotal) {
        this.jLabel_AmplitudeTotal = jLabel_AmplitudeTotal;
    }

    public JLabel getjLabel_CoeficienteVariacao() {
        return this.jLabel_CoeficienteVariacao;
    }

    public void setjLabel_CoeficienteVariacao(JLabel jLabel_CoeficienteVariacao) {
        this.jLabel_CoeficienteVariacao = jLabel_CoeficienteVariacao;
    }

    public JLabel getjLabel_DesvioAbsoluto() {
        return this.jLabel_DesvioAbsoluto;
    }

    public void setjLabel_DesvioAbsoluto(JLabel jLabel_DesvioAbsoluto) {
        this.jLabel_DesvioAbsoluto = jLabel_DesvioAbsoluto;
    }

    public JLabel getjLabel_DesvioPadraoPopulacional() {
        return this.jLabel_DesvioPadraoPopulacional;
    }

    public void setjLabel_DesvioPadraoPopulacional(JLabel jLabel_DesvioPadraoPopulacional) {
        this.jLabel_DesvioPadraoPopulacional = jLabel_DesvioPadraoPopulacional;
    }

    public JLabel getjLabel_FinalizarDados() {
        return this.jLabel_FinalizarDados;
    }

    public JLabel getjLabel_Indice() {
        return this.jLabel_Indice;
    }

    public void setjLabel_Indice(JLabel jLabel_Indice) {
        this.jLabel_Indice = jLabel_Indice;
    }

    public JLabel getjLabel_Intervalo() {
        return this.jLabel_Intervalo;
    }

    public void setjLabel_Intervalo(JLabel jLabel_Intervalo) {
        this.jLabel_Intervalo = jLabel_Intervalo;
    }

    public JLabel getjLabel_LimiteInferiorClasse() {
        return this.jLabel_LimiteInferiorClasse;
    }

    public void setjLabel_LimiteInferiorClasse(JLabel jLabel_LimiteInferiorClasse) {
        this.jLabel_LimiteInferiorClasse = jLabel_LimiteInferiorClasse;
    }

    public JLabel getjLabel_MediaAritmetica() {
        return this.jLabel_MediaAritmetica;
    }

    public void setjLabel_MediaAritmetica(JLabel jLabel_MediaAritmetica) {
        this.jLabel_MediaAritmetica = jLabel_MediaAritmetica;
    }

    public JLabel getjLabel_MediaClasse() {
        return this.jLabel_MediaClasse;
    }

    public void setjLabel_MediaClasse(JLabel jLabel_MediaClasse) {
        this.jLabel_MediaClasse = jLabel_MediaClasse;
    }

    public JLabel getjLabel_QuantidadeClasses() {
        return this.jLabel_QuantidadeClasses;
    }

    public void setjLabel_QuantidadeClasses(JLabel jLabel_QuantidadeClasses) {
        this.jLabel_QuantidadeClasses = jLabel_QuantidadeClasses;
    }

    public JLabel getjLabel_SomaFi() {
        return this.jLabel_SomaFi;
    }

    public void setjLabel_SomaFi(JLabel jLabel_SomaFi) {
        this.jLabel_SomaFi = jLabel_SomaFi;
    }

    public JLabel getjLabel_VariaciaPopulacional() {
        return this.jLabel_VariaciaPopulacional;
    }

    public void setjLabel_VariaciaPopulacional(JLabel jLabel_VariaciaPopulacional) {
        this.jLabel_VariaciaPopulacional = jLabel_VariaciaPopulacional;
    }

    public JLabel getjLabel_Xmax() {
        return this.jLabel_Xmax;
    }

    public void setjLabel_Xmax(JLabel jLabel_Xmax) {
        this.jLabel_Xmax = jLabel_Xmax;
    }

    public JLabel getjLabel_Xmin() {
        return this.jLabel_Xmin;
    }

    public void setjLabel_Xmin(JLabel jLabel_Xmin) {
        this.jLabel_Xmin = jLabel_Xmin;
    }

    public JLayeredPane getjLayeredPane_Resultados() {
        return this.jLayeredPane_Resultados;
    }

    public void setjLayeredPane_Resultados(JLayeredPane jLayeredPane_Resultados) {
        this.jLayeredPane_Resultados = jLayeredPane_Resultados;
    }

    public JLayeredPane getjLayeredPane_Tabela() {
        return this.jLayeredPane_Tabela;
    }

    public void setjLayeredPane_Tabela(JLayeredPane jLayeredPane_Tabela) {
        this.jLayeredPane_Tabela = jLayeredPane_Tabela;
    }

    public JMenuBar getjMenuBar() {
        return this.jMenuBar;
    }

    public void setjMenuBar(JMenuBar jMenuBar) {
        this.jMenuBar = jMenuBar;
    }

    public JMenuItem getjMenuItemAcoes_DesvioAbsoluto() {
        return this.jMenuItemAcoes_DesvioAbsoluto;
    }

    public void setjMenuItemAcoes_DesvioAbsoluto(JMenuItem jMenuItemAcoes_DesvioAbsoluto) {
        this.jMenuItemAcoes_DesvioAbsoluto = jMenuItemAcoes_DesvioAbsoluto;
    }

    public JMenuItem getjMenuItemAcoes_Intervalo() {
        return this.jMenuItemAcoes_Intervalo;
    }

    public void setjMenuItemAcoes_Intervalo(JMenuItem jMenuItemAcoes_Intervalo) {
        this.jMenuItemAcoes_Intervalo = jMenuItemAcoes_Intervalo;
    }

    public JMenuItem getjMenuItemAcoes_MediaAritmetica() {
        return this.jMenuItemAcoes_MediaAritmetica;
    }

    public void setjMenuItemAcoes_MediaAritmetica(JMenuItem jMenuItemAcoes_MediaAritmetica) {
        this.jMenuItemAcoes_MediaAritmetica = jMenuItemAcoes_MediaAritmetica;
    }

    public JMenuItem getjMenuItemAcoes_MediaClasses() {
        return this.jMenuItemAcoes_MediaClasses;
    }

    public void setjMenuItemAcoes_MediaClasses(JMenuItem jMenuItemAcoes_MediaClasses) {
        this.jMenuItemAcoes_MediaClasses = jMenuItemAcoes_MediaClasses;
    }

    public JMenuItem getjMenuItemAcoes_SomaFi() {
        return this.jMenuItemAcoes_SomaFi;
    }

    public void setjMenuItemAcoes_SomaFi(JMenuItem jMenuItemAcoes_SomaFi) {
        this.jMenuItemAcoes_SomaFi = jMenuItemAcoes_SomaFi;
    }

    public JMenuItem getjMenuItemAcoes_Variacia() {
        return this.jMenuItemAcoes_Variacia;
    }

    public void setjMenuItemAcoes_Variacia(JMenuItem jMenuItemAcoes_Variacia) {
        this.jMenuItemAcoes_Variacia = jMenuItemAcoes_Variacia;
    }

    public JMenuItem getjMenuItemArquivo_Novo() {
        return this.jMenuItemArquivo_Novo;
    }

    public void setjMenuItemArquivo_Novo(JMenuItem jMenuItemArquivo_Novo) {
        this.jMenuItemArquivo_Novo = jMenuItemArquivo_Novo;
    }

    public JMenuItem getjMenuItemArquivo_Sair() {
        return this.jMenuItemArquivo_Sair;
    }

    public void setjMenuItemArquivo_Sair(JMenuItem jMenuItemArquivo_Sair) {
        this.jMenuItemArquivo_Sair = jMenuItemArquivo_Sair;
    }

    public JMenuItem getjMenuItemEditar_ApagarDadosFi() {
        return this.jMenuItemEditar_ApagarDadosFi;
    }

    public void setjMenuItemEditar_ApagarDadosFi(JMenuItem jMenuItemEditar_ApagarDadosFi) {
        this.jMenuItemEditar_ApagarDadosFi = jMenuItemEditar_ApagarDadosFi;
    }

    public JMenu getjMenu_Acoes() {
        return this.jMenu_Acoes;
    }

    public void setjMenu_Acoes(JMenu jMenu_Acoes) {
        this.jMenu_Acoes = jMenu_Acoes;
    }

    public JMenu getjMenu_Ajuda() {
        return this.jMenu_Ajuda;
    }

    public void setjMenu_Ajuda(JMenu jMenu_Ajuda) {
        this.jMenu_Ajuda = jMenu_Ajuda;
    }

    public JMenu getjMenu_Arquivo() {
        return this.jMenu_Arquivo;
    }

    public void setjMenu_Arquivo(JMenu jMenu_Arquivo) {
        this.jMenu_Arquivo = jMenu_Arquivo;
    }

    public JMenu getjMenu_Editar() {
        return this.jMenu_Editar;
    }

    public void setjMenu_Editar(JMenu jMenu_Editar) {
        this.jMenu_Editar = jMenu_Editar;
    }

    public JPanel getjPanel_RecebeDados() {
        return this.jPanel_RecebeDados;
    }

    public void setjPanel_RecebeDados(JPanel jPanel_RecebeDados) {
        this.jPanel_RecebeDados = jPanel_RecebeDados;
    }

    public JPanel getjPanel_Resultados() {
        return this.jPanel_Resultados;
    }

    public void setjPanel_Resultados(JPanel jPanel_Resultados) {
        this.jPanel_Resultados = jPanel_Resultados;
    }

    public JPanel getjPanel_Tabela() {
        return this.jPanel_Tabela;
    }

    public void setjPanel_Tabela(JPanel jPanel_Tabela) {
        this.jPanel_Tabela = jPanel_Tabela;
    }

    public JTabbedPane getjTabbedPaneDados() {
        return this.jTabbedPaneDados;
    }

    public void setjTabbedPaneDados(JTabbedPane jTabbedPaneDados) {
        this.jTabbedPaneDados = jTabbedPaneDados;
    }

    public JTable getjTable_Tabela() {
        return this.jTable_Tabela;
    }

    public void setjTable_Tabela(JTable jTable_Tabela) {
        this.jTable_Tabela = jTable_Tabela;
    }

    public JTextField getjText_Indice() {
        return this.jText_Indice;
    }

    public void setjText_Indice(JTextField jText_Indice) {
        this.jText_Indice = jText_Indice;
    }

    public JTextField getjText_Xmax() {
        return this.jText_Xmax;
    }

    public void setjText_Xmax(JTextField jText_Xmax) {
        this.jText_Xmax = jText_Xmax;
    }

    public JTextField getjText_Xmin() {
        return this.jText_Xmin;
    }

    public void setjText_Xmin(JTextField jText_Xmin) {
        this.jText_Xmin = jText_Xmin;
    }
}
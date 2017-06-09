import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tutorial extends JFrame {
    private JScrollPane jScrollPane;
    private JTextArea jTextArea_Tutorial;

    public Tutorial() {
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
                new Tutorial().setVisible(true);
            }
        });
    }

    private void initComponents() {
        this.jScrollPane = new JScrollPane();
        this.jTextArea_Tutorial = new JTextArea();
        setTitle("Tutorial de Ajuda");
        setBackground(new Color(255, 255, 255));
        setBounds(new Rectangle(0, 0, 0, 0));
        setExtendedState(6);
        setName("Tutorial");
        setResizable(false);
        this.jScrollPane.setAutoscrolls(true);
        this.jTextArea_Tutorial.setEditable(false);
        this.jTextArea_Tutorial.setColumns(20);
        this.jTextArea_Tutorial.setFont(new Font("Times New Roman", 0, 18));
        this.jTextArea_Tutorial.setRows(5);
        this.jTextArea_Tutorial.setText("  Tutorial de Ajuda - Manipulação do Programa\no Aba de 'Dados Iniciais'\n     Devem-se preencher todos os campos, pois são obrigatórios. O primeiro campo exige o Xi mínimo, o segundo campo exige o Xi máximo e o terceiro campo exige a quantidade de \n    classes, ou seja, o maior índice. Ao colocar todos os valores corretamente em seus respectivos campos, clique no botão ‘Gerar Tabela’. Lembrando que para gerar a tabela, precisam-se \n    ser informados os valores corretos a sua devida solicitação.\no Aba de 'Tabela'\n     Depois de entrar com os primeiros dados, serão calculados os índices e as classes. Para concluir o processo, preencha todos os espaços de fi e clique no botão ‘Calcular’. Lembrando \n    que ao informar o ultimo número de fi deve-se apertar ‘Enter’ para finalizar e então assim clicar no botão requerido senão o programa reconhecera que está faltando o último número. \n    Quando clicar no botão ‘Calcular’, será concluído o processo, mostrando todos os resultados. Obs. Importante: Sempre que mudar um numero de fi na tabela, repita o processo de \n    apertar o botão ‘Calcular’ para mostrar os novos resultados.\no Aba de 'Resultados'\n     Essa aba apenas será liberada quando todos os valores forem calculados. Assim informando os resultados finais.\no Menu Principal\n     Itens do Menu 'Arquivos'\n        • Novo – Retorna para a primeira aba para gerar uma nova tabela com outros dados iniciais.\n        • Sair – Encerra o programa.\n     Itens do Menu 'Editar'\n        • Apagar Dados de fi – Apagar todos os fi digitados apenas com um clique.\n     Itens do Menu 'Ações'\n        • Exibir Gráfico – Imprimi na tela o gráfico de barras estatístico em relação com os respectivos dados informados ao programa.\n        • Exibir Valor do Intervalo (h) – Imprimi na tela o valor do intervalo estatístico (h) em relação aos respectivos dados informados ao programa.\n        • Exibir Média das Classes – Imprimi na tela o valor da média das classes em relação aos respectivos dados informados ao programa.\n        • Exibir Soma de fi – Imprimi na tela o valor da soma de fi em relação aos respectivos dados informados ao programa.\n        • Exibir Média Aritmética – Imprimi na tela o valor da média aritmética em relação aos respectivos dados informados ao programa.\n        • Exibir Variância – Imprimi na tela o valor da variância em relação aos respectivos dados informados ao programa.\n        • Exibir Desvio Absoluto - Imprimi na tela o valor do desvio absoluto em relação aos respectivos dados informados ao programa.\n     Itens do Menu 'Ajuda'\n        • Tutorial – Exibi na tela este tutorial.\n        • Sobre – Exibi na tela informações sobre os programadores e sistemas usados.");
        this.jScrollPane.setViewportView(this.jTextArea_Tutorial);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane, -2, 1015, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane, GroupLayout.Alignment.TRAILING, -2, 558, -2));
        pack();
        setLocationRelativeTo(null);
    }
}
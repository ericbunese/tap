import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogoNovaRefeicao extends JInternalFrame
{
  private JLabel labelNome, labelQuantidadePessoas;
  private JTextField textFieldNome, textQuantidadePessoas;
  private JButton botaoOk;
  private JScrollPane listaRefeicoesScroll;
  private JList listaRefeicoes;
  private JPanel panel;
  private ControleNovaRefeicao controle;
  private ControleReceitas controleReceita;

  public DialogoNovaRefeicao(ControleReceitas controleReceita)
  {
    super("Nova Refeicao", true, true, true, true );

    this.controleReceita = controleReceita;
    controle = new ControleNovaRefeicao(controleReceita);

    panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);

    labelNome = new JLabel("Nome");
    textFieldNome = new JTextField("Nome da Refeicao");
    labelQuantidadePessoas = new JLabel("Quantidade de pessoas");
    textQuantidadePessoas = new JTextField("10000");
    botaoOk = new JButton("OK");

    listaRefeicoes = new JList(controle.getItensReceita());
    listaRefeicoes.setLayoutOrientation(JList.VERTICAL);
    listaRefeicoes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    listaRefeicoesScroll = new JScrollPane(listaRefeicoes);

    panel.setLayout(new FlowLayout());
    panel.add(listaRefeicoesScroll);
    panel.add(labelNome);
    panel.add(textFieldNome);
    panel.add(labelQuantidadePessoas);
    panel.add(textQuantidadePessoas);
    panel.add(botaoOk);
    setSize(450, 300);
    setVisible(true);

    botaoOk.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        int quantidadePessoas = Integer.parseInt(textQuantidadePessoas.getText());
        String nomeRefeicao = textFieldNome.getText();
        java.util.List<String> receitas = listaRefeicoes.getSelectedValuesList();
        ArrayList<Receita> receitasTemp = new ArrayList<Receita>();

        String tempName;
        Receita rct;

        for (String s:receitas)
        {
          tempName = s.split(":")[1];
          rct = controleReceita.buscarPorNome(tempName);
          if (rct!=null)
          {
            receitasTemp.add(rct);
            System.out.println("Adicionado receita "+rct.getNome());
          }
        }

        controle.criarRefeicao(nomeRefeicao, quantidadePessoas, receitasTemp);
        controle.imprimirRefeicao();
      }
    });
  }
}

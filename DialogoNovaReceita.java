import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogoNovaReceita extends JInternalFrame
{
  private JLabel labelNome, labelCalorias, labelQuantidade, labelUnidade, labelModoPreparo;
  private JTextField textFieldNome, textFieldCalorias, textFieldQuantidade;
  private JButton botaoOk, botaoQuantidade;
  private JScrollPane listaReceitasScroll, modoPreparoScroll;
  private JTextArea modoPreparo;
  private JList listaReceitas;
  private JPanel panel;
  private ControleNovaReceita controle;
  private ControleVisualizarEstoque controleVisualizarEstoque;
  private ControleEstoque controleEstoque;
  private ControleReceitas controleReceitas;

  public DialogoNovaReceita(ControleReceitas controleReceitas, ControleEstoque controleEstoque)
  {
    super("Nova Receita", true, true, true, true );

    this.controleReceitas = controleReceitas;
    this.controleEstoque = controleEstoque;
    controle = new ControleNovaReceita(controleReceitas, controleEstoque);
    controleVisualizarEstoque = new ControleVisualizarEstoque(controleEstoque);

    panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);

    labelNome = new JLabel("Nome");
    textFieldNome = new JTextField("Nome da Receita");
    labelCalorias = new JLabel("Calorias");
    textFieldCalorias = new JTextField("1");
    labelQuantidade = new JLabel("Quantidade");
    textFieldQuantidade = new JTextField("1");
    labelUnidade = new JLabel("unidades");
    botaoQuantidade = new JButton("Definir Quantidade");
    labelModoPreparo = new JLabel("Modo Preparo");
    modoPreparo = new JTextArea(5, 40);
    modoPreparoScroll = new JScrollPane(modoPreparo);
    botaoOk = new JButton("OK");

    listaReceitas = new JList(controleVisualizarEstoque.getItensEstoque());
    listaReceitas.setLayoutOrientation(JList.VERTICAL);
    listaReceitas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    listaReceitasScroll = new JScrollPane(listaReceitas);

    panel.setLayout(new FlowLayout());
    panel.add(listaReceitasScroll);
    panel.add(labelNome);
    panel.add(textFieldNome);
    panel.add(labelCalorias);
    panel.add(textFieldCalorias);
    panel.add(labelQuantidade);
    panel.add(textFieldQuantidade);
    panel.add(labelUnidade);
    panel.add(botaoQuantidade);
    panel.add(labelModoPreparo);
    panel.add(modoPreparoScroll);
    panel.add(botaoOk);
    setSize(600, 400);
    setVisible(true);

    botaoQuantidade.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        String nome;
        java.util.List<String> ingredientesString = listaReceitas.getSelectedValuesList();
        for (String s:ingredientesString)
        {
          nome = s.split(" ")[1];
          int quantidade = Integer.parseInt(textFieldQuantidade.getText());
          System.out.println("Nome: "+nome+". Quantidade: "+quantidade);
          Ingrediente i = controle.buscarPorNome(nome);
          if (i!=null)
          {
            i.setQuantidade(quantidade);
          }
        }
        DefaultListModel model = controle.atualizarQuantidades();
        listaReceitas.setModel(model);
      }
    });

    botaoOk.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        int calorias = Integer.parseInt(textFieldCalorias.getText());
        String nomeReceita = textFieldNome.getText();
        java.util.List<String> ingredientesString = listaReceitas.getSelectedValuesList();
        ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
        String preparo = modoPreparo.getText();

        String tempName;
        Ingrediente igr;

        for (String s:ingredientesString)
        {
          tempName = s.split(" ")[1];
          igr = controle.buscarPorNome(tempName);
          if (igr!=null)
          {
            ingredientes.add(igr);
            System.out.println("Adicionado ingrediente "+igr.getNome());
          }
        }

        controle.criarReceita(nomeReceita, calorias, preparo);
        controle.setIngredientes(ingredientes);
        controle.salvarReceita();
      }
    });
  }
}

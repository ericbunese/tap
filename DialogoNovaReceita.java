import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogoNovaReceita extends JInternalFrame
{
  private JLabel labelNome, labelCalorias;
  private JTextField textFieldNome, textFieldCalorias;
  private JButton botaoOk;
  private JScrollPane listaReceitasScroll;
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
    controle = new ControleNovaReceita(controleReceitas);
    controleVisualizarEstoque = new ControleVisualizarEstoque(controleEstoque);

    panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);

    labelNome = new JLabel("Nome");
    textFieldNome = new JTextField("Nome da Receita");
    labelCalorias = new JLabel("Calorias");
    textFieldCalorias = new JTextField("1");
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
    panel.add(botaoOk);
    setSize(450, 300);
    setVisible(true);

    botaoOk.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        int calorias = Integer.parseInt(textFieldCalorias.getText());
        String nomeReceita = textFieldNome.getText();
        java.util.List<Ingrediente> ingredientes = listaReceitas.getSelectedValuesList();
        ArrayList<Ingrediente> ingredientesTemp = new ArrayList<Ingrediente>();

        String tempName;
        for (Ingrediente i:ingredientes)
        {
          tempName = i.getNome().split(" ")[1];
          for (Ingrediente j:controleEstoque.getIngredientes())
          {
            if (j.getNome().equals(tempName))
            {
              ingredientesTemp.add(j);
            }
          }
        }

        controle.criarReceita(nomeReceita, calorias, ingredientesTemp);
        controle.salvarReceita();
      }
    });
  }
}

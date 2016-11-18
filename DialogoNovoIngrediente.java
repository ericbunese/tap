import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogoNovoIngrediente extends JInternalFrame
{
  private JLabel labelNome, labelQuantidade, labelUnidade;
  private JTextField textFieldNome, textFieldQuantidade, textFieldUnidade;
  private JButton botaoOk;
  private JPanel panel;
  private ControleNovoIngrediente controle;
  private ControleEstoque controleEstoque;

  public DialogoNovoIngrediente(ControleEstoque controleEstoque)
  {
    super("Novo Ingrediente", true, true, true, true );

    this.controleEstoque = controleEstoque;
    controle = new ControleNovoIngrediente(controleEstoque);

    panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);

    labelNome = new JLabel("Nome");
    textFieldNome = new JTextField("Nome do Ingrediente");
    labelQuantidade = new JLabel("Quantidade");
    textFieldQuantidade = new JTextField("1");
    labelUnidade = new JLabel("Unidade");
    textFieldUnidade = new JTextField("unidades");
    botaoOk = new JButton("OK");

    panel.setLayout(new FlowLayout());
    panel.add(labelNome);
    panel.add(textFieldNome);
    panel.add(labelQuantidade);
    panel.add(textFieldQuantidade);
    panel.add(labelUnidade);
    panel.add(textFieldUnidade);
    panel.add(botaoOk);
    setSize(450, 300);
    setVisible(true);

    botaoOk.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        int quantidade = Integer.parseInt(textFieldQuantidade.getText());
        String nomeIngrediente = textFieldNome.getText();
        String unidade = textFieldUnidade.getText();

        controle.criarIngrediente(nomeIngrediente, quantidade, unidade);
        controle.salvarIngrediente();
      }
    });

  }
}

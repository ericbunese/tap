import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogoNovoIngrediente extends JInternalFrame
{
  private JLabel labelNome, labelQuantidade;
  private JTextField textFieldNome, textFieldQuantidade;
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
    botaoOk = new JButton("OK");

    panel.setLayout(new FlowLayout());
    panel.add(labelNome);
    panel.add(textFieldNome);
    panel.add(labelQuantidade);
    panel.add(textFieldQuantidade);
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

        for (int i=0;i<quantidade;++i)
        {
          controle.criarIngrediente(nomeIngrediente);
          controle.salvarIngrediente();
        }
      }
    });

  }
}

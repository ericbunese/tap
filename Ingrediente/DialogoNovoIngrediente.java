import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DialogoNovoIngrediente extends JInternalFrame implements ActionListener
{
  private JLabel labelNome;
  private JTextField textFieldNome;
  private JButton botaoOk;
  private JPanel panel;
  private ControleNovoIngrediente controle;
  private ControleEstoque controleEstoque;

  public DialogoNovoIngrediente(ControleEstoque controleEstoque)
  {
    this.controleEstoque = controleEstoque;
    controle = new ControleNovoIngrediente(controleEstoque);

    super("Novo Ingrediente", true, true, true, true );
    panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);
    setSize(100,100);
    setVisible(true);

    labelNome = new JLabel("Ingrediente");
    panel.add(labelNome);
    textFieldNome = new JTextField("Ingrediente");
    panel.add(textFieldNome);

    botaoOk = new JButton("OK");
    panel.setLayout(new FlowLayout());
    panel.add(botaoOk);

    botaoOk.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        String nomeIngrediente = textFieldNome.getText();
        controle.criarIngrediente(nomeIngrediente);
        controle.salvarIngrediente();
        desktop.remove(this);
      }
    });

  }
}

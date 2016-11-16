import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogoVisualizarEstoque extends JInternalFrame
{
  private JList listaEstoque;
  private JPanel panel;
  private ControleVisualizarEstoque controle;
  private ControleEstoque controleEstoque;

  public DialogoNovoIngrediente(ControleEstoque controleEstoque)
  {
    super("Estoque", true, true, true, true );

    this.controleEstoque = controleEstoque;
    controle = new ControleVisualizarEstoque(controleEstoque);

    panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);

    listaEstoque = new JList();
    listaEstoque.setLayoutOrientation(JList.VERTICAL);
    listaEstoque.add("TESTE");
    listaEstoque.add("TESTE");
    listaEstoque.add("TESTE");
    listaEstoque.add("TESTE");
    listaEstoque.add("TESTE");

    panel.add(listaEstoque);

    setSize(450, 300);
    setVisible(true);
  }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogoVisualizarEstoque extends JInternalFrame
{
  private JScrollPane listaEstoqueScroll;
  private JList listaEstoque;
  private JPanel panel;
  private ControleVisualizarEstoque controle;
  private ControleEstoque controleEstoque;

  public DialogoVisualizarEstoque(ControleEstoque controleEstoque)
  {
    super("Estoque", true, true, true, true );

    this.controleEstoque = controleEstoque;
    controle = new ControleVisualizarEstoque(controleEstoque);

    panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);

    listaEstoque = new JList(controle.getItensEstoque());
    listaEstoque.setLayoutOrientation(JList.VERTICAL);

    listaEstoqueScroll = new JScrollPane(listaEstoque);

    panel.add(listaEstoqueScroll);

    setSize(450, 300);
    setVisible(true);
  }
}

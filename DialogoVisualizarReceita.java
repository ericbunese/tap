import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogoVisualizarReceita extends JInternalFrame
{
  private JLabel nomeReceita, caloriasReceita;
  private JScrollPane listaIngredientesScroll;
  private JList listaIngredientes;
  private JPanel panel;
  private ControleVisualizarReceita controle;
  private Receita receita;

  public DialogoVisualizarReceita(Receita receita)
  {
    super("Estoque", true, true, true, true );

    this.receita = receita;
    controle = new ControleVisualizarReceita(receita);

    panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);

    nomeReceita = new JLabel("Nome: "+receita.getNome());
    caloriasReceita = new JLabel("Calorias: "+String.valueOf(receita.getCalorias()));

    listaIngredientes = new JList(controle.getIngredientes());
    listaIngredientes.setLayoutOrientation(JList.VERTICAL);

    listaIngredientesScroll = new JScrollPane(listaIngredientes);

    panel.add(listaIngredientesScroll);
    panel.add(nomeReceita);
    panel.add(caloriasReceita);

    setSize(450, 300);
    setVisible(true);
  }
}

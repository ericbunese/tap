import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogoVisualizarReceita extends JInternalFrame
{
  private JLabel nomeReceita, caloriasReceita, labelModoPreparo;
  private JScrollPane listaIngredientesScroll, modoPreparoScroll;
  private JTextArea modoPreparo;
  private JList listaIngredientes;
  private JPanel panel;
  private ControleVisualizarReceita controle;
  private Receita receita;

  public DialogoVisualizarReceita(Receita receita)
  {
    super("Receita", true, true, true, true );

    this.receita = receita;
    controle = new ControleVisualizarReceita(receita);

    panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);

    nomeReceita = new JLabel("Nome: "+receita.getNome());
    caloriasReceita = new JLabel("Calorias: "+String.valueOf(receita.getCalorias()));

    listaIngredientes = new JList(controle.getIngredientes());
    listaIngredientes.setLayoutOrientation(JList.VERTICAL);

    listaIngredientesScroll = new JScrollPane(listaIngredientes);

    labelModoPreparo = new JLabel("Modo Preparo");
    modoPreparo = new JTextArea(5, 40);
    modoPreparo.setEditable(false);
    modoPreparo.setText(receita.getModoPreparo());
    modoPreparoScroll = new JScrollPane(modoPreparo);

    panel.add(listaIngredientesScroll);
    panel.add(nomeReceita);
    panel.add(caloriasReceita);
    panel.add(labelModoPreparo);
    panel.add(modoPreparoScroll);

    setSize(600, 400);
    setVisible(true);
  }
}

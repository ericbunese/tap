import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogoVisualizarReceitas extends JInternalFrame
{
  private JScrollPane listaReceitasScroll;
  private JList listaReceitas;
  private JPanel panel;
  private ControleVisualizarReceitas controle;
  private ControleReceitas controleReceitas;
  private DesktopPane desktopPane;
  private JButton botaoOk;

  public DialogoVisualizarReceitas(ControleReceitas controleReceitas, DesktopPane desktopPane)
  {
    super("Receitas", true, true, true, true );

    this.controleReceitas = controleReceitas;
    this.desktopPane = desktopPane;
    controle = new ControleVisualizarReceitas(controleReceitas);

    panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);

    listaReceitas = new JList(controle.getItensReceitas());
    listaReceitas.setLayoutOrientation(JList.VERTICAL);

    listaReceitasScroll = new JScrollPane(listaReceitas);
    botaoOk = new JButton("Visualizar");

    panel.add(listaReceitasScroll);
    panel.add(botaoOk);

    setSize(450, 300);
    setVisible(true);

    botaoOk.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        String nome = listaReceitas.getSelectedValue().toString();
        Receita r = controleReceitas.buscarPorNome(nome);
        if (r!=null)
        {
          DialogoVisualizarReceita dvr = new DialogoVisualizarReceita(r);
          desktopPane.add(dvr);
          System.out.println(r.toString());
        }
      }
    });
  }
}

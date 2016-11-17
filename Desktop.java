import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Desktop extends JFrame
{
 private JMenuBar barra;
 private JMenu menuAdicionar, menuVisualizar;
 private JMenuItem itemIngrediente, itemReceita, itemVisualizarEstoque, itemVisualizarReceitas;
 private DesktopPane desktop;
 private ControleEstoque controleEstoque =  new ControleEstoque();
 private ControleReceitas controleReceitas = new ControleReceitas();

 public Desktop()
 {
  super("Sistema do RU");
  //Barra superior
  barra = new JMenuBar();
  menuAdicionar = new JMenu("Adicionar");
  menuVisualizar = new JMenu("Visualizar");

  //Itens no primeiro campo da barra
  itemIngrediente = new JMenuItem("Adicionar Ingrediente ao Estoque");
  menuAdicionar.add(itemIngrediente);
  itemReceita = new JMenuItem("Receita");
  menuAdicionar.add(itemReceita);

  //Itens no segundo campo da barra
  itemVisualizarEstoque = new JMenuItem("Visualizar Estoque");
  menuVisualizar.add(itemVisualizarEstoque);
  itemVisualizarReceitas = new JMenuItem("Visualizar Receitas");
  menuVisualizar.add(itemVisualizarReceitas);

  barra.add(menuAdicionar);
  barra.add(menuVisualizar);
  setJMenuBar(barra);

  //Novo desktop
  desktop = new DesktopPane();
  getContentPane().add(desktop);

  itemIngrediente.addActionListener(new ActionListener()
  {
   @Override
   public void actionPerformed(ActionEvent e)
   {
     //Novo Ingrediente
     DialogoNovoIngrediente dni = new DialogoNovoIngrediente(controleEstoque);
     desktop.add(dni);
   }
  });

  itemReceita.addActionListener(new ActionListener()
  {
   @Override
   public void actionPerformed(ActionEvent e)
   {
     DialogoNovaReceita dnr = new DialogoNovaReceita(controleReceitas, controleEstoque);
     desktop.add(dnr);
   }
  });

  itemVisualizarEstoque.addActionListener(new ActionListener()
  {
   @Override
   public void actionPerformed(ActionEvent e)
   {
     //Visualizar Estoque
     DialogoVisualizarEstoque dvi = new DialogoVisualizarEstoque(controleEstoque);
     desktop.add(dvi);
   }
  });

  itemVisualizarReceitas.addActionListener(new ActionListener()
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      //Visualizar Receitas
      DialogoVisualizarReceitas dvr = new DialogoVisualizarReceitas(controleReceitas, desktop);
      desktop.add(dvr);
    }
  });

  this.setSize(1024, 768);
  this.setVisible(true);

  addWindowListener(new WindowAdapter()
  {
   public void windowClosing( WindowEvent e )
   {
     controleEstoque.salvarEstoque();
     controleReceitas.salvarReceitas();
     System.exit(0);
   }
  });
 }
}

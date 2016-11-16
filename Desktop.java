import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Desktop extends JFrame
{
 private JMenuBar barra;
 private JMenu menuAdicionar, menuVisualizar;
 private JMenuItem itemIngrediente, itemReceita, itemVisualizarEstoque;
 private JDesktopPane desktop;
 private ControleEstoque controleEstoque =  new ControleEstoque();

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

   barra.add(menuAdicionar);
   barra.add(menuVisualizar);
   setJMenuBar(barra);

   //Novo desktop
   desktop = new JDesktopPane();
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
       //Nova Receita.
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

   this.setSize(1024, 768);
   this.setVisible(true);

   addWindowListener(new WindowAdapter()
   {
     public void windowClosing( WindowEvent e )
     {
       controleEstoque.salvarEstoque();
       System.exit(0);
     }
  });
 }
}

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Desktop extends JFrame
{
 private JMenuBar barra;
 private JMenu menuAdicionar;
 private JMenuItem itemIngrediente, itemReceita;
 private JDesktopPane desktop;
 private ControleEstoque controleEstoque =  new ControleEstoque();

 public Desktop()
 {
   super("Sistema do RU");
   //Barra superior
   barra = new JMenuBar();
   menuAdicionar = new JMenu("Adicionar");

   //Itens no primeiro campo da barra
   itemIngrediente = new JMenuItem("Ingrediente");
   menuAdicionar.add(this.itemIngrediente);
   itemReceita = new JMenuItem("Receita");
   menuAdicionar.add(this.itemReceita);

   barra.add(this.menuAdicionar);
   setJMenuBar(this.barra);

   //Novo desktop
   desktop = new JDesktopPane();
   getContentPane().add(this.desktop);

   itemIngrediente.addActionListener(new ActionListener()
   {
     @Override
     public void actionPerformed(ActionEvent e)
     {
       //Novo Ingrediente
       DialogoNovoIngrediente dni = new DialogoNovoIngrediente(controleEstoque);
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

import javax.swing.JOptionPane;
import java.util.*;

public class ControleVisualizarEstoque
{
  private ControleEstoque controleEstoque;
  private String[] itensEstoque;
  private ArrayList<Ingrediente> ingredientes;

  public ControleVisualizarEstoque(ControleEstoque controleEstoque)
  {
    this.controleEstoque = controleEstoque;
    ingredientes = controleEstoque.getIngredientes();

    int pos = 0;
    itensEstoque = new String[ingredientes.size()];
    System.out.println("VISUALIZAR ESTOQUE");
    for (Ingrediente i:ingredientes)
    {
      System.out.println(i.toString());
      itensEstoque[pos] = i.toString();
      pos++;
    }
    System.out.println(".");
  }

  public String[] getItensEstoque()
  {
    return itensEstoque;
  }
}

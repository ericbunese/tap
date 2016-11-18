import javax.swing.JOptionPane;
import java.util.*;

public class ControleVisualizarReceita
{
  private ControleEstoque controleEstoque;
  private String[] itensIngredientes;
  private ArrayList<Ingrediente> ingredientes;

  public ControleVisualizarReceita(Receita receita)
  {
    this.controleEstoque = controleEstoque;
    ingredientes = receita.getIngredientes();

    int pos = 0;
    itensIngredientes = new String[ingredientes.size()];
    System.out.println("VISUALIZAR INGREDIENTES DA RECEITA");
    for (Ingrediente i:ingredientes)
    {
      System.out.println(i.getQuantidade()+i.getUnidade()+". "+i.getNome());
      itensIngredientes[pos] = i.getQuantidade()+i.getUnidade()+". "+i.getNome();
      pos++;
    }
    System.out.println(".");
  }

  public String[] getIngredientes()
  {
    return itensIngredientes;
  }
}

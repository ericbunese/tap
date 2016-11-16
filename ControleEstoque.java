import java.util.*;

public class ControleEstoque
{
  private ArrayList<Ingrediente> ingredientes;

  public ControleEstoque()
  {
    ingredientes = new ArrayList<Ingrediente>();
  }

  public void incluirEstoque(Ingrediente ingrediente)
  {
    if (!ingredientes.contains(ingrediente))
    {
      ingredientes.add(ingrediente);
      System.out.println("Adicionado ingrediente "+ingrediente.getNome());
    }
    else
    {
      for (Ingrediente i:ingredientes)
      {
        if (i.equals(ingrediente))
        {
          i.setQuantidade(i.getQuantidade()+1);
          System.out.println("Alterada quantidade do item "+i.getNome());
          break;
        }
      }
    }
  }

  public void removerEstoque(Ingrediente ingrediente)
  {
    ingredientes.remove(ingrediente);
  }

  public void salvarEstoque()
  {

  }

  public ArrayList<Ingrediente> getIngredientes()
  {
    return ingredientes;
  }
}

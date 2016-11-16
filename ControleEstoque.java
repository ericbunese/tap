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
    ingredientes.add(ingrediente);
  }

  public void removerEstoque(Ingrediente ingrediente)
  {
    ingredientes.remove(ingrediente);
  }

  public void salvarEstoque()
  {

  }
}

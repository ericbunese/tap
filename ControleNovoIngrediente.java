import javax.swing.JOptionPane;

public class ControleNovoIngrediente
{
  private Ingrediente ingrediente=null;
  private ControleEstoque controleEstoque;

  public ControleNovoIngrediente(ControleEstoque controleEstoque)
  {
    this.controleEstoque = controleEstoque;
  }

  public void criarIngrediente(String nome)
  {
    if (nome!=null && !nome.equals(""))
    {
      if (ingrediente==null)
      {
        ingrediente = new Ingrediente(nome);
      }
      else
      {
        ingrediente.setNome(nome);
      }
      System.out.println("Novo Ingrediente: "+nome+" criado");
    }
  }

  public void salvarIngrediente()
  {
    if (ingrediente!=null)
    {
      controleEstoque.incluirEstoque(ingrediente);
      controleEstoque.salvarEstoque();
      System.out.println("Ingrediente adicionado ao estoque.");
      ingrediente = null;
    }
    else
    {
      JOptionPane.showMessageDialog(null, "Não foi possível salvar o ingrediente.");
    }
  }
}

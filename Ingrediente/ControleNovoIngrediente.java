public class ControleNovoIngrediente
{
  private Ingrediente ingrediente=null;
  private ControleEstoque controleEstoque;

  public ControleNovoIngrediente(ControleEstoque controleEstoque)
  {
    this.controleEstoque = controleEstoque;
  }

  public criarIngrediente(String nome)
  {
    if (nome!=null)
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

  public salvarIngrediente(Ingrediente ingrediente)
  {
    if (ingrediente!=null)
    {
      controleEstoque.incluirEstoque(ingrediente);
      controleEstoque.salvarEstoque();
      JOptionPane.showMessageDialog(null, "Ingrediente salvo com sucesso.");
    }
    else
    {
      JOptionPane.showMessageDialog(null, "Não foi possível salvar o ingrediente.");
    }
  }
}

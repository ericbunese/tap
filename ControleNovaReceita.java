import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.util.*;

public class ControleNovaReceita
{
  private Receita receita=null;
  private ControleReceitas controleReceitas;
  private String[] itensReceita;
  private ArrayList<Receita> receitas;
  private ControleEstoque controleEstoque;

  public ControleNovaReceita(ControleReceitas controleReceitas, ControleEstoque controleEstoque)
  {
    this.controleReceitas = controleReceitas;
    receitas = controleReceitas.getReceitas();
    receita = new Receita();
    ArrayList<Ingrediente> recIgrs = new ArrayList<Ingrediente>();

    for (Ingrediente i:controleEstoque.getIngredientes())
    {
      recIgrs.add(new Ingrediente(i.getNome(), i.getQuantidade(), i.getUnidade()));
    }
    receita.setIngredientes(recIgrs);

    int pos = 0;
    itensReceita = new String[receitas.size()];
    System.out.println("VISUALIZAR ESTOQUE PARA RECEITAS");
    for (Receita r:receitas)
    {
      System.out.println(r.toString());
      itensReceita[pos] = r.toString();
      pos++;
    }
    System.out.println(".");
  }

  public void criarReceita(String nome, int calorias)
  {
    receita.setNome(nome);
    receita.setCalorias(calorias);
  }

  public void salvarReceita()
  {
    if (receita!=null)
    {
      controleReceitas.incluirReceita(receita);
      controleReceitas.salvarReceitas();
      System.out.println("Receita adicionada.");
      receita = null;
    }
    else
    {
      JOptionPane.showMessageDialog(null, "Não foi possível salvar a receita.");
    }
  }

  public String[] getItensReceita()
  {
    return itensReceita;
  }

  public ArrayList<Ingrediente> getIngredientes()
  {
    return receita.getIngredientes();
  }

  public void setIngredientes(ArrayList<Ingrediente> ingredientes)
  {
    receita.setIngredientes(ingredientes);
  }

  public DefaultListModel atualizarQuantidades()
  {
    DefaultListModel model = new DefaultListModel();

    for (Ingrediente i:receita.getIngredientes())
    {
      model.addElement(i.toString());
    }

    return model;
  }

  public Ingrediente buscarPorNome(String nome)
  {
    if  (receita==null)
      return null;
    for (Ingrediente i:receita.getIngredientes())
    {
      if (i.getNome().equals(nome))
        return i;
    }
    return null;
  }
}

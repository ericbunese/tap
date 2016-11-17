import javax.swing.JOptionPane;
import java.util.*;

public class ControleNovaReceita
{
  private Receita receita=null;
  private ControleReceitas controleReceitas;
  private String[] itensReceita;
  private ArrayList<Receita> receitas;

  public ControleNovaReceita(ControleReceitas controleReceitas)
  {
    this.controleReceitas = controleReceitas;
    receitas = controleReceitas.getReceitas();

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

  public void criarReceita(String nome, int calorias, java.util.List<Ingrediente> ingredientes)
  {
    if (nome!=null && !nome.equals(""))
    {
      if (receita==null)
      {
        receita = new Receita(nome, calorias, (ArrayList)ingredientes);
      }
      else
      {
        receita.setNome(nome);
        receita.setCalorias(calorias);
        receita.setIngredientes(ingredientes);
      }
      System.out.println("Nova Receita: "+nome+" criada");
    }
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
}

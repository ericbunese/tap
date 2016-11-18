import javax.swing.JOptionPane;
import java.util.*;

public class ControleNovaRefeicao
{
  private Receita receita=null;
  private ControleReceitas controleReceitas;
  private String[] itensReceita;
  private ArrayList<Receita> receitas;
  private Refeicao refeicao;

  public ControleNovaRefeicao(ControleReceitas controleReceitas)
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

  public void criarRefeicao(String nome, int quantidadePessoas, ArrayList<Receita> receitas)
  {
    if (nome!=null && !nome.equals(""))
    {
      if (refeicao==null)
      {
        refeicao = new Refeicao(nome, quantidadePessoas, receitas);
      }
      else
      {
        refeicao.setNome(nome);
        refeicao.setQuantidadePessoas(quantidadePessoas);
        refeicao.setReceitas(receitas);
      }
      System.out.println("Nova Refeicao: "+nome+" criada");
    }
  }

  public void imprimirRefeicao()
  {
    if (refeicao!=null)
    {
      //@mostrar refeição
      System.out.println(refeicao.toString());
      System.out.println("Refeicao impressa.");
      refeicao = null;
    }
    else
    {
      JOptionPane.showMessageDialog(null, "Não foi possível imprimir a refeicao.");
    }
  }

  public String[] getItensReceita()
  {
    return itensReceita;
  }
}

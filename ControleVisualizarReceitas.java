import javax.swing.JOptionPane;
import java.util.*;

public class ControleVisualizarReceitas
{
  private ControleReceitas controleReceitas;
  private String[] itensReceitas;
  private ArrayList<Receita> receitas;

  public ControleVisualizarReceitas(ControleReceitas controleReceitas)
  {
    this.controleReceitas = controleReceitas;
    receitas = controleReceitas.getReceitas();

    int pos = 0;
    itensReceitas = new String[receitas.size()];
    System.out.println("VISUALIZAR ESTOQUE");
    for (Receita r:receitas)
    {
      System.out.println(r.toString());
      itensReceitas[pos] = r.getNome();
      pos++;
    }
    System.out.println(".");
  }

  public String[] getItensReceitas()
  {
    return itensReceitas;
  }
}

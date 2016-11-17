import java.util.*;
import java.io.*;

public class ControleReceitas
{
  private ArrayList<Receita> receitas;

  public ControleReceitas()
  {
    receitas = new ArrayList<Receita>();
    carregarReceitas();
  }

  public void incluirReceita(Receita receita)
  {
    if (!receitas.contains(receita))
    {
      receitas.add(receita);
      System.out.println("Adicionada receita "+receita.getNome());
    }
  }

  public void removerReceita(Receita receita)
  {
    receitas.remove(receita);
  }

  public void carregarReceitas()
  {
    Receita r = null;
    try
    {
      FileInputStream fileIn = new FileInputStream("receitas.dat");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      r = (Receita) in.readObject();
      if (r!=null)
      {
        incluirReceita(r);
        while((r = (Receita) in.readObject())!=null)
        {
          incluirReceita(r);
        }
      }
      in.close();
      fileIn.close();
      System.out.println("Receitas Carregadas.");
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
      System.out.println("Não foi possível carregar as receitas.");
    }
    catch(ClassNotFoundException cne)
    {
      cne.printStackTrace();
      System.out.println("Não foi possível carregar as receitas.");
    }
  }

  public void salvarReceitas()
  {
    try
    {
      FileOutputStream fileOut = new FileOutputStream("receitas.dat");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      for (Receita r:receitas)
      {
        out.writeObject(r);
      }
      out.writeObject(null);
      out.close();
      fileOut.close();
      System.out.println("Receitas salvas no arquivo receitas.dat");
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
      System.out.println("Não foi possível salvar o estoque.");
    }
  }

  public ArrayList<Receita> getReceitas()
  {
    return receitas;
  }

  public Receita buscarPorNome(String nome)
  {
    for (Receita r:receitas)
    {
      if (r.getNome().equals(nome))
          return r;
    }
    return null;
  }
}

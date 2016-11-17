import java.util.*;
import java.io.*;

public class ControleEstoque
{
  private ArrayList<Ingrediente> ingredientes;

  public ControleEstoque()
  {
    ingredientes = new ArrayList<Ingrediente>();
    carregarEstoque();
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

  public void carregarEstoque()
  {
    Ingrediente i = null;
    try
    {
      FileInputStream fileIn = new FileInputStream("estoque.dat");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      i = (Ingrediente) in.readObject();
      if (i!=null)
      {
        incluirEstoque(i);
        while((i = (Ingrediente) in.readObject())!=null)
        {
          incluirEstoque(i);
        }
      }
      in.close();
      fileIn.close();
      System.out.println("Estoque Carregado.");
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
      System.out.println("Não foi possível carregar o estoque.");
    }
    catch(ClassNotFoundException cne)
    {
      cne.printStackTrace();
      System.out.println("Não foi possível carregar o estoque.");
    }
  }

  public void salvarEstoque()
  {
    try
    {
      FileOutputStream fileOut = new FileOutputStream("estoque.dat");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      for (Ingrediente i:ingredientes)
      {
        out.writeObject(i);
      }
      out.writeObject(null);
      out.close();
      fileOut.close();
      System.out.println("Estoque salvo no arquivo estoque.dat");
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
      System.out.println("Não foi possível salvar o estoque.");
    }
  }

  public ArrayList<Ingrediente> getIngredientes()
  {
    return ingredientes;
  }

  public Ingrediente buscarPorNome(String nome)
  {
    for (Ingrediente i:ingredientes)
    {
      if (i.getNome().equals(nome))
          return i;
    }
    return null;
  }
}

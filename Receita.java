import java.io.*;
import java.util.*;

public class Receita implements java.io.Serializable
{
  private String nome;
  private int calorias;
  private ArrayList<Ingrediente> ingredientes;

  public Receita()
  {

  }

  public Receita(String nome)
  {
    this.nome = nome;
    calorias = 0;
    ingredientes = new ArrayList<Ingrediente>();
  }

  public Receita(String nome, int calorias)
  {
    this.nome = nome;
    this.calorias = calorias;
    ingredientes = new ArrayList<Ingrediente>();
  }

  public Receita(String nome, int calorias, ArrayList<Ingrediente> ingredientes)
  {
    this.nome = nome;
    this.calorias = calorias;
    this.ingredientes = ingredientes;
  }

  public String getNome()
  {
    return nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  public int getCalorias()
  {
    return calorias;
  }

  public void setCalorias(int calorias)
  {
    this.calorias = calorias;
  }

  public void setIngredientes(ArrayList<Ingrediente> ingredientes)
  {
    this.ingredientes = ingredientes;
  }

  public ArrayList<Ingrediente> getIngredientes()
  {
    return ingredientes;
  }

  public String toString()
  {
    String ingrs = "";
    for(Ingrediente i:ingredientes)
    {
      ingrs+=i.toString()+";";
    }
    return String.valueOf(calorias)+"kcal:"+nome+": "+ingrs;
  }

  public String imprimir(int quantidadePessoas)
  {
    String master = "Receita "+getNome()+". Calorias: "+getCalorias()+"\n";
    int quantidade;
    master+="===================\nIngredientes:";
    for(Ingrediente i: ingredientes)
    {
      quantidade = i.getQuantidade()*quantidadePessoas;
      master+=i.getNome()+":   "+quantidade;
    }

    return master;
  }

  @Override
  public boolean equals(Object object)
  {
    boolean result = false;
    if (object == null || object.getClass() != getClass())
    {
      result = false;
    }
    else
    {
      Receita receita = (Receita) object;
      if (this.nome.equals(receita.getNome()) && this.calorias == receita.calorias)
      {
        result = true;
      }
    }
    return result;
  }
}

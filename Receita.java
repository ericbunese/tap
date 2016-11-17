import java.io.*;
import java.util.*;

public class Receita implements java.io.Serializable
{
  private String nome;
  private int calorias;
  private ArrayList<Ingrediente> ingredientes;

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

  public Receita(String nome, int calorias, List<Ingrediente> ingredientes)
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

  public void setIngredientes(List<Ingrediente> ingredientes)
  {
    this.ingredientes = ingredientes;
  }

  public List<Ingrediente> getIngredientes()
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
    return String.valueOf(calorias)+". "+nome+" - "+ingrs;
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
      if (this.nome.equals(ingrediente.getNome()) && this.calorias == receita.calorias)
      {
        result = true;
      }
    }
    return result;
  }
}

import java.io.*;
import java.util.*;

public class Refeicao
{
  private String nome;
  private int quantidadePessoas;
  private ArrayList<Receita> receitas;

  public Refeicao(String nome)
  {
    this.nome = nome;
    quantidadePessoas = 0;
    receitas = new ArrayList<Receita>();
  }

  public Refeicao(String nome, int quantidadePessoas)
  {
    this.nome = nome;
    this.quantidadePessoas = quantidadePessoas;
    receitas = new ArrayList<Receita>();
  }

  public Refeicao(String nome, int quantidadePessoas, ArrayList<Receita> receitas)
  {
    this.nome = nome;
    this.quantidadePessoas = quantidadePessoas;
    this.receitas = receitas;
  }

  public String getNome()
  {
    return nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  public int getQuantidadePessoas()
  {
    return quantidadePessoas;
  }

  public void setQuantidadePessoas(int quantidadePessoas)
  {
    this.quantidadePessoas = quantidadePessoas;
  }

  public void setReceitas(ArrayList<Receita> receitas)
  {
    this.receitas = receitas;
  }

  public ArrayList<Receita> getReceitas()
  {
    return receitas;
  }

  public String toString()
  {
    String recs = "";
    for(Receita r:receitas)
    {
      recs+=r.toString()+";";
    }
    return String.valueOf(quantidadePessoas)+". "+nome+" - "+recs;
  }

  public String imprimir()
  {
    String master = "Refeição "+getNome()+". Para: "+getQuantidadePessoas()+" pessoas.\n\n";
    master+="==========\nReceitas:\n";
    for (Receita r:receitas)
    {
      master += r.imprimir(getQuantidadePessoas())+"\n";
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
      if (this.nome.equals(receita.getNome()))
      {
        result = true;
      }
    }
    return result;
  }
}

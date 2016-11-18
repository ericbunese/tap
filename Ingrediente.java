import java.io.*;

public class Ingrediente implements java.io.Serializable
{
  private String nome;
  private String unidade;
  private int quantidade;

  public Ingrediente(String nome)
  {
    this.nome = nome;
    this.unidade = "unidades";
    quantidade = 1;
  }

  public Ingrediente(String nome, int quantidade)
  {
    this.nome = nome;
    this.quantidade = quantidade;
    this.unidade = "unidades";
  }

  public Ingrediente(String nome, int quantidade, String unidade)
  {
    this.nome = nome;
    this.quantidade = quantidade;
    this.unidade = unidade;
  }

  public String getNome()
  {
    return nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  public int getQuantidade()
  {
    return quantidade;
  }

  public void setQuantidade(int quantidade)
  {
    this.quantidade = quantidade;
  }

  public String getUnidade()
  {
    return unidade;
  }

  public void setUnidade(String unidade)
  {
    this.unidade = unidade;
  }

  public String toString()
  {
    return String.valueOf(quantidade)+unidade+" "+nome;
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
      Ingrediente ingrediente = (Ingrediente) object;
      if (this.nome.equals(ingrediente.getNome()))
      {
        result = true;
      }
    }
    return result;
  }
}

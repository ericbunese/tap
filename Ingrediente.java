import java.io.*;

public class Ingrediente implements java.io.Serializable
{
  private String nome;
  private int quantidade;

  public Ingrediente(String nome)
  {
    this.nome = nome;
    quantidade = 1;
  }

  public Ingrediente(String nome, int quantidade)
  {
    this.nome = nome;
    this.quantidade = quantidade;
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

  public String toString()
  {
    return String.valueOf(quantidade)+". "+nome;
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

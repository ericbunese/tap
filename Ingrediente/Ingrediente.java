package br.com.marblestudio.tap;

public class Ingrediente
{
  private String name;

  public Ingrediente()
  {

  }

  public Ingrediente(String nome)
  {
    this.nome = nome;
  }

  public String getNome()
  {
    return nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }
}

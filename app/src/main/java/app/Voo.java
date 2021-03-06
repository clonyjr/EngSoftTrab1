package app;

import java.util.List;


public class Voo {
  final String id;
  final String numero;
  final String pais;

  public Voo(final List line) {
    this.id = (String)line.get(0);
    this.numero = (String)line.get(1);
    this.pais = (String)line.get(2);
  }

  public String getId() { return id; }
  public String getNumero() { return numero; }
  public String getCidade() { return pais; }

  @Override
  public String toString() {
    return String.format(
      "{ id: %s, numero: %s, cidade: %s }",
      this.id,
      this.numero,
      this.pais
    );
  }
}

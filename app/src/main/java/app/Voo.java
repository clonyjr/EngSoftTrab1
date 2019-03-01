package app;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voo {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(nullable = false, unique = false)
  final String vooId;
  @Column(nullable = false, unique = false)
  final String numero;
  @Column(nullable = false, unique = false)
  final String pais;

  public Voo(final List line) {
    this.vooId = (String)line.get(0);
    this.numero = (String)line.get(1);
    this.pais = (String)line.get(2);
  }

  public Long getId() { return id; }
  public String getVooId() { return vooId; }
  public String getNumero() { return numero; }
  public String getCidade() { return pais; }

  @Override
  public String toString() {
    return String.format(
      "{ vooId: %s, number: %s, country: %s }",
      this.vooId,
      this.numero,
      this.pais
    );
  }
}

package modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Genero.todos", query = "SELECT c FROM Genero c"),
        @NamedQuery(name = "Genero.porNome", query = "SELECT col FROM Genero col WHERE col.nome LIKE :nomequalquer")
})
@Table(name = "genero")
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_genero")
    private int codigo;

    @Column(name = "nome", length = 30, nullable = false)
    private String nome;

    public Genero() {
    }

    public Genero(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;

    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Genero other = (Genero) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Genero{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }
}

package modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Cliente.todos", query = "SELECT c FROM Cliente c WHERE c.ativo = true"),
        @NamedQuery(name = "Cliente.porNome", query = "SELECT col FROM Cliente col WHERE col.nome LIKE :nomequalquer AND col.ativo = true")
})
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cliente")
    private int codigo;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;

    @Column(name = "telefone", length = 17, nullable = false)
    private String telefone;

    @Column(name = "email", length = 45, nullable = false)
    private String email;

    @Column(name = "cidade", length = 70, nullable = false)
    private String cidade;

    @Column(name = "estado", length = 2, nullable = false)
    private String estado;

    @Column(name = "endereco", length = 70, nullable = true)
    private String endereco;

    @Column(name = "cep", length = 9, nullable = true)
    private String cep;

    @Column(name = "ativo", nullable = true)
    private boolean ativo;

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String cpf, String telefone, String email, String cidade, String estado, String endereco, String cep, boolean ativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
        this.cep = cep;
        this.ativo = ativo;

    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.codigo;
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
        final Cliente other = (Cliente) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + ", cidade=" + cidade + ", estado=" + estado + ", endereco=" + endereco + ", cep=" + cep + '}';
    }

}

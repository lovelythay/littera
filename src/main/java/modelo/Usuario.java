package modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Usuario.todos", query = "SELECT u FROM Usuario u WHERE u.ativo = true"),
        @NamedQuery(name = "Usuario.porNome", query = "SELECT user FROM Usuario user  WHERE user.nome LIKE :nomequalquer and user.ativo = true"),
        @NamedQuery(name = "Usuario.login", query = "SELECT u FROM Usuario u WHERE u.email = :login AND u.senha = :senha AND u.ativo = true"),
        @NamedQuery(name = "Usuario.quantidadeUsuarios", query = "SELECT COUNT(u) FROM Usuario u")
})
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_usuario")
    private int codigo;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;

    @Column(name = "email", length = 45, nullable = false)
    private String email;

    @Column(name = "senha", length = 20, nullable = false)
    private String senha;

    @Column(name = "tipo", length = 1, nullable = false)
    private String tipo;

    @Column(name = "endereco", length = 60, nullable = false)
    private String endereco;

    @Column(name = "cidade", length = 70, nullable = false)
    private String cidade;

    @Column(name = "estado", length = 2, nullable = false)
    private String estado;

    @Column(name = "cep", length = 9, nullable = false)
    private String cep;

    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    public Usuario() {
    }

    public Usuario(int codigo, String nome, String telefone, String email, String senha, String tipo, String endereco, String cidade, String estado, String cep, String cpf, boolean ativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.cpf = cpf;
        this.ativo = ativo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getCpf() {
        return cpf;
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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codigo;
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
        final Usuario other = (Usuario) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", senha=" + senha + ", tipo=" + tipo + ", endereco=" + endereco + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + '}';
    }

}

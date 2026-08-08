package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Historico.livro", query = "SELECT h FROM Historico h WHERE h.livro = :livro"),
        @NamedQuery(name = "Historico.usuario", query = "SELECT hist FROM Historico hist WHERE hist.usuario = :usuario")
})
@Table(name = "historico")

public class Historico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_historico")
    private int codigo;

    @ManyToOne
    @JoinColumn(name = "cod_livro", referencedColumnName = "cod_livro")
    private Livro livro;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_atualizacao", nullable = false)
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario")
    private Usuario usuario;

    public Historico() {
    }

    public Historico(int codigo, Livro livro, int quantidade, String descricao, Date dataAtualizacao, Usuario usuario) {
        this.codigo = codigo;
        this.livro = livro;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.dataAtualizacao = dataAtualizacao;
        this.usuario = usuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        final Historico other = (Historico) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Historico{" + "codigo=" + codigo + ", livro=" + livro + ", quantidade=" + quantidade + ", descricao=" + descricao + ", dataAtualizacao=" + dataAtualizacao + ", usuario=" + usuario + '}';
    }

}

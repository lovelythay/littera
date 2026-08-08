package modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Livro.todos", query = "SELECT l FROM Livro l WHERE l.ativo = true"),
        @NamedQuery(name = "Livro.porNome", query = "SELECT liv FROM Livro liv WHERE liv.nome LIKE :nomequalquer AND liv.ativo = true"),
        @NamedQuery(name = "Livro.porGenero", query = "SELECT livro FROM Livro livro WHERE livro.genero = :gen"),
        @NamedQuery(name = "Livro.porGeneroAtivo", query = "SELECT livro FROM Livro livro WHERE livro.genero = :gen AND livro.ativo = true"),
        @NamedQuery(name = "Livro.baixoEstoque", query = "SELECT li FROM Livro li WHERE li.quantidade <= 10 AND li.ativo = true")
})
@Table(name = "livro")
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_livro")
    private int codigo;

    @Column(name = "nome", length = 70, nullable = false)
    private String nome;

    @Column(name = "isbn", length = 17, nullable = false)
    private String isbn;

    @Column(name = "tipo", length = 1, nullable = false)
    private String tipo;

    @Column(name = "autor", length = 60, nullable = false)
    private String autor;

    @Column(name = "editora", length = 50, nullable = false)
    private String editora;

    @Column(name = "situacao", nullable = false)
    private boolean situacao;

    @Column(name = "preco")
    private double preco;

    @Column(name = "taxa")
    private double taxa;

    @Column(name = "prateleira", length = 10, nullable = false)
    private String prateleira;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "quantidade_disponivel", nullable = false)
    private int quantidadeDisponivel;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "cod_genero", referencedColumnName = "cod_genero")
    private Genero genero;

    public Livro() {
    }

    public Livro(int codigo, String nome, String isbn, String tipo, String autor, String editora, boolean situacao, double preco, double taxa, String prateleira, int quantidade, int quantidadeDisponivel, boolean ativo, Genero genero) {
        this.codigo = codigo;
        this.nome = nome;
        this.isbn = isbn;
        this.tipo = tipo;
        this.autor = autor;
        this.editora = editora;
        this.situacao = situacao;
        this.preco = preco;
        this.taxa = taxa;
        this.prateleira = prateleira;
        this.quantidade = quantidade;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.ativo = ativo;
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTipo() {
        return tipo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public double getPreco() {
        return preco;
    }

    public double getTaxa() {
        return taxa;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }


    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getStringTipo() {

        String tipoString;

        tipoString = switch (this.tipo) {
            case "A" -> "Venda/Empréstimo";
            case "V" -> "Venda";
            default -> "Empréstimo";
        };
        return tipoString;
    }

    public String getStringSituacao() {

        String situacaoString;

        if (this.situacao) {

            situacaoString = "Livros Disponíveis";

        } else {

            situacaoString = "Livros Indisponíveis";
        }

        return situacaoString;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.codigo;
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
        final Livro other = (Livro) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Livro{" + "codigo=" + codigo + ", nome=" + nome + ", isbn=" + isbn + ", tipo=" + tipo + ", autor=" + autor + ", editora=" + editora + ", situacao=" + situacao + ", preco=" + preco + ", taxa=" + taxa + ", genero=" + genero + '}';
    }

}

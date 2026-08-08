package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;

@Entity
@Table(name = "item_venda")
@NamedQueries({
        @NamedQuery(name = "ItemVenda.livro", query = "SELECT item FROM ItemVenda item WHERE item.livro = :livro"),
        @NamedQuery(name = "ItemVenda.cliente", query = "SELECT iv FROM ItemVenda iv WHERE iv.venda.cliente = :clientee ORDER BY iv.venda.codigo")
})
@IdClass(ItemVendaId.class)
public class ItemVenda implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "cod_venda", referencedColumnName = "cod_venda")
    private Venda venda;

    @Id
    @ManyToOne
    @JoinColumn(name = "cod_livro", referencedColumnName = "cod_livro")
    private Livro livro;

    @Column(name = "preco", nullable = false)
    private double preco;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    public ItemVenda() {
    }

    public ItemVenda(Venda venda, Livro livro, double preco, int quantidade) {
        this.venda = venda;
        this.livro = livro;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public Livro getLivro() {
        return livro;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // método GET para relátorios
    public String getStringPreco() {

        NumberFormat formatar = NumberFormat.getCurrencyInstance();

        String precoString = formatar.format(this.preco);

        return precoString;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.venda);
        hash = 97 * hash + Objects.hashCode(this.livro);
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
        final ItemVenda other = (ItemVenda) obj;
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        return Objects.equals(this.livro, other.livro);
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "venda=" + venda + ", livro=" + livro + ", preco=" + preco + ", quantidade=" + quantidade + '}';
    }

}

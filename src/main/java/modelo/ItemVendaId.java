package modelo;

import java.io.Serializable;

public class ItemVendaId implements Serializable {

    private int livro;
    private int venda;

    public ItemVendaId() {
    }

    public ItemVendaId(int livro, int venda) {
        this.livro = livro;
        this.venda = venda;
    }

    public int getLivro() {
        return livro;
    }

    public int getVenda() {
        return venda;
    }

    public void setLivro(int livro) {
        this.livro = livro;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.livro;
        hash = 79 * hash + this.venda;
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
        final ItemVendaId other = (ItemVendaId) obj;
        if (this.livro != other.livro) {
            return false;
        }
        return this.venda == other.venda;
    }

}

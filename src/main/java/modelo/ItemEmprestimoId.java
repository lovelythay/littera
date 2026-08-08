package modelo;

import java.io.Serializable;

public class ItemEmprestimoId implements Serializable {

    private int emprestimo;
    private int livro;

    public ItemEmprestimoId() {
    }

    public ItemEmprestimoId(int emprestimo, int livro) {
        this.emprestimo = emprestimo;
        this.livro = livro;
    }

    public int getEmprestimo() {
        return emprestimo;
    }

    public int getLivro() {
        return livro;
    }

    public void setEmprestimo(int emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void setLivro(int livro) {
        this.livro = livro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.emprestimo;
        hash = 79 * hash + this.livro;
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
        final ItemEmprestimoId other = (ItemEmprestimoId) obj;
        if (this.emprestimo != other.emprestimo) {
            return false;
        }
        return this.livro == other.livro;
    }

}

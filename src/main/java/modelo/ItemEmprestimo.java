package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "item_emprestimo")
@NamedQueries({
        @NamedQuery(name = "ItemEmprestimo.livro", query = "SELECT item FROM ItemEmprestimo item WHERE item.livro = :livro"),
        @NamedQuery(name = "ItemEmprestimo.cliente", query = "SELECT ie FROM ItemEmprestimo ie WHERE ie.emprestimo.cliente = :clientee ORDER BY ie.emprestimo.codigo")
})
@IdClass(ItemEmprestimoId.class)
public class ItemEmprestimo implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "cod_emprestimo", referencedColumnName = "cod_emprestimo")
    private Emprestimo emprestimo;

    @Id
    @ManyToOne
    @JoinColumn(name = "cod_livro", referencedColumnName = "cod_livro")
    private Livro livro;

    @Column(name = "preco", nullable = false)
    private double preco;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_real")
    private Date dataReal;

    @Column(name = "situacao", nullable = false)
    private boolean situacao;

    @Column(name = "multa")
    private double multa;

    public ItemEmprestimo() {
    }

    public ItemEmprestimo(double preco, Date dataReal, Emprestimo emprestimo, Livro livro, boolean situacao, double multa) {
        this.preco = preco;
        this.dataReal = dataReal;
        this.emprestimo = emprestimo;
        this.livro = livro;
        this.situacao = situacao;
        this.multa = multa;
    }

    public double getPreco() {
        return preco;
    }

    public Date getDataReal() {
        return dataReal;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public double getMulta() {
        return multa;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDataReal(Date dataReal) {
        this.dataReal = dataReal;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double calcularMulta(int dias) {

        double multaCalculada = dias * this.preco;
        return multaCalculada;
    }

    // métodos GET para relatórios
    public String getStringDataReal() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String real;

        if (this.situacao) {
            real = sdf.format(this.dataReal);
        } else {

            real = "Não houve devolução.";
        }

        return real;
    }

    public String getStringPreco() {

        NumberFormat formatar = NumberFormat.getCurrencyInstance();

        String precoString = formatar.format(this.preco);

        return precoString;
    }

    public String getStringMulta() {

        NumberFormat formatar = NumberFormat.getCurrencyInstance();

        String multaString = formatar.format(this.multa);

        return multaString;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.emprestimo);
        hash = 67 * hash + Objects.hashCode(this.livro);
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
        final ItemEmprestimo other = (ItemEmprestimo) obj;
        if (!Objects.equals(this.emprestimo, other.emprestimo)) {
            return false;
        }
        return Objects.equals(this.livro, other.livro);
    }

    @Override
    public String toString() {
        return "ItemEmprestimo{" + "emprestimo=" + emprestimo + ", livro=" + livro + ", preco=" + preco + ", dataReal=" + dataReal + ", situacao=" + situacao + ", multa=" + multa + '}';
    }

}

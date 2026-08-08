package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Emprestimo.todos", query = "SELECT e FROM Emprestimo e "),
        @NamedQuery(name = "Emprestimo.pendente", query = "SELECT emp FROM Emprestimo emp WHERE emp.caixa IS NULL "),
        // ver emprestimos vencidos
        @NamedQuery(name = "Emprestimo.finalizado", query = "SELECT em FROM Emprestimo em WHERE em.caixa IS NOT NULL"),
        @NamedQuery(name = "Emprestimo.usuario", query = "SELECT emprestimo FROM Emprestimo emprestimo WHERE emprestimo.usuario = :usuario")
})

@Table(name = "emprestimo")
public class Emprestimo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_emprestimo")
    private int codigo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_locacao", nullable = false)
    private Date dataLocacao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_devolucao", nullable = false)
    private Date dataDevolucao;

    @Column(name = "multa", nullable = true)
    private double multa;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Column(name = "situacao", nullable = false)
    private boolean situacao;

    @ManyToOne
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "caixa_data", referencedColumnName = "caixa_data")
    private Caixa caixa;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "emprestimo")
    private List<ItemEmprestimo> itens = new ArrayList<>();

    public Emprestimo() {
    }

    public Emprestimo(int codigo, Date dataLocacao, Date dataDevolucao, double multa, double valor, boolean situacao, Usuario usuario, Cliente cliente, Caixa caixa) {
        this.codigo = codigo;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.multa = multa;
        this.valor = valor;
        this.situacao = situacao;
        this.usuario = usuario;
        this.cliente = cliente;
        this.caixa = caixa;
    }

    public int getCodigo() {
        return codigo;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public double getMulta() {
        return multa;
    }

    public double getValor() {
        return valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public List<ItemEmprestimo> getItens() {
        return itens;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public void setItens(List<ItemEmprestimo> itens) {
        this.itens = itens;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public void adicionarItem(ItemEmprestimo item) {

        item.setEmprestimo(this);
        itens.add(item);

    }

    // métodos GET para relatórios
    public String getStringCaixa() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String data;
        if (this.caixa != null) {

            data = sdf.format(caixa.getData());
        } else {

            data = "Pendente";
        }

        return data;
    }

    public String getStringDevolucao() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String devolucao = sdf.format(this.dataDevolucao);

        return devolucao;
    }

    public String getStringLocacao() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String locacao = sdf.format(this.dataLocacao);

        return locacao;
    }

    public String getStringValor() {

        NumberFormat formatar = NumberFormat.getCurrencyInstance();

        String valor = formatar.format(this.valor + this.multa);

        return valor;
    }

    public String getStringMulta() {

        NumberFormat formatar = NumberFormat.getCurrencyInstance();

        String multa = formatar.format(this.multa);

        return multa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.codigo;
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
        final Emprestimo other = (Emprestimo) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "codigo=" + codigo + ", dataLocacao=" + dataLocacao + ", dataDevolucao=" + dataDevolucao + ", multa=" + multa + ", valor=" + valor + ", situacao=" + situacao + ", usuario=" + usuario + ", cliente=" + cliente + ", caixa=" + caixa + ", itens=" + itens + '}';
    }

}

package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "venda")
@NamedQueries({
        @NamedQuery(name = "Venda.todos", query = "SELECT v FROM Venda v "),
        @NamedQuery(name = "Venda.pendente", query = "SELECT venda FROM Venda venda WHERE venda.caixa IS NULL "),
        @NamedQuery(name = "Venda.finalizado", query = "SELECT ve FROM Venda ve WHERE ve.caixa IS NOT NULL"),
        @NamedQuery(name = "Venda.usuario", query = "SELECT venda FROM Venda venda WHERE venda.usuario = :usuario")
})
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_venda")
    private int codigo;

    @Column(name = "valor_total", nullable = false)
    private double valorTotal;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_operacao", nullable = false)
    private Date dataOperacao;

    @ManyToOne
    @JoinColumn(name = "caixa_data", referencedColumnName = "caixa_data")
    private Caixa caixa;

    @ManyToOne
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "cod_cliente", referencedColumnName = "cod_cliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "venda")
    List<ItemVenda> itens = new ArrayList<>();

    public Venda() {
    }

    public Venda(int codigo, double valorTotal, Date dataOperacao, Caixa caixa, Usuario usuario, Cliente cliente) {
        this.codigo = codigo;
        this.valorTotal = valorTotal;
        this.dataOperacao = dataOperacao;
        this.caixa = caixa;
        this.usuario = usuario;
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void adicionarItem(ItemVenda item) {

        item.setVenda(this);
        itens.add(item);

    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    // métodos GET para relatorios
    public String getStringValorTotal() {

        NumberFormat formatar = NumberFormat.getCurrencyInstance();

        String vt = formatar.format(this.valorTotal);

        return vt;

    }

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

    public String getStringDataOperacao() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String operacao = sdf.format(this.dataOperacao);

        return operacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.codigo;
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
        final Venda other = (Venda) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", valorTotal=" + valorTotal + ", dataOperacao=" + dataOperacao + ", caixa=" + caixa + ", usuario=" + usuario + ", cliente=" + cliente + ", itens=" + itens + '}';
    }

}

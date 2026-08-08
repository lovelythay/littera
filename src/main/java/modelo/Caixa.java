package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Caixa.aberto", query = "SELECT c FROM Caixa c WHERE c.situacao = false"),
        @NamedQuery(name = "Caixa.fechado", query = "SELECT cx FROM Caixa cx WHERE cx.situacao = true"),
        @NamedQuery(name = "Caixa.todos", query = "Select cc FROM Caixa cc"),
        @NamedQuery(name = "Caixa.verificarData", query = "SELECT caixa FROM Caixa caixa WHERE caixa.data = :data and caixa.horarioFechamento is not null"),
        @NamedQuery(name = "Caixa.usuario", query = "SELECT caixa FROM Caixa caixa WHERE caixa.usuario = :usuario")
})
@Table(name = "caixa")
public class Caixa implements Serializable {

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "caixa_data")
    private Date data;

    @Temporal(TemporalType.TIME)
    @Column(name = "horario_abertura", nullable = false)
    private Date horarioAbertura;

    @Temporal(TemporalType.TIME)
    @Column(name = "horario_fechamento")
    private Date horarioFechamento;

    @Column(name = "valor_abertura", nullable = false)
    private double valorAbertura;

    @Column(name = "total_entrada")
    private double totalEntrada;

    @Column(name = "total_saida")
    private double totalSaida;

    @Column(name = "saldo")
    private double saldo;

    @Column(name = "situacao")
    private boolean situacao;

    @ManyToOne
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "caixa")
    private final List<Movimentacao> movimentacoes = new ArrayList<>();

    public Caixa() {
    }

    public Caixa(Date data, Date horarioAbertura, Date horarioFechamento, double valorAbertura, double totalEntrada, double totalSaida, double saldo, boolean situacao, Usuario usuario) {
        this.data = data;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
        this.valorAbertura = valorAbertura;
        this.totalEntrada = totalEntrada;
        this.totalSaida = totalSaida;
        this.saldo = saldo;
        this.situacao = situacao;
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public Date getHorarioAbertura() {
        return horarioAbertura;
    }

    public Date getHorarioFechamento() {
        return horarioFechamento;
    }

    public double getValorAbertura() {
        return valorAbertura;
    }

    public double getTotalEntrada() {
        return totalEntrada;
    }

    public double getTotalSaida() {
        return totalSaida;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    // métodos GET para os relatórios

    public String getStringData() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String data = sdf.format(this.data);

        return data;
    }


    public String getStringAbertura() {

        SimpleDateFormat h = new SimpleDateFormat("HH:mm");

        String ab = h.format(horarioAbertura);

        return ab;
    }

    public String getStringFechamento() {

        SimpleDateFormat h = new SimpleDateFormat("HH:mm");

        String ab = h.format(horarioFechamento);

        return ab;
    }


    public String getStringValorAbertura() {

        NumberFormat formatar = NumberFormat.getCurrencyInstance();

        String valor = formatar.format(this.valorAbertura);

        return valor;
    }

    public String getStringEntrada() {

        NumberFormat formatar = NumberFormat.getCurrencyInstance();

        String entrada = formatar.format(this.totalEntrada);

        return entrada;
    }

    public String getStringSaida() {

        NumberFormat formatar = NumberFormat.getCurrencyInstance();

        String saida = formatar.format(this.totalSaida);

        return saida;
    }

    public String getStringSaldo() {

        NumberFormat formatar = NumberFormat.getCurrencyInstance();

        String saldo = formatar.format(this.saldo);

        return saldo;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setHorarioAbertura(Date horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public void setHorarioFechamento(Date horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public void setValorAbertura(double valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public void setTotalEntrada(double totalEntrada) {
        this.totalEntrada = totalEntrada;
    }

    public void setTotalSaida(double totalSaida) {
        this.totalSaida = totalSaida;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void adicionarItem(Movimentacao mov) {

        mov.setCaixa(this);
        movimentacoes.add(mov);

    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.data);
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
        final Caixa other = (Caixa) obj;
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return "Caixa{" + "data=" + data + ", horarioAbertura=" + horarioAbertura + ", horarioFechamento=" + horarioFechamento + ", valorAbertura=" + valorAbertura + ", totalEntrada=" + totalEntrada + ", totalSaida=" + totalSaida + ", saldo=" + saldo + ",  usuario=" + usuario + ", movimentacoes=" + movimentacoes + '}';
    }

}

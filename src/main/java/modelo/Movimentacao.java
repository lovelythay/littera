package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;

@Entity
@NamedQueries({
        @NamedQuery(name = "Movimentacao.fechados", query = "SELECT me FROM Movimentacao me WHERE me.caixa.data BETWEEN :inicial AND :final"),
        @NamedQuery(name = "Movimentacao.diario", query = "SELECT m FROM Movimentacao m WHERE m.caixa = :caixaa ORDER BY m.caixa.data"),
        @NamedQuery(name = "Movimentacao.relatorio", query = "SELECT mv FROM Movimentacao mv WHERE mv.caixa.horarioFechamento is not null ORDER BY mv.caixa.data")
})
@Table(name = "movimentacao")
public class Movimentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_movimentacao")
    private int codigo;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Column(name = "motivo", length = 200, nullable = false)
    private String motivo;

    @Column(name = "tipo", length = 1, nullable = false)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "caixa_data", referencedColumnName = "caixa_data")
    private Caixa caixa;

    public Movimentacao() {
    }

    public Movimentacao(int codigo, double valor, String motivo, String tipo, Caixa caixa) {
        this.codigo = codigo;
        this.valor = valor;
        this.motivo = motivo;
        this.tipo = tipo;
        this.caixa = caixa;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getTipo() {
        return tipo;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    // métodos GET para os relatórios
    public String getStringValor() {

        NumberFormat formatar = NumberFormat.getCurrencyInstance();

        String valor = formatar.format(this.valor);

        return valor;
    }

    public String getStringTipo() {

        String tipoString;

        if (this.tipo.equals("S")) {

            tipoString = "Saída";

        } else {

            tipoString = "Entrada";
        }

        return tipoString;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.codigo;
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
        final Movimentacao other = (Movimentacao) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Movimentacao{" + "codigo=" + codigo + ", valor=" + valor + ", motivo=" + motivo + ", tipo=" + tipo + ", caixa=" + caixa.getStringData() + '}';
    }

}

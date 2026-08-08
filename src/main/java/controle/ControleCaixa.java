package controle;

import modelo.Caixa;
import modelo.Movimentacao;
import modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class ControleCaixa {

    private static Caixa caixaAberto = null;

    public void abrir(Caixa c) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(c);

        gerente.getTransaction().commit();

        gerente.close();

    }

    public Caixa fechar(Caixa c) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        Caixa caixaAtualizado = gerente.merge(c);

        gerente.getTransaction().commit();

        caixaAberto = null;

        gerente.close();

        return caixaAtualizado;
    }

    public List<Caixa> getTodos() {
        EntityManager gerente = GerenciadorConexao.getGerente();
        TypedQuery<Caixa> consulta
                = gerente.createNamedQuery("Caixa.todos", Caixa.class);
        return consulta.getResultList();

    }

    public List<Caixa> getFechados() {
        EntityManager gerente = GerenciadorConexao.getGerente();
        TypedQuery<Caixa> consulta
                = gerente.createNamedQuery("Caixa.fechado", Caixa.class);
        return consulta.getResultList();

    }

    public List<Movimentacao> getRelatorio() {
        EntityManager gerente = GerenciadorConexao.getGerente();
        TypedQuery<Movimentacao> consulta
                = gerente.createNamedQuery("Movimentacao.relatorio", Movimentacao.class);
        return consulta.getResultList();

    }

    public List<Movimentacao> getDiario(Caixa caixa) {

        EntityManager gerente = GerenciadorConexao.getGerente();
        TypedQuery<Movimentacao> consulta
                = gerente.createNamedQuery("Movimentacao.diario", Movimentacao.class);

        consulta.setParameter("caixaa", caixa);

        return consulta.getResultList();
    }

    public List<Movimentacao> getData(Date inicio, Date fim) {

        EntityManager gerente = GerenciadorConexao.getGerente();
        TypedQuery<Movimentacao> consulta
                = gerente.createNamedQuery("Movimentacao.fechados", Movimentacao.class);

        consulta.setParameter("inicial", inicio);
        consulta.setParameter("final", fim);

        return consulta.getResultList();

    }

    public boolean isCaixaHoje(Date hoje) {

        EntityManager gerente = GerenciadorConexao.getGerente();
        TypedQuery<Caixa> consulta = gerente.createNamedQuery("Caixa.verificarData", Caixa.class);

        consulta.setParameter("data", hoje);

        return consulta.getResultList().isEmpty();
    }

    public boolean isUsuarioEmCaixa(Usuario u) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Caixa> consulta = gerente.createNamedQuery("Caixa.usuario", Caixa.class);
        consulta.setParameter("usuario", u);

        return !consulta.getResultList().isEmpty();
    }

    private static Caixa verificarCaixaAbertoBanco() {
        List<Caixa> caixas;

        EntityManager gerente = GerenciadorConexao.getGerente();
        TypedQuery<Caixa> consulta
                = gerente.createNamedQuery("Caixa.aberto", Caixa.class);

        caixas = consulta.getResultList();

        if (caixas.isEmpty()) {
            return null;
        }

        return caixas.get(0);
    }

    public static boolean isCaixaAberto() {
        if (caixaAberto == null) {
            caixaAberto = verificarCaixaAbertoBanco();
        }
        return caixaAberto != null;
    }

    public static Caixa getCaixaAberto() {
        if (caixaAberto == null) {
            caixaAberto = verificarCaixaAbertoBanco();
        }
        return caixaAberto;
    }

}

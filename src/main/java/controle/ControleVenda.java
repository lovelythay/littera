package controle;

import modelo.Cliente;
import modelo.ItemVenda;
import modelo.Usuario;
import modelo.Venda;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ControleVenda {

    public List<Venda> pegarTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Venda> consulta = gerente.createNamedQuery("Venda.todos", Venda.class);

        return consulta.getResultList();

    }

    public List<Venda> pegarPendente() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Venda> consulta = gerente.createNamedQuery("Venda.pendente", Venda.class);

        return consulta.getResultList();
    }

    public List<Venda> pegarFinalizado() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Venda> consulta = gerente.createNamedQuery("Venda.finalizado", Venda.class);

        return consulta.getResultList();
    }

    public void persistir(Venda v) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(v);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void excluir(Venda v) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Venda excluir = gerente.find(Venda.class, v.getCodigo());

        gerente.getTransaction().begin();

        gerente.remove(excluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<ItemVenda> pegarCliente(Cliente c) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<ItemVenda> consulta = gerente.createNamedQuery("ItemVenda.cliente", ItemVenda.class);

        consulta.setParameter("clientee", c);

        return consulta.getResultList();

    }

    public boolean isUsuarioEmVenda(Usuario u) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Venda> consulta = gerente.createNamedQuery("Venda.usuario", Venda.class);
        consulta.setParameter("usuario", u);

        return !consulta.getResultList().isEmpty();
    }
}

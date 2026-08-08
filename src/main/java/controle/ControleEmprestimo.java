package controle;

import modelo.Cliente;
import modelo.Emprestimo;
import modelo.ItemEmprestimo;
import modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ControleEmprestimo {

    public List<Emprestimo> pegarTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Emprestimo> consulta = gerente.createNamedQuery("Emprestimo.todos", Emprestimo.class);

        return consulta.getResultList();

    }

    public List<Emprestimo> pegarPendente() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Emprestimo> consulta = gerente.createNamedQuery("Emprestimo.pendente", Emprestimo.class);

        return consulta.getResultList();
    }

    public List<Emprestimo> pegarFinalizado() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Emprestimo> consulta = gerente.createNamedQuery("Emprestimo.finalizado", Emprestimo.class);

        return consulta.getResultList();
    }

    public void persistir(Emprestimo e) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(e);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void excluir(Emprestimo e) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Emprestimo excluir = gerente.find(Emprestimo.class, e.getCodigo());

        gerente.getTransaction().begin();

        gerente.remove(excluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<ItemEmprestimo> pegarCliente(Cliente c) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<ItemEmprestimo> consulta = gerente.createNamedQuery("ItemEmprestimo.cliente", ItemEmprestimo.class);

        consulta.setParameter("clientee", c);

        return consulta.getResultList();

    }

    public boolean isUsuarioEmEmprestimo(Usuario u) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Emprestimo> consulta = gerente.createNamedQuery("Emprestimo.usuario", Emprestimo.class);
        consulta.setParameter("usuario", u);

        return !consulta.getResultList().isEmpty();
    }

}

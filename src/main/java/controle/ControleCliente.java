package controle;

import modelo.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ControleCliente {

    public List<Cliente> pegarTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Cliente> consulta = gerente.createNamedQuery("Cliente.todos", Cliente.class);

        return consulta.getResultList();

    }

    public void adicionar(Cliente c) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(c);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Cliente c) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(c);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void excluir(Cliente c) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Cliente excluir = gerente.find(Cliente.class, c.getCodigo());

        gerente.getTransaction().begin();

        gerente.remove(excluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Cliente> pegarNome(String nome) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Cliente> consulta = gerente.createNamedQuery("Cliente.porNome", Cliente.class);

        consulta.setParameter("nomequalquer", "%" + nome + "%");

        return consulta.getResultList();

    }
}

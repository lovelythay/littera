package controle;

import modelo.Genero;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ControleGenero {

    public List<Genero> pegarTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Genero> consulta = gerente.createNamedQuery("Genero.todos", Genero.class);

        return consulta.getResultList();

    }

    public void adicionar(Genero g) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(g);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Genero g) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(g);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void excluir(Genero g) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Genero excluir = gerente.find(Genero.class, g.getCodigo());

        gerente.getTransaction().begin();

        gerente.remove(excluir);

        gerente.getTransaction().commit();

        gerente.close();
    }


    public List<Genero> pegarNome(String nome) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Genero> consulta = gerente.createNamedQuery("Genero.porNome", Genero.class);

        consulta.setParameter("nomequalquer", "%" + nome + "%");

        return consulta.getResultList();

    }
}

package controle;

import modelo.Genero;
import modelo.ItemEmprestimo;
import modelo.ItemVenda;
import modelo.Livro;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ControleLivro {

    public List<Livro> pegarTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Livro> consulta = gerente.createNamedQuery("Livro.todos", Livro.class);

        return consulta.getResultList();

    }

    public void adicionar(Livro l) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(l);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Livro l) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(l);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void excluir(Livro l) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Livro excluir = gerente.find(Livro.class, l.getCodigo());

        gerente.getTransaction().begin();

        gerente.remove(excluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Livro> pegarNome(String nome) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Livro> consulta = gerente.createNamedQuery("Livro.porNome", Livro.class);

        consulta.setParameter("nomequalquer", "%" + nome + "%");

        return consulta.getResultList();

    }

    public List<Livro> pegarGenero(Genero g) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Livro> consulta = gerente.createNamedQuery("Livro.porGenero", Livro.class);

        consulta.setParameter("gen", g);

        return consulta.getResultList();

    }

    public List<Livro> pegarGeneroAtivo(Genero g) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Livro> consulta = gerente.createNamedQuery("Livro.porGeneroAtivo", Livro.class);

        consulta.setParameter("gen", g);

        return consulta.getResultList();

    }

    public List<Livro> pegarEstoque() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Livro> consulta = gerente.createNamedQuery("Livro.baixoEstoque", Livro.class);

        return consulta.getResultList();

    }

    public boolean verificarItemLivro(Livro livro) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<ItemVenda> consultaItemVenda = gerente.createNamedQuery("ItemVenda.livro", ItemVenda.class);
        consultaItemVenda.setParameter("livro", livro);

        TypedQuery<ItemEmprestimo> consultaItemEmprestimo = gerente.createNamedQuery("ItemEmprestimo.livro", ItemEmprestimo.class);
        consultaItemEmprestimo.setParameter("livro", livro);

        return !consultaItemVenda.getResultList().isEmpty() || !consultaItemEmprestimo.getResultList().isEmpty();
    }
}

package controle;

import modelo.Historico;
import modelo.Livro;
import modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ControleHistorico {

    public List<Historico> pegarLivro(Livro livro) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Historico> consulta = gerente.createNamedQuery("Historico.livro", Historico.class);

        consulta.setParameter("livro", livro);

        return consulta.getResultList();

    }


    public boolean isUsuarioEmHistorico(Usuario usuario) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Historico> consulta = gerente.createNamedQuery("Historico.usuario", Historico.class);
        consulta.setParameter("usuario", usuario);

        return !consulta.getResultList().isEmpty();

    }

    public void adicionar(Historico h) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(h);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void excluir(Historico h) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Historico excluir = gerente.find(Historico.class, h.getCodigo());

        gerente.getTransaction().begin();

        gerente.remove(excluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

}

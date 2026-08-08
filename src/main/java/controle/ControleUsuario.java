package controle;

import modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ControleUsuario {

    private static Usuario usuarioLogado = null;

    public List<Usuario> pegarTodos() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Usuario> consulta = gerente.createNamedQuery("Usuario.todos", Usuario.class);

        return consulta.getResultList();

    }

    public void adicionar(Usuario u) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.persist(u);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void alterar(Usuario u) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        gerente.getTransaction().begin();

        gerente.merge(u);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public void excluir(Usuario u) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        Usuario excluir = gerente.find(Usuario.class, u.getCodigo());

        gerente.getTransaction().begin();

        gerente.remove(excluir);

        gerente.getTransaction().commit();

        gerente.close();
    }

    public List<Usuario> pegarNome(String nome) {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Usuario> consulta = gerente.createNamedQuery("Usuario.porNome", Usuario.class);

        consulta.setParameter("nomequalquer", "%" + nome + "%");

        return consulta.getResultList();

    }

    public static Usuario login(String login, String senha) throws UsuarioOuSenhaIncorretaException {
        List<Usuario> usuarios;

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Usuario> consulta
                = gerente.createNamedQuery("Usuario.login", Usuario.class);

        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);

        usuarios = consulta.getResultList();
        if (usuarios.isEmpty()) {
            throw new UsuarioOuSenhaIncorretaException("O usuario ou senha digitada está incorreta.");
        } else {
            ControleUsuario.usuarioLogado = usuarios.get(0);
        }

        return usuarios.get(0);
    }

    public static void logout() {
        ControleUsuario.usuarioLogado = null;
    }

    public static boolean isUsuarioLogado() {
        return usuarioLogado != null;
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public boolean isPrimeiroLogin() {

        EntityManager gerente = GerenciadorConexao.getGerente();

        TypedQuery<Long> consulta = gerente.createNamedQuery("Usuario.quantidadeUsuarios", Long.class);
        Long total = consulta.getSingleResult();

        return total == 0;
    }
}

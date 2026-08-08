package controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GerenciadorConexao {

    private static EntityManagerFactory emf;

    public static EntityManagerFactory getFabrica() {

        if (emf == null) {
            Properties dbProps = carregarPropriedadesBanco();

            Map<String, String> overrides = new HashMap<>();
            overrides.put("javax.persistence.jdbc.url", dbProps.getProperty("db.url"));
            overrides.put("javax.persistence.jdbc.user", dbProps.getProperty("db.user"));
            overrides.put("javax.persistence.jdbc.password", dbProps.getProperty("db.password"));

            emf = Persistence.createEntityManagerFactory("LitteraPU", overrides);
        }

        return emf;
    }

    public static EntityManager getGerente() {
        return getFabrica().createEntityManager();
    }

    private static Properties carregarPropriedadesBanco() {
        Properties props = new Properties();
        try (InputStream input = GerenciadorConexao.class.getClassLoader()
                .getResourceAsStream("db.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "db.properties não encontrado no classpath. Copie db.properties.example, renomeie para db.properties e coloque no default package (dentro de src)."
                );
            }
            props.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar db.properties", e);
        }
        return props;
    }
}

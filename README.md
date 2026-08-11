# Littera

Sistema desktop para gerenciamento de um sebo, desenvolvido em <b>Java 17</b>.

📋<b>Sobre o projeto</b>

O Littera foi desenvolvido com o objetivo de centralizar e facilitar o gerenciamento das principais operações de um sebo.
O sistema permite controlar o estoque de livros, registrar vendas e empréstimos, gerenciar clientes e usuários, acompanhar o fluxo de caixa e emitir relatórios sobre as informações cadastradas e movimentações realizadas.

O projeto utiliza *Java Swing* para a interface gráfica e *JPA/Hibernate* para a persistência dos dados em um banco de dados *MySQL*.

🚀<b>Principais Funcionalidades</b>

- Controle de acesso por perfil, diferenciando usuários administradores e vendedores
- Controle de estoque, incluindo identificação de livros com baixo estoque
- Gerenciamento do fluxo de caixa, permitindo acompanhar as movimentações financeiras do sebo
- Registro e gerenciamento de vendas, com atualização das informações relacionadas ao estoque e ao caixa
- Gerenciamento de empréstimos de livros, mantendo o histórico de empréstimos realizados pelos clientes
- Geração de relatórios gerenciais utilizando JasperReports
- Relatórios de estoque e acervo, incluindo livros cadastrados, livros com baixo estoque e livros organizados por gênero.
- Histórico de compras dos clientes
- Histórico de empréstimos dos clientes
- Relatórios financeiros, incluindo histórico de caixa e relatório de caixa diário

🛠️<b>Tecnologias utilizadas</b>

- Java 17
- JDK 17
- Java Swing
- JPA
- Hibernate
- MySQL
- JasperReports

🏗️<b>Estrutura do projeto</b>

O projeto está organizado em três principais pacotes dentro de `src/main/java`:
``` text
src 
└── main 
    └── java 
           ├── modelo 
           ├── controle 
           └── visao
```

`modelo`

Contém as classes responsáveis pela representação dos dados e entidades do sistema.

É nessa camada que estão as entidades utilizadas pelo JPA/Hibernate, responsáveis pelo mapeamento dos objetos Java para as tabelas do banco de dados MySQL.

`controle`

Contém as classes responsáveis pelo controle e execução das operações do sistema, concentrando regras e ações relacionadas às funcionalidades da aplicação.

`visao`

Contém as interfaces gráficas desenvolvidas com Java Swing, responsáveis pela interação entre o usuário e o sistema.

⚙️<b>Como executar</b>

*Pré requisitos*

Para executar o Littera, é necessário ter instalado:

- JDK 17
- MySQL 8
- IDE para desenvolvimento JAVA
- Git

*1. Clone o repositório:*

``` text
git clone https://github.com/lovelythay/littera.git
cd littera
```

*2. Configuração do banco de dados*

O Littera utiliza MySQL para persistência dos dados.
As configurações de conexão são armazenadas no arquivo `db.properties`, que não é versionado no Git por conter as credenciais do banco.

O projeto disponibiliza o arquivo `db.properties.example` como modelo.

*Para configurar:*

Copie o arquivo de exemplo e renomeie para `db.properties`
``` text
cp src/main/resources/db.properties.example src/main/resources/db.properties
```

Edite o `db.properties` com as suas credenciais locais do MySQL.

O banco de dados littera é criado automaticamente caso não exista. As tabelas são gerenciadas pelo <b>JPA/Hibernate</b>.

*3. Executar a aplicação*

*Opção 1 - Pela IDE*

Importe o projeto como um projeto Maven na sua IDE (IntelliJ IDEA, Eclipse, etc.) e execute a classe principal `visao.TelaLogin` (a que contém o método main).

*Opção 2 - Via Maven*

`mvn compile exec:java`

⚠️ Requer o Maven instalado e configurado no PATH do sistema.

🖥️ <b>Demonstração da aplicação</b>

Abaixo estão algumas das principais telas do Littera.

- Tela de Login
<p align="center">
 <img width="417" height="417" alt="image" src="https://github.com/user-attachments/assets/d7a3fe2a-a9c6-489f-8715-3824997ef0b8" /> 
</p>

- Tela Principal

<img width="1918" height="992" alt="image" src="https://github.com/user-attachments/assets/566697c7-a304-4874-b9f3-802718ab9f5b" />

- Gerenciamento de Livros

<p align="center">
  <img width="437" height="356" alt="image" src="https://github.com/user-attachments/assets/19ea905c-440a-4be8-a3e4-18abdaf97fef" />
</p>

- Gerenciamento de Clientes

<p align="center">
 <img width="437" height="356" alt="image" src="https://github.com/user-attachments/assets/d1328e2b-c463-4a31-adbd-752e5eadbc63" /> 
</p>

- Fluxo de Caixa

<img width="1410" height="761" alt="image" src="https://github.com/user-attachments/assets/739f3a70-60cb-4fe0-ba46-266b25838aea" />

- Empréstimos

<img width="1291" height="745" alt="image" src="https://github.com/user-attachments/assets/e2a3d353-d6f9-4dd3-bd51-7ebfb26f0876" />

- Vendas

<img width="1242" height="623" alt="image" src="https://github.com/user-attachments/assets/a3151e92-73cb-418d-837a-d38df1f18f15" />

📌<b>Considerações Finais</b>

O Littera foi desenvolvido para praticar conceitos de desenvolvimento back-end, persistência de dados com JPA/Hibernate e organização de projeto com Maven.

👤<b>Autor</b>

Desenvolvido por Thaynara Alves.

[LinkedIn](www.linkedin.com/in/thaynaralves) • [Email](thaynaraalves.22k@gmail.com)

📄<b>Licença</b>

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

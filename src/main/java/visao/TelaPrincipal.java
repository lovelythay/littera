package visao;

import controle.ControleCaixa;
import controle.ControleCliente;
import controle.ControleGenero;
import controle.ControleLivro;
import modelo.Caixa;
import modelo.Cliente;
import modelo.Genero;
import modelo.Livro;

import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TelaPrincipal extends javax.swing.JFrame {

    private final ControleLivro controleLivro = new ControleLivro();
    private final ControleCliente controleCliente = new ControleCliente();
    private final ControleGenero controleGenero = new ControleGenero();
    private final ControleCaixa controleCaixa = new ControleCaixa();

    private final List<Livro> listaLivro = new ArrayList<>();
    private final List<Cliente> listaCliente = new ArrayList<>();

    private boolean existe = true;

    public TelaPrincipal() {
        initComponents();

        setLocationRelativeTo(null);

        this.setExtendedState(MAXIMIZED_BOTH);

        URL url = this.getClass().getResource("/imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        botCaixa = new javax.swing.JButton();
        botVenda = new javax.swing.JButton();
        botEmprestimo = new javax.swing.JButton();
        botCliente = new javax.swing.JButton();
        botGenero = new javax.swing.JButton();
        botLivro = new javax.swing.JButton();
        botUsuario = new javax.swing.JButton();
        botSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LITTERA");

        jPanel1.setBackground(new java.awt.Color(249, 249, 252));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 0, 36)); // NOI18N
        jLabel1.setText("Littera");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addGap(8, 8, 8))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        botCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dinheiro.png"))); // NOI18N
        botCaixa.setText("Caixa");
        botCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCaixaActionPerformed(evt);
            }
        });
        jPanel3.add(botCaixa);

        botVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/venda.png"))); // NOI18N
        botVenda.setText("Vendas");
        botVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVendaActionPerformed(evt);
            }
        });
        jPanel3.add(botVenda);

        botEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/calendario.png"))); // NOI18N
        botEmprestimo.setText("Empréstimos");
        botEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEmprestimoActionPerformed(evt);
            }
        });
        jPanel3.add(botEmprestimo);

        botCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cliente.png"))); // NOI18N
        botCliente.setText("Clientes");
        botCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botClienteActionPerformed(evt);
            }
        });
        jPanel3.add(botCliente);

        botGenero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/genero.png"))); // NOI18N
        botGenero.setText("Gêneros");
        botGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botGeneroActionPerformed(evt);
            }
        });
        jPanel3.add(botGenero);

        botLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/livro.png"))); // NOI18N
        botLivro.setText("Livros");
        botLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botLivroActionPerformed(evt);
            }
        });
        jPanel3.add(botLivro);

        botUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuario.png"))); // NOI18N
        botUsuario.setText("Usuários");
        botUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botUsuarioActionPerformed(evt);
            }
        });
        jPanel3.add(botUsuario);

        botSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.png"))); // NOI18N
        botSair.setText("Sair");
        botSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSairActionPerformed(evt);
            }
        });
        jPanel3.add(botSair);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botSairActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private boolean isGeneroCadastrado() {

        List<Genero> listaGenero = controleGenero.pegarTodos();

        if (listaGenero.isEmpty()) {

            JOptionPane.showMessageDialog(this, "É necessário que ao menos um gênero esteja cadastrado para poder inserir livros ao sistema");

            TelaGenero tela = new TelaGenero(this, true);

            tela.setVisible(true);
            this.existe = false;
        }

        return this.existe;
    }

    private void botLivroActionPerformed(java.awt.event.ActionEvent evt) {

        if (isGeneroCadastrado()) {
            TelaLivro tela = new TelaLivro(this, true);

            tela.setVisible(true);
        }

    }

    private void botGeneroActionPerformed(java.awt.event.ActionEvent evt) {
        TelaGenero tela = new TelaGenero(this, true);

        tela.setVisible(true);
    }

    private void botUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        TelaUsuario tela = new TelaUsuario(this, true);

        tela.setVisible(true);
    }

    private void botClienteActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCliente tela = new TelaCliente(this, true);

        tela.setVisible(true);
    }

    private void botVendaActionPerformed(java.awt.event.ActionEvent evt) {

        Caixa caixa = ControleCaixa.getCaixaAberto();

        if (caixa != null) {

            this.listaLivro.clear();

            this.listaLivro.addAll(controleLivro.pegarTodos());

            if (!this.listaLivro.isEmpty()) {

                TelaVenda tela = new TelaVenda(this, true);

                tela.setVisible(true);
            } else {

                JOptionPane.showMessageDialog(this, "É necessário que ao menos um livro esteja cadastrado!");

                if (isGeneroCadastrado()) {
                    TelaLivro tela = new TelaLivro(this, true);

                    tela.setVisible(true);
                }

            }
        } else {

            JOptionPane.showMessageDialog(this, "Para realizar uma venda é necessário que o caixa esteja aberto!");
        }

    }

    private void botEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {

        Caixa caixa = ControleCaixa.getCaixaAberto();

        if (caixa != null) {
            this.listaLivro.clear();
            this.listaCliente.clear();

            this.listaLivro.addAll(controleLivro.pegarTodos());
            this.listaCliente.addAll(controleCliente.pegarTodos());

            if (!this.listaLivro.isEmpty() && !this.listaCliente.isEmpty()) {

                TelaEmprestimo tela = new TelaEmprestimo(this, true);

                tela.setVisible(true);
            } else {

                if (this.listaCliente.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "É necessário que ao menos um cliente esteja cadastrado!");

                    TelaCliente tela = new TelaCliente(this, true);

                    tela.setVisible(true);

                } else if (this.listaLivro.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "É necessário que ao menos um livro esteja cadastrado!");

                    if (isGeneroCadastrado()) {
                        TelaLivro tela = new TelaLivro(this, true);

                        tela.setVisible(true);
                    }

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Para realizar um empréstimo é necessário que o caixa esteja aberto!");
        }
    }

    private void botCaixaActionPerformed(java.awt.event.ActionEvent evt) {

        Date hoje = new Date();

        boolean caixaDiario = controleCaixa.isCaixaHoje(hoje);

        if (caixaDiario) {
            if (ControleCaixa.isCaixaAberto()) {
                TelaCaixa tela = new TelaCaixa(this, true);
                tela.setVisible(true);

            } else {

                DadosCaixa tela = new DadosCaixa(this, true);
                tela.setVisible(true);
            }
        } else {

            JOptionPane.showMessageDialog(this, "O caixa diário já foi fechado!");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botCaixa;
    private javax.swing.JButton botCliente;
    private javax.swing.JButton botEmprestimo;
    private javax.swing.JButton botGenero;
    private javax.swing.JButton botLivro;
    private javax.swing.JButton botSair;
    private javax.swing.JButton botUsuario;
    private javax.swing.JButton botVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}

package visao;

import controle.*;
import modelo.Usuario;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TelaUsuario extends javax.swing.JDialog {

    private final List<Usuario> listaUsuario = new ArrayList<>();
    private final ControleUsuario controle = new ControleUsuario();

    public TelaUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);

        tabUsuario.getColumnModel().getColumn(0).setPreferredWidth(210);
        tabUsuario.getColumnModel().getColumn(1).setPreferredWidth(240);
        tabUsuario.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabUsuario.getColumnModel().getColumn(3).setPreferredWidth(150);

        atualizarTabela();

        URL url = this.getClass().getResource("/imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabUsuario = new javax.swing.JTable();
        botCadastrar = new javax.swing.JButton();
        botExcluir = new javax.swing.JButton();
        botVer = new javax.swing.JButton();
        botAlterar = new javax.swing.JButton();
        botSair = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        botPesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LITTERA - Gerenciar Usuários");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 0, 36)); // NOI18N
        jLabel1.setText("Usuários");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabUsuario.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "CPF", "Nome", "Telefone", "Nível"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabUsuario);

        botCadastrar.setBackground(new java.awt.Color(225, 225, 245));
        botCadastrar.setText("CADASTRAR");
        botCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCadastrarActionPerformed(evt);
            }
        });

        botExcluir.setBackground(new java.awt.Color(225, 225, 245));
        botExcluir.setText("EXCLUIR");
        botExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botExcluirActionPerformed(evt);
            }
        });

        botVer.setBackground(new java.awt.Color(225, 225, 245));
        botVer.setText("VER");
        botVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVerActionPerformed(evt);
            }
        });

        botAlterar.setBackground(new java.awt.Color(225, 225, 245));
        botAlterar.setText("ALTERAR");
        botAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAlterarActionPerformed(evt);
            }
        });

        botSair.setBackground(new java.awt.Color(225, 225, 245));
        botSair.setText("VOLTAR");
        botSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSairActionPerformed(evt);
            }
        });

        txtPesquisar.setBackground(new java.awt.Color(235, 235, 255));
        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyTyped(evt);
            }
        });

        botPesquisar.setBackground(new java.awt.Color(225, 225, 245));
        botPesquisar.setText("PESQUISAR");
        botPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botPesquisarActionPerformed(evt);
            }
        });

        jLabel3.setText("Usuário : ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(botCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botVer, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botSair, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(botPesquisar)))
                                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botPesquisar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(botAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botVer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tabUsuario.getModel();

        modelo.setRowCount(0);

        listaUsuario.clear();
        listaUsuario.addAll(controle.pegarNome(txtPesquisar.getText()));

        for (Usuario u : listaUsuario) {

            if (u.getTipo().equals("V")) {
                modelo.addRow(new Object[]{u.getCpf(), u.getNome(), u.getTelefone(), "Vendedor"
                });
            } else {
                modelo.addRow(new Object[]{u.getCpf(), u.getNome(), u.getTelefone(), "Administrador"
                });
            }

        }
    }

    private void botVerActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabUsuario.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um usuário para visualizar.");
        } else {

            DadosUsuario tela = new DadosUsuario(null, true);

            tela.setUsuario(listaUsuario.get(linha));
            tela.desabilitar();
            tela.setVisible(true);
        }

    }

    private void botSairActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void botAlterarActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabUsuario.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um usuário para alterar.");
        } else {

            DadosUsuario tela = new DadosUsuario(null, true);

            tela.setUsuario(listaUsuario.get(linha));
            tela.setVisible(true);

            if (tela.isConfirmacao()) {

                Usuario u = tela.getUsuario();
                controle.alterar(u);

                atualizarTabela();
            }

        }


    }

    private void botCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        DadosUsuario tela = new DadosUsuario(null, true);

        tela.setVisible(true);

        if (tela.isConfirmacao()) {

            Usuario u = tela.getUsuario();
            controle.adicionar(u);

            atualizarTabela();
        }
    }

    private void botExcluirActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabUsuario.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um usuário para excluir.");
        } else {

            int resposta = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir esse usuário?", "Excluir Usuário", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_NO_OPTION) {

                Usuario u = listaUsuario.get(linha);

                if (u.equals(ControleUsuario.getUsuarioLogado())) {
                    JOptionPane.showMessageDialog(null, "Usuário logado no momento, não é possível exclui-lo.");
                } else {

                    ControleEmprestimo controleEmprestimo = new ControleEmprestimo();
                    ControleVenda controleVenda = new ControleVenda();
                    ControleCaixa controleCaixa = new ControleCaixa();
                    ControleHistorico controleHistorico = new ControleHistorico();

                    if (controleVenda.isUsuarioEmVenda(u) || controleEmprestimo.isUsuarioEmEmprestimo(u) || controleCaixa.isUsuarioEmCaixa(u) || controleHistorico.isUsuarioEmHistorico(u)) {

                        u.setAtivo(false);
                        controle.alterar(u);
                        atualizarTabela();
                    } else {

                        controle.excluir(u);
                    }

                    JOptionPane.showMessageDialog(null, "Operação finalizada.");
                    atualizarTabela();
                }
            }
        }
    }

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void botPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        atualizarTabela();
    }

    private void txtPesquisarKeyTyped(java.awt.event.KeyEvent evt) {
        atualizarTabela();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAlterar;
    private javax.swing.JButton botCadastrar;
    private javax.swing.JButton botExcluir;
    private javax.swing.JButton botPesquisar;
    private javax.swing.JButton botSair;
    private javax.swing.JButton botVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabUsuario;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}

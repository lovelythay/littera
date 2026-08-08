package visao;

import controle.ControleHistorico;
import controle.ControleLivro;
import controle.ControleUsuario;
import modelo.Historico;
import modelo.Livro;
import modelo.Usuario;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaLivro extends javax.swing.JDialog {

    private final List<Livro> listaLivros = new ArrayList<>();
    private final ControleLivro controle = new ControleLivro();

    private final ControleHistorico controleHistorico = new ControleHistorico();

    private final Date hoje = new Date();
    private final Usuario usuario = ControleUsuario.getUsuarioLogado();

    public TelaLivro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);

        tabLivros.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabLivros.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabLivros.getColumnModel().getColumn(2).setPreferredWidth(180);
        tabLivros.getColumnModel().getColumn(3).setPreferredWidth(150);

        atualizarTabela();

        URL url = this.getClass().getResource("/imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    private void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tabLivros.getModel();

        modelo.setRowCount(0);

        listaLivros.clear();
        listaLivros.addAll(controle.pegarNome(txtPesquisar.getText()));

        for (Livro l : listaLivros) {

            String disp;

            if (l.getQuantidadeDisponivel() != 0) {

                disp = "Disponível";
            } else {

                disp = "Indisponível";
            }

            switch (l.getTipo()) {
                case "A" -> modelo.addRow(new Object[]{l.getPrateleira(), l.getNome(), "Venda/Empréstimo", disp
                });
                case "E" -> modelo.addRow(new Object[]{l.getPrateleira(), l.getNome(), "Empréstimo", disp
                });
                default -> modelo.addRow(new Object[]{l.getPrateleira(), l.getNome(), "Venda", disp
                });

            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabLivros = new javax.swing.JTable();
        botCadastrar = new javax.swing.JButton();
        botExcluir = new javax.swing.JButton();
        botVer = new javax.swing.JButton();
        botAlterar = new javax.swing.JButton();
        botSair = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        botPesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botHist = new javax.swing.JButton();
        botDisponivel = new javax.swing.JButton();
        botIndisponivel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LITTERA - Gerenciar Livros");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 0, 36)); // NOI18N
        jLabel1.setText("Livros");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/livro.png"))); // NOI18N

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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabLivros.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Prateleira", "Nome", "Tipo", "Disponibilidade"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabLivros);

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

        jLabel3.setText("Livro : ");

        botHist.setBackground(new java.awt.Color(225, 225, 245));
        botHist.setText("HISTÓRICO");
        botHist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botHistActionPerformed(evt);
            }
        });

        botDisponivel.setBackground(new java.awt.Color(225, 225, 245));
        botDisponivel.setText("CADASTRADOS");
        botDisponivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botDisponivelActionPerformed(evt);
            }
        });

        botIndisponivel.setBackground(new java.awt.Color(225, 225, 245));
        botIndisponivel.setText("BAIXO ESTOQUE");
        botIndisponivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIndisponivelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(jLabel3)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(botPesquisar)))
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(botCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botHist, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botVer, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botSair, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(botDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botIndisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(41, Short.MAX_VALUE))
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
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(botAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botHist, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botVer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botDisponivel)
                                        .addComponent(botIndisponivel))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botVerActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabLivros.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um livro para visualizar.");
        } else {

            DadosLivro tela = new DadosLivro(null, true);

            tela.setLivro(listaLivros.get(linha));
            tela.desabilitar();

            tela.setVisible(true);

        }


    }

    private void botSairActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void botCadastrarActionPerformed(java.awt.event.ActionEvent evt) {

        DadosLivro tela = new DadosLivro(null, true);

        tela.setVisible(true);

        if (tela.isConfirmacao()) {

            Livro l = tela.getLivro();

            controle.adicionar(l);

            Historico historico = new Historico();

            historico.setCodigo(0);
            historico.setLivro(l);
            historico.setDataAtualizacao(this.hoje);
            historico.setQuantidade(l.getQuantidade());
            historico.setDescricao("Cadastro do livro ao sistema");
            historico.setUsuario(this.usuario);

            controleHistorico.adicionar(historico);

            atualizarTabela();
        }


    }

    private void botAlterarActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabLivros.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um livro para alterar.");
        } else {

            DadosLivro tela = new DadosLivro(null, true);

            tela.setLivro(listaLivros.get(linha));

            int quantidade = (listaLivros.get(linha)).getQuantidade();

            tela.setVisible(true);

            if (tela.isConfirmacao()) {

                Livro l = tela.getLivro();

                controle.alterar(l);

                if (l.getQuantidade() != quantidade) {

                    Historico historico = new Historico();

                    historico.setCodigo(0);
                    historico.setLivro(l);
                    historico.setDataAtualizacao(this.hoje);
                    historico.setQuantidade(l.getQuantidade());

                    String desc = "";

                    if (l.getQuantidade() > quantidade) {
                        desc = "Entrada - Alteração";
                    } else if (l.getQuantidade() < quantidade) {
                        desc = "Saída - Alteração";
                    }

                    historico.setDescricao(desc);
                    historico.setUsuario(this.usuario);

                    controleHistorico.adicionar(historico);

                }

                atualizarTabela();
            }
        }
    }

    private void botExcluirActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabLivros.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um livro para excluir.");
        } else {
            int resposta = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir esse livro?", "Excluir Livro", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_NO_OPTION) {

                Livro l = listaLivros.get(linha);

                if (controle.verificarItemLivro(l)) {

                    // exclusão lógica
                    l.setAtivo(false);
                    controle.alterar(l);

                } else {

                    List<Historico> historico = controleHistorico.pegarLivro(l);
                    controleHistorico.excluir(historico.get(0));

                    controle.excluir(l);

                }

                atualizarTabela();
                JOptionPane.showMessageDialog(null, "Operação finalizada.");
            }
        }
    }

    private void txtPesquisarKeyTyped(java.awt.event.KeyEvent evt) {

        atualizarTabela();
    }

    private void botPesquisarActionPerformed(java.awt.event.ActionEvent evt) {

        atualizarTabela();
    }

    private void botHistActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabLivros.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um livro para visualizar seu histórico.");
        } else {

            TelaHistorico tela = new TelaHistorico(null, true);

            tela.setLivro(listaLivros.get(linha));

            tela.setVisible(true);
        }
    }

    private void botDisponivelActionPerformed(java.awt.event.ActionEvent evt) {

        List<Livro> disponiveis = new ArrayList<>(controle.pegarTodos());

        if (!disponiveis.isEmpty()) {
            try {
                JasperReport relatorioCompilado
                        = JasperCompileManager.compileReport("src/main/java/relatorio/relatorioLivros.jrxml");

                JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null,
                        new JRBeanCollectionDataSource(disponiveis));

                JDialog tela = new JDialog(this, "Relatório de Livros", true);
                tela.setSize(1000, 800);

                JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);

                tela.getContentPane().add(painelRelatorio);

                tela.setLocationRelativeTo(null);
                tela.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Erro ao gerar o relatório.");
            }
        } else {

            JOptionPane.showMessageDialog(this, "Não há livros cadastrados.");
        }
    }

    private void botIndisponivelActionPerformed(java.awt.event.ActionEvent evt) {


        List<Livro> indisponiveis = new ArrayList<>(controle.pegarEstoque());

        if (!indisponiveis.isEmpty()) {
            try {
                JasperReport relatorioCompilado
                        = JasperCompileManager.compileReport("src/main/java/relatorio/relatorioBaixoEstoque.jrxml");

                JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null,
                        new JRBeanCollectionDataSource(indisponiveis));

                JDialog tela = new JDialog(this, "Relatório de Livros sem Estoque", true);
                tela.setSize(1000, 800);

                JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);

                tela.getContentPane().add(painelRelatorio);

                tela.setLocationRelativeTo(null);
                tela.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Erro ao gerar o relatório.");
            }
        } else {

            JOptionPane.showMessageDialog(this, "Não há livros com baixo estoque.");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAlterar;
    private javax.swing.JButton botCadastrar;
    private javax.swing.JButton botDisponivel;
    private javax.swing.JButton botExcluir;
    private javax.swing.JButton botHist;
    private javax.swing.JButton botIndisponivel;
    private javax.swing.JButton botPesquisar;
    private javax.swing.JButton botSair;
    private javax.swing.JButton botVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabLivros;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}

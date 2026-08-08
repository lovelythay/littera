package visao;

import controle.ControleGenero;
import controle.ControleLivro;
import controle.ControleUsuario;
import modelo.Genero;
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
import java.util.List;


public class TelaGenero extends JDialog {

    private final List<Genero> listaGenero = new ArrayList<>();

    private final ControleGenero controle = new ControleGenero();
    private final Usuario usuarioLogado = ControleUsuario.getUsuarioLogado();

    public TelaGenero(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);

        tabGenero.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabGenero.getColumnModel().getColumn(1).setPreferredWidth(350);

        atualizarTabela();

        URL url = this.getClass().getResource("/imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    private void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tabGenero.getModel();

        modelo.setRowCount(0);

        listaGenero.clear();
        listaGenero.addAll(controle.pegarNome(txtPesquisar.getText()));

        for (Genero g : listaGenero) {

            modelo.addRow(new Object[]{g.getCodigo(), g.getNome()
            });

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
        tabGenero = new javax.swing.JTable();
        botCadastrar = new javax.swing.JButton();
        botExcluir = new javax.swing.JButton();
        botVer = new javax.swing.JButton();
        botAlterar = new javax.swing.JButton();
        botSair = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        botPesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LITTERA - Gerenciar Gêneros");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 0, 36)); // NOI18N
        jLabel1.setText("Gêneros");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/genero.png"))); // NOI18N

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

        tabGenero.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String[]{
                        "Código", "Nome"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabGenero);

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

        jLabel3.setText("Gênero :");

        botRelatorio.setBackground(new java.awt.Color(225, 225, 245));
        botRelatorio.setText("LIVROS POR GÊNERO");
        botRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botRelatorioActionPerformed(evt);
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
                                        .addComponent(jLabel3)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(botCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botVer, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botSair, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(botPesquisar))
                                        .addComponent(botRelatorio))
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
                                .addGap(18, 18, 18)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botRelatorio)
                                .addContainerGap(28, Short.MAX_VALUE))
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

    private void botVerActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabGenero.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(null, "Selecione um gênero para visualizar!");
        } else {

            DadosGenero tela = new DadosGenero(null, true);

            tela.setGenero(listaGenero.get(linha));
            tela.desabilitar();

            tela.setVisible(true);

        }

    }

    private void botSairActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void botCadastrarActionPerformed(java.awt.event.ActionEvent evt) {

        if (this.usuarioLogado.getTipo().equals("A")) {

            DadosGenero tela = new DadosGenero(null, true);

            tela.setVisible(true);

            if (tela.isConfirmacao()) {

                Genero g = tela.getGenero();

                controle.adicionar(g);

                atualizarTabela();
            }
        } else {

            JOptionPane.showMessageDialog(this, "Você não possui permissão para isso.");
        }

    }

    private void botAlterarActionPerformed(java.awt.event.ActionEvent evt) {

        if (this.usuarioLogado.getTipo().equals("A")) {
            int linha = tabGenero.getSelectedRow();

            if (linha == -1) {

                JOptionPane.showMessageDialog(this, "Selecione um gênero para alterar!");
            } else {

                DadosGenero tela = new DadosGenero(null, true);

                tela.setGenero(listaGenero.get(linha));
                tela.setVisible(true);

                if (tela.isConfirmacao()) {

                    Genero g = tela.getGenero();

                    controle.alterar(g);

                    atualizarTabela();
                }

            }
        } else {

            JOptionPane.showMessageDialog(this, "Você não possui permissão para isso.");
        }

    }

    private void botExcluirActionPerformed(java.awt.event.ActionEvent evt) {

        if (this.usuarioLogado.getTipo().equals("A")) {
            int linha = tabGenero.getSelectedRow();

            if (linha == -1) {

                JOptionPane.showMessageDialog(this, "Selecione um gênero para excluir!");
            } else {

                int resposta = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir esse gênero ?", "Excluir Gênero", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_NO_OPTION) {

                    Genero genero = listaGenero.get(linha);

                    ControleLivro controleLivro = new ControleLivro();

                    List<Livro> livrosGenero = controleLivro.pegarGenero(genero);

                    if (livrosGenero.isEmpty()) {

                        controle.excluir(genero);
                        JOptionPane.showMessageDialog(null, "Operação finalizada.");
                        atualizarTabela();

                    } else {

                        JOptionPane.showMessageDialog(null, "Operação cancelada.\n"
                                + "Há livros relacionados a esse gênero.");
                    }

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Você não possui permissão para isso.");
        }
    }

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtPesquisarKeyTyped(java.awt.event.KeyEvent evt) {
        atualizarTabela();
    }

    private void botPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        atualizarTabela();
    }

    private void botRelatorioActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabGenero.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um gênero.");
        } else {

            Genero g = listaGenero.get(linha);

            ControleLivro controleLivro = new ControleLivro();

            List<Livro> livros = new ArrayList<>(controleLivro.pegarGeneroAtivo(g));

            if (!livros.isEmpty()) {
                try {
                    JasperReport relatorioCompilado
                            = JasperCompileManager.compileReport("src/main/java/relatorio/relatorioGeneroLivro.jrxml");

                    JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null,
                            new JRBeanCollectionDataSource(livros));

                    JDialog tela = new JDialog(this, "Relatório de Livros por Gênero", true);
                    tela.setSize(1000, 800);

                    JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);

                    tela.getContentPane().add(painelRelatorio);

                    tela.setLocationRelativeTo(null);
                    tela.setVisible(true);

                } catch (JRException ex) {

                    JOptionPane.showMessageDialog(this, "Erro ao gerar o relatório.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Não há livros desse gênero");
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAlterar;
    private javax.swing.JButton botCadastrar;
    private javax.swing.JButton botExcluir;
    private javax.swing.JButton botPesquisar;
    private javax.swing.JButton botRelatorio;
    private javax.swing.JButton botSair;
    private javax.swing.JButton botVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabGenero;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}

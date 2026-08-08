package visao;

import controle.ControleCaixa;
import controle.ControleEmprestimo;
import controle.ControleLivro;
import modelo.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TelaEmprestimo extends javax.swing.JDialog {

    private final List<Emprestimo> listaEmprestimo = new ArrayList<>();

    private final ControleEmprestimo controle = new ControleEmprestimo();
    private final ControleLivro controleLivro = new ControleLivro();

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public TelaEmprestimo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);

        tabEmprestimo.getColumnModel().getColumn(0).setPreferredWidth(250);
        tabEmprestimo.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabEmprestimo.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabEmprestimo.getColumnModel().getColumn(3).setPreferredWidth(150);
        tabEmprestimo.getColumnModel().getColumn(4).setPreferredWidth(100);

        atualizarTabela();

        cmbOpcoes.setSelectedItem("Selecione");

        URL url = this.getClass().getResource("/imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    private void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tabEmprestimo.getModel();

        modelo.setRowCount(0);

        listaEmprestimo.clear();
        listaEmprestimo.addAll(controle.pegarTodos());

        for (Emprestimo e : listaEmprestimo) {

            String situacao;

            Cliente cliente = e.getCliente();

            Caixa caixa = e.getCaixa();
            String pgto;

            if (caixa != null) {

                pgto = sdf.format(caixa.getData());
                situacao = "Finalizado";

            } else {

                pgto = "";
                situacao = "Pendente";
            }
            String dataLocacao = sdf.format(e.getDataLocacao());
            String dataDevolucao = sdf.format(e.getDataDevolucao());

            modelo.addRow(new Object[]{cliente.getNome(), dataLocacao, dataDevolucao, situacao, pgto
            });
        }
    }

    private void atualizarTabelaPendente() {

        DefaultTableModel modelo = (DefaultTableModel) tabEmprestimo.getModel();

        modelo.setRowCount(0);

        listaEmprestimo.clear();
        listaEmprestimo.addAll(controle.pegarPendente());

        // varre todos os produtos que estão no controle
        for (Emprestimo e : listaEmprestimo) {

            Cliente c = e.getCliente();

            String dataLocacao = sdf.format(e.getDataLocacao());
            String dataDevolucao = sdf.format(e.getDataDevolucao());

            modelo.addRow(new Object[]{c.getNome(), dataLocacao, dataDevolucao, "Pendente", ""
            });
        }

    }

    private void atualizarTabelaFinalizado() {

        DefaultTableModel modelo = (DefaultTableModel) tabEmprestimo.getModel();

        modelo.setRowCount(0);

        listaEmprestimo.clear();
        listaEmprestimo.addAll(controle.pegarFinalizado());

        for (Emprestimo e : listaEmprestimo) {

            Cliente cliente = e.getCliente();

            Caixa caixa = e.getCaixa();

            String pgto = sdf.format(caixa.getData());
            String dataLocacao = sdf.format(e.getDataLocacao());
            String dataDevolucao = sdf.format(e.getDataDevolucao());

            modelo.addRow(new Object[]{cliente.getNome(), dataLocacao, dataDevolucao, "Finalizado", pgto
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
        tabEmprestimo = new javax.swing.JTable();
        botCadastrar = new javax.swing.JButton();
        botPagar = new javax.swing.JButton();
        botVer = new javax.swing.JButton();
        botAlterar = new javax.swing.JButton();
        botSair = new javax.swing.JButton();
        botPesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbOpcoes = new javax.swing.JComboBox<>();
        botDevolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LITTERA - Empréstimo");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 0, 36)); // NOI18N
        jLabel1.setText("Empréstimos");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/calendario.png"))); // NOI18N

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
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabEmprestimo.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Cliente", "Locação", "Devolução", "Situação", "Pagamento"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabEmprestimo);

        botCadastrar.setBackground(new java.awt.Color(225, 225, 245));
        botCadastrar.setText("CADASTRAR");
        botCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCadastrarActionPerformed(evt);
            }
        });

        botPagar.setBackground(new java.awt.Color(225, 225, 245));
        botPagar.setText("BAIXA");
        botPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botPagarActionPerformed(evt);
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

        botPesquisar.setBackground(new java.awt.Color(225, 225, 245));
        botPesquisar.setText("PESQUISAR");
        botPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botPesquisarActionPerformed(evt);
            }
        });

        jLabel3.setText("Selecione a pesquisa de empréstimo :");

        cmbOpcoes.setBackground(new java.awt.Color(225, 225, 245));
        cmbOpcoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Selecione", "Empréstimos Pendentes", "Empréstimos Finalizados", "Todos os empréstimos"}));

        botDevolver.setBackground(new java.awt.Color(225, 225, 245));
        botDevolver.setText("DEVOLUÇÃO");
        botDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botDevolverActionPerformed(evt);
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
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(botCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botVer, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botSair, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(46, 46, 46))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(cmbOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(botPesquisar)))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botPesquisar)
                                        .addComponent(cmbOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(botAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botVer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 50, Short.MAX_VALUE))
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

        int linha = tabEmprestimo.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um empréstimo para visualizar.");

        } else {

            VerEmprestimo tela = new VerEmprestimo(null, true);

            tela.setEmprestimo(listaEmprestimo.get(linha));

            tela.setVisible(true);
        }


    }

    private void botSairActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void botCadastrarActionPerformed(java.awt.event.ActionEvent evt) {

        DadosEmprestimo tela = new DadosEmprestimo(null, true);

        tela.setVisible(true);

        if (tela.isConfirmacao()) {

            Emprestimo e = tela.getEmprestimo();

            controle.persistir(e);

            atualizarTabela();

        }

    }

    private void botAlterarActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabEmprestimo.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um empréstimo para alterar.");
        } else {

            Emprestimo emp = listaEmprestimo.get(linha);

            if (emp.getCaixa() != null) {
                JOptionPane.showMessageDialog(this, "Não é possível alterar esse empréstimo pois ele já foi finalizado.");
            } else {

                DadosEmprestimo tela = new DadosEmprestimo(null, true);

                tela.setAlterar(true);
                tela.setEmprestimo(emp);
                tela.setVisible(true);

                if (tela.isConfirmacao()) {

                    Emprestimo e = tela.getEmprestimo();

                    controle.persistir(e);

                    atualizarTabela();

                }
            }
        }
    }

    private void botPagarActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabEmprestimo.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um empréstimo para dar baixa!");
        } else {

            Emprestimo e = listaEmprestimo.get(linha);

            if (e.getCaixa() == null) {
                if (e.isSituacao()) {
                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja confirmar o pagamento?", "Confirmar pagamento", JOptionPane.YES_NO_OPTION);

                    if (resposta == JOptionPane.YES_NO_OPTION) {
                        {

                            Caixa caixa = ControleCaixa.getCaixaAberto();

                            e.setCaixa(caixa);
                            e.setSituacao(true);

                            controle.persistir(e);

                            TelaCaixa c = new TelaCaixa(null, true);

                            Movimentacao m = new Movimentacao();

                            Cliente ce = e.getCliente();

                            double pagar = e.getValor() + e.getMulta();

                            m.setMotivo("Pagamento Empréstimo - Cliente : " + ce.getNome());
                            m.setValor(pagar);
                            m.setTipo("E");

                            c.adicionarMovimentacao(m);
                            atualizarTabela();

                            JOptionPane.showMessageDialog(this, "Operação finalizada.");
                        }
                    }
                } else {

                    JOptionPane.showMessageDialog(this, "Não é possível dar baixa nesse empréstimo pois nem todos os livros foram devolvidos.");
                }

            } else {

                JOptionPane.showMessageDialog(this, "Empréstimo já pago.");
            }
        }


    }

    private void botPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = cmbOpcoes.getSelectedIndex();

        switch (linha) {
            case 0:
                JOptionPane.showMessageDialog(this, "Selecione o tipo de pesquisa a ser feita.");
                break;
            case 1:
                atualizarTabelaPendente();
                break;
            case 2:
                atualizarTabelaFinalizado();
                break;
            default:
                atualizarTabela();
                break;
        }

    }

    private void botDevolverActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabEmprestimo.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um empréstimo para atualizar.");
        } else {

            Emprestimo e = listaEmprestimo.get(linha);

            if (!e.isSituacao()) {
                TelaDevolucao tela = new TelaDevolucao(null, true);

                tela.setItens(listaEmprestimo.get(linha));

                tela.setVisible(true);

                if (tela.isConfirmacao()) {

                    List<ItemEmprestimo> novos = new ArrayList<>(tela.getNovos());

                    Emprestimo emp = listaEmprestimo.get(linha);

                    double multa = 0;

                    for (ItemEmprestimo ie : novos) {

                        Livro l = ie.getLivro();

                        if (l.getQuantidadeDisponivel() == 0) {
                            l.setSituacao(true);
                        }

                        l.setQuantidadeDisponivel(l.getQuantidadeDisponivel() + 1);
                        controleLivro.alterar(l);

                        multa = multa + ie.getMulta();

                    }

                    if (tela.getMudanca() == emp.getItens().size()) {

                        emp.setSituacao(true);
                    }

                    emp.setMulta(multa);
                    emp.setItens(tela.getItens());

                    controle.persistir(emp);

                    atualizarTabela();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Todos os livros foram devolvidos.");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAlterar;
    private javax.swing.JButton botCadastrar;
    private javax.swing.JButton botDevolver;
    private javax.swing.JButton botPagar;
    private javax.swing.JButton botPesquisar;
    private javax.swing.JButton botSair;
    private javax.swing.JButton botVer;
    private javax.swing.JComboBox<String> cmbOpcoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabEmprestimo;
    // End of variables declaration//GEN-END:variables
}

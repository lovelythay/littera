package visao;

import controle.ControleCaixa;
import controle.ControleHistorico;
import controle.ControleVenda;
import modelo.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TelaVenda extends javax.swing.JDialog {

    private final List<Venda> listaVenda = new ArrayList<>();

    private final ControleVenda controle = new ControleVenda();
    private final ControleCaixa controleCaixa = new ControleCaixa();
    private final ControleHistorico controleHistorico = new ControleHistorico();

    private final NumberFormat formatar = NumberFormat.getCurrencyInstance();
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public TelaVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);

        tabVenda.getColumnModel().getColumn(0).setPreferredWidth(250);
        tabVenda.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabVenda.getColumnModel().getColumn(2).setPreferredWidth(250);
        tabVenda.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabVenda.getColumnModel().getColumn(4).setPreferredWidth(100);

        atualizarTabela();

        cmbOpcoes.setSelectedItem("Selecione");

        URL url = this.getClass().getResource("/imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    private void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tabVenda.getModel();

        modelo.setRowCount(0);

        listaVenda.clear();
        listaVenda.addAll(controle.pegarTodos());
        for (Venda v : listaVenda) {

            Usuario u = v.getUsuario();
            Cliente c = v.getCliente();

            String cliente;
            if (c != null) {

                cliente = c.getNome();
            } else {

                cliente = "Não informado.";
            }

            String preco = formatar.format(v.getValorTotal());
            String data = sdf.format(v.getDataOperacao());

            Caixa ca = v.getCaixa();
            String pgto;

            if (ca != null) {

                pgto = sdf.format(ca.getData());
            } else {
                pgto = "";
            }

            modelo.addRow(new Object[]{cliente, data, u.getNome(), preco, pgto
            });

        }
    }

    private void atualizarTabelaPendente() {

        DefaultTableModel modelo = (DefaultTableModel) tabVenda.getModel();

        modelo.setRowCount(0);

        listaVenda.clear();
        listaVenda.addAll(controle.pegarPendente());

        for (Venda v : listaVenda) {

            Usuario u = v.getUsuario();
            Cliente c = v.getCliente();

            String cliente;
            if (c != null) {

                cliente = c.getNome();
            } else {

                cliente = "Não informado.";
            }

            String preco = formatar.format(v.getValorTotal());
            String data = sdf.format(v.getDataOperacao());

            modelo.addRow(new Object[]{cliente, data, u.getNome(), preco, ""
            });
        }

    }

    private void atualizarTabelaFinalizado() {

        DefaultTableModel modelo = (DefaultTableModel) tabVenda.getModel();

        modelo.setRowCount(0);

        listaVenda.clear();
        listaVenda.addAll(controle.pegarFinalizado());

        for (Venda v : listaVenda) {

            Usuario u = v.getUsuario();
            Cliente c = v.getCliente();

            String cliente;
            if (c != null) {

                cliente = c.getNome();
            } else {

                cliente = "Não informado.";
            }

            String preco = formatar.format(v.getValorTotal());
            String data = sdf.format(v.getDataOperacao());

            Caixa ca = v.getCaixa();
            String pgto = sdf.format(ca.getData());

            modelo.addRow(new Object[]{cliente, data, u.getNome(), preco, pgto
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
        tabVenda = new javax.swing.JTable();
        botCadastrar = new javax.swing.JButton();
        botPagar = new javax.swing.JButton();
        botVer = new javax.swing.JButton();
        botAlterar = new javax.swing.JButton();
        botSair = new javax.swing.JButton();
        botPesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbOpcoes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LITTERA - Venda");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 0, 36)); // NOI18N
        jLabel1.setText("Vendas");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/venda.png"))); // NOI18N

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

        tabVenda.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Cliente", "Data", "Vendedor", "Preço", "Pagamento"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabVenda);

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

        jLabel3.setText("Selecione a pesquisa de venda :");

        cmbOpcoes.setBackground(new java.awt.Color(225, 225, 245));
        cmbOpcoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Selecione", "Vendas Pendentes", "Vendas Finalizados", "Todos as vendas"}));
        cmbOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOpcoesActionPerformed(evt);
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
                                                .addComponent(cmbOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botPesquisar))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(botCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botVer, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botSair, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botPesquisar)
                                        .addComponent(cmbOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(botAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(botPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void botVerActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabVenda.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione uma venda para visualizar.");
        } else {

            VerVenda tela = new VerVenda(null, true);

            tela.setVenda(listaVenda.get(linha));
            tela.setVisible(true);

        }


    }

    private void botSairActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void botCadastrarActionPerformed(java.awt.event.ActionEvent evt) {

        DadosVenda tela = new DadosVenda(null, true);

        tela.setVisible(true);

        if (tela.isConfirmacao()) {

            Venda v = tela.getVenda();
            controle.persistir(v);

            atualizarTabela();

        }
    }

    private void botAlterarActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabVenda.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione uma venda para alterar.");
        } else {

            Venda v = listaVenda.get(linha);

            if (v.getCaixa() != null) {
                JOptionPane.showMessageDialog(this, "Não é possível alterar essa venda, pois ela já foi finalizada.");
            } else {

                DadosVenda tela = new DadosVenda(null, true);

                tela.setAlterar(true);
                tela.setVenda(v);
                tela.setVisible(true);

                if (tela.isConfirmacao()) {

                    Venda ve = tela.getVenda();

                    controle.persistir(ve);

                    atualizarTabela();

                }
            }
        }
    }

    private void botPagarActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabVenda.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione uma venda para dar baixa.");
        } else {

            Venda v = listaVenda.get(linha);

            if (v.getCaixa() == null) {
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja confirmar o pagamento?", "Confirmar pagamento", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_NO_OPTION) {

                    Caixa caixa = ControleCaixa.getCaixaAberto();

                    List<ItemVenda> itens = new ArrayList<>(v.getItens());

                    for (ItemVenda iv : itens) {

                        Livro l = iv.getLivro();

                        Historico h = new Historico();

                        h.setQuantidade(iv.getQuantidade());
                        h.setDataAtualizacao(v.getDataOperacao());
                        h.setLivro(l);
                        h.setUsuario(v.getUsuario());
                        h.setDescricao("Saída - Venda");

                        controleHistorico.adicionar(h);

                    }

                    v.setCaixa(caixa);

                    controle.persistir(v);

                    int codigo = 0;

                    TelaCaixa c = new TelaCaixa(null, true);

                    Movimentacao m = new Movimentacao();

                    Cliente ce = v.getCliente();
                    Usuario u = v.getUsuario();

                    m.setCodigo(codigo);

                    if (ce != null) {

                        m.setMotivo("Pagamento Venda - Cliente : " + ce.getNome());
                    } else {

                        m.setMotivo("Pagamento Venda - Usuário : " + u.getNome());
                    }

                    m.setValor(v.getValorTotal());
                    m.setTipo("E");

                    c.adicionarMovimentacao(m);

                    atualizarTabela();

                    JOptionPane.showMessageDialog(this, "Operação finalizada");
                }
            } else {

                JOptionPane.showMessageDialog(this, "Venda já paga.");
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

    private void cmbOpcoesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAlterar;
    private javax.swing.JButton botCadastrar;
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
    private javax.swing.JTable tabVenda;
    // End of variables declaration//GEN-END:variables
}

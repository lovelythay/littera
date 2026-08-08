package visao;

import controle.ControleLivro;
import modelo.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

public class DadosVenda extends javax.swing.JDialog {

    private Cliente cliente = null;
    private Usuario usuario = null;
    private Livro livro = null;
    private double valor = 0;
    private int codigo;
    private Date dataOperacao = new Date();

    private final List<ItemVenda> itens = new ArrayList<>();
    private final List<ItemVenda> novos = new ArrayList<>();

    private final Map<ItemVenda, Integer> quantidadesOriginais = new HashMap<>();
    private final List<ItemVenda> itensRemovidos = new ArrayList<>();

    private boolean confirmacao;
    private boolean alterar;

    private final ControleLivro controleLivro = new ControleLivro();

    private final NumberFormat formatar = NumberFormat.getCurrencyInstance();

    public DadosVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);

        atualizarTabela();

        String valorString = formatar.format(0.00);

        txtPreco.setText(valorString);
        txtValor.setText(valorString);

        txtCliente.setEditable(false);
        txtUsuario.setEditable(false);
        txtLivro.setEditable(false);

        URL url = this.getClass().getResource("/imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    private void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tabLivros.getModel();

        modelo.setRowCount(0);

        for (ItemVenda i : itens) {

            Livro l = i.getLivro();

            String preco = formatar.format(i.getPreco());

            modelo.addRow(new Object[]{l.getNome(), preco, i.getQuantidade()
            });

        }

    }

    private void alterarQuantidade() {

        List<ItemVenda> livrosAlterar = this.alterar ? novos : itens;

        for (ItemVenda it : livrosAlterar) {

            Livro l = it.getLivro();
            int quantidadeOriginal = quantidadesOriginais.getOrDefault(it, 0);
            int delta = it.getQuantidade() - quantidadeOriginal;

            if (delta != 0) {
                l.setQuantidade(l.getQuantidade() - delta);
                l.setQuantidadeDisponivel(l.getQuantidadeDisponivel() - delta);
            }

            l.setSituacao(l.getQuantidade() > 0);
            controleLivro.alterar(l);
        }

        for (ItemVenda removido : itensRemovidos) {

            Livro l = removido.getLivro();
            int quantidadeOriginal = quantidadesOriginais.getOrDefault(removido, 0);

            if (quantidadeOriginal > 0) {
                l.setQuantidade(l.getQuantidade() + quantidadeOriginal);
                l.setQuantidadeDisponivel(l.getQuantidadeDisponivel() + quantidadeOriginal);
                l.setSituacao(true);
                controleLivro.alterar(l);
            }
        }
    }

    private void atualizarNovos(ItemVenda iv) {
        boolean estaNovo = false;
        for (ItemVenda it : novos) {
            if (it.getLivro().equals(iv.getLivro())) {
                novos.set(novos.indexOf(it), iv);
                estaNovo = true;
                break;
            }
        }
        if (!estaNovo) {
            novos.add(iv);
        }
    }

    public Venda getVenda() {

        Venda v = new Venda();

        v.setCodigo(this.codigo);
        v.setUsuario(this.usuario);
        v.setDataOperacao(this.dataOperacao);

        if (this.cliente != null) {

            v.setCliente(this.cliente);
        }

        for (ItemVenda i : itens) {

            v.adicionarItem(i);

            Livro l = i.getLivro();

            l.setSituacao(true);
            controleLivro.alterar(l);

        }

        alterarQuantidade();
        v.setValorTotal(this.valor);

        return v;
    }

    public void setVenda(Venda v) {

        this.codigo = v.getCodigo();
        this.cliente = v.getCliente();

        this.dataOperacao = v.getDataOperacao();

        if (cliente != null) {

            txtCliente.setText(cliente.getNome());
        }

        this.usuario = v.getUsuario();
        txtUsuario.setText(usuario.getNome());

        String total = formatar.format(v.getValorTotal());

        this.valor = v.getValorTotal();
        txtPreco.setText(total);

        itens.clear();
        itens.addAll(v.getItens());

        for (ItemVenda iv : itens) {

            Livro l = iv.getLivro();
            quantidadesOriginais.put(iv, iv.getQuantidade());

            if (l.isSituacao()) {
                l.setSituacao(false);
                controleLivro.alterar(l);
            }
        }

        txtUsuario.setEditable(false);
        txtCliente.setEditable(false);
        botPesquisarCliente.setVisible(false);
        botPesquisarUsuario.setVisible(false);

        atualizarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        botPesquisarCliente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtLivro = new javax.swing.JTextField();
        botAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabLivros = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        botExcluir = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        botCancelar = new javax.swing.JButton();
        botConfirmar = new javax.swing.JButton();
        txtPreco = new javax.swing.JLabel();
        botPesquisarLivro = new javax.swing.JButton();
        botPesquisarUsuario = new javax.swing.JButton();
        txtValor = new javax.swing.JLabel();
        botAdicionarLivro = new javax.swing.JButton();
        botExcluirLivro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Littera - Empréstimo");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 0, 36)); // NOI18N
        jLabel1.setText("Vendas");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/venda.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addContainerGap(861, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Cliente :   ");

        txtCliente.setEditable(false);
        txtCliente.setBackground(new java.awt.Color(235, 235, 255));
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        botPesquisarCliente.setBackground(new java.awt.Color(225, 225, 245));
        botPesquisarCliente.setText("PESQUISAR");
        botPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botPesquisarClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Vendedor :  *  ");

        txtUsuario.setBackground(new java.awt.Color(235, 235, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Itens da Venda :   *");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Livro :   ");

        txtLivro.setBackground(new java.awt.Color(235, 235, 255));

        botAdicionar.setBackground(new java.awt.Color(225, 225, 245));
        botAdicionar.setText("ADICIONAR");
        botAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAdicionarActionPerformed(evt);
            }
        });

        tabLivros.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "Nome", "Preço", "Quantidade"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabLivros);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Preço :   ");

        botExcluir.setBackground(new java.awt.Color(225, 225, 245));
        botExcluir.setText("EXCLUIR");
        botExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botExcluirActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Valor total:   ");

        jLabel13.setForeground(new java.awt.Color(135, 158, 255));
        jLabel13.setText("* - campos obrigatórios");

        botCancelar.setBackground(new java.awt.Color(225, 225, 245));
        botCancelar.setText("CANCELAR");
        botCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCancelarActionPerformed(evt);
            }
        });

        botConfirmar.setBackground(new java.awt.Color(225, 225, 245));
        botConfirmar.setText("CONFIRMAR");
        botConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botConfirmarActionPerformed(evt);
            }
        });

        txtPreco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPreco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtPreco.setText("0,00");

        botPesquisarLivro.setBackground(new java.awt.Color(225, 225, 245));
        botPesquisarLivro.setText("PESQUISAR");
        botPesquisarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botPesquisarLivroActionPerformed(evt);
            }
        });

        botPesquisarUsuario.setBackground(new java.awt.Color(225, 225, 245));
        botPesquisarUsuario.setText("PESQUISAR");
        botPesquisarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botPesquisarUsuarioActionPerformed(evt);
            }
        });

        txtValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtValor.setText("0,00");

        botAdicionarLivro.setBackground(new java.awt.Color(225, 225, 245));
        botAdicionarLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botAdicionarLivro.setText("+");
        botAdicionarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAdicionarLivroActionPerformed(evt);
            }
        });

        botExcluirLivro.setBackground(new java.awt.Color(225, 225, 245));
        botExcluirLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botExcluirLivro.setText("-");
        botExcluirLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botExcluirLivroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel13))
                                                .addGap(24, 24, 24)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtLivro)
                                                                .addGap(29, 29, 29)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(botPesquisarUsuario)
                                                                        .addComponent(botPesquisarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel9)
                                                                                        .addComponent(txtValor))
                                                                                .addGap(136, 136, 136)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel10)
                                                                                        .addComponent(txtPreco)))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(botAdicionarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(botExcluirLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(botAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(botConfirmar)
                                                                                .addGap(31, 31, 31)
                                                                                .addComponent(botCancelar))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(botExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(botPesquisarCliente))
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel5))
                                                .addGap(48, 48, 48)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtUsuario)
                                                                .addGap(136, 136, 136)))))
                                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botPesquisarCliente)
                                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botPesquisarUsuario))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(botConfirmar)
                                                                        .addComponent(botCancelar)))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel13))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botPesquisarLivro))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel10))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtPreco)
                                                        .addComponent(txtValor))
                                                .addGap(27, 27, 27)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(botAdicionar)
                                                        .addComponent(botExcluir))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(botAdicionarLivro)
                                                        .addComponent(botExcluirLivro))))
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {
        PesquisarCliente tela = new PesquisarCliente(null, true);
        tela.setVisible(true);

        if (tela.isConfirmacao()) {

            this.cliente = tela.getCliente();

            txtCliente.setText(cliente.getNome());

        }
    }

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void botAdicionarActionPerformed(java.awt.event.ActionEvent evt) {

        if (this.livro == null) {
            JOptionPane.showMessageDialog(this, "Selecione um livro para adicionar.");
        } else {

            ItemVenda i = new ItemVenda();

            i.setLivro(this.livro);
            i.setPreco(this.livro.getPreco());
            i.setQuantidade(1);

            quantidadesOriginais.put(i, 0);

            livro.setSituacao(false); // isso é para na busca o livro não aparecer novamente
            controleLivro.alterar(livro);

            if (this.alterar) {
                novos.add(i);
            }
            itens.add(i);

            atualizarTabela();

            this.valor = this.valor + i.getPreco();

            String v = formatar.format(this.valor);
            txtPreco.setText(v);

            txtLivro.setText("");
            String a = formatar.format(0.00);
            txtValor.setText(a);

            this.livro = null;
        }
    }

    private void botExcluirActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabLivros.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um item para excluir.");
        } else {

            int resposta = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir esse item ?", "Excluir Item", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_NO_OPTION) {

                ItemVenda i = itens.get(linha);
                itens.remove(linha);
                itensRemovidos.add(i);

                if (this.alterar) {
                    novos.removeIf(it -> it.getLivro().equals(i.getLivro()));
                }

                Livro l = i.getLivro();
                l.setSituacao(true);
                controleLivro.alterar(l);

                this.valor = this.valor - i.getPreco() * i.getQuantidade();
                txtPreco.setText(formatar.format(this.valor));
                txtValor.setText(formatar.format(0.0));
                atualizarTabela();

                JOptionPane.showMessageDialog(null, "Operação finalizada.");
            }
        }
    }

    public void setAlterar(boolean alterar) {

        this.alterar = alterar;
    }

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {

        if (this.alterar) {

            for (ItemVenda i : novos) {

                Livro l = i.getLivro();

                l.setSituacao(true);
                this.controleLivro.alterar(l);

            }
        } else {

            for (ItemVenda i : itens) {

                Livro l = i.getLivro();

                l.setSituacao(true);
                this.controleLivro.alterar(l);

            }
        }

        this.setVisible(false);
    }

    private void botConfirmarActionPerformed(java.awt.event.ActionEvent evt) {

        if (this.valor == 0) {

            JOptionPane.showMessageDialog(this, "Selecione um livro para finalizar a venda.");
        } else if (itens.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Selecione um livro para finalizar a venda.");
        } else if (txtUsuario.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Informe o vendedor responsável pela venda.");
            txtUsuario.requestFocus();
        } else {

            confirmacao = true;
            this.setVisible(false);
        }
    }

    public boolean isConfirmacao() {
        return confirmacao;
    }

    private void botPesquisarLivroActionPerformed(java.awt.event.ActionEvent evt) {

        PesquisarLivro tela = new PesquisarLivro(null, true);

        tela.setTipo(1);

        tela.setVisible(true);

        if (tela.isConfirmacao()) {

            this.livro = tela.getLivro();

            txtLivro.setText(livro.getNome());

            String v = formatar.format(this.livro.getPreco());
            txtValor.setText(v);
        }
    }

    private void botPesquisarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {

        PesquisarUsuario tela = new PesquisarUsuario(null, true);
        tela.setVisible(true);

        if (tela.isConfirmacao()) {

            this.usuario = tela.getUsuario();

            txtUsuario.setText(usuario.getNome());

        }
    }

    private void botAdicionarLivroActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tabLivros.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um livro para adicionar outro exemplar.");
        } else {

            ItemVenda iv = itens.get(linha);
            Livro l = iv.getLivro();

            int quantidadeOriginal = quantidadesOriginais.getOrDefault(iv, 0);
            int limiteMaximo = l.getQuantidadeDisponivel() + quantidadeOriginal;

            if (iv.getQuantidade() + 1 <= limiteMaximo) {

                iv.setQuantidade(iv.getQuantidade() + 1);

                this.valor = this.valor + iv.getPreco();

                String v = formatar.format(this.valor);

                txtPreco.setText(v);

                itens.set(linha, iv);

                if (this.alterar) {

                    atualizarNovos(iv);
                }

                atualizarTabela();

            } else {

                JOptionPane.showMessageDialog(this, "Não é possível adicionar mais um exemplar deste livro pois não há mais estoque.");
            }
        }

    }

    private void botExcluirLivroActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabLivros.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um livro para remover um exemplar.");
        } else {

            ItemVenda iv = itens.get(linha);

            if (iv.getQuantidade() - 1 > 0) {

                iv.setQuantidade(iv.getQuantidade() - 1);
                this.valor = this.valor - iv.getPreco();
                txtPreco.setText(formatar.format(this.valor));
                itens.set(linha, iv);

                if (this.alterar) {
                    atualizarNovos(iv);
                }

                atualizarTabela();

            } else {

                itens.remove(iv);
                itensRemovidos.add(iv);

                if (this.alterar) {
                    novos.removeIf(it -> it.getLivro().equals(iv.getLivro()));
                }

                Livro l = iv.getLivro();
                l.setSituacao(true);
                controleLivro.alterar(l);

                this.valor = this.valor - iv.getPreco() * iv.getQuantidade();
                txtPreco.setText(formatar.format(this.valor));
                atualizarTabela();
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAdicionar;
    private javax.swing.JButton botAdicionarLivro;
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botConfirmar;
    private javax.swing.JButton botExcluir;
    private javax.swing.JButton botExcluirLivro;
    private javax.swing.JButton botPesquisarCliente;
    private javax.swing.JButton botPesquisarLivro;
    private javax.swing.JButton botPesquisarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabLivros;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtLivro;
    private javax.swing.JLabel txtPreco;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel txtValor;
    // End of variables declaration//GEN-END:variables
}

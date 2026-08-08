package visao;

import controle.ControleLivro;
import modelo.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DadosEmprestimo extends javax.swing.JDialog {

    // formatações
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final NumberFormat formatar = NumberFormat.getCurrencyInstance();

    private boolean confirmacao;
    private double multa;
    private double valorFinal;

    private boolean alterar;

    private final List<ItemEmprestimo> itens = new ArrayList<>();
    private final List<ItemEmprestimo> novos = new ArrayList<>();

    private Date dataHoje = new Date();

    private Livro livro = null;
    private Cliente cliente = null;
    private Usuario usuario = null;

    private final ControleLivro controleLivro = new ControleLivro();

    private int codigo;

    public DadosEmprestimo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);

        calendarDevolucao.setMinSelectableDate(dataHoje);

        atualizarTabela();

        String v = formatar.format(0.00);

        txtPreco.setText(v);
        txtTotal.setText(v);

        tabLivros.getColumnModel().getColumn(0).setPreferredWidth(300);
        tabLivros.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabLivros.getColumnModel().getColumn(2).setPreferredWidth(100);

        situacao.setEditable(false);
        situacao.setText("Pendente");

        txtUsuario.setEditable(false);
        txtCliente.setEditable(false);
        txtLivro.setEditable(false);

        novos.clear();

        URL url = this.getClass().getResource("/imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);

    }

    private void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tabLivros.getModel();

        modelo.setRowCount(0);

        // varre todos os produtos que estão no controle
        for (ItemEmprestimo i : itens) {

            Livro l = i.getLivro();

            String dataD;

            if (i.isSituacao()) {

                dataD = sdf.format(i.getDataReal());
                l.setQuantidadeDisponivel(l.getQuantidadeDisponivel() + 1);

                if (!l.isSituacao()) {
                    l.setSituacao(true);
                }

                controleLivro.alterar(l);

            } else {

                dataD = "O livro não foi devolvido.";

            }

            String taxa = formatar.format(l.getTaxa());

            modelo.addRow(new Object[]{l.getNome(), dataD, taxa
            });
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        calendarDevolucao = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        botPesquisarCliente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labLivro = new javax.swing.JLabel();
        txtLivro = new javax.swing.JTextField();
        botAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabLivros = new javax.swing.JTable();
        labTaxa = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        botCancelar = new javax.swing.JButton();
        botConfirmar = new javax.swing.JButton();
        txtPreco = new javax.swing.JLabel();
        botPesquisarLivro = new javax.swing.JButton();
        botExcluir = new javax.swing.JButton();
        situacao = new javax.swing.JTextField();
        botPesquisarUsuario = new javax.swing.JButton();
        labVTT = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Littera - Empréstimo");

        panPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panPrincipal.setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 0, 36)); // NOI18N
        jLabel1.setText("Empréstimos");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/calendario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Data de Devolução :   *");

        calendarDevolucao.setBackground(new java.awt.Color(235, 235, 255));
        calendarDevolucao.setDateFormatString("dd '/' MM '/' yyyy");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Cliente :   *");

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

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Situação :     ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Itens do Empréstimo :   *");

        labLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labLivro.setText("Livro :   ");

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
                        "Livro", "Data de Devolução", "Taxa"
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

        labTaxa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labTaxa.setText("Taxa :   ");

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

        botExcluir.setBackground(new java.awt.Color(225, 225, 245));
        botExcluir.setText("EXCLUIR");
        botExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botExcluirActionPerformed(evt);
            }
        });

        situacao.setBackground(new java.awt.Color(235, 235, 255));

        botPesquisarUsuario.setBackground(new java.awt.Color(225, 225, 245));
        botPesquisarUsuario.setText("PESQUISAR");
        botPesquisarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botPesquisarUsuarioActionPerformed(evt);
            }
        });

        labVTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labVTT.setText("Valor total :");

        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotal.setText("0,00");

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
                panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(botConfirmar)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(botCancelar))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panPrincipalLayout.createSequentialGroup()
                                                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panPrincipalLayout.createSequentialGroup()
                                                                                                .addComponent(botAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(botExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panPrincipalLayout.createSequentialGroup()
                                                                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(txtLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(labTaxa)
                                                                                                        .addComponent(txtPreco))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                                                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(botPesquisarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(labVTT)
                                                                                                        .addComponent(txtTotal))))
                                                                                .addGap(0, 35, Short.MAX_VALUE)))
                                                                .addGap(0, 64, Short.MAX_VALUE))
                                                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                                                .addComponent(labLivro)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLabel11)
                                                                        .addComponent(calendarDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                                                        .addComponent(jLabel15)
                                                                        .addComponent(situacao))
                                                                .addGap(71, 71, 71)
                                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel6)
                                                                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                                                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(botPesquisarCliente))
                                                                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                                                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(botPesquisarUsuario))))
                                                        .addComponent(jLabel7))
                                                .addContainerGap())))
        );
        panPrincipalLayout.setVerticalGroup(
                panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(calendarDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(botPesquisarCliente)))
                                .addGap(18, 18, 18)
                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botPesquisarUsuario))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel13)
                                                .addContainerGap(39, Short.MAX_VALUE))
                                        .addGroup(panPrincipalLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(labLivro)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botPesquisarLivro))
                                                .addGap(18, 18, 18)
                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labTaxa)
                                                        .addComponent(labVTT))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtPreco)
                                                        .addComponent(txtTotal))
                                                .addGap(28, 28, 28)
                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(botAdicionar)
                                                        .addComponent(botExcluir))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(botCancelar)
                                                        .addComponent(botConfirmar))
                                                .addGap(14, 14, 14))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alterarQuantidadeDisponivel() {

        List<ItemEmprestimo> livrosAlterar = new ArrayList<>();

        if (this.alterar) {
            livrosAlterar.addAll(novos);
        } else {
            livrosAlterar.addAll(itens);
        }

        for (ItemEmprestimo it : livrosAlterar) {

            Livro l = it.getLivro();

            l.setQuantidadeDisponivel(l.getQuantidadeDisponivel() - 1);

            if (l.getQuantidadeDisponivel() == 0) {

                l.setSituacao(false);
            } else {
                l.setSituacao(true);
            }

            controleLivro.alterar(l);
        }

    }

    public Emprestimo getEmprestimo() {

        Emprestimo e = new Emprestimo();

        e.setUsuario(this.usuario);
        e.setCliente(this.cliente);
        e.setCodigo(this.codigo);

        e.setDataLocacao(dataHoje);
        e.setDataDevolucao(calendarDevolucao.getDate());

        for (ItemEmprestimo it : itens) {

            e.adicionarItem(it);

            if (this.alterar) {

                this.multa = this.multa + it.getMulta();
            }

            Livro l = it.getLivro();

            l.setSituacao(true);
            controleLivro.alterar(l);
        }

        alterarQuantidadeDisponivel();
        e.setValor(this.valorFinal);
        e.setMulta(this.multa);

        return e;

    }

    public void setAlterar(boolean sit) {

        this.alterar = sit;

    }


    public void setEmprestimo(Emprestimo e) {

        this.codigo = e.getCodigo();

        this.dataHoje = e.getDataLocacao();
        itens.clear();

        itens.addAll(e.getItens());

        usuario = e.getUsuario();
        txtUsuario.setText(usuario.getNome());
        txtUsuario.setEditable(false);
        botPesquisarUsuario.setVisible(false);

        situacao.setText("Pendente");

        situacao.setEditable(false);
        this.cliente = e.getCliente();
        txtCliente.setText(this.cliente.getNome());
        txtCliente.setEditable(false);
        botPesquisarCliente.setVisible(false);

        calendarDevolucao.setDate(e.getDataDevolucao());

        for (ItemEmprestimo it : e.getItens()) {

            this.multa = this.multa + it.getMulta();

            Livro l = it.getLivro();
            l.setSituacao(false);

            controleLivro.alterar(l);
        }

        this.valorFinal = e.getValor() + this.multa;

        Date hoje = new Date();
        Date dev = e.getDataDevolucao();

        if (hoje.getTime() > dev.getTime()) {

            labVTT.setVisible(true);
            txtTotal.setVisible(true);

            String vlf = formatar.format(this.valorFinal);
            txtTotal.setText(vlf);

        }

        txtTotal.setText(formatar.format(this.valorFinal));

        atualizarTabela();

        botExcluir.setVisible(false);
        this.alterar = true;
    }

    private void botPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {
        PesquisarCliente tela = new PesquisarCliente(null, true);
        tela.setVisible(true);

        if (tela.isConfirmacao()) {

            this.cliente = tela.getCliente();

            txtCliente.setText(cliente.getNome());
            txtCliente.setEditable(false);
        }
    }

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void botAdicionarActionPerformed(java.awt.event.ActionEvent evt) {

        if (this.livro == null) {

            JOptionPane.showMessageDialog(this, "Selecione um livro para adicionar.");
        } else {

            ItemEmprestimo i = new ItemEmprestimo();

            i.setLivro(livro);
            i.setPreco(livro.getTaxa());
            i.setSituacao(false);
            i.setDataReal(dataHoje);
            i.setMulta(0);

            livro.setSituacao(false);
            controleLivro.alterar(livro);

            itens.add(i);

            if (this.alterar) {

                novos.add(i);
            }

            atualizarTabela();

            this.valorFinal = this.valorFinal + i.getPreco();

            txtTotal.setText(formatar.format(this.valorFinal));

            String v = formatar.format(0.00);
            txtPreco.setText(v);

            txtLivro.setText("");
            txtPreco.setText("R$ 0,00");

            this.livro = null;

        }
    }


    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {

        if (this.alterar) {

            for (ItemEmprestimo i : novos) {

                Livro l = i.getLivro();

                l.setSituacao(true);
                this.controleLivro.alterar(l);

            }
        } else {

            for (ItemEmprestimo i : itens) {

                Livro l = i.getLivro();

                l.setSituacao(true);
                this.controleLivro.alterar(l);

            }
        }

        this.setVisible(false);
    }

    private void botConfirmarActionPerformed(java.awt.event.ActionEvent evt) {

        if (itens.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Selecione um livro para finalizar o empréstimo.");

        } else if (calendarDevolucao.getDate() == null) {

            JOptionPane.showMessageDialog(this, "Selecione a data de devoluçao do livro.");
            calendarDevolucao.requestFocus();

        } else if (this.cliente == null) {

            JOptionPane.showMessageDialog(this, "Selecione o cliente.");
            txtCliente.requestFocus();

        } else if (this.usuario == null) {

            JOptionPane.showMessageDialog(this, "Selecione o usuário.");
            txtUsuario.requestFocus();
        } else {

            this.confirmacao = true;

            this.setVisible(false);
        }

    }

    public boolean isConfirmacao() {
        return confirmacao;
    }

    private void botPesquisarLivroActionPerformed(java.awt.event.ActionEvent evt) {

        PesquisarLivro tela = new PesquisarLivro(null, true);

        tela.setTipo(0);

        tela.setVisible(true);

        if (tela.isConfirmacao()) {

            this.livro = tela.getLivro();

            txtLivro.setText(livro.getNome());
            txtPreco.setText(formatar.format(livro.getTaxa()));
        }

    }

    private void botExcluirActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabLivros.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um item para excluir.");
        } else {

            int resposta = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir esse item ?", "Excluir Item", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_NO_OPTION) {

                ItemEmprestimo i = itens.get(linha);

                Livro l = i.getLivro();

                l.setSituacao(true);

                controleLivro.alterar(l);

                this.valorFinal = this.valorFinal - i.getPreco();

                itens.remove(linha);

                //this.valor = 0;
                String valorTotal = formatar.format(this.valorFinal);

                txtPreco.setText(formatar.format(0.00));
                txtTotal.setText(valorTotal);

                atualizarTabela();

                JOptionPane.showMessageDialog(null, "Operação finalizada.");
            }
        }
    }

    private void botPesquisarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {

        PesquisarUsuario tela = new PesquisarUsuario(null, true);
        tela.setVisible(true);

        if (tela.isConfirmacao()) {

            this.usuario = tela.getUsuario();

            txtUsuario.setText(usuario.getNome());
            txtCliente.setEditable(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAdicionar;
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botConfirmar;
    private javax.swing.JButton botExcluir;
    private javax.swing.JButton botPesquisarCliente;
    private javax.swing.JButton botPesquisarLivro;
    private javax.swing.JButton botPesquisarUsuario;
    private com.toedter.calendar.JDateChooser calendarDevolucao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labLivro;
    private javax.swing.JLabel labTaxa;
    private javax.swing.JLabel labVTT;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JTextField situacao;
    private javax.swing.JTable tabLivros;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtLivro;
    private javax.swing.JLabel txtPreco;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

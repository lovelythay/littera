package visao;

import controle.ControleCaixa;
import controle.ControleUsuario;
import modelo.Caixa;
import modelo.Movimentacao;
import modelo.Usuario;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TelaCaixa extends javax.swing.JDialog {

    private final List<Movimentacao> movimentacoes = new ArrayList<>();
    private final List<Movimentacao> novas = new ArrayList<>();

    private final ControleCaixa controle = new ControleCaixa();

    private Caixa caixa = ControleCaixa.getCaixaAberto();
    private final Usuario usuario = ControleUsuario.getUsuarioLogado();

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
    private final NumberFormat formatar = NumberFormat.getCurrencyInstance();

    private double saldo = 0;
    private double entradas = 0;
    private double saidas = 0;

    public TelaCaixa(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);

        novas.clear();

        tabMovimentacao.getColumnModel().getColumn(0).setPreferredWidth(300);
        tabMovimentacao.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabMovimentacao.getColumnModel().getColumn(2).setPreferredWidth(100);

        if (this.caixa != null) {
            setCaixa();
        }
        if (usuario.getTipo().equals("V")) {

            botAcoes.setVisible(false);
            botVerCaixa.setVisible(false);
        }

        URL url = this.getClass().getResource("/imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);

    }

    public void abrirCaixa(Caixa c) {

        this.caixa = c;

        controle.abrir(c);
        setCaixa();

    }

    private void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tabMovimentacao.getModel();

        modelo.setRowCount(0);

        movimentacoes.clear();

        if (ControleCaixa.isCaixaAberto()) {
            movimentacoes.addAll(caixa.getMovimentacoes());
        }

        movimentacoes.addAll(this.novas);

        for (Movimentacao m : novas) {

            caixa.adicionarItem(m);
        }

        for (Movimentacao m : movimentacoes) {

            String v = formatar.format(m.getValor());

            String tipo;

            if (m.getTipo().equals("S")) {

                tipo = "Saída";

                this.saidas = this.saidas + m.getValor();

            } else {

                tipo = "Entrada";
                this.entradas = this.entradas + m.getValor();

            }

            modelo.addRow(new Object[]{m.getMotivo(), v, tipo
            });
        }

        if (ControleCaixa.isCaixaAberto()) {
            this.saldo = caixa.getValorAbertura() - this.saidas + this.entradas;
        } else {

            this.saldo = 0;
        }

        String sd = formatar.format(this.saldo);
        String s = formatar.format(this.saidas);
        String e = formatar.format(this.entradas);

        txtSaldo.setText(sd);
        txtSaidas.setText(s);
        txtEntradas.setText(e);

        if (ControleCaixa.isCaixaAberto()) {

            caixa.setTotalSaida(this.saidas);
            caixa.setTotalEntrada(this.entradas);
            caixa.setSaldo(this.saldo);

            this.caixa = controle.fechar(caixa);

        }

        this.saidas = 0;
        this.entradas = 0;

        this.novas.clear();

    }

    private void setCaixa() {

        String ab = formatar.format(caixa.getValorAbertura());
        String dia = sdf.format(caixa.getData());
        String h = hora.format(caixa.getHorarioAbertura());

        txtAbertura.setText(ab);
        txtData.setText(dia);
        txtAberturaHorario.setText(h);

        Usuario u = caixa.getUsuario();

        txtUsuario.setText(u.getNome());

        if (caixa.getHorarioFechamento() == null) {

            txtSit.setText("Aberto");

        } else {

            botAcoes.setVisible(false);
        }

        if (caixa.getSaldo() == 0) {

            this.saldo = caixa.getValorAbertura();

        } else {

            this.saldo = caixa.getSaldo();
        }

        atualizarTabela();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panMovimentacao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabMovimentacao = new javax.swing.JTable();
        botAdicionar = new javax.swing.JButton();
        botVer = new javax.swing.JButton();
        panInfo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtAbertura = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEntradas = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSaidas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAberturaHorario = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtData = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSit = new javax.swing.JLabel();
        botVoltar = new javax.swing.JButton();
        botAcoes = new javax.swing.JButton();
        botVerCaixa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LITTERA - Caixa");
        setPreferredSize(new java.awt.Dimension(1150, 690));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 0, 36)); // NOI18N
        jLabel1.setText("Caixa");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dinheiro.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        panMovimentacao.setBackground(new java.awt.Color(255, 255, 255));
        panMovimentacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Movimentações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tabMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "Motivo", "Valor", "Tipo"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabMovimentacao);

        botAdicionar.setBackground(new java.awt.Color(225, 225, 245));
        botAdicionar.setText("ADICIONAR");
        botAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAdicionarActionPerformed(evt);
            }
        });

        botVer.setBackground(new java.awt.Color(225, 225, 245));
        botVer.setText("VER");
        botVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panMovimentacaoLayout = new javax.swing.GroupLayout(panMovimentacao);
        panMovimentacao.setLayout(panMovimentacaoLayout);
        panMovimentacaoLayout.setHorizontalGroup(
                panMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panMovimentacaoLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(panMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panMovimentacaoLayout.createSequentialGroup()
                                                .addComponent(botAdicionar)
                                                .addGap(18, 18, 18)
                                                .addComponent(botVer, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(33, Short.MAX_VALUE))
        );
        panMovimentacaoLayout.setVerticalGroup(
                panMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panMovimentacaoLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panMovimentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(botVer)
                                        .addComponent(botAdicionar))
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        panInfo.setBackground(new java.awt.Color(255, 255, 255));
        panInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumo do Caixa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Valor de Abertura ");

        txtAbertura.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAbertura.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtAbertura.setText("R$ 0,00");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Saldo");

        txtSaldo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSaldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtSaldo.setText("R$ 0,00");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Total de Entradas");

        txtEntradas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEntradas.setForeground(new java.awt.Color(0, 255, 51));
        txtEntradas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtEntradas.setText("R$ 0,00");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Total de Saídas");

        txtSaidas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSaidas.setForeground(new java.awt.Color(255, 51, 51));
        txtSaidas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtSaidas.setText("R$ 0,00");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Horário de Abertura :");

        txtAberturaHorario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAberturaHorario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Usuário :");

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Data :");

        txtData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtData.setText("dd/mm/aaaa");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Status :");

        txtSit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtSit.setText("Fechado");

        javax.swing.GroupLayout panInfoLayout = new javax.swing.GroupLayout(panInfo);
        panInfo.setLayout(panInfoLayout);
        panInfoLayout.setHorizontalGroup(
                panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panInfoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(txtAbertura)
                                        .addComponent(txtEntradas)
                                        .addComponent(jLabel5)
                                        .addComponent(txtAberturaHorario)
                                        .addComponent(jLabel7)
                                        .addComponent(txtData)
                                        .addComponent(jLabel9))
                                .addGap(63, 63, 63)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panInfoLayout.createSequentialGroup()
                                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel6)
                                                        .addComponent(txtSaldo)
                                                        .addComponent(txtSaidas)
                                                        .addComponent(txtUsuario)
                                                        .addComponent(txtSit))
                                                .addGap(0, 79, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        panInfoLayout.setVerticalGroup(
                panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panInfoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtAbertura)
                                        .addComponent(txtSaldo))
                                .addGap(29, 29, 29)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtEntradas)
                                        .addComponent(txtSaidas))
                                .addGap(28, 28, 28)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtAberturaHorario)
                                        .addComponent(txtUsuario))
                                .addGap(32, 32, 32)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtData)
                                        .addComponent(txtSit))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botVoltar.setBackground(new java.awt.Color(225, 225, 245));
        botVoltar.setText("VOLTAR");
        botVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVoltarActionPerformed(evt);
            }
        });

        botAcoes.setBackground(new java.awt.Color(225, 225, 245));
        botAcoes.setText("FECHAR CAIXA");
        botAcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAcoesActionPerformed(evt);
            }
        });

        botVerCaixa.setBackground(new java.awt.Color(225, 225, 245));
        botVerCaixa.setText("VER HISTÓRICO");
        botVerCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVerCaixaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(panMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(botAcoes)
                                                .addGap(18, 18, 18)
                                                .addComponent(botVerCaixa)
                                                .addGap(18, 18, 18)
                                                .addComponent(botVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(panInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panMovimentacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botVoltar)
                                        .addComponent(botVerCaixa)
                                        .addComponent(botAcoes))
                                .addContainerGap(35, Short.MAX_VALUE))
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

    private void botAdicionarActionPerformed(java.awt.event.ActionEvent evt) {

        if (!caixa.isSituacao()) {
            DadosMovimentacao tela = new DadosMovimentacao(null, true);

            tela.setSaldo(this.saldo);
            tela.setVisible(true);

            if (tela.isConfirmacao()) {

                Movimentacao m = tela.getMovimentacao();

                novas.add(m);

                atualizarTabela();
            }
        } else {

            JOptionPane.showMessageDialog(this, "Não é possível adicionar novas movimentações pois o caixa está fechado.");
        }


    }

    private void botVerActionPerformed(java.awt.event.ActionEvent evt) {

        int linha = tabMovimentacao.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione uma movimentação para visualizar.");
        } else {
            DadosMovimentacao tela = new DadosMovimentacao(null, true);

            tela.setMovimentacao(movimentacoes.get(linha));
            tela.esconderBotaoConfirmacao();
            tela.setVisible(true);
        }
    }

    private void botVoltarActionPerformed(java.awt.event.ActionEvent evt) {

        this.setVisible(false);

    }


    private void botAcoesActionPerformed(java.awt.event.ActionEvent evt) {

        TelaFecharCaixa tela = new TelaFecharCaixa(null, true);

        tela.setVisible(true);

        if (tela.isFecharCaixa()) {

            this.setVisible(false);
        }
    }

    private void botVerCaixaActionPerformed(java.awt.event.ActionEvent evt) {


        List<Movimentacao> cx = new ArrayList<>(controle.getRelatorio());

        if (!cx.isEmpty()) {

            TelaPeriodo tela = new TelaPeriodo(null, true);

            tela.setVisible(true);
        } else {

            JOptionPane.showMessageDialog(null, "Não há caixas anteriores.");
        }
    }

    public void adicionarMovimentacao(Movimentacao m) {

        caixa.adicionarItem(m);

        this.caixa = controle.fechar(caixa);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAcoes;
    private javax.swing.JButton botAdicionar;
    private javax.swing.JButton botVer;
    private javax.swing.JButton botVerCaixa;
    private javax.swing.JButton botVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panInfo;
    private javax.swing.JPanel panMovimentacao;
    private javax.swing.JTable tabMovimentacao;
    private javax.swing.JLabel txtAbertura;
    private javax.swing.JLabel txtAberturaHorario;
    private javax.swing.JLabel txtData;
    private javax.swing.JLabel txtEntradas;
    private javax.swing.JLabel txtSaidas;
    private javax.swing.JLabel txtSaldo;
    private javax.swing.JLabel txtSit;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}

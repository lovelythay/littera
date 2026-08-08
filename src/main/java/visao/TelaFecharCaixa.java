package visao;

import controle.ControleCaixa;
import modelo.Caixa;
import modelo.Movimentacao;
import modelo.Usuario;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TelaFecharCaixa extends JDialog {

    private final ControleCaixa controle = new ControleCaixa();
    private final Caixa caixa = ControleCaixa.getCaixaAberto();

    private final Date horaFechamento = new Date();

    private final NumberFormat formatar = NumberFormat.getCurrencyInstance();
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat hora = new SimpleDateFormat("HH:mm");

    private double entrada = 0;
    private double saida = 0;
    private double saldo = 0;

    private boolean fecharCaixa;

    private final List<Movimentacao> movimentacoes = new ArrayList<>();

    public TelaFecharCaixa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        movimentacoes.clear();
        movimentacoes.addAll(caixa.getMovimentacoes());

        setCaixa();
        setLocationRelativeTo(null);

        URL url = this.getClass().getResource("/imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        txtFechamento = new javax.swing.JLabel();
        botSaidas = new javax.swing.JButton();
        botEntradas = new javax.swing.JButton();
        botFechar = new javax.swing.JButton();
        botCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LITTERA - Fechar Caixa");
        setPreferredSize(new java.awt.Dimension(700, 638));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(730, 516));

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
        txtAberturaHorario.setText("00:00");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Usuário :");

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtUsuario.setText("Usuário");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Data :");

        txtData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtData.setText("dd/mm/aaaa");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Horário de Abertura :");

        txtFechamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFechamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtFechamento.setText("00:00");

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
                                .addGap(57, 57, 57)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panInfoLayout.createSequentialGroup()
                                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtSaldo)
                                                        .addComponent(txtSaidas)
                                                        .addComponent(txtUsuario)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel6)
                                                        .addComponent(txtFechamento))
                                                .addGap(0, 71, Short.MAX_VALUE)))
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
                                        .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtAberturaHorario)
                                        .addComponent(txtFechamento))
                                .addGap(32, 32, 32)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtData)
                                        .addComponent(txtUsuario))
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        botSaidas.setBackground(new java.awt.Color(225, 225, 245));
        botSaidas.setText("SAÍDAS");
        botSaidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSaidasActionPerformed(evt);
            }
        });

        botEntradas.setBackground(new java.awt.Color(225, 225, 245));
        botEntradas.setText("ENTRADAS");
        botEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEntradasActionPerformed(evt);
            }
        });

        botFechar.setBackground(new java.awt.Color(225, 225, 245));
        botFechar.setText("FECHAR CAIXA");
        botFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botFecharActionPerformed(evt);
            }
        });

        botCancelar.setBackground(new java.awt.Color(225, 225, 245));
        botCancelar.setText("CANCELAR");
        botCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(panInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(botSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(panInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(104, 104, 104)
                                                .addComponent(botEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(botSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(botFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(botCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botSaidasActionPerformed(java.awt.event.ActionEvent evt) {

        List<Movimentacao> saidas = new ArrayList<>();

        saidas.clear();

        for (Movimentacao m : movimentacoes) {

            if (m.getTipo().equals("S")) {

                saidas.add(m);
            }
        }

        if (!saidas.isEmpty()) {

            VerMovimentacoes tela = new VerMovimentacoes(null, true);

            tela.atualizarTabela(saidas);
            tela.setTipo(0);

            tela.setVisible(true);

        } else {

            JOptionPane.showMessageDialog(this, "Não houve saídas.");
        }

    }

    private void botEntradasActionPerformed(java.awt.event.ActionEvent evt) {

        List<Movimentacao> entradas = new ArrayList<>();

        entradas.clear();

        for (Movimentacao m : movimentacoes) {

            if (m.getTipo().equals("E")) {

                entradas.add(m);
            }
        }

        if (!entradas.isEmpty()) {
            VerMovimentacoes tela = new VerMovimentacoes(null, true);

            tela.atualizarTabela(entradas);
            tela.setTipo(1);

            tela.setVisible(true);
        } else {

            JOptionPane.showMessageDialog(this, "Não houve entradas.");
        }
    }

    private void setCaixa() {

        String abertura = formatar.format(caixa.getValorAbertura());

        txtAbertura.setText(abertura);

        String aberturaHora = hora.format(caixa.getHorarioAbertura());
        String fechamentoHora = hora.format(this.horaFechamento);

        txtAberturaHorario.setText(aberturaHora);
        txtFechamento.setText(fechamentoHora);

        Usuario usuario = caixa.getUsuario();
        txtUsuario.setText(usuario.getNome());

        String data = sdf.format(caixa.getData());
        txtData.setText(data);

        for (Movimentacao m : movimentacoes) {

            if (m.getTipo().equals("S")) {

                this.saida = this.saida + m.getValor();

            } else {

                this.entrada = this.entrada + m.getValor();
            }
        }

        this.saldo = caixa.getValorAbertura() + this.entrada - this.saida;

        String entradaString = formatar.format(this.entrada);
        String saidaString = formatar.format(this.saida);
        String saldoString = formatar.format(this.saldo);

        txtEntradas.setText(entradaString);
        txtSaidas.setText(saidaString);
        txtSaldo.setText(saldoString);

    }

    private void botFecharActionPerformed(java.awt.event.ActionEvent evt) {

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja fechar o caixa?", "Fechar Caixa", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_NO_OPTION) {

            caixa.setHorarioFechamento(horaFechamento);
            caixa.setTotalEntrada(entrada);
            caixa.setTotalSaida(saida);
            caixa.setSaldo(saldo);
            caixa.setSituacao(true);

            controle.fechar(caixa);

            JOptionPane.showMessageDialog(null, "Operação finalizada.");

            int res = JOptionPane.showConfirmDialog(null, "Imprimir relatório diário?", "Relatório Caixa Diário", JOptionPane.YES_NO_OPTION);

            if (res == JOptionPane.YES_NO_OPTION) {

                List<Movimentacao> diario = new ArrayList<>(controle.getDiario(caixa));
                try {
                    JasperReport relatorioCompilado
                            = JasperCompileManager.compileReport("src/main/java/relatorio/relatorioCaixaDiario.jrxml");

                    JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null,
                            new JRBeanCollectionDataSource(diario));

                    JDialog tela = new JDialog(this, "Relatório do Caixa Diário", true);
                    tela.setSize(1000, 800);

                    JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);

                    tela.getContentPane().add(painelRelatorio);

                    tela.setLocationRelativeTo(null);
                    tela.setVisible(true);

                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao gerar o relatório.");
                }

            }
            this.fecharCaixa = true;
            this.setVisible(false);

        }

    }

    public boolean isFecharCaixa() {
        return fecharCaixa;
    }

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {

        this.setVisible(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botEntradas;
    private javax.swing.JButton botFechar;
    private javax.swing.JButton botSaidas;
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
    private javax.swing.JPanel panInfo;
    private javax.swing.JLabel txtAbertura;
    private javax.swing.JLabel txtAberturaHorario;
    private javax.swing.JLabel txtData;
    private javax.swing.JLabel txtEntradas;
    private javax.swing.JLabel txtFechamento;
    private javax.swing.JLabel txtSaidas;
    private javax.swing.JLabel txtSaldo;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}

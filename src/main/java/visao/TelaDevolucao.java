package visao;

import modelo.Emprestimo;
import modelo.ItemEmprestimo;
import modelo.Livro;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TelaDevolucao extends javax.swing.JDialog {

    private final List<ItemEmprestimo> itens = new ArrayList<>();

    private final List<ItemEmprestimo> novos = new ArrayList<>();

    private final Date hoje = new Date();

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final NumberFormat formatar = NumberFormat.getCurrencyInstance();

    private double livre = 0;
    private double total = 0;
    private double multa = 0;

    private int mudanca = 0;

    private boolean confirmacao;
    private boolean alterou;

    public TelaDevolucao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);

        tabLivros.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabLivros.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabLivros.getColumnModel().getColumn(2).setPreferredWidth(100);

        txtLivre.setVisible(false);
        labValorLivre.setVisible(false);

        labMulta.setVisible(false);
        txtMulta.setVisible(false);

        this.novos.clear();

        URL url = this.getClass().getResource("/imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    private void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tabLivros.getModel();

        modelo.setRowCount(0);

        for (ItemEmprestimo ie : itens) {

            Livro l = ie.getLivro();

            String dataDevolucao;

            if (ie.isSituacao()) {

                dataDevolucao = sdf.format(ie.getDataReal());

            } else {

                dataDevolucao = "O livro não foi devolvido.";

            }

            String taxa = formatar.format(ie.getPreco());
            modelo.addRow(new Object[]{l.getNome(), dataDevolucao, taxa
            });
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labMulta = new javax.swing.JLabel();
        txtMulta = new javax.swing.JLabel();
        labValorLivre = new javax.swing.JLabel();
        txtLivre = new javax.swing.JLabel();
        labValorTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        botDevolucao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabLivros = new javax.swing.JTable();
        botCancelar = new javax.swing.JButton();
        botConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Littera - Empréstimo");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        labMulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labMulta.setText("Multa :");

        txtMulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMulta.setForeground(new java.awt.Color(255, 0, 0));
        txtMulta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtMulta.setText("0,00");

        labValorLivre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labValorLivre.setText("Valor Livre :");

        txtLivre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtLivre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtLivre.setText("0,00");

        labValorTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labValorTotal.setText("Valor total :");

        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotal.setText("0,00");

        botDevolucao.setBackground(new java.awt.Color(225, 225, 245));
        botDevolucao.setText("DEVOLUÇÃO");
        botDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botDevolucaoActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(labValorTotal)
                                                                        .addComponent(txtTotal))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(labValorLivre)
                                                                        .addComponent(txtLivre))
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(botDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtMulta)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(botConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(30, 30, 30)
                                                                .addComponent(botCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(labMulta))))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labValorTotal)
                                        .addComponent(labValorLivre)
                                        .addComponent(botDevolucao)
                                        .addComponent(labMulta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtLivre)
                                        .addComponent(txtTotal)
                                        .addComponent(txtMulta))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botCancelar)
                                        .addComponent(botConfirmar))
                                .addGap(18, 39, Short.MAX_VALUE))
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

    private void botDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tabLivros.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this, "Selecione um item para devolver.");
        } else {

            ItemEmprestimo ie = itens.get(linha);

            if (!ie.isSituacao()) {

                this.alterou = true;
                this.mudanca++;

                novos.add(ie);
                ie.setDataReal(this.hoje);

                ie.setSituacao(true);

                Emprestimo e = ie.getEmprestimo();

                Date dev = e.getDataDevolucao();

                if (this.hoje.getTime() > dev.getTime()) {

                    int dias = this.calcularDias(e.getDataDevolucao(), this.hoje);

                    ie.setMulta(ie.calcularMulta(dias));

                    this.multa = this.multa + ie.getMulta();
                    this.total = this.total + ie.getMulta();

                    labMulta.setVisible(true);
                    txtMulta.setVisible(true);

                    txtTotal.setText(formatar.format(this.total));
                    txtMulta.setText(formatar.format(this.multa));

                }

                itens.set(linha, ie);

                atualizarTabela();

            } else {

                JOptionPane.showMessageDialog(this, "Esse livro já foi devolvido.");
            }
        }

    }

    private int calcularDias(Date devolucao, Date real) {

        LocalDate dataDevolucao = Instant.ofEpochMilli(devolucao.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate dataReal = Instant.ofEpochMilli(real.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        long dias = ChronoUnit.DAYS.between(dataDevolucao, dataReal);

        return (int) dias;

    }

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {

        for (ItemEmprestimo ie : itens) {

            for (ItemEmprestimo nv : novos) {

                if (ie.equals(nv)) {

                    ie.setSituacao(false);
                }
            }
        }

        this.confirmacao = false;
        this.setVisible(false);


    }

    private void botConfirmarActionPerformed(java.awt.event.ActionEvent evt) {

        if (!this.alterou) {
            JOptionPane.showMessageDialog(this, "Altere a data de devolução de algum item para prosseguir.");
        } else {

            this.confirmacao = true;
            this.setVisible(false);
        }
    }

    public List<ItemEmprestimo> getNovos() {
        return novos;
    }

    public List<ItemEmprestimo> getItens() {
        return itens;
    }

    public int getMudanca() {
        return mudanca;
    }

    public boolean isConfirmacao() {

        return this.confirmacao;
    }

    public void setItens(Emprestimo e) {

        this.livre = e.getValor();
        this.multa = e.getMulta();

        this.total = this.livre + this.multa;
        txtTotal.setText(formatar.format(this.total));

        itens.clear();
        itens.addAll(e.getItens());

        for (ItemEmprestimo ie : itens) {

            if (ie.isSituacao()) {

                this.mudanca++;
            }
        }

        if (this.hoje.getTime() > e.getDataDevolucao().getTime()) {

            labMulta.setVisible(true);
            txtMulta.setVisible(true);

            labValorLivre.setVisible(true);
            txtLivre.setVisible(true);

            txtLivre.setText(formatar.format(this.livre));
            txtMulta.setText(formatar.format(this.multa));

        }

        atualizarTabela();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botConfirmar;
    private javax.swing.JButton botDevolucao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labMulta;
    private javax.swing.JLabel labValorLivre;
    private javax.swing.JLabel labValorTotal;
    private javax.swing.JTable tabLivros;
    private javax.swing.JLabel txtLivre;
    private javax.swing.JLabel txtMulta;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}

package visao;

import modelo.Genero;
import modelo.Livro;

import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class DadosLivro extends javax.swing.JDialog {

    private int codigo;
    private int disp = 0;
    private int qnt = 0;
    private boolean confirmacao;

    private Genero generoSelecionado;
    private String tipo;

    public DadosLivro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        txtGenero.setEditable(false);
        txtFmtPreco.setValue(0.00);
        txtFmtTaxa.setValue(0.00);

        URL url = this.getClass().getResource("/imagens/icon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFmtIsbn = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEditora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        botConfirmar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        botPesquisar = new javax.swing.JButton();
        botCancelar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtPrateleira = new javax.swing.JTextField();
        txtFmtPreco = new javax.swing.JFormattedTextField();
        txtFmtTaxa = new javax.swing.JFormattedTextField();
        txtFmtQuantidade = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LITTERA - Livros");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 0, 36)); // NOI18N
        jLabel1.setText("Livros");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/livro.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nome :   *");

        txtAutor.setBackground(new java.awt.Color(235, 235, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("ISBN :   *");

        txtFmtIsbn.setBackground(new java.awt.Color(235, 235, 255));
        try {
            txtFmtIsbn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#-##-######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFmtIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFmtIsbnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Autor :   *");

        txtNome.setBackground(new java.awt.Color(235, 235, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Editora :   *");

        txtEditora.setBackground(new java.awt.Color(235, 235, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Gênero :   *");

        txtGenero.setBackground(new java.awt.Color(235, 235, 255));

        botConfirmar.setBackground(new java.awt.Color(225, 225, 245));
        botConfirmar.setText("CONFIRMAR");
        botConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botConfirmarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Preço : ");

        cmbTipo.setBackground(new java.awt.Color(235, 235, 255));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Selecione", "Empréstimo", "Venda", "Venda/Empréstimo"}));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Quantidade :   *");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tipo :   *");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Taxa : ");

        jLabel12.setForeground(new java.awt.Color(135, 158, 255));
        jLabel12.setText("* - campos obrigatórios");

        botPesquisar.setBackground(new java.awt.Color(225, 225, 245));
        botPesquisar.setText("PESQUISAR");
        botPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botPesquisarActionPerformed(evt);
            }
        });

        botCancelar.setBackground(new java.awt.Color(225, 225, 245));
        botCancelar.setText("CANCELAR");
        botCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCancelarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Prateleira:   *");

        txtPrateleira.setBackground(new java.awt.Color(235, 235, 255));

        txtFmtPreco.setBackground(new java.awt.Color(235, 235, 255));
        txtFmtPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtFmtTaxa.setBackground(new java.awt.Color(235, 235, 255));
        txtFmtTaxa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtFmtQuantidade.setBackground(new java.awt.Color(235, 235, 255));
        txtFmtQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtFmtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFmtQuantidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botConfirmar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(botCancelar)
                                                .addGap(31, 31, 31))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel6)
                                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtFmtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel10)
                                                                                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel8)
                                                                                        .addComponent(txtFmtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(48, 48, 48)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel11)
                                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(jLabel9)
                                                                                                        .addComponent(txtFmtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(52, 52, 52)
                                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(txtPrateleira, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                        .addComponent(txtFmtTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(botPesquisar))
                                                        .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(99, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFmtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botPesquisar))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrateleira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFmtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFmtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFmtTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botCancelar)
                                        .addComponent(botConfirmar)
                                        .addComponent(jLabel12))
                                .addGap(15, 15, 15))
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

    private void txtFmtIsbnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void botConfirmarActionPerformed(java.awt.event.ActionEvent evt) {

        double preco = ((Number) txtFmtPreco.getValue()).doubleValue();
        double taxa = ((Number) txtFmtTaxa.getValue()).doubleValue();
        int quantidade = ((Number) txtFmtQuantidade.getValue()).intValue();

        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O nome precisa ser informado!");
            txtNome.requestFocus();
        } else if (txtAutor.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "O autor precisa ser informado!");
            txtAutor.requestFocus();
        } else if (txtEditora.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "A editora precisa ser informada!");
            txtEditora.requestFocus();

        } else if (txtFmtIsbn.getText().equals("   - -  -      - ")) {

            JOptionPane.showMessageDialog(this, "O ISBN precisa ser informado!");
            txtFmtIsbn.requestFocus();
        } else if (cmbTipo.getSelectedItem().equals("Selecione")) {

            JOptionPane.showMessageDialog(this, "O tipo deve ser selecionado!");
            cmbTipo.requestFocus();
        } else if (quantidade <= 0) {

            JOptionPane.showMessageDialog(this, "A quantidade deve ser informada!");
            txtFmtQuantidade.requestFocus();
        } else if (cmbTipo.getSelectedItem().equals("Empréstimo") && taxa == 0.00) {

            JOptionPane.showMessageDialog(this, "É necessário que taxa seja informada!");
            txtFmtTaxa.requestFocus();

        } else if (cmbTipo.getSelectedItem().equals("Venda") && preco == 0.00) {

            JOptionPane.showMessageDialog(this, "É necessário que o preço seja informado!");
            txtFmtPreco.requestFocus();

        }
        if (cmbTipo.getSelectedItem().equals("Venda/Empréstimo") && preco == 0.00 || taxa == 0.00 && this.tipo.equals("A")) {

            JOptionPane.showMessageDialog(this, "É necessário que o preço e a taxa  seja informado!");
            if (preco == 0.00) {
                txtFmtPreco.requestFocus();
            } else {
                txtFmtTaxa.requestFocus();
            }

        } else if (txtPrateleira.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "É necessário que a prateleira seja informada!");
            txtPrateleira.requestFocus();
        } else {
            this.confirmacao = true;
            this.setVisible(false);
        }

    }

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void botPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        PesquisarGenero tela = new PesquisarGenero(null, true);

        tela.setVisible(true);

        if (tela.isConfirmacao()) {

            this.generoSelecionado = tela.getGenero();
            txtGenero.setText(generoSelecionado.getNome());
            txtGenero.setEditable(false);
        }
    }

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {

        if (cmbTipo.getSelectedItem().equals("Venda")) {

            this.tipo = "V";
            txtFmtTaxa.setText("0,00");

        } else if (cmbTipo.getSelectedItem().equals("Empréstimo")) {

            this.tipo = "E";
            txtFmtPreco.setText("0,00");
        } else {

            this.tipo = "A";
        }
    }

    private void txtFmtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public Livro getLivro() {

        Livro l = new Livro();

        l.setCodigo(this.codigo);
        l.setAutor(txtAutor.getText());
        l.setEditora(txtEditora.getText());
        l.setGenero(generoSelecionado);
        l.setIsbn(txtFmtIsbn.getText());
        l.setNome(txtNome.getText());

        if (txtFmtPreco.getValue() == "0,00") {

            txtFmtPreco.setValue("");
        }

        if (txtFmtTaxa.getValue() == "0,00") {

            txtFmtTaxa.setValue("");
        }
        l.setPreco(((Number) txtFmtPreco.getValue()).doubleValue());
        l.setTaxa(((Number) txtFmtTaxa.getValue()).doubleValue());
        l.setPrateleira(txtPrateleira.getText());

        int quantidade = ((Number) txtFmtQuantidade.getValue()).intValue();

        l.setQuantidade(quantidade);

        if (this.qnt < quantidade) {
            int d = quantidade - this.qnt;
            l.setQuantidadeDisponivel(this.disp + d);

        } else if (this.qnt > quantidade) {

            int d = this.qnt - quantidade;
            l.setQuantidadeDisponivel(this.disp - d);

        } else {

            l.setQuantidade(this.disp);
        }

        if (quantidade > 0) {
            l.setSituacao(true);
        } else {
            l.setSituacao(false);
        }

        String tipoLivro;

        if (cmbTipo.getSelectedItem().equals("Empréstimo")) {
            tipoLivro = "E";

        } else if (cmbTipo.getSelectedItem().equals("Venda")) {
            tipoLivro = "V";
        } else {
            tipoLivro = "A";
        }

        l.setTipo(tipoLivro);
        l.setAtivo(true);

        return l;
    }

    public void setLivro(Livro l) {

        this.codigo = l.getCodigo();
        txtNome.setText(l.getNome());
        txtAutor.setText(l.getAutor());
        txtEditora.setText(l.getEditora());

        txtFmtIsbn.setText(l.getIsbn());
        txtFmtPreco.setValue(l.getPreco());
        txtFmtTaxa.setValue(l.getTaxa());
        txtPrateleira.setText(l.getPrateleira());

        this.disp = l.getQuantidadeDisponivel();
        this.qnt = l.getQuantidade();

        this.generoSelecionado = l.getGenero();

        txtGenero.setText(generoSelecionado.getNome());
        txtGenero.setEditable(false);

        String tipoLivro;

        txtFmtQuantidade.setValue(l.getQuantidade());

        switch (l.getTipo()) {
            case "V":
                tipoLivro = "Venda";
                break;
            case "E":
                tipoLivro = "Empréstimo";
                break;
            default:
                tipoLivro = "Venda/Empréstimo";
                break;
        }

        cmbTipo.setSelectedItem(tipoLivro);

    }

    public void desabilitar() {

        txtNome.setEditable(false);
        txtAutor.setEditable(false);
        txtFmtIsbn.setEditable(false);
        txtFmtPreco.setEditable(false);
        txtFmtTaxa.setEditable(false);
        txtEditora.setEditable(false);
        txtPrateleira.setEditable(false);
        txtFmtQuantidade.setEditable(false);

        cmbTipo.setEnabled(false);

        botPesquisar.setVisible(false);
        botConfirmar.setVisible(false);

    }

    public boolean isConfirmacao() {
        return confirmacao;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botConfirmar;
    private javax.swing.JButton botPesquisar;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JFormattedTextField txtFmtIsbn;
    private javax.swing.JFormattedTextField txtFmtPreco;
    private javax.swing.JFormattedTextField txtFmtQuantidade;
    private javax.swing.JFormattedTextField txtFmtTaxa;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPrateleira;
    // End of variables declaration//GEN-END:variables
}

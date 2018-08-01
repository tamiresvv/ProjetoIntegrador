/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.CategoriaDAO;
import dao.MedicamentoDAO;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.ObjCategoria;
import model.ObjMedicamento;

/**
 *
 * @author 181710089
 */
public class FrmMedicamento extends javax.swing.JInternalFrame {

    private ObjMedicamento medicamento;
    private List<ObjCategoria> listaDeCategorias;
    private boolean novo;
    

    /**
     * Creates new form FrmMedicamento
     */

    public FrmMedicamento() {
        initComponents();
        carregarCategorias();
        lblCodigo.setText("");
        novo = true;

    }

    public FrmMedicamento(int codigo) {
        initComponents();
        carregarCategorias();
        medicamento = MedicamentoDAO.getMedicamentoByCodigo(codigo);
        carregarFormulario();
        novo = false;
    }

    private void carregarCategorias() {
        List<ObjCategoria> listaDeCategorias = CategoriaDAO.getCategorias();
        ObjCategoria fake = new ObjCategoria(0, "Selecione...");
        listaDeCategorias.add(0, fake);

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (ObjCategoria cid : listaDeCategorias) {
            modelo.addElement(cid);
        }
        cmbCategoria.setModel(modelo);
    }

    private void carregarFormulario() {
        String qtd = "" + medicamento.getQuantidade();
        qtd = qtd.replace(".", ",");
        txtQuantidade.setText(qtd);

        txtNome.setText(medicamento.getNome());

        lblCodigo.setText(String.valueOf(medicamento.getCodigo()));
        
        int contCategorias = cmbCategoria.getModel().getSize();
        for (int i = 1; i < contCategorias; i++) {
            ObjCategoria cat = listaDeCategorias.get(i);
            if (cat.getCodigo() == medicamento.getCategoria().getCodigo()) {
                cmbCategoria.setSelectedIndex(i);
                break;
            }
        }

        int dia = medicamento.getData_de_vencimento().getDate();
        int mes = medicamento.getData_de_vencimento().getMonth() + 1;
        int ano = medicamento.getData_de_vencimento().getYear();

        String sdia = "" + dia;
        if (dia < 10) {
            sdia = "0" + dia;
        }

        String smes = "" + mes;
        if (mes < 10) {
            sdia = "0" + mes;
        }

        txtDataVencimento.setText(sdia + "/" + smes + "/" + ano);
        
        
        
        dia = medicamento.getData_de_cadastro().getDate();
        mes = medicamento.getData_de_cadastro().getMonth() + 1;
        ano = medicamento.getData_de_cadastro().getYear();

        sdia = "" + dia;
        if (dia < 10) {
            sdia = "0" + dia;
        }

        smes = "" + mes;
        if (mes < 10) {
            sdia = "0" + mes;
        }

        txtDataCadastro.setText(sdia + "/" + smes + "/" + ano);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDataCadastro = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDataVencimento = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Medicamentos");

        jPanel1.setBackground(new java.awt.Color(227, 225, 225));
        jPanel1.setForeground(new java.awt.Color(162, 197, 197));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setText("Código:");

        lblCodigo.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblCodigo.setText("000");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel3.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel4.setText("Quantidade:");

        txtQuantidade.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel5.setText("Data de Cadastro:");

        try {
            txtDataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**/**/****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataCadastro.setToolTipText("");
        txtDataCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataCadastroActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel6.setText("Data de Vencimento:");

        try {
            txtDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**/**/****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataVencimento.setToolTipText("");
        txtDataVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataVencimentoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel7.setText("Tipo:");

        cmbCategoria.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Calibri Light", 0, 15)); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpar.setFont(new java.awt.Font("Calibri Light", 0, 15)); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(104, 104, 104)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCodigo)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(34, 34, 34)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtDataCadastro)
                                    .addGap(225, 225, 225))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblCodigo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnSalvar))
                .addGap(70, 70, 70))
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

    private void txtDataCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataCadastroActionPerformed

    private void txtDataVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataVencimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataVencimentoActionPerformed

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged


    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        String nome = txtNome.getText();
        String quantidade = txtQuantidade.getText();
        String data_cadastro = txtDataCadastro.getText();
        String data_vencimento = txtDataVencimento.getText();
        ObjCategoria categoria = (ObjCategoria) cmbCategoria.getSelectedItem();
        if (nome.isEmpty() || categoria.getCodigo() == 0) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios ! (Nome e Categoria)");
        } else {
            ObjMedicamento med = new ObjMedicamento();
            med.setNome(nome);
            if (!quantidade.isEmpty()) {
                quantidade = quantidade.replace(",", ".");
                double q = Double.valueOf(quantidade);
                med.setQuantidade(q);
            }
            int dia = Integer.valueOf(data_cadastro.substring(0, 2));
            int mes = Integer.valueOf(data_cadastro.substring(3, 5));
            int ano = Integer.valueOf(data_cadastro.substring(6, 10));

            Date cadastro = new Date(ano, (mes - 1), dia);

            dia = Integer.valueOf(data_vencimento.substring(0, 2));
            mes = Integer.valueOf(data_vencimento.substring(3, 5));
            ano = Integer.valueOf(data_vencimento.substring(6, 10));

            Date vencimento = new Date(ano, (mes - 1), dia);

            med.setData_de_cadastro(cadastro);
            med.setData_de_vencimento(vencimento);

            med.setCategoria(categoria);
            MedicamentoDAO.inserir(med);

            limparFormulario();
            if(!novo){
        this.dispose();
    }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed
    private void limparFormulario() {
        txtNome.setText("");
        txtQuantidade.setText("");
        txtDataCadastro.setText("");
        txtDataVencimento.setText("");
        cmbCategoria.setSelectedIndex(0);
    }
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        limparFormulario();

    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JFormattedTextField txtDataCadastro;
    private javax.swing.JFormattedTextField txtDataVencimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}

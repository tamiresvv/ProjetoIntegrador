/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.MedicamentoDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ObjMedicamento;

/**
 *
 * @author 181710089
 */
public class ListMedicamentos extends javax.swing.JInternalFrame {

    private JDesktopPane painelTelaInicial;
    /**
     * Creates new form ListMedicamentos
     */
    public ListMedicamentos(JDesktopPane painelTelaInicial) {
        initComponents();
        this.painelTelaInicial = painelTelaInicial;
        carregarTabela();            
    }
    
    public void carregarTabela(){
        DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = { "Código" , "Nome", "Quantidade", "Cadastro", "Vencimento", "Categoria","Situação"};
        modelo.setColumnIdentifiers(colunas);
        List<ObjMedicamento> lista = MedicamentoDAO.getMedicamentos();
  
        
        for(ObjMedicamento pro : lista ){
            
            Calendar h = Calendar.getInstance(); 
            Date hoje = new Date(h.get(Calendar.YEAR),h.get(Calendar.MONTH),h.get(Calendar.DAY_OF_MONTH));
            
            int dias = pro.getData_de_vencimento().compareTo(hoje); 
            String situacao = "";
            if(dias < 0) { 
                situacao = "VENCIDO"; 
            }
            if(dias ==0) {
                situacao = "VENCE HOJE";  
            }
            
    
            int dia = pro.getData_de_vencimento().getDate(); 
            int mes = pro.getData_de_vencimento().getMonth() + 1; 

            String sdia = "" + dia;
            if (dia < 10) {
                sdia = "0" + dia;
            }

            String smes = "" + mes;
            if (mes < 10) {
                smes = "0" + mes;
            }
            
                String vencimento = sdia+"/"+smes+"/"+pro.getData_de_vencimento().getYear();
            
            
            dia = pro.getData_de_cadastro().getDate();
            mes = pro.getData_de_cadastro().getMonth() + 1;
            sdia = "" + dia;
            if (dia < 10) {
                sdia = "0" + dia;
            }
            smes = "" + mes;
            if (mes < 10) {
                smes = "0" + mes;
            }
            String cadastro = sdia+"/"+smes+"/"+pro.getData_de_cadastro().getYear();
            
            Object[] obj = { 
                pro.getCodigo(), 
                pro.getNome(),
                pro.getQuantidade(),
                cadastro,
                vencimento,
                pro.getCategoria().getNome() ,
                situacao
            };
            
            modelo.addRow(obj);
        }
        tableMedicamentos.setModel(modelo);
        
        
        
        
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMedicamentos = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Medicamentos");

        jPanel1.setBackground(new java.awt.Color(230, 227, 227));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setText("Medicamentos Cadastrados:");

        tableMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableMedicamentos);

        btnExcluir.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        int linha = tableMedicamentos.getSelectedRow(); 
      if ( linha == -1) { 
          JOptionPane.showMessageDialog(this, "Você deve selecionar um medicamento!");
      }else{  
          String nome = (String) tableMedicamentos.getValueAt(linha, 1);
          int resposta = JOptionPane.showConfirmDialog(this, "Confirma a exclusão do medicamento selecionado" + nome + "?", "Excluir Medicamento", JOptionPane.YES_NO_OPTION); 
           if( resposta == JOptionPane.YES_OPTION) { 
               ObjMedicamento cid = new ObjMedicamento(); 
          int codigo =(int) tableMedicamentos.getModel().getValueAt(linha, 0);
          cid.setCodigo(codigo); 
               MedicamentoDAO.excluir(cid);   
          carregarTabela(); 
           } 
      }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        int linha = tableMedicamentos.getSelectedRow();
        if( linha == -1 ){
            JOptionPane.showMessageDialog(this, "Você deve selecionar um medicamento!");
        }else{
            int codigo = (int) tableMedicamentos.getValueAt(linha, 0);
            FrmMedicamento tela = new FrmMedicamento(codigo, this);
            this.painelTelaInicial.add(tela);
            tela.setVisible(true);
            
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMedicamentos;
    // End of variables declaration//GEN-END:variables
}

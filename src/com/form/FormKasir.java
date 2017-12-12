package com.form;

import com.koneksi.UserID;
import com.model.model_kasir;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


public class FormKasir extends javax.swing.JFrame {
    public DefaultTableModel tbl;
    String header[] = {"ID", "Kode Barang", "Nama Barang", "Harga", "Jumlah", "Total"};
    model_kasir model = new model_kasir();
    
    String ID = UserID.getUserLogin();
    
    public FormKasir() throws SQLException {
        initComponents();
        tbl = new DefaultTableModel(null, header);
        tblKasir.setModel(tbl);
        tblKasir.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        model.Tanggal(this);
        model.AutoNomor(this);
        model.AutoNomorKode(this);
        setLebarKolom();
        txtid_transaksi2.setVisible(false);
        txtkode_barang.requestFocus();
        txttotal.setText("0");
        this.getRootPane().setDefaultButton(btnOK);
        txtnama_kasir.setText(ID);
    }
    
    public void setColomnWidth(int kolom){
        DefaultTableColumnModel dt = (DefaultTableColumnModel) tblKasir.getColumnModel();
        TableColumn kolomtabel = dt.getColumn(kolom);
        int lebar = 0;
        int margin = 10;
        int a;
        
        TableCellRenderer render = kolomtabel.getHeaderRenderer();
        if (render == null) {
            render = tblKasir.getTableHeader().getDefaultRenderer();
        }
        Component kompo = render.getTableCellRendererComponent(tblKasir, kolomtabel.getHeaderValue(), false, false, 0, 0);
        lebar = kompo.getPreferredSize().width;
        for (a = 0; a < tblKasir.getRowCount(); a++) {
            render = tblKasir.getCellRenderer(a, kolom);
            kompo = render.getTableCellRendererComponent(tblKasir, tblKasir.getValueAt(a, kolom), false, false, a, kolom);
            int lebarKolom = kompo.getPreferredSize().width;
            lebar = Math.max(lebar, lebarKolom);
        }lebar = lebar + margin;
        kolomtabel.setPreferredWidth(lebar);
    }
    
    public void setLebarKolom(){
        int a;
        for (a = 0; a < tblKasir.getColumnCount(); a++) {
            setColomnWidth(a);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        txtid_transaksi = new javax.swing.JTextField();
        txtnama_kasir = new javax.swing.JTextField();
        txtkode_barang = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKasir = new javax.swing.JTable();
        txttotal = new javax.swing.JTextField();
        txtbayar = new javax.swing.JTextField();
        txtkembali = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txttotal2 = new javax.swing.JTextField();
        txtkode_transaksi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtid_transaksi2 = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        txtTanggal = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Toko Pendowo - Kasir");
        setResizable(false);

        txtid_transaksi.setEditable(false);
        txtid_transaksi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtnama_kasir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtkode_barang.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtkode_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkode_barangActionPerformed(evt);
            }
        });
        txtkode_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkode_barangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtkode_barangKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtkode_barangKeyTyped(evt);
            }
        });

        txtnama.setEditable(false);
        txtnama.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtharga.setEditable(false);
        txtharga.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txthargaKeyReleased(evt);
            }
        });

        txtjumlah.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahActionPerformed(evt);
            }
        });
        txtjumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtjumlahKeyReleased(evt);
            }
        });

        btnOK.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        tblKasir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblKasir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKasirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKasir);

        txttotal.setEditable(false);
        txttotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtbayar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbayarActionPerformed(evt);
            }
        });

        txtkembali.setEditable(false);
        txtkembali.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkembaliActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("TOTAL");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("BAYAR");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("KEMBALI");

        txttotal2.setEditable(false);
        txttotal2.setFont(new java.awt.Font("Tahoma", 0, 70)); // NOI18N

        txtkode_transaksi.setEditable(false);
        txtkode_transaksi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ID Transaksi");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Kode Transaksi");

        txtid_transaksi2.setEditable(false);

        btnCari.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        txtTanggal.setEditable(false);
        txtTanggal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("KEMBALI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(34, 34, 34)
                                .addComponent(txtid_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtkode_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(txtid_transaksi2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnama_kasir, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(txtTanggal)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtkode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txttotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(83, 83, 83))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(59, 59, 59)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(txtbayar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtkembali, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtid_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtid_transaksi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCari)
                        .addComponent(btnHapus)
                        .addComponent(jButton1))
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkode_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtkode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txttotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtbayar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtkembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txttotal2)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        try {
            model.Simpan(this);
        } catch (SQLException ex) {
            Logger.getLogger(FormKasir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void txtkode_barangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkode_barangKeyTyped
        
    }//GEN-LAST:event_txtkode_barangKeyTyped

    private void txtjumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlahKeyReleased
        
    }//GEN-LAST:event_txtjumlahKeyReleased

    private void txtkode_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkode_barangActionPerformed
        try {
            model.ScanBarcode(this);
        } catch (Exception ex) {
            Logger.getLogger(FormKasir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtkode_barangActionPerformed

    private void txtbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbayarActionPerformed
        try {
            model.Kembalian(this);
            model.CetakStruk(this);
        } catch (Exception ex) {
            Logger.getLogger(FormKasir.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dispose();
        }
    }//GEN-LAST:event_txtbayarActionPerformed

    private void txtkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkembaliActionPerformed
        
    }//GEN-LAST:event_txtkembaliActionPerformed

    private void tblKasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKasirMouseClicked
        try {
            model.KlikTabel(this);
        } catch (Exception ex) {
            Logger.getLogger(FormKasir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblKasirMouseClicked

    private void txthargaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthargaKeyReleased
        try {
            model.Simpan(this);
            
        } catch (SQLException ex) {
            Logger.getLogger(FormKasir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txthargaKeyReleased

    private void txtjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahActionPerformed
        try {
            model.UbahJumlah(this);
        } catch (Exception ex) {
            Logger.getLogger(FormKasir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtjumlahActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        try {
            new FormCariBarang().show();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            model.Hapus(this);
        } catch (Exception ex) {
            Logger.getLogger(FormKasir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FormMenuAwal().show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtkode_barangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkode_barangKeyReleased
        try {
            if (txtkode_barang.getText().equals("+")) {
                tblKasir.requestFocus();
                int lastRow = tblKasir.convertRowIndexToView(tbl.getRowCount()-1);
                tblKasir.setRowSelectionInterval(lastRow,lastRow);
                model.KlikTabel(this);
            }
        } catch (Exception ex) {
            Logger.getLogger(FormKasir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtkode_barangKeyReleased

    private void txtkode_barangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkode_barangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_END) {
            txtbayar.requestFocus();
        }
    }//GEN-LAST:event_txtkode_barangKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormKasir().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormKasir.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    public static javax.swing.JButton btnOK;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    public javax.swing.JTable tblKasir;
    public javax.swing.JTextField txtTanggal;
    public static javax.swing.JTextField txtbayar;
    public static javax.swing.JTextField txtharga;
    public javax.swing.JTextField txtid_transaksi;
    public javax.swing.JTextField txtid_transaksi2;
    public static javax.swing.JTextField txtjumlah;
    public static javax.swing.JTextField txtkembali;
    public static javax.swing.JTextField txtkode_barang;
    public javax.swing.JTextField txtkode_transaksi;
    public static javax.swing.JTextField txtnama;
    public javax.swing.JTextField txtnama_kasir;
    public static javax.swing.JTextField txttotal;
    public static javax.swing.JTextField txttotal2;
    // End of variables declaration//GEN-END:variables
}

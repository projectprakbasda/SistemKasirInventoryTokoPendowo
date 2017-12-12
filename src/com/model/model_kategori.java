package com.model;

import com.koneksi.koneksi;
import com.form.FormKategori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.method.interface_kategori;


public class model_kategori implements interface_kategori {

    @Override
    public void Simpan(FormKategori ktg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "insert kategori values (?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, ktg.txtid_kategori.getText());
            prepare.setString(2, ktg.txtnama_kategori.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(ktg);
            ktg.setLebarKolom();
            Bersih(ktg);
            AutoNomor(ktg);
        }
    }

    @Override
    public void Ubah(FormKategori ktg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "update kategori set nama = ? where id_kategori = ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, ktg.txtnama_kategori.getText());
            prepare.setString(2, ktg.txtid_kategori.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(ktg);
            ktg.setLebarKolom();
            Bersih(ktg);
            AutoNomor(ktg);
        }
    }

    @Override
    public void Hapus(FormKategori ktg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "delete from kategori where id_kategori = ?";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, ktg.txtid_kategori.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(ktg);
            ktg.setLebarKolom();
            Bersih(ktg);
            AutoNomor(ktg);
        }
    }

    @Override
    public void Tampil(FormKategori ktg) throws SQLException {
        ktg.tbl.getDataVector().removeAllElements();
        ktg.tbl.fireTableDataChanged();
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select * from kategori order by id_kategori asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] ob = new Object[8];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ktg.tbl.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Bersih(FormKategori ktg) throws SQLException {
        ktg.txtid_kategori.setText(null);
        ktg.txtnama_kategori.setText(null);
        ktg.txtnama_kategori.requestFocus();
    }

    @Override
    public void KlikTabel(FormKategori ktg) throws SQLException {
        try {
            int pilih = ktg.tblKategori.getSelectedRow();
            if (pilih == -1) {
                return;
            }
            ktg.txtid_kategori.setText(ktg.tbl.getValueAt(pilih, 0).toString());
            ktg.txtnama_kategori.setText(ktg.tbl.getValueAt(pilih, 1).toString());
        } catch (Exception e) {
        } finally {
            ktg.txtnama_kategori.requestFocus();
        }
    }

    @Override
    public void AutoNomor(FormKategori ktg) throws SQLException {
         try{
            Connection con = koneksi.getKoneksi();
            
            Statement st = con.createStatement();
            String sql = "select max(id_kategori) from kategori";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int a = rs.getInt(1);
                ktg.txtid_kategori.setText(""+ Integer.toString(a+1));
            }
        }catch (Exception e){
            System.out.println(""+ e.getMessage());
        }
    }
        
}

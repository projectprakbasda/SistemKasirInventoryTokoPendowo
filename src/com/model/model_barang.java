package com.model;

import com.koneksi.koneksi;
import com.form.FormBarang;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import com.method.interface_barang;

public class model_barang implements interface_barang {

    @Override
    public void Simpan(FormBarang brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "insert barang values(?,?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);

            prepare.setString(1, brg.txtkode_barang.getText());
            prepare.setString(2, brg.txtnama.getText());
            prepare.setString(3, brg.txtid_kategori.getText());
            prepare.setString(4, brg.txtharga.getText());

            prepare.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(brg);
            brg.setLebarKolom();
            Bersih(brg);
        }
    }

    @Override
    public void Ubah(FormBarang brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "update barang set nama = ?, "
                    + "id_kategori = ?, "
                    + "harga = ? "
                    + "where kode_barang = ?";
            PreparedStatement prepare = con.prepareStatement(sql);

            prepare.setString(1, brg.txtnama.getText());
            prepare.setString(2, brg.txtid_kategori.getText());
            prepare.setString(3, brg.txtharga.getText());

            prepare.setString(4, brg.txtkode_barang.getText());
            prepare.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(brg);
            brg.setLebarKolom();
            Bersih(brg);
        }
    }

    @Override
    public void Hapus(FormBarang brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "delete from barang where kode_barang = ?";
            PreparedStatement prepare = con.prepareStatement(sql);

            prepare.setString(1, brg.txtkode_barang.getText());
            prepare.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasi Dihapus");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(brg);
            brg.setLebarKolom();
            Bersih(brg);
        }
    }

    @Override
    public void Tampil(FormBarang brg) throws SQLException {
        brg.tbl.getDataVector().removeAllElements();
        brg.tbl.fireTableDataChanged();
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select * from barang order by kode_barang asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] ob = new Object[8];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getString(3);
                ob[3] = rs.getString(4);

                brg.tbl.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Bersih(FormBarang brg) {
        brg.txtkode_barang.setText(null);
        brg.txtnama.setText(null);
        brg.cmbkategori.setSelectedItem("Kategori");
        brg.txtid_kategori.setText(null);
        brg.txtharga.setText(null);

        brg.txtkode_barang.requestFocus();
    }

    @Override
    public void KlikTabel(FormBarang brg) throws SQLException {
        try {
            int pilih = brg.tblBarang.getSelectedRow();
            String s = (String) brg.tblBarang.getModel().getValueAt(pilih, 3);

            if (pilih == -1) {
                return;
            }
            brg.txtkode_barang.setText(brg.tbl.getValueAt(pilih, 0).toString());
            brg.txtnama.setText(brg.tbl.getValueAt(pilih, 1).toString());
            brg.txtid_kategori.setText(brg.tbl.getValueAt(pilih, 2).toString());
            brg.txtharga.setText(brg.tbl.getValueAt(pilih, 3).toString());

        } catch (Exception e) {
        }
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select nama from kategori where id_kategori = '" + brg.txtid_kategori.getText() + "'";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Object[] ob = new Object[3];
                ob[1] = rs.getString(1);

                brg.cmbkategori.setSelectedItem(rs.getString("nama"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void Combo(FormBarang brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select nama from kategori";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Object[] ob = new Object[3];
                ob[1] = rs.getString(1);

                brg.cmbkategori.addItem((String) ob[1]);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void Cari(FormBarang brg) throws SQLException {
        brg.tbl.getDataVector().removeAllElements();
        brg.tbl.fireTableDataChanged();
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select * from barang where nama like '%" + brg.txtCari.getText() + "%'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] ob = new Object[8];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getString(3);
                ob[3] = rs.getString(4);

                brg.tbl.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Combo2(FormBarang brg) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();
            String sql = "select id_kategori from kategori where nama = '" + brg.cmbkategori.getSelectedItem() + "'";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Object[] ob = new Object[3];
                ob[1] = rs.getString(1);

                brg.txtid_kategori.setText(rs.getString("id_kategori"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        }
    }
}

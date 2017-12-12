package com.method;

import com.form.FormPembelian;
import java.sql.SQLException;


public interface interface_pembelian {
    public void Simpan (FormPembelian pmbl) throws SQLException;
    public void Hapus (FormPembelian pmbl) throws SQLException;
    public void Tampil (FormPembelian pmbl) throws SQLException;
    public void KlikTabel (FormPembelian pmbl) throws SQLException;
    public void Bersih (FormPembelian pmbl) throws SQLException;
    public void Combo1 (FormPembelian pmbl) throws SQLException;
    public void Combo2 (FormPembelian pmbl) throws SQLException;
    public void Combo3 (FormPembelian pmbl) throws SQLException;
    public void Combo4 (FormPembelian pmbl) throws SQLException;
    public void AutoNomor (FormPembelian pmbl) throws SQLException;
}

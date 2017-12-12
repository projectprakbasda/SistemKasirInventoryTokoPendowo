package com.method;

import com.form.FormPembalian;
import java.sql.SQLException;


public interface controller_pembelian {
    public void Simpan (FormPembalian pmbl) throws SQLException;
    public void Hapus (FormPembalian pmbl) throws SQLException;
    public void Tampil (FormPembalian pmbl) throws SQLException;
    public void KlikTabel (FormPembalian pmbl) throws SQLException;
    public void Bersih (FormPembalian pmbl) throws SQLException;
    public void Combo1 (FormPembalian pmbl) throws SQLException;
    public void Combo2 (FormPembalian pmbl) throws SQLException;
    public void Combo3 (FormPembalian pmbl) throws SQLException;
    public void Combo4 (FormPembalian pmbl) throws SQLException;
    public void AutoNomor (FormPembalian pmbl) throws SQLException;
}

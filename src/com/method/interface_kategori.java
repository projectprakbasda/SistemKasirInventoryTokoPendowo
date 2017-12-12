package com.method;

import com.form.FormKategori;
import java.sql.SQLException;


public interface interface_kategori {
    public void Simpan (FormKategori ktg) throws SQLException;
    public void Ubah (FormKategori ktg) throws SQLException;
    public void Hapus (FormKategori ktg) throws SQLException;
    public void Tampil (FormKategori ktg) throws SQLException;
    public void Bersih (FormKategori ktg) throws SQLException;
    public void KlikTabel (FormKategori ktg) throws SQLException;
    public void AutoNomor (FormKategori ktg) throws SQLException;
}

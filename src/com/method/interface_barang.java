package com.method;

import com.form.FormBarang;
import java.sql.SQLException;

public interface interface_barang {
    public void Simpan(FormBarang brg) throws SQLException;
    public void Ubah (FormBarang brg) throws SQLException;
    public void Hapus(FormBarang brg) throws SQLException;
    public void Tampil (FormBarang brg) throws SQLException;
    public void Bersih(FormBarang brg) throws SQLException;
    public void KlikTabel (FormBarang brg) throws SQLException;
    public void Combo (FormBarang brg) throws SQLException;
    public void Combo2 (FormBarang brg) throws SQLException;
    public void Cari (FormBarang brg) throws SQLException;
}

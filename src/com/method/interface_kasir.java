package com.method;

import com.form.FormKasir;
import java.sql.SQLException;


public interface interface_kasir {
    public void Simpan (FormKasir ksr) throws SQLException;
    public void Ubah (FormKasir ksr) throws SQLException;
    public void Hapus (FormKasir ksr) throws SQLException;
    public void Tampil (FormKasir ksr) throws SQLException;
    public void KlikTabel (FormKasir ksr) throws SQLException;
    public void Bersih (FormKasir ksr) throws SQLException;
    public void Tanggal (FormKasir ksr) throws SQLException;
    public void ScanBarcode (FormKasir ksr) throws SQLException;
    public void AutoNomor (FormKasir ksr) throws SQLException;
    public void AutoNomorKode (FormKasir ksr) throws SQLException;
    public void Total (FormKasir ksr) throws SQLException;
    public void Kembalian (FormKasir ksr) throws SQLException;
    public void UbahJumlah (FormKasir ksr) throws SQLException;
    public void CetakStruk (FormKasir ksr) throws SQLException;
}

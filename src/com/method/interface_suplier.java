package com.method;

import com.form.FormSuplier;
import java.sql.SQLException;


public interface interface_suplier {
    public void Simpan (FormSuplier spl) throws SQLException;
    public void Ubah (FormSuplier spl) throws SQLException;
    public void Hapus (FormSuplier spl) throws SQLException;
    public void Tampil (FormSuplier spl) throws SQLException;
    public void Bersih (FormSuplier spl) throws SQLException;
    public void KlikTabel (FormSuplier spl) throws SQLException;
    public void AutoNomor (FormSuplier spl) throws SQLException;
}

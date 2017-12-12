package com.method;

import com.form.FormFaktur;
import java.sql.SQLException;


public interface interface_faktur {
    public void Simpan (FormFaktur fkt) throws SQLException;
    public void Hapus (FormFaktur fkt) throws SQLException;
    public void Tampil (FormFaktur fkt) throws SQLException;
    public void Bersih(FormFaktur fkt) throws SQLException;
    public void KlikTabel (FormFaktur fkt) throws SQLException;
    public void Tanggal (FormFaktur fkt) throws SQLException;
    public void AutoNomor (FormFaktur fkt) throws SQLException;
}

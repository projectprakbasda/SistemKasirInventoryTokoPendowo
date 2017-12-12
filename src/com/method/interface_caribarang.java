package com.method;

import com.form.FormCariBarang;
import java.sql.SQLException;


public interface interface_caribarang {
    public void Tampil (FormCariBarang cb) throws SQLException;
    public void KlikTabel (FormCariBarang cb) throws SQLException;
    public void Cari (FormCariBarang cb) throws SQLException;
}

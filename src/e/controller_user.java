package com.method;

import com.form.FormUser;
import java.sql.SQLException;


public interface controller_user {
    public void Simpan (FormUser usr) throws SQLException;
    public void Ubah (FormUser usr) throws SQLException;
    public void Hapus (FormUser usr) throws SQLException;
    public void Tampil (FormUser usr) throws SQLException;
    public void Bersih (FormUser usr) throws SQLException;
    public void KlikTabel (FormUser usr) throws SQLException;
    public void AutoNomor (FormUser usr) throws SQLException;
    
}

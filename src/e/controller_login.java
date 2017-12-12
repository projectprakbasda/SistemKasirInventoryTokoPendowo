package com.method;

import com.form.FormLogin;
import java.sql.SQLException;


public interface controller_login {
    public void Login (FormLogin lgn) throws SQLException;
    public void Bersih (FormLogin lgn) throws SQLException;
}

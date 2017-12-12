package com.model;

import com.koneksi.UserID;
import com.koneksi.koneksi;
import com.form.FormLogin;
import com.form.FormMenuAwal;
import com.form.FormKasir;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.method.interface_login;

public class model_login implements interface_login {

    @Override
    public void Login(FormLogin lgn) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            Statement st = con.createStatement();

            String user = lgn.txtusername.getText();
            System.out.println("u " + user);
            String pass = lgn.txtpassword.getText();
            System.out.println(pass);
            String sql = "SELECT * FROM user where username='" + user + "' and password = '" + pass + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                UserID.setUserLogin(lgn.txtusername.getText());
                if (rs.getString(4).equalsIgnoreCase("admin")) {
                    new FormMenuAwal().show();
                    lgn.dispose();
                } else if (rs.getString(4).equalsIgnoreCase("kasir")) {
                    new FormKasir().show();
                    lgn.dispose();
                } else {
                    JOptionPane.showMessageDialog(lgn, "Password Salah");
                    Bersih(lgn);
                }
            } else {
                JOptionPane.showMessageDialog(lgn, "Username Belum Terdaftar");
                Bersih(lgn);
                lgn.txtusername.requestFocus();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void Bersih(FormLogin lgn) throws SQLException {
        lgn.txtusername.setText(null);
        lgn.txtpassword.setText(null);
        lgn.txtusername.requestFocus();
    }
}

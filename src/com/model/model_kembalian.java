package com.model;

import com.form.FormKembalian;
import com.form.FormKasir;
import java.sql.SQLException;
import com.method.interface_kembalian;


public class model_kembalian implements interface_kembalian {

    @Override
    public void Bersih(FormKembalian kmbl) throws SQLException {        
        kmbl.dispose();
        FormKasir.txttotal.setText(null);
        FormKasir.txttotal2.setText(null);
        FormKasir.txtbayar.setText(null);
        FormKasir.txtkembali.setText(null);
        new FormKasir().show();
    }   
}

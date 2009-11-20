package upc.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import upc.data.AccessJDBCUtil;

/**
 *
 * @author pablo.sierralta
 */
public class ControlData {

    public List getCliente() {
        List lstCliente = null;


        return lstCliente;
    }

    public List getProveedor() {
        List lstProveedor = null;


        return lstProveedor;
    }

    public boolean guadarCliente() {
        Connection conn = null;
        Statement stm = null;

        try {
            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();

            stm.executeUpdate("Cliente");

            stm.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }


    }
}

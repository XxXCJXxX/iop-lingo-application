package upc.control;

import upc.data.Proveedor;
import upc.data.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import upc.data.AccessJDBCUtil;

/**
 *
 * @author pablo.sierralta
 */
public class ControlData {

    public Vector getCliente() {
        Vector lstCliente = null;
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from cliente");

            lstCliente = new Vector();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int demanda = rs.getInt("demanda");
                lstCliente.add(new Cliente(nombre, demanda));
            }

            return lstCliente;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                stm.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public Vector getClienteArray() {
        Vector data = getCliente();
        Vector result = new Vector();
        for (int i = 0; i < data.size(); i ++) {
            Vector temp = new Vector();
            temp.add(((Cliente)data.get(i)).getNombre());
            temp.add(((Cliente)data.get(i)).getDemanda());
            result.add(temp);
        }        
        return result;
    }

    public Vector getProveedorArray() {
        Vector data = getProveedor();
        Vector result = new Vector();
        for (int i = 0; i < data.size(); i ++) {
            Vector temp = new Vector();
            temp.add(((Proveedor)data.get(i)).getNombre());
            temp.add(((Proveedor)data.get(i)).getCapacidad());
            result.add(temp);
        }
        return result;
    }

    public Vector getProveedor() {
        Vector lstProveedor = null;
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();

            rs = stm.executeQuery("select * from proveedor");

            lstProveedor = new Vector();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int demanda = rs.getInt("capacidad");
                lstProveedor.add(new Proveedor(nombre, demanda));
            }

            return lstProveedor;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                stm.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean guadarCliente() {
        Connection conn = null;
        Statement stm = null;

        try {
            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();

            int val = stm.executeUpdate("update cliente set nombre = 'C1' where nombre = 'C6'");

            return val > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                stm.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

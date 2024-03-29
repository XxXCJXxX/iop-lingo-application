package upc.control;

import upc.data.Unidad;
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

    public Vector<Unidad> getUnidad() {
        Vector<Unidad> lstUnidad = null;
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from unidad");
            lstUnidad = new Vector<Unidad>();

            while (rs.next()) {
                String nombre = rs.getString("nombreUnidad");
                String abrev = rs.getString("abrevUnidad");
                lstUnidad.add(new Unidad(nombre, abrev));
            }

            return lstUnidad;
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

    public Vector getParametroUnidad() {
        Vector<ParametroUnidad> lstUnidad = null;
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select nombreUnidad, abrevUnidad, parametro from test");
            lstUnidad = new Vector<ParametroUnidad>();

            while (rs.next()) {
                String nombre = rs.getString("nombreUnidad");
                String abrev = rs.getString("abrevUnidad");
                Double inputEmpleado = rs.getDouble("parametro");
                rs.next();
                Double inputMercados = rs.getDouble("parametro");
                rs.next();
                Double outputVentasPersonas = rs.getDouble("parametro");
                rs.next();
                Double outputVentasNegocios = rs.getDouble("parametro");
                lstUnidad.add(new ParametroUnidad(nombre, abrev, inputEmpleado, inputMercados, outputVentasPersonas, outputVentasNegocios));
            }

            return lstUnidad;
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

    public Vector<Resultado> getResultado() {
        Vector<Resultado> lstResultado = null;
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from resultado");
            lstResultado = new Vector<Resultado>();

            while (rs.next()) {
                String dmu = rs.getString("dmu");
                Double score = rs.getDouble("score");
                lstResultado.add(new Resultado(dmu, score));
            }

            return lstResultado;
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

    public Vector<Object> getArregloUnidad() {
        Vector<Unidad> data = getUnidad();
        Vector result = new Vector();
        for (int i = 0; i < data.size(); i++) {
            Vector<Object> temp = new Vector<Object>();
            temp.add((data.get(i)).getNombreUnidad());
            temp.add((data.get(i)).getAbrevUnidad());
            result.add(temp);
        }
        return result;
    }

    public Vector<Object> getArregloUnidadParametro() {
        Vector<ParametroUnidad> data = getParametroUnidad();
        Vector result = new Vector();
        for (int i = 0; i < data.size(); i++) {
            Vector<Object> temp = new Vector<Object>();
            temp.add((data.get(i)).getNombreUnidad());
            temp.add((data.get(i)).getAbrevUnidad());
            temp.add((data.get(i)).getInputEmpleado());
            temp.add((data.get(i)).getInputMercados());
            temp.add((data.get(i)).getOutputVentasPersonas());
            temp.add((data.get(i)).getOutputVentasNegocios());
            result.add(temp);
        }
        return result;
    }

    public boolean guardarUnidad(Vector<Unidad> lstUnidad) {
        Connection conn = null;
        Statement stm = null;
        try {
            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();
            
            for (int i = 0; i < lstUnidad.size(); i++) {
                Unidad beanUnidad = lstUnidad.get(i);
                
                
                StringBuilder builder = new StringBuilder();
                builder.append("insert into Unidad(nombreUnidad, abrevUnidad) ");
                builder.append("values ('");
                builder.append(beanUnidad.getNombreUnidad());
                builder.append("','");
                builder.append(beanUnidad.getAbrevUnidad());
                builder.append("');");

                System.out.println(builder.toString());
                stm.executeUpdate(builder.toString());
            }
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
        return true;
    }

    public boolean limpiarUnidad() {
        Connection conn = null;
        Statement stm = null;
        try {
            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();
            StringBuilder builder = new StringBuilder();
            builder.append("delete from unidad");
            return stm.executeUpdate(builder.toString()) > 0;

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

    public boolean eliminarUnidad(String nombre) {
        Connection conn = null;
        Statement stm = null;

        try {
            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();
            StringBuilder builder = new StringBuilder();
            builder.append("delete from unidad where nombreUnidad = '");
            builder.append(nombre);
            builder.append("'");
            return stm.executeUpdate(builder.toString()) > 0;

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

    public boolean crearEspacioResultado(int rowCount) {
        Connection conn = null;
        Statement stm = null;

        try {
            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();
            stm.executeUpdate("delete from Resultado");

            int cant = 0;
            for (int i = 0; i < rowCount; i++) {
                cant += stm.executeUpdate("insert into Resultado values (null,null);");
            }
            return cant == rowCount;

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

    public Vector<Object> getArregloResultado() {
        Vector<Resultado> data = getResultado();
        Vector result = new Vector();
        for (int i = 0; i < data.size(); i++) {
            Vector<Object> temp = new Vector<Object>();
            temp.add((data.get(i)).getDmu());
            temp.add((data.get(i)).getScore());
            result.add(temp);
        }
        return result;
    }

    public boolean guardarParametroUnidad(Vector<ParametroUnidad> lstUnidad) {
        Connection conn = null;
        Statement stm = null;
        try {

            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();

            for (int i = 0; i < lstUnidad.size(); i++) {
                ParametroUnidad beanUnidad = lstUnidad.get(i);
                
                StringBuilder builder = new StringBuilder();
                builder.append("insert into Test(nombreUnidad, abrevUnidad, parametro) values ('");
                builder.append(beanUnidad.getNombreUnidad());
                builder.append("','");
                builder.append(beanUnidad.getAbrevUnidad());
                builder.append("',");
                builder.append(beanUnidad.getInputEmpleado());
                builder.append(");");
                stm.executeUpdate(builder.toString());

                builder = new StringBuilder();
                builder.append("insert into Test(nombreUnidad, abrevUnidad, parametro) values ('");
                builder.append(beanUnidad.getNombreUnidad());
                builder.append("','");
                builder.append(beanUnidad.getAbrevUnidad());
                builder.append("',");
                builder.append(beanUnidad.getInputMercados());
                builder.append(");");
                stm.executeUpdate(builder.toString());

                builder = new StringBuilder();
                builder.append("insert into Test(nombreUnidad, abrevUnidad, parametro) values ('");
                builder.append(beanUnidad.getNombreUnidad());
                builder.append("','");
                builder.append(beanUnidad.getAbrevUnidad());
                builder.append("',");
                builder.append(beanUnidad.getOutputVentasPersonas());
                builder.append(");");
                stm.executeUpdate(builder.toString());

                builder = new StringBuilder();
                builder.append("insert into Test(nombreUnidad, abrevUnidad, parametro) values ('");
                builder.append(beanUnidad.getNombreUnidad());
                builder.append("','");
                builder.append(beanUnidad.getAbrevUnidad());
                builder.append("',");
                builder.append(beanUnidad.getOutputVentasNegocios());
                builder.append(");");
                stm.executeUpdate(builder.toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                stm.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    public boolean limpiarParametroUnidad() {
        Connection conn = null;
        Statement stm = null;
        try {
            conn = AccessJDBCUtil.getAccessDBConnection();
            stm = conn.createStatement();
            StringBuilder builder = new StringBuilder();
            builder.append("delete from test");
            return stm.executeUpdate(builder.toString()) > 0;

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

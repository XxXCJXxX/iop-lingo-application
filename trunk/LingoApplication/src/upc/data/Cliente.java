/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.data;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usd32902
 */
public class Cliente implements Serializable {

    private String nombre;
    private int demanda;

    public Cliente() {
    }

    public Cliente(String nombre, int demanda) {
        this.nombre = nombre;
        this.demanda = demanda;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the demanda
     */
    public int getDemanda() {
        return demanda;
    }

    /**
     * @param demanda the demanda to set
     */
    public void setDemanda(int demanda) {
        this.demanda = demanda;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Object[] showAttributeNames() {
        List<String> list = new ArrayList<String>();
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.getModifiers() == Modifier.PRIVATE
                    && field.getModifiers() != Modifier.TRANSIENT) {
                System.out.println(field.getName());
                list.add(field.getName());
            }
        }

        return list.toArray();
    }

    public Object[] showAttributesValues() {
        List list = new ArrayList();
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {
            String name = method.getName();
            if (name.startsWith("get")) {
                try {
                    Object data = method.invoke(this, new Object[0]);
                    list.add(data);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return list.toArray();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public int hashCode() {
        return nombre.hashCode() + Integer.toString(demanda).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cliente) {
            return obj.hashCode() == this.hashCode();
        } else {
            return false;
        }
    }
}

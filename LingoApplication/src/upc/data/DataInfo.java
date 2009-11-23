/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.data;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Vector;

/**
 *
 * @author usd32902
 */
public class DataInfo {

    private static Field[] fields = null;
    /*
    public static Object[] toStrings(String name) {
    try {
    List<Object> list = new ArrayList<Object>();
    fields = Class.forName(name).getFields();
    for (Field field : fields) {
    if (field.getModifiers() == Modifier.PRIVATE && field.getModifiers() != Modifier.TRANSIENT) {
    System.out.println(field.getName());
    list.add(field.getName());
    }
    }
    return (String[]) list.toArray();
    } catch (ClassNotFoundException ex) {
    ex.printStackTrace();
    return null;
    }
     */

    public static Vector toStrings(String name) {
        try {
            Vector<Object> list = new Vector<Object>();
            fields = Class.forName(name).getDeclaredFields();
            for (Field field : fields) {
                if (field.getModifiers() == Modifier.PRIVATE && field.getModifiers() != Modifier.TRANSIENT) {
                    System.out.println(field.getName());
                    list.add(field.getName());
                }
            }
            return list;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String[] arg) {

        Vector data = toStrings(Cliente.class.getName());
        System.out.println(Cliente.class.getName() + " - " + data.toString());

        Cliente cli = new Cliente("aaa ", 12312312);

        Object[] dataaaa = cli.showAttributesValues();
        for (Object object : dataaaa) {
            System.out.println(object);
        }
    }
}

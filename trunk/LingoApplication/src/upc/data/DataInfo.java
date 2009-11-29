package upc.data;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Vector;

/**
 *
 * @author pablo.sierralta
 */
public class DataInfo {

    private static Field[] fields = null;

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
        /*
        Vector data = toStrings(Cliente.class.getName());
        System.out.println(Cliente.class.getName() + " - " + data.toString());

        Cliente cli = new Cliente("aaa ", 12312312);

        Object[] dataaaa = cli.showAttributesValues();
        for (Object object : dataaaa) {
        System.out.println(object);
        }
         */

        Runtime run4 = Runtime.getRuntime();
        try {
            run4.exec("C:\\Program Files\\Microsoft Office\\Office12\\EXCEL.exe E:\\LingoApplication\\DEAMOD.xls");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("5\n");
        }
    }
}

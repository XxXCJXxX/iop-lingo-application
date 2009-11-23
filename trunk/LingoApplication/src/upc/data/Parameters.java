package upc.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author pablo.sierralta
 */
public final class Parameters {

    private static Properties parameter = null;

    private Parameters() {
    }

    public static Properties fillInstance(Properties defaults) {

        if (parameter == null) {
            parameter = new Properties(defaults);
        }
        return parameter;
    }

    public static Properties fillInstance(FileInputStream stream) throws IOException {
        if (parameter == null) {
            parameter = new Properties();
            parameter.load(new FileInputStream(new File("base.ini")));
        }
        return parameter;
    }

    public static Properties getInstance() {
        return parameter;
    }

    public static String getProperty(String key) {
        return parameter.getProperty(key);
    }

}

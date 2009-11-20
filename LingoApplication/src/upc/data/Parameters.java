package upc.data;

import java.util.List;
import java.util.Properties;
import org.jdesktop.application.ResourceMap;
import upc.view.LingoApplication;

/**
 *
 * @author pablo.sierralta
 */
public final class Parameters {
    private static Properties parameter = null;

    public static void fillParameters(List<String> bundleNames) {
        if (parameter == null) {
            parameter = new Properties(parameter);
        }    }

    public  Parameters() {
        ResourceMap resourceMap = LingoApplication.getInstance(upc.view.LingoApplication.class).getContext().getResourceMap(Parameters.class);
        System.out.println("getResourcesDir " + resourceMap.getResourcesDir());
        System.out.println("getBundleNames " + resourceMap.getBundleNames());
        System.out.println("resourceMap2 " + resourceMap.getString("StatusBar.busyAnimationRate"));
        System.out.println("resourceMap2 " + resourceMap.getString("Application.database.user"));
        System.out.println("resourceMap2 " + resourceMap.getString("Application.database.path"));
        System.out.println("resourceMap2 " + resourceMap.getString("Parameter.database.path"));
    }

    public static void fillParameters(Properties defaults) {
        if (parameter == null) {
            parameter = new Properties(defaults);
        }
    }

    public static String getProperty(String key) {
        return parameter.getProperty(key);
    }

}

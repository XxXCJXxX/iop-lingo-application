/*
 * LingoApplication.java
 */
package upc.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import upc.data.Parameters;

/**
 * The main class of the application.
 */
public class LingoApplication extends SingleFrameApplication {

    static {

        try {
            System.loadLibrary("Lingj11");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {
        try {
            Parameters.fillInstance(new FileInputStream(new File("base.ini")));
            System.out.println(Parameters.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        show(new LingoView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of LingoApplication
     */
    public static LingoApplication getApplication() {
        return Application.getInstance(LingoApplication.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(LingoApplication.class, args);
    }
}

/*
 * LingoApplication.java
 */
package upc.view;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFrame;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import upc.data.Parameters;

/**
 * The main class of the application.
 * @author pablo.sierralta
 */
public class LingoApplication extends SingleFrameApplication {

    static {
        try {
            System.loadLibrary("Lingj11");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    private java.util.Hashtable view;
    private Object actualView;

    public void setActualView(String type, Object view) {
        this.view.put(type, view);
    }

    public void setActualView(Object actualView) {
        this.actualView = actualView;
    }

    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {
        try {
            Parameters.fillInstance(new FileInputStream(new File("base.ini")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        LingoView lingoView = new LingoView(this);
        show(lingoView.getFrame());
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow(java.awt.Window root) {
        //System.out.println(this.getClass() + " " + root);
        //System.out.println(this.getClass() + " " + root.getParent());
        if (root instanceof javax.swing.JFrame) {
             javax.swing.JFrame mainFrame = (JFrame) root;
        mainFrame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }
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

    @Action()
    public void returnFrame() {
        if (actualView != null) {
            ((java.awt.Window) actualView).setVisible(false);
        }
    }
}

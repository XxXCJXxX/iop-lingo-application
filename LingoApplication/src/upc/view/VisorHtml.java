package upc.view;


import javax.swing.*;
import java.net.*;
import java.io.*;
import javax.swing.text.html.*;
import javax.swing.event.*;

public class VisorHtml extends JScrollPane {

    JEditorPane html = new JEditorPane();

    public VisorHtml(JPanel padre) {
        try {
            URL url = null;
            String path = null;
            try {
                path = "/index.html";
                url = getClass().getResource(path);
            } catch (Exception e) {
                System.err.println("Error al abrir " + path);
                url = null;
            }
            if (url != null) {
                html.setPage(url);
                html.addHyperlinkListener(createHyperLinkListener());
                JViewport vp = this.getViewport();
                vp.add(html);
            }
        } catch (MalformedURLException e) {
            System.out.println("URL incorrecta: " + e);
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }
    }

    public HyperlinkListener createHyperLinkListener() {
        return new HyperlinkListener() {

            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    if (e instanceof HTMLFrameHyperlinkEvent) {
                        ((HTMLDocument) html.getDocument()).processHTMLFrameHyperlinkEvent((HTMLFrameHyperlinkEvent) e);
                    } else {
                        try {
                            html.setPage(e.getURL());
                        } catch (IOException ioe) {
                            System.out.println("Error E/S: " + ioe);
                        }
                    }
                }
            }
        };
    }
}
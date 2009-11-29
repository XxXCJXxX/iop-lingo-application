package upc.control;

import com.lindo.Lingd11;
import upc.data.Parameters;

/**
 *
 * @author pablo.sierralta
 */
public class ControlLingo {

    /**
     *
     * @param lingoFile     E:\\Trabajo IOP\\FINAL.lng
     * @param resultFile    E:\\Trabajo IOP\\FINAL.xls
     * @param logFile
     * @return
     */
    public boolean showExcelReport(String resultFile) {
        boolean result = false;

        try {
            Runtime run = Runtime.getRuntime();
            run.exec(Parameters.getProperty("application.excel") + " " + resultFile);
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        } finally {
            return result;
        }
    }

    /**
     *
     * @param lingoFile     E:\\Trabajo IOP\\FINAL.lng
     * @param resultFile    E:\\Trabajo IOP\\FINAL.xls
     * @param logFile
     * @return
     */
    public boolean executeLingoFile(String lingoFile, String logFile) {
        try {
            Object pnLngEnv = Lingd11.LScreateEnvLng();
            int nErr = Lingd11.LSopenLogFileLng(pnLngEnv, logFile);
            if (pnLngEnv == null) {
                System.out.println("***Unable to create Lingo environment***");
                return false;
            }
            String sScript = "SET ECHOIN 1\n";
            sScript += "TAKE " + lingoFile + "\n";
            sScript += "LOOK ALL\n";
            sScript += "GO\n";
            sScript += "QUIT\n";
            nErr = Lingd11.LSexecuteScriptLng(pnLngEnv, sScript);
            if (nErr != 0) {
                System.out.println("***LSexecuteScriptLng error***: ");
                return false;
            }
            nErr = Lingd11.LScloseLogFileLng(pnLngEnv);
            if (nErr != 0) {
                System.out.println("***LScloseLogFileLng() error***: ");
                return false;
            }
            nErr = Lingd11.LSdeleteEnvLng(pnLngEnv);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

package upc.data;

/**
 *
 * @author pablo.sierralta
 */
public class Unidad {

    private String nombreUnidad;
    private String abrevUnidad;

    public Unidad(String nombreUnidad, String abrevUnidad) {
        this.nombreUnidad = nombreUnidad;
        this.abrevUnidad = abrevUnidad;
    }

    /**
     * @return the nombreUnidad
     */
    public String getNombreUnidad() {
        return nombreUnidad;
    }

    /**
     * @param nombreUnidad the nombreUnidad to set
     */
    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    /**
     * @return the abrevUnidad
     */
    public String getAbrevUnidad() {
        return abrevUnidad;
    }

    /**
     * @param abrevUnidad the abrevUnidad to set
     */
    public void setAbrevUnidad(String abrevUnidad) {
        this.abrevUnidad = abrevUnidad;
    }
}
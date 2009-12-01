/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.control;

/**
 *
 * @author usd32902
 */
public class ParametroUnidad {

    private String nombreUnidad;
    private String abrevUnidad;
    private Double inputEmpleado;
    private Double inputMercados;
    private Double outputVentasPersonas;
    private Double outputVentasNegocios;

    public ParametroUnidad(String nombreUnidad, String abrevUnidad, Double inputEmpleado, Double inputMercados, Double outputVentasPersonas, Double outputVentasNegocios) {
        this.nombreUnidad = nombreUnidad;
        this.abrevUnidad = abrevUnidad;
        this.inputEmpleado = inputEmpleado;
        this.inputMercados = inputMercados;
        this.outputVentasPersonas = outputVentasPersonas;
        this.outputVentasNegocios = outputVentasNegocios;
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

    /**
     * @return the inputEmpleado
     */
    public Double getInputEmpleado() {
        return inputEmpleado;
    }

    /**
     * @param inputEmpleado the inputEmpleado to set
     */
    public void setInputEmpleado(Double inputEmpleado) {
        this.inputEmpleado = inputEmpleado;
    }

    /**
     * @return the inputMercados
     */
    public Double getInputMercados() {
        return inputMercados;
    }

    /**
     * @param inputMercados the inputMercados to set
     */
    public void setInputMercados(Double inputMercados) {
        this.inputMercados = inputMercados;
    }

    /**
     * @return the outputVentasPersonas
     */
    public Double getOutputVentasPersonas() {
        return outputVentasPersonas;
    }

    /**
     * @param outputVentasPersonas the outputVentasPersonas to set
     */
    public void setOutputVentasPersonas(Double outputVentasPersonas) {
        this.outputVentasPersonas = outputVentasPersonas;
    }

    /**
     * @return the outputVentasNegocios
     */
    public Double getOutputVentasNegocios() {
        return outputVentasNegocios;
    }

    /**
     * @param outputVentasNegocios the outputVentasNegocios to set
     */
    public void setOutputVentasNegocios(Double outputVentasNegocios) {
        this.outputVentasNegocios = outputVentasNegocios;
    }

    
}

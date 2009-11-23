/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upc.data;

/**
 *
 * @author usd32902
 */
public class Proveedor {

    private String nombre;
    private int capacidad;

    public Proveedor(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the demanda
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param demanda the demanda to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}

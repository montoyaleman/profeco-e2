/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Esta clase representa una empresa con sus atributos básicos.
 *
 * @author Usuario
 */
public class Empresa {

    /** Identificador único de la empresa. */
    private int idEmpresa;

    /** Nombre de la empresa. */
    private String nombre;

    /** Tipo de negocio al que se dedica la empresa. */
    private String tipoNegocio;

    /**
     * Obtiene el identificador único de la empresa.
     *
     * @return El identificador único de la empresa.
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Establece el identificador único de la empresa.
     *
     * @param idEmpresa El nuevo identificador único de la empresa.
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * Obtiene el nombre de la empresa.
     *
     * @return El nombre de la empresa.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la empresa.
     *
     * @param nombre El nuevo nombre de la empresa.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo de negocio de la empresa.
     *
     * @return El tipo de negocio de la empresa.
     */
    public String getTipoNegocio() {
        return tipoNegocio;
    }

    /**
     * Establece el tipo de negocio de la empresa.
     *
     * @param tipoNegocio El nuevo tipo de negocio de la empresa.
     */
    public void setTipoNegocio(String tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
    }
}

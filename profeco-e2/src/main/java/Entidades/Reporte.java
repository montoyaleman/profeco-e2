/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 * Esta clase representa un reporte con sus atributos básicos.
 *
 * @author Usuario
 */
public class Reporte {

    /** Identificador único del reporte. */
    private int idReporte;

    /** Fecha de creación del reporte. */
    private Date fechaCreacion;

    /** Identificador de la empresa asociada al reporte. */
    private int idEmpresa;

    /** Identificador del usuario que creó el reporte. */
    private int idUsuario;

    /** Descripción del contenido del reporte. */
    private String descripcion;

    /** Estado actual del reporte. */
    private String estado;

    /**
     * Obtiene el identificador único del reporte.
     *
     * @return El identificador único del reporte.
     */
    public int getIdReporte() {
        return idReporte;
    }

    /**
     * Establece el identificador único del reporte.
     *
     * @param idReporte El nuevo identificador único del reporte.
     */
    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    /**
     * Obtiene la fecha de creación del reporte.
     *
     * @return La fecha de creación del reporte.
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Establece la fecha de creación del reporte.
     *
     * @param fechaCreacion La nueva fecha de creación del reporte.
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Obtiene el identificador de la empresa asociada al reporte.
     *
     * @return El identificador de la empresa.
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Establece el identificador de la empresa asociada al reporte.
     *
     * @param idEmpresa El nuevo identificador de la empresa.
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * Obtiene el identificador del usuario que creó el reporte.
     *
     * @return El identificador del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario que creó el reporte.
     *
     * @param idUsuario El nuevo identificador del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene la descripción del contenido del reporte.
     *
     * @return La descripción del reporte.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del contenido del reporte.
     *
     * @param descripcion La nueva descripción del reporte.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el estado actual del reporte.
     *
     * @return El estado del reporte.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del reporte.
     *
     * @param estado El nuevo estado del reporte.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Esta clase representa un producto con sus atributos básicos.
 *
 * @author Usuario
 */
public class Producto {

    /** Identificador único del producto. */
    private int idProducto;

    /** Identificador de la empresa a la que pertenece el producto. */
    private int idEmpresa;

    /** Nombre del producto. */
    private String nombre;

    /** Descripción del producto. */
    private String descripcion;

    /** Precio del producto. */
    private double precio;

    /** Indica si el producto está en oferta. */
    private boolean oferta;

    /** Etiquetas asociadas al producto. */
    private String etiquetas;

    /**
     * Obtiene el identificador único del producto.
     *
     * @return El identificador único del producto.
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el identificador único del producto.
     *
     * @param idProducto El nuevo identificador único del producto.
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Obtiene el identificador de la empresa a la que pertenece el producto.
     *
     * @return El identificador de la empresa.
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Establece el identificador de la empresa a la que pertenece el producto.
     *
     * @param idEmpresa El nuevo identificador de la empresa.
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return La descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     *
     * @param descripcion La nueva descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Indica si el producto está en oferta.
     *
     * @return true si el producto está en oferta, false en caso contrario.
     */
    public boolean isOferta() {
        return oferta;
    }

    /**
     * Establece si el producto está en oferta.
     *
     * @param oferta true si el producto está en oferta, false en caso contrario.
     */
    public void setOferta(boolean oferta) {
        this.oferta = oferta;
    }

    /**
     * Obtiene las etiquetas asociadas al producto.
     *
     * @return Las etiquetas del producto.
     */
    public String getEtiquetas() {
        return etiquetas;
    }

    /**
     * Establece las etiquetas asociadas al producto.
     *
     * @param etiquetas Las nuevas etiquetas del producto.
     */
    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }
}

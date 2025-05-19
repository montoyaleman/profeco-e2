/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Esta clase representa un usuario con sus atributos básicos.
 *
 * @author Usuario
 */
public class Usuario {

    /** Identificador único del usuario. */
    private int idUsuario;

    /** Nombres del usuario. */
    private String nombres;

    /** Apellido paterno del usuario. */
    private String apellidoPaterno;

    /** Apellido materno del usuario. */
    private String apellidoMaterno;

    /** Contraseña del usuario. */
    private String password;

    /** Correo electrónico del usuario. */
    private String email;

    /** Indica si el usuario es administrador. */
    private boolean isAdmin;

    /** Identificador de la empresa a la que pertenece el usuario. */
    private int idEmpresa;

    /**
     * Obtiene el identificador único del usuario.
     *
     * @return El identificador único del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param idUsuario El nuevo identificador único del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene los nombres del usuario.
     *
     * @return Los nombres del usuario.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del usuario.
     *
     * @param nombres Los nuevos nombres del usuario.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno del usuario.
     *
     * @return El apellido paterno del usuario.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del usuario.
     *
     * @param apellidoPaterno El nuevo apellido paterno del usuario.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del usuario.
     *
     * @return El apellido materno del usuario.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del usuario.
     *
     * @param apellidoMaterno El nuevo apellido materno del usuario.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password La nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El nuevo correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Indica si el usuario es administrador.
     *
     * @return true si el usuario es administrador, false en caso contrario.
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * Establece si el usuario es administrador.
     *
     * @param isAdmin true si el usuario es administrador, false en caso contrario.
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * Obtiene el identificador de la empresa a la que pertenece el usuario.
     *
     * @return El identificador de la empresa.
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Establece el identificador de la empresa a la que pertenece el usuario.
     *
     * @param idEmpresa El nuevo identificador de la empresa.
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}

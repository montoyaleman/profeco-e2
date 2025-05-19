package com.mycompany.profeco.e2;

import Pantallas.Login;

/**
 * Esta clase contiene el método principal para iniciar la aplicación.
 * Crea una instancia de la pantalla de inicio de sesión y la hace visible.
 */
public class main {

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este contexto).
     */
    public static void main(String[] args) {
        // Crea una instancia de la pantalla de inicio de sesión.
        Login a = new Login();

        // Hace visible la pantalla de inicio de sesión.
        a.setVisible(true);
    }
}

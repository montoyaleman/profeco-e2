package DAOs;

import Entidades.Usuario;
import java.util.List;

/**
 *
 * @author José Iván Vázquez Brambila
 */
public class UsuarioDAOTest {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Prueba para obtenerUsuarios
        testObtenerUsuarios(usuarioDAO);

        // Prueba para obtenerUsuarioPorId
        testObtenerUsuarioPorId(usuarioDAO);

        // Prueba para crearUsuario
        testCrearUsuario(usuarioDAO);

        // Prueba para actualizarUsuario
        testActualizarUsuario(usuarioDAO);

        // Prueba para eliminarUsuario
        testEliminarUsuario(usuarioDAO);
    }

    private static void testObtenerUsuarios(UsuarioDAO usuarioDAO) {
        System.out.println("Probando obtenerUsuarios...");
        List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();
        if (usuarios != null && !usuarios.isEmpty()) {
            System.out.println("Prueba obtenerUsuarios: PASADA");
        } else {
            System.out.println("Prueba obtenerUsuarios: FALLIDA");
        }
    }

    private static void testObtenerUsuarioPorId(UsuarioDAO usuarioDAO) {
        System.out.println("Probando obtenerUsuarioPorId...");
        int idUsuarioExistente = 2; // Asegúrate de que este ID exista en tu base de datos
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(idUsuarioExistente);
        if (usuario != null && usuario.getIdUsuario() == idUsuarioExistente) {
            System.out.println("Prueba obtenerUsuarioPorId: PASADA");
        } else {
            System.out.println("Prueba obtenerUsuarioPorId: FALLIDA");
        }
    }

    private static void testCrearUsuario(UsuarioDAO usuarioDAO) {
        System.out.println("Probando crearUsuario...");
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombres("Juanesx");
        nuevoUsuario.setApellidoPaterno("Perez");
        nuevoUsuario.setApellidoMaterno("Gomez");
        nuevoUsuario.setEmail("juanx.perez@example.com");
        nuevoUsuario.setPassword("password123");
        nuevoUsuario.setIsAdmin(false);

        usuarioDAO.crearUsuario(nuevoUsuario);
        Usuario usuarioCreado = usuarioDAO.obtenerUsuarioPorId(nuevoUsuario.getIdUsuario());
        if (usuarioCreado != null && "Juan".equals(usuarioCreado.getNombres())) {
            System.out.println("Prueba crearUsuario: PASADA");
        } else {
            System.out.println("Prueba crearUsuario: FALLIDA");
        }
    }

    private static void testActualizarUsuario(UsuarioDAO usuarioDAO) {
        System.out.println("Probando actualizarUsuario...");
        int idUsuarioExistente = 2; // Asegúrate de que este ID exista en tu base de datos
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(idUsuarioExistente);
        if (usuario != null) {
            usuario.setNombres("Juan Actualizado");
            usuarioDAO.actualizarUsuario(usuario);
            Usuario usuarioActualizado = usuarioDAO.obtenerUsuarioPorId(idUsuarioExistente);
            if ("Juan Actualizado".equals(usuarioActualizado.getNombres())) {
                System.out.println("Prueba actualizarUsuario: PASADA");
            } else {
                System.out.println("Prueba actualizarUsuario: FALLIDA");
            }
        } else {
            System.out.println("Prueba actualizarUsuario: FALLIDA - Usuario no encontrado");
        }
    }

    private static void testEliminarUsuario(UsuarioDAO usuarioDAO) {
        System.out.println("Probando eliminarUsuario...");
        int idUsuarioExistente = 2; // Asegúrate de que este ID exista en tu base de datos
        usuarioDAO.eliminarUsuario(idUsuarioExistente);
        Usuario usuarioEliminado = usuarioDAO.obtenerUsuarioPorId(idUsuarioExistente);
        if (usuarioEliminado == null) {
            System.out.println("Prueba eliminarUsuario: PASADA");
        } else {
            System.out.println("Prueba eliminarUsuario: FALLIDA");
        }
    }
}

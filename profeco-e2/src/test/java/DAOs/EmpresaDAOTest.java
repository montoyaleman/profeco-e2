package DAOs;

import Entidades.Empresa;
import java.util.List;

/**
 *
 * @author José Iván Vázquez Brambila
 */
public class EmpresaDAOTest {

    public static void main(String[] args) {
        EmpresaDAO empresaDAO = new EmpresaDAO();

        // Prueba para obtenerEmpresas
        testObtenerEmpresas(empresaDAO);

        // Prueba para obtenerEmpresaPorId
        testObtenerEmpresaPorId(empresaDAO);

        // Prueba para crearEmpresa
        testCrearEmpresa(empresaDAO);

        // Prueba para actualizarEmpresa
        testActualizarEmpresa(empresaDAO);

        // Prueba para eliminarEmpresa
        testEliminarEmpresa(empresaDAO);
    }

    private static void testObtenerEmpresas(EmpresaDAO empresaDAO) {
        System.out.println("Probando obtenerEmpresas...");
        List<Empresa> empresas = empresaDAO.obtenerEmpresas();
        if (empresas != null && !empresas.isEmpty()) {
            System.out.println("Prueba obtenerEmpresas: PASADA");
        } else {
            System.out.println("Prueba obtenerEmpresas: FALLIDA");
        }
    }

    private static void testObtenerEmpresaPorId(EmpresaDAO empresaDAO) {
        System.out.println("Probando obtenerEmpresaPorId...");
        int idEmpresaExistente = 1; // Asegúrate de que este ID exista en tu base de datos
        Empresa empresa = empresaDAO.obtenerEmpresaPorId(idEmpresaExistente);
        if (empresa != null && empresa.getIdEmpresa() == idEmpresaExistente) {
            System.out.println("Prueba obtenerEmpresaPorId: PASADA");
        } else {
            System.out.println("Prueba obtenerEmpresaPorId: FALLIDA");
        }
    }

    private static void testCrearEmpresa(EmpresaDAO empresaDAO) {
        System.out.println("Probando crearEmpresa...");
        Empresa nuevaEmpresa = new Empresa();
        nuevaEmpresa.setNombre("Empresa Ejemplo");
        nuevaEmpresa.setTipoNegocio("Tecnología");

        empresaDAO.crearEmpresa(nuevaEmpresa);
        Empresa empresaCreada = empresaDAO.obtenerEmpresaPorId(nuevaEmpresa.getIdEmpresa());
        if (empresaCreada != null && "Empresa Ejemplo".equals(empresaCreada.getNombre())) {
            System.out.println("Prueba crearEmpresa: PASADA");
        } else {
            System.out.println("Prueba crearEmpresa: FALLIDA");
        }
    }

    private static void testActualizarEmpresa(EmpresaDAO empresaDAO) {
        System.out.println("Probando actualizarEmpresa...");
        int idEmpresaExistente = 1; // Asegúrate de que este ID exista en tu base de datos
        Empresa empresa = empresaDAO.obtenerEmpresaPorId(idEmpresaExistente);
        if (empresa != null) {
            empresa.setNombre("Empresa Actualizada");
            empresaDAO.actualizarEmpresa(empresa);
            Empresa empresaActualizada = empresaDAO.obtenerEmpresaPorId(idEmpresaExistente);
            if ("Empresa Actualizada".equals(empresaActualizada.getNombre())) {
                System.out.println("Prueba actualizarEmpresa: PASADA");
            } else {
                System.out.println("Prueba actualizarEmpresa: FALLIDA");
            }
        } else {
            System.out.println("Prueba actualizarEmpresa: FALLIDA - Empresa no encontrada");
        }
    }

    private static void testEliminarEmpresa(EmpresaDAO empresaDAO) {
        System.out.println("Probando eliminarEmpresa...");
        int idEmpresaExistente = 1; // Asegúrate de que este ID exista en tu base de datos
        empresaDAO.eliminarEmpresa(idEmpresaExistente);
        Empresa empresaEliminada = empresaDAO.obtenerEmpresaPorId(idEmpresaExistente);
        if (empresaEliminada == null) {
            System.out.println("Prueba eliminarEmpresa: PASADA");
        } else {
            System.out.println("Prueba eliminarEmpresa: FALLIDA");
        }
    }
}


package DAOs;

import Entidades.Reporte;
import java.util.Date;
import java.util.List;

/**
 *
 * @author José Iván Vázquez Brambila
 */
public class ReporteDAOTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ReporteDAO reporteDAO = new ReporteDAO();

        // Prueba para obtenerReportes
        testObtenerReportes(reporteDAO);

        // Prueba para obtenerReportePorId
        testObtenerReportePorId(reporteDAO);

        // Prueba para crearReporte
        testCrearReporte(reporteDAO);

        // Prueba para actualizarReporte
        testActualizarReporte(reporteDAO);

        // Prueba para eliminarReporte
        testEliminarReporte(reporteDAO);
    }

    private static void testObtenerReportes(ReporteDAO reporteDAO) {
        System.out.println("Probando obtenerReportes...");
        List<Reporte> reportes = reporteDAO.obtenerReportes();
        if (reportes != null && !reportes.isEmpty()) {
            System.out.println("Prueba obtenerReportes: PASADA");
        } else {
            System.out.println("Prueba obtenerReportes: FALLIDA");
        }
    }

    private static void testObtenerReportePorId(ReporteDAO reporteDAO) {
        System.out.println("Probando obtenerReportePorId...");
        int idReporteExistente = 1; // Asegúrate de que este ID exista en tu base de datos
        Reporte reporte = reporteDAO.obtenerReportePorId(idReporteExistente);
        if (reporte != null && reporte.getIdReporte() == idReporteExistente) {
            System.out.println("Prueba obtenerReportePorId: PASADA");
        } else {
            System.out.println("Prueba obtenerReportePorId: FALLIDA");
        }
    }

    private static void testCrearReporte(ReporteDAO reporteDAO) {
        System.out.println("Probando crearReporte...");
        Reporte nuevoReporte = new Reporte();
        nuevoReporte.setFechaCreacion(new Date());
        nuevoReporte.setIdEmpresa(1); // Asegúrate de que este ID de empresa exista en tu base de datos
        nuevoReporte.setIdUsuario(4); // Asegúrate de que este ID de usuario exista en tu base de datos
        nuevoReporte.setDescripcion("Descripción del reporte ejemplo");
        nuevoReporte.setEstado("Pendiente");

        reporteDAO.crearReporte(nuevoReporte);
        Reporte reporteCreado = reporteDAO.obtenerReportePorId(nuevoReporte.getIdReporte());
        if (reporteCreado != null && "Descripción del reporte ejemplo".equals(reporteCreado.getDescripcion())) {
            System.out.println("Prueba crearReporte: PASADA");
        } else {
            System.out.println("Prueba crearReporte: FALLIDA");
        }
    }

    private static void testActualizarReporte(ReporteDAO reporteDAO) {
        System.out.println("Probando actualizarReporte...");
        int idReporteExistente = 1; // Asegúrate de que este ID exista en tu base de datos
        Reporte reporte = reporteDAO.obtenerReportePorId(idReporteExistente);
        if (reporte != null) {
            reporte.setDescripcion("Descripción del reporte actualizada");
            reporteDAO.actualizarReporte(reporte);
            Reporte reporteActualizado = reporteDAO.obtenerReportePorId(idReporteExistente);
            if ("Descripción del reporte actualizada".equals(reporteActualizado.getDescripcion())) {
                System.out.println("Prueba actualizarReporte: PASADA");
            } else {
                System.out.println("Prueba actualizarReporte: FALLIDA");
            }
        } else {
            System.out.println("Prueba actualizarReporte: FALLIDA - Reporte no encontrado");
        }
    }

    private static void testEliminarReporte(ReporteDAO reporteDAO) {
        System.out.println("Probando eliminarReporte...");
        int idReporteExistente = 1; // Asegúrate de que este ID exista en tu base de datos
        reporteDAO.eliminarReporte(idReporteExistente);
        Reporte reporteEliminado = reporteDAO.obtenerReportePorId(idReporteExistente);
        if (reporteEliminado == null) {
            System.out.println("Prueba eliminarReporte: PASADA");
        } else {
            System.out.println("Prueba eliminarReporte: FALLIDA");
        }
    }
}

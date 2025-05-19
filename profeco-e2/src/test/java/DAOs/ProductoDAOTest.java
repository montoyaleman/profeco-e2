
package DAOs;

import Entidades.Producto;
import java.util.List;

/**
 *
 * @author José Iván Vázquez Brambila
 */
public class ProductoDAOTest {

    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.obtenerProductosPorNombre("Producto Ejemplo")
                .forEach(producto  -> System.out.println(producto.getNombre()));
        
        /*
        // Prueba para obtenerProductos
        testObtenerProductos(productoDAO);

        // Prueba para obtenerProductoPorId
        testObtenerProductoPorId(productoDAO);

        // Prueba para crearProducto
        testCrearProducto(productoDAO);

        // Prueba para actualizarProducto
        testActualizarProducto(productoDAO);

        // Prueba para eliminarProducto
        testEliminarProducto(productoDAO);*/
    }

    private static void testObtenerProductos(ProductoDAO productoDAO) {
        System.out.println("Probando obtenerProductos...");
        List<Producto> productos = productoDAO.obtenerProductos();
        if (productos != null && !productos.isEmpty()) {
            System.out.println("Prueba obtenerProductos: PASADA");
        } else {
            System.out.println("Prueba obtenerProductos: FALLIDA");
        }
    }

    private static void testObtenerProductoPorId(ProductoDAO productoDAO) {
        System.out.println("Probando obtenerProductoPorId...");
        int idProductoExistente = 2; // Asegúrate de que este ID exista en tu base de datos
        Producto producto = productoDAO.obtenerProductoPorId(idProductoExistente);
        if (producto != null && producto.getIdProducto() == idProductoExistente) {
            System.out.println("Prueba obtenerProductoPorId: PASADA");
        } else {
            System.out.println("Prueba obtenerProductoPorId: FALLIDA");
        }
    }

    private static void testCrearProducto(ProductoDAO productoDAO) {
        System.out.println("Probando crearProducto...");
        Producto nuevoProducto = new Producto();
        nuevoProducto.setIdEmpresa(1); // Asegúrate de que este ID de empresa exista en tu base de datos
        nuevoProducto.setNombre("Producto Ejemplo");
        nuevoProducto.setDescripcion("Descripción del producto ejemplo");
        nuevoProducto.setPrecio(19.99);
        nuevoProducto.setOferta(false);
        nuevoProducto.setEtiquetas("etiqueta1, etiqueta2");

        productoDAO.crearProducto(nuevoProducto);
        Producto productoCreado = productoDAO.obtenerProductoPorId(nuevoProducto.getIdProducto());
        if (productoCreado != null && "Producto Ejemplo".equals(productoCreado.getNombre())) {
            System.out.println("Prueba crearProducto: PASADA");
        } else {
            System.out.println("Prueba crearProducto: FALLIDA");
        }
    }

    private static void testActualizarProducto(ProductoDAO productoDAO) {
        System.out.println("Probando actualizarProducto...");
        int idProductoExistente = 2; // Asegúrate de que este ID exista en tu base de datos
        Producto producto = productoDAO.obtenerProductoPorId(idProductoExistente);
        if (producto != null) {
            producto.setNombre("Producto Actualizado");
            productoDAO.actualizarProducto(producto);
            Producto productoActualizado = productoDAO.obtenerProductoPorId(idProductoExistente);
            if ("Producto Actualizado".equals(productoActualizado.getNombre())) {
                System.out.println("Prueba actualizarProducto: PASADA");
            } else {
                System.out.println("Prueba actualizarProducto: FALLIDA");
            }
        } else {
            System.out.println("Prueba actualizarProducto: FALLIDA - Producto no encontrado");
        }
    }

    private static void testEliminarProducto(ProductoDAO productoDAO) {
        System.out.println("Probando eliminarProducto...");
        int idProductoExistente = 11; // Asegúrate de que este ID exista en tu base de datos
        productoDAO.eliminarProducto(idProductoExistente);
        Producto productoEliminado = productoDAO.obtenerProductoPorId(idProductoExistente);
        if (productoEliminado == null) {
            System.out.println("Prueba eliminarProducto: PASADA");
        } else {
            System.out.println("Prueba eliminarProducto: FALLIDA");
        }
    }
}

package proyectofinal.service;



import org.springframework.stereotype.*;
import proyectofinal.entity.*;
import proyectofinal.repository.*;

import java.util.*;

@Service
public class ProductoService {


    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public Producto guardarProducto(Producto producto) {
        return repository.save(producto);
    }

    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    public Producto buscarProductoPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }



    public Producto actualizarProducto(Long id, Producto productoNuevo) {
        Producto productoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        productoExistente.setNombre(productoNuevo.getNombre());
        productoExistente.setPrecio(productoNuevo.getPrecio());
        return repository.save(productoExistente);
    }

    public void eliminarProducto(Long id) {
        repository.deleteById(id);
    }
}

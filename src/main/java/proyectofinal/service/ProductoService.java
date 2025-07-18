package proyectofinal.service;

import org.springframework.stereotype.Service;
import proyectofinal.dto.ProductoDTO;
import proyectofinal.dto.ProductoResponseDTO;
import proyectofinal.entity.Producto;
import proyectofinal.repository.ProductoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public ProductoResponseDTO guardarProducto(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setDescripcion(dto.getDescripcion());
        producto.setStock(dto.getStock());
        Producto guardado = repository.save(producto);
        return new ProductoResponseDTO(guardado.getId(), guardado.getNombre(), guardado.getPrecio(), guardado.getDescripcion(), guardado.getStock());
    }

    public List<ProductoResponseDTO> listarProductos() {
        return repository.findAll().stream()
                .map(p -> new ProductoResponseDTO(p.getId(), p.getNombre(), p.getPrecio(), p.getDescripcion(), p.getStock()))
                .collect(Collectors.toList());
    }

    public ProductoResponseDTO buscarProductoPorId(Long id) {
        Producto p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return new ProductoResponseDTO(p.getId(), p.getNombre(), p.getPrecio(), p.getDescripcion(), p.getStock());
    }

    public List<ProductoResponseDTO> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre).stream()
                .map(p -> new ProductoResponseDTO(p.getId(), p.getNombre(), p.getPrecio(), p.getDescripcion(), p.getStock()))
                .collect(Collectors.toList());
    }

    public ProductoResponseDTO actualizarProducto(Long id, ProductoDTO dto) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setDescripcion(dto.getDescripcion());
        producto.setStock(dto.getStock());
        Producto actualizado = repository.save(producto);
        return new ProductoResponseDTO(actualizado.getId(), actualizado.getNombre(), actualizado.getPrecio(), actualizado.getDescripcion(), actualizado.getStock());
    }

    public void eliminarProducto(Long id) {
        repository.deleteById(id);
    }
}

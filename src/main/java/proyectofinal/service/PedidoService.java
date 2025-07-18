package proyectofinal.service;

import org.springframework.stereotype.Service;
import proyectofinal.dto.PedidoDTO;
import proyectofinal.entity.Pedido;
import proyectofinal.entity.Producto;
import proyectofinal.repository.PedidoRepository;
import proyectofinal.repository.ProductoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    public Pedido crearPedido(PedidoDTO dto) {
        List<Producto> productos = new ArrayList<>();
        double total = 0.0;

        for (PedidoDTO.ItemPedidoDTO item : dto.getItems()) {
            Producto producto = productoRepository.findById(item.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + item.getProductoId()));

            if (producto.getStock() < item.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - item.getCantidad());
            productoRepository.save(producto);


            for (int i = 0; i < item.getCantidad(); i++) {
                productos.add(producto);
            }

            total += producto.getPrecio() * item.getCantidad();
        }

        Pedido pedido = new Pedido(dto.getCliente(), productos);
        pedido.setTotal(total);

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
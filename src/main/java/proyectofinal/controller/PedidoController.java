package proyectofinal.controller;

import org.springframework.web.bind.annotation.*;
import proyectofinal.dto.PedidoDTO;
import proyectofinal.entity.Pedido;
import proyectofinal.service.PedidoService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public Pedido crear(@RequestBody PedidoDTO dto) {
        return service.crearPedido(dto);
    }

    @GetMapping
    public List<Pedido> listar() {
        return service.listarPedidos();
    }

}

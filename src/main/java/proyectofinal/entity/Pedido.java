package proyectofinal.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;

    private Double total;

    @ManyToMany
    private List<Producto> productos;

    public Pedido() {
    }

    public Pedido(String cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }



    public Long getId() { return id; }

    public String getCliente() { return cliente; }

    public void setCliente(String cliente) { this.cliente = cliente; }

    public List<Producto> getProductos() { return productos; }

    public void setProductos(List<Producto> productos) { this.productos = productos; }

    public Double getTotal() { return total; }

    public void setTotal(Double total) { this.total = total; }
}

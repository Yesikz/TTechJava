package proyectofinal.dto;

import java.util.List;

public class PedidoDTO {

    private String cliente;
    private List<ItemPedidoDTO> items;

    public PedidoDTO() {}

    public PedidoDTO(String cliente, List<ItemPedidoDTO> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public List<ItemPedidoDTO> getItems() { return items; }
    public void setItems(List<ItemPedidoDTO> items) { this.items = items; }


    public static class ItemPedidoDTO {
        private Long productoId;
        private int cantidad;

        public ItemPedidoDTO() {}

        public ItemPedidoDTO(Long productoId, int cantidad) {
            this.productoId = productoId;
            this.cantidad = cantidad;
        }

        public Long getProductoId() { return productoId; }
        public void setProductoId(Long productoId) { this.productoId = productoId; }

        public int getCantidad() { return cantidad; }
        public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    }
}
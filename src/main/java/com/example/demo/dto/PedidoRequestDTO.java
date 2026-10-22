package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class PedidoRequestDTO {

    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    private String cliente;

    @NotBlank(message = "El estado del pedido es obligatorio")
    private String estadoPedido;

    @NotBlank(message = "El método de pago es obligatorio")
    private String metodoPago;

    @NotEmpty(message = "El pedido debe contener al menos un producto")
    @Valid // Esto hace que valide también los datos dentro de cada item
    private List<ItemPedidoRequestDTO> items;

    public PedidoRequestDTO() {}

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getEstadoPedido() { return estadoPedido; }
    public void setEstadoPedido(String estadoPedido) { this.estadoPedido = estadoPedido; }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public List<ItemPedidoRequestDTO> getItems() { return items; }
    public void setItems(List<ItemPedidoRequestDTO> items) { this.items = items; }
}
package com.example.demo.controller;

import com.example.demo.dto.PedidoRequestDTO;
import com.example.demo.entity.Pedido;
import com.example.demo.service.ElectroStoreService;
import jakarta.validation.Valid; // <-- IMPORTANTE: Nuevo import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private ElectroStoreService service;

    // 1. Crear un nuevo pedido
    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@Valid @RequestBody PedidoRequestDTO request) { // <-- AQUÍ ESTÁ EL @Valid
        Pedido nuevoPedido = service.crearPedido(request);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    // 2. Listar todos los pedidos realizados
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(service.listarPedidos());
    }

    // 3. Obtener un pedido específico por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPedidoPorId(id));
    }
}
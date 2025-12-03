package com.duoc.perfulandia.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String marca;
    private String descripcion;
    private String notas;
    private Double precio;
    private Double precioViejo;
    private String descuento;
    private String imagen; // URL o ruta de la imagen

    // Getters y Setters (o usa @Data de Lombok)
    // Constructor vacío necesario
    public Perfume() {}

    // Constructor con campos
    public Perfume(String nombre, String marca, Double precio, String imagen) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
    }
    
    // ... Generar Getters y Setters aquí ...
}
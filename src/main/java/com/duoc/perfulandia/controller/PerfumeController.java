package com.duoc.perfulandia.controller;

import com.duoc.perfulandia.model.Perfume;
import com.duoc.perfulandia.repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfumes")
@CrossOrigin(origins = "http://localhost:3000") // Permite que React se conecte
public class PerfumeController {

    @Autowired
    private PerfumeRepository perfumeRepository;

    // Endpoint 1: Listar todos (Público)
    // Documentar esto en el Anexo 3 como GET /api/perfumes
    @GetMapping
    public List<Perfume> obtenerPerfumes() {
        return perfumeRepository.findAll();
    }
    @PutMapping("/{id}")
    public Perfume actualizarPerfume(@PathVariable Long id, @RequestBody Perfume perfumeDetalles) {
        return perfumeRepository.findById(id).map(perfume -> {
            perfume.setNombre(perfumeDetalles.getNombre());
            perfume.setMarca(perfumeDetalles.getMarca());
            perfume.setDescripcion(perfumeDetalles.getDescripcion());
            perfume.setNotas(perfumeDetalles.getNotas());
            perfume.setPrecio(perfumeDetalles.getPrecio());
            perfume.setPrecioViejo(perfumeDetalles.getPrecioViejo());
            perfume.setDescuento(perfumeDetalles.getDescuento());
            perfume.setImagen(perfumeDetalles.getImagen());
            return perfumeRepository.save(perfume);
        }).orElse(null);
    }

    // Endpoint 2: Crear perfume (Privado/Admin)
    // Documentar en Anexo 3 como POST /api/perfumes
    @PostMapping
    public Perfume crearPerfume(@RequestBody Perfume perfume) {
        return perfumeRepository.save(perfume);
    }
    
    // Endpoint 3: Ver detalle (Público)
    @GetMapping("/{id}")
    public Perfume obtenerPerfumePorId(@PathVariable Long id) {
        return perfumeRepository.findById(id).orElse(null);
    }
    // Endpoint 4: Eliminar perfume (Admin)

    @DeleteMapping("/{id}")
    public void eliminarPerfume(@PathVariable Long id) {
        perfumeRepository.deleteById(id);
    }
}
package backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dtos.EstablecimientoDTO;
import backend.services.EstablecimientoService;

@RestController
@RequestMapping("/establecimientos")
public class EstablecimientoController {
    @Autowired
    private EstablecimientoService establecimientoService;

    @GetMapping("/comerciante/{comercianteId}")
    public ResponseEntity<List<EstablecimientoDTO>> findByComercianteId(@PathVariable Long comercianteId) {
        return ResponseEntity.ok(establecimientoService.findByComercianteId(comercianteId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstablecimientoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(establecimientoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EstablecimientoDTO> save(@RequestBody EstablecimientoDTO establecimientoDTO) {
        return ResponseEntity.ok(establecimientoService.save(establecimientoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        establecimientoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


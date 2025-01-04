package backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.dtos.ComercianteDTO;
import backend.services.ComercianteService;

@RestController
@RequestMapping("/comerciantes")
public class CRUDController {
    @Autowired
    private ComercianteService comercianteService;

    @GetMapping
    public Page<ComercianteDTO> findAll(
            @RequestParam(required = false, defaultValue = "") String nombre,
            @RequestParam(required = false, defaultValue = "") String estado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return comercianteService.findAll(nombre, estado, page, size);
    }

    @GetMapping("/{id}")
    public ComercianteDTO findById(@PathVariable Long id) {
        return comercianteService.findById(id);
    }

    @PostMapping
    public ComercianteDTO save(@RequestBody ComercianteDTO comercianteDTO) {
        return comercianteService.save(comercianteDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        comercianteService.delete(id);
    }
}


package backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dtos.DepartamentoDTO;
import backend.services.ValueListService;

@RestController
@RequestMapping("/values")
public class ValueListController {
    @Autowired
    private ValueListService valueListService;

    @GetMapping("/departamentos")
    public ResponseEntity<List<DepartamentoDTO>> getDepartamentos() {
        return ResponseEntity.ok(valueListService.getDepartamentos());
    }
}


package com.proyecto.turismo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.turismo.models.Destino;
import com.proyecto.turismo.services.DestinoService;
import com.proyecto.turismo.utils.ResponseController;
import com.proyecto.turismo.utils.ResponseObject;

@RestController
@RequestMapping("/destino")
public class DestinoController extends ResponseController {
    
    @Autowired
    DestinoService service;

    @GetMapping("/getAll")
    public ResponseObject getAll() {
        try {
            return setResponse(service.getAll(), 200, "");
        } catch (Exception err) {
            return setResponse(null, 203, err.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseObject getById(@PathVariable int id) {
        try {
            return setResponse(service.getById(id), 200, "");
        } catch (Exception err) {
            return setResponse(null, 203, err.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseObject save(@RequestBody Destino destino) {
        try {
            return setResponse(service.save(destino), 200, "");
        } catch (Exception err) {
            return setResponse(null, 203, err.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseObject update(@RequestBody Destino destino) {
        try {
            return setResponse(service.update(destino), 200, "");
        } catch (Exception err) {
            return setResponse(null, 203, err.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseObject update(@PathVariable int id) {
        try {
            return setResponse(service.delete(id), 200, "");
        } catch (Exception err) {
            return setResponse(null, 203, err.getMessage());
        }
    }

}

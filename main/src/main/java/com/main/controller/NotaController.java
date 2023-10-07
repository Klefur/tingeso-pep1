package com.main.controller;

import com.main.model.Nota;
import com.main.model.Pago;
import com.main.model.Usuario;
import com.main.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/nota")
public class NotaController {
    @Autowired
    NotaService notaServ;

    @GetMapping()
    public String subirNotas(Model model) {
        return "subir-notas";
    }

    @PostMapping()
    public String guardarNotas() {
        return "redirect:/";
    }
}

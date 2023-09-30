package com.main.controller;


import com.main.model.TipoColegio;
import com.main.model.Usuario;
import com.main.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService uServ;

    @GetMapping()
    public String getALl(Model model) {
        List<Usuario> users = uServ.getALl();
        model.addAttribute("usuarios", users);

        return "listar";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("usuario", new Usuario()); // Para enlazar el formulario con un objeto Usuario
        return "registro";
    }

    @PostMapping("/guardar_usuario")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, @RequestParam("tipo_colegio") Long idTipoColegio) {
        uServ.crear(usuario, idTipoColegio);
        return "redirect:/usuario"; // Redirige de nuevo a la lista de usuarios
    }
}
package com.main.controller;

import com.main.model.Pago;
import com.main.model.Usuario;
import com.main.service.PagoService;
import com.main.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/pago")
public class PagoController {
    @Autowired
    PagoService pagServ;
    @Autowired
    UsuarioService userServ;

    @GetMapping("/{userId}")
    public String registrarCuotas(@PathVariable Long userId, Model model) {
        Usuario user = userServ.show(userId);
        Pago cuotasForm = new Pago();

        model.addAttribute("estudiante", user);
        model.addAttribute("cuotasForm", cuotasForm);

        return "generar-cuota";
    }

    @PostMapping("/{userId}")
    public String generarCuotas(@ModelAttribute("cuotasForm") Pago cuotasForm, @PathVariable Long userId) {
        cuotasForm.setTotal(1000000);
        System.out.println(cuotasForm);
        pagServ.generarCuotas(cuotasForm, userId);

        return "redirect:/pago/ver-cuotas/" + userId;
    }

    @GetMapping("/ver-cuotas/{userId}")
    public String cuotasUsuario(@PathVariable Long userId, Model model) {
        Usuario user = userServ.show(userId);

        List<Pago> cuotas = pagServ.getALlByUser(user);
        model.addAttribute("cuotas", cuotas);
        model.addAttribute("usuario", user);

        return "cuotas-usuario";
    }
}

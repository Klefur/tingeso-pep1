package com.main;

import com.main.model.Usuario;
import com.main.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UsuarioTests {
    @Autowired
    UsuarioService uServ;

    @Test
    void testGetUsuario() {
         Usuario user = new Usuario();

         Date fecha = new Date();

         user.setNombres("Valentina");
         user.setApellidos("Campos");
         user.setGrad_year(2020);
         user.setRut("1234567");
         user.setFecha_nacimiento(fecha);
         user.setNombre_colegio("College");
         user = uServ.crear(user, 1L);
         assertNotNull(uServ.getALl());
         uServ.delete(user.getId());
    }

}

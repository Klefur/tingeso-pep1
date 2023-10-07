package com.main.service;

import com.main.model.Nota;
import com.main.model.Usuario;
import com.main.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {
    @Autowired
    NotaRepository notaRep;
    @Autowired
    UsuarioService uServ;

    public Nota crear(Nota nota) {
        return notaRep.save(nota);
    }

    public List<Nota> getByUser(Long uId) {
        return notaRep.findAllByUsuario(uServ.show(uId));
    }
}

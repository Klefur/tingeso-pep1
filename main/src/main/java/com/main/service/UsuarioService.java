package com.main.service;

import com.main.model.TipoColegio;
import com.main.model.Usuario;
import com.main.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository userRep;

    public Usuario crear(Usuario user, Long idTipoColegio) {
        TipoColegio tc = new TipoColegio();
        tc.setId(idTipoColegio);
        user.setTipo_colegio(tc);
        return userRep.save(user);
    }

    public List<Usuario> getALl() {
        return userRep.findAll();
    }

    public Usuario show(Long id) {
        try {
            return userRep.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public Usuario findByRut(String rut) {
        try {
            return userRep.findByRut(rut).get();
        } catch (Exception e) {
            return null;
        }
    }

    public String delete(Long id) {
        try {
            userRep.deleteById(id);
            return "Se borro usuario";
        } catch (Exception e) {
            return "No existe usuario con ese id";
        }
    }
}

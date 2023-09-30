package com.main.service;

import com.main.model.Pago;
import com.main.model.TipoColegio;
import com.main.model.Usuario;
import com.main.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {
    @Autowired
    PagoRepository pagoRep;

    public Pago crear(Pago user) {
        return pagoRep.save(user);
    }

    public List<Pago> getALlByUser(Usuario user) {
        return pagoRep.findAllByUsuario(user);
    }

    public Pago show(Long id) {
        try {
            return pagoRep.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public Pago update(Pago newPago, Long id) {
        Pago temp;
        try {
            temp = show(id);

            return pagoRep.save(temp);

        } catch (Exception e) {
            return null;
        }
    }

    public String delete(Long id) {
        try {
            pagoRep.deleteById(id);
            return "Se borro pago";
        } catch (Exception e) {
            return "No existe pago con ese id";
        }
    }
}

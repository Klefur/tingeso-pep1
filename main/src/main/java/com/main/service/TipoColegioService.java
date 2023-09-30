package com.main.service;

import com.main.model.Pago;
import com.main.model.TipoColegio;
import com.main.model.Usuario;
import com.main.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoColegioService {
    @Autowired
    PagoRepository pagoRep;

    public Pago crear(Pago colType) {
        return pagoRep.save(colType);
    }

    public List<Pago> getALl() {
        return pagoRep.findAll();
    }

    public List<Pago> getAllByUser(Usuario user) {
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

            if ( newPago.getAtrasado() != temp.getAtrasado()) {
                temp.setAtrasado(newPago.getAtrasado());
            }

            if ( newPago.getPagado() != temp.getPagado()) {
                temp.setPagado(newPago.getPagado());
            }

            if ( newPago.getDcto_aplicable() != null) {
                temp.setDcto_aplicable(newPago.getDcto_aplicable());
            }

            if ( newPago.getInteres_acumulado() != null) {
                temp.setInteres_acumulado(newPago.getInteres_acumulado());
            }

            return pagoRep.save(temp);

        } catch (Exception e) {
            return null;
        }
    }

    public String delete(Long id) {
        try {
            pagoRep.deleteById(id);
            return "Se borro tipo colegio";
        } catch (Exception e) {
            return "No existe tipo colegio con ese id";
        }
    }
}

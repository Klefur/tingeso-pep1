package com.main.service;

import com.main.model.Pago;
import com.main.model.Usuario;
import com.main.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PagoService {
    @Autowired
    PagoRepository pagoRep;

    public void generarCuotas(Pago cuotasForm, Long userId) {
        Integer total = cuotasForm.getTotal() / cuotasForm.getNro_cuota();
        Usuario user = new Usuario();
        user.setId(userId);

        List<Date> fechas = generarFechasDeVencimiento(cuotasForm.getNro_cuota());

        for (int i = 1; i <= cuotasForm.getNro_cuota(); i++) {
            Pago cuota = new Pago();
            cuota.setNro_cuota(i);
            cuota.setTotal(total);
            cuota.setUsuario(user);
            cuota.setFecha_plazo(fechas.get(i - 1));
            pagoRep.save(cuota);
        }
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

    private List<Date> generarFechasDeVencimiento(int n) {
        List<Date> fechas = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < n; i++) {
            // Establecer el día actual
            int diaActual = calendar.get(Calendar.DAY_OF_MONTH);

            // Establecer la fecha al día 10 del mes
            calendar.set(Calendar.DAY_OF_MONTH, 10);

            // Obtener la fecha resultante como un objeto Date
            Date fechaVencimiento = calendar.getTime();

            // Agregar la fecha de vencimiento a la lista
            fechas.add(fechaVencimiento);

            // Avanzar al siguiente mes para la próxima iteración
            calendar.add(Calendar.MONTH, 1);
        }

        return fechas;
    }

}

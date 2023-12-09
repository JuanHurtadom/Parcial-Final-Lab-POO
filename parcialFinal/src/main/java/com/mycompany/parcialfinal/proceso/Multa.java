
package com.mycompany.parcialfinal.proceso;

import java.util.Date;


public class Multa {

    private static final int CONST_PLAZO_PAGAR = 20; //dias
    
    private Date fechaInicio;
    private Date fechaFin;

    public Multa(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public Date calcularFechaFin(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DAY_OF_MONTH, CONST_PLAZO_PAGAR);
        return calendar.getTime();
    }
}

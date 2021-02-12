package com.mybank;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreditoLibreInversion {


    private int tipoPersona;//  1 - personaNatural , 2- personaJuridica
    private int edad;
    private int nacionalidad;// 1 - Argentino, 2 - Español, 3 - Colombiano, 4 - Otros
    private double ingresos;
    private int plazo; //meses
    private double valor;
    private int tipoContratoLaboral; //1- indefinido, 2 - fijo, 3 - obra o labor
    private int anosAntiguedadLaboral;
    private boolean estado;
    private int genero; //1 - Masculino, 2- Femenino
    private int residencia; // 1 - Argentina, 2 - España,3 - Colombia , 4 -otros
    private String mensaje;


    public void solicitarCredito() {

        if (personaIndicada() && edadIndicada() && residenciaNacIndicada() && ingresosIndicados()
                && plazoCredIndicado() && contratoIndicado() && nivelEndeudamiento()
                && edadPlazoIndicado() && preaprobadoIndicado()) {
            mensaje = "Su credito de libre inversion ha sido aprobado por: " + valor;
            estado = true;
            return;
        }
        System.out.println("Motivo del rechazo del credito: " + mensaje);

    }


    private boolean personaIndicada() {
        final int PERSONA_NATURAL = 1;//Persona natural
        if (tipoPersona == PERSONA_NATURAL)
            return true;
        mensaje = "La persona debe ser Segmento Personas";
        return false;
    }

    private boolean edadIndicada() {
        final int EDAD_MIN = 18;
        final int EDAD_MAX = 60;

        if (edad >= EDAD_MIN && edad <= EDAD_MAX)
            return true;

        mensaje = "La edad debe estar entre 18 y 60";
        return false;
    }

    private boolean residenciaNacIndicada() {
        final int COLOMBIANO = 3;
        final int COLOMBIA = 3;
        if (nacionalidad == COLOMBIANO || residencia == COLOMBIA)
            return true;

        mensaje = "Debe ser residente o de nacionalidad Colombiana";
        return false;
    }

    private boolean ingresosIndicados() {
        final int INGRESO_MIN = 1000000;
        if (ingresos >= INGRESO_MIN)
            return true;

        mensaje = "Debe tener ingresos minimos de $1 millon de Pesos";
        return false;
    }

    private boolean plazoCredIndicado() {
        final int PLAZO_MIN = 24;
        final int PLAZO_MAX = 60;
        if (plazo >= PLAZO_MIN && plazo <= PLAZO_MAX)
            return true;
        mensaje = "El plazo del credito debe ser entre 24 y 60 meses";
        return false;
    }

    private boolean vlorCredIndicado() {
        final double VLR_MIN_CRED = 3000000; //Valor minimo del credito
        final double VLR_MAX_CRED = 60000000;//Valor maximo del credito

        if (valor >= VLR_MIN_CRED && valor <= VLR_MAX_CRED)
            return true;

        mensaje = "El credito solicitado debe ser minimo de $3 millones y maximo de $60 millones";
        return false;
    }

    private boolean contratoIndicado() {
        final int CONTRATO_IND = 1; //Contrato laboral indefinido
        final int ANT_LABORAL_MIN = 1; //Antiguedad laboral en anos

        if (tipoContratoLaboral == CONTRATO_IND && anosAntiguedadLaboral >= ANT_LABORAL_MIN)
            return true;

        mensaje = "El cliente debe ser empleado con contrato indefinido minimo de 1 año de antiguedad";
        return false;
    }

    private boolean nivelEndeudamiento() {
        final double CAPACIDAD = ingresos * 0.55; //Capacidad de pago
        final double NIVEL_END = valor * 0.015;

        if (NIVEL_END <= CAPACIDAD)
            return true;
        mensaje = "El cliente no tiene capacidad de endeudamiento";
        return false;
    }

    public boolean edadPlazoIndicado() {
        int plazoAnos = plazo / 12;
        int edadIndicada = edad + plazoAnos;

        if ((genero == 1 && edadIndicada < 62) || (genero == 2 && edad < 57))
            return true;

        mensaje = "La edad del cliente mas el plazo del credito no debe superar la edad de jubilacion";

        return false;
    }

    public boolean preaprobadoIndicado() {

        if ((ingresos >= 1000000 && ingresos <= 3000000)) {
            if (valor > 15000000) {
                mensaje = "Debido a su ingreso mensual " + ingresos + " solo se le puede realizar una preaprobacion maxima de $15 Millones";
                return false;
            }
        }

        if ((ingresos > 3000000 && ingresos <= 5000000))
            if (valor > 30000000) {
                mensaje = "Debido a su ingreso mensual " + ingresos + " solo se le puede realizar una preaprobacion maxima de 30$ Millones";
                return false;
            }
        if ((ingresos > 5000000 && ingresos <= 8000000))
            if (valor > 50000000) {
                mensaje = "Debido a su ingreso mensual " + ingresos + " solo se le puede realizar una preaprobacion maxima de 50$ Millones";
                return false;
            }
        if ((ingresos > 8000000 && ingresos <= 10000000)) {
            if (valor > 60000000) {
                mensaje = "Debido a su ingreso mensual " + ingresos + " solo se le puede realizar una preaprobacion maxima de 60$ Millones";
                return false;
            }

        }

        if (ingresos > 10000000 && valor > 60000000) {
            mensaje = "Debido a su ingreso mensual " + ingresos + " solo se le puede realizar una preaprobacion" +
                    " maxima de 100$ Millones,pero el credito de libre inversion no debe superar los 60 Millones";
            return false;
        }
        vlorCredIndicado();
        return true;


    }

}

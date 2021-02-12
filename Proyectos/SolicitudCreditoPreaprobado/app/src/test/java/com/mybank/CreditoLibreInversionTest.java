package com.mybank;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreditoLibreInversionTest {
    CreditoLibreInversion credLib;

    @Before
    public void init() {
        credLib = new CreditoLibreInversion();
    }

    @After
    public void teardown() {
        credLib = null;
    }

    @Test
    public void VerificarEstadocreditoAprobado() {

        credLib.setTipoPersona(1);
        credLib.setEdad(23);
        credLib.setGenero(1);
        credLib.setResidencia(3);
        credLib.setNacionalidad(3);
        credLib.setIngresos(3000000);
        credLib.setValor(15000000);
        credLib.setPlazo(40);
        credLib.setTipoContratoLaboral(1);
        credLib.setAnosAntiguedadLaboral(5);

        credLib.solicitarCredito();
        boolean aprobacion = credLib.isEstado();

        assertEquals(true, aprobacion);

    }

    @Test
    public void VerificarcreditoNoAprobadoPersonaJuridica() {

        credLib.setTipoPersona(2);

        credLib.solicitarCredito();
        boolean aprobacion = credLib.isEstado();

        assertEquals(false, aprobacion);

    }

    @Test
    public void VerificarSaldoAprobado() {

        credLib.setTipoPersona(1);
        credLib.setEdad(30);
        credLib.setGenero(2);
        credLib.setResidencia(3);
        credLib.setNacionalidad(3);
        credLib.setIngresos(10000000);
        credLib.setValor(60000000);
        credLib.setPlazo(40);
        credLib.setTipoContratoLaboral(1);
        credLib.setAnosAntiguedadLaboral(10);

        credLib.solicitarCredito();
        boolean aprobacion = credLib.isEstado();
        double saldoCred = credLib.getValor();
        assertEquals(true, aprobacion);
        assertEquals(60000000, saldoCred, 0);

    }

    @Test
    public void VerificarCreditoNoAprobadoEdadMujer() {

        credLib.setTipoPersona(1);
        credLib.setEdad(60);
        credLib.setGenero(2);
        credLib.setNacionalidad(3);
        credLib.setIngresos(7000000);
        credLib.setValor(4000000);
        credLib.setPlazo(24);
        credLib.setTipoContratoLaboral(1);
        credLib.setAnosAntiguedadLaboral(4);

        credLib.solicitarCredito();
        boolean aprobacion = credLib.isEstado();

        assertEquals(false, aprobacion);

    }

    @Test
    public void VerificarcreditoNoAprobadoNivelEndeudamiento() {

        credLib.setTipoPersona(1);
        credLib.setEdad(30);
        credLib.setGenero(2);
        credLib.setNacionalidad(3);
        credLib.setIngresos(2000000);
        credLib.setValor(100000000);
        credLib.setPlazo(24);
        credLib.setTipoContratoLaboral(1);
        credLib.setAnosAntiguedadLaboral(4);

        credLib.solicitarCredito();
        boolean aprobacion = credLib.isEstado();

        assertEquals(false, aprobacion);

    }

    @Test
    public void VerificarcreditoNoPreAprobado() {

        credLib.setTipoPersona(1);
        credLib.setEdad(30);
        credLib.setGenero(2);
        credLib.setNacionalidad(3);
        credLib.setIngresos(10500000);
        credLib.setValor(100000000);
        credLib.setPlazo(24);

        credLib.setTipoContratoLaboral(1);
        credLib.setAnosAntiguedadLaboral(4);

        credLib.solicitarCredito();
        boolean aprobacion = credLib.isEstado();

        assertEquals(false, aprobacion);

    }

    @Test
    public void VerificarcreditoNoAprobadoMenorEdad() {

        credLib.setTipoPersona(1);
        credLib.setEdad(15);
        credLib.setGenero(2);
        credLib.setNacionalidad(3);
        credLib.setIngresos(4000000);
        credLib.setValor(30000000);
        credLib.setPlazo(24);

        credLib.solicitarCredito();
        boolean aprobacion = credLib.isEstado();

        assertEquals(false, aprobacion);

    }

    @Test
    public void VerificarcreditoNoAprobadoIngresos() {

        credLib.setTipoPersona(1);
        credLib.setEdad(40);
        credLib.setGenero(2);
        credLib.setNacionalidad(3);
        credLib.setIngresos(850000);
        credLib.setValor(30000000);
        credLib.setPlazo(24);
        credLib.setTipoContratoLaboral(1);
        credLib.setAnosAntiguedadLaboral(4);

        credLib.solicitarCredito();
        boolean aprobacion = credLib.isEstado();

        assertEquals(false, aprobacion);

    }

    @Test
    public void VerificarcreditoNoAprobadoContrato() {

        credLib.setTipoPersona(1);
        credLib.setEdad(40);
        credLib.setGenero(2);
        credLib.setNacionalidad(3);
        credLib.setIngresos(6000000);
        credLib.setValor(30000000);
        credLib.setPlazo(24);
        credLib.setTipoContratoLaboral(2);
        credLib.setAnosAntiguedadLaboral(4);

        credLib.solicitarCredito();
        boolean aprobacion = credLib.isEstado();

        assertEquals(false, aprobacion);

    }


    @Test
    public void VerificarcreditoAprobadoMaximoMonto() {

        credLib.setTipoPersona(1);
        credLib.setEdad(40);
        credLib.setGenero(2);
        credLib.setNacionalidad(3);
        credLib.setIngresos(9200000);
        credLib.setValor(60000000);
        credLib.setPlazo(24);
        credLib.setTipoContratoLaboral(1);
        credLib.setAnosAntiguedadLaboral(4);

        credLib.solicitarCredito();
        boolean aprobacion = credLib.isEstado();

        assertEquals(true, aprobacion);

    }

    @Test
    public void VerificarcreditoNoAprobadoNacionalidad() {

        credLib.setTipoPersona(1);
        credLib.setEdad(30);
        credLib.setGenero(2);
        credLib.setNacionalidad(1);

        credLib.solicitarCredito();
        boolean aprobacion = credLib.isEstado();

        assertEquals(false, aprobacion);

    }

}

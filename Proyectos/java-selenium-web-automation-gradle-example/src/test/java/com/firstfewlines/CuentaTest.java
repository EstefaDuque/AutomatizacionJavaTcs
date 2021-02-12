package com.firstfewlines;

import org.junit.Assert;
import org.junit.Test;


public class CuentaTest {

    @Test
    public void validarSiCuentaExiste(){


        Cuenta cuenta = new Cuenta();
        Boolean cuentaExiste = cuenta.buscarCuenta("123");
        Assert.assertTrue(cuentaExiste);
    }
}


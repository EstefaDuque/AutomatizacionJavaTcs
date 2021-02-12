package com.firstfewlines;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Cuentas.class)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CuentasTest {

    @InjectMocks
    @Autowired
    Cuentas cuenta;

    @Mock
    RecursosCuentas recursosCuentas;

    @Before
    public void setUp(){
        //MockitoAnnotations.initMocks(this); // Instancia los mocks
        Mockito.when(recursosCuentas.buscarCuenta("123")).thenReturn(true); //Definie un mock
        Mockito.when(recursosCuentas.buscarCuenta("1234")).thenReturn(false); //Define un mock
    }

    @Test
    public void validarSiCuentaExiste() {

        Boolean cuentaExiste = cuenta.buscarCuenta("123");

        Assert.assertTrue(cuentaExiste);
    }

}

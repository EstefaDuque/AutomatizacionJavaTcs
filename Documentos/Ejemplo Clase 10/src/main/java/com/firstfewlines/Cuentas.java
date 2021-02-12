package com.firstfewlines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cuentas {

    @Autowired
    RecursosCuentas recursosCuentas;

    public Boolean buscarCuenta(String nroCuenta) {

        return recursosCuentas.buscarCuenta(nroCuenta);
    }

}

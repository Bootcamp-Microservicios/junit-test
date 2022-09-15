package com.bootcamp.unittests.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import com.bootcamp.unittests.exception.SaldoInsuficienteException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RetiroImplTest {

    private static RetiroImpl retiro;

    @BeforeAll
    public static void setUp(){
        retiro = new RetiroImpl();
    }

    @Test
    public void retiroExitosoTest() throws SaldoInsuficienteException {
        //Dado
        long saldoInicial = 300;
        long montoRetiro = 100;
        long valorEsperado = 200;

        //Hacer
        long valorResultado = retiro.retirarDinero(saldoInicial, montoRetiro);

        //Evaluar
        assertEquals(valorEsperado, valorResultado);
    }

    @Test
    public void saldoInsuficienteTest() {
        //Dado
        long saldoInicial = 300;
        long montoRetiro = 302;

        // Hacer y Evaluar
        assertThrowsExactly(SaldoInsuficienteException.class,
                () -> retiro.retirarDinero(saldoInicial, montoRetiro));
    }
    
}

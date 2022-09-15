package com.bootcamp.unittests.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.bootcamp.unittests.exception.SaldoInsuficienteException;
import com.bootcamp.unittests.service.Retiro;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;


public class RetiroControllerTest {

    private static WebTestClient webClient;

    @Mock
    private static Retiro service;

    @BeforeAll
    public static void setUp() {
        service = mock(Retiro.class);
        webClient = WebTestClient.bindToController(new RetiroController(service))
                .configureClient()
                .build();
    }

    @Test
    public void peticionExitosa() throws SaldoInsuficienteException {
        long saldoInicial = 300;
        long montoRetiro = 100;
        String valorEsperado = "200";

        Mockito.when(service.retirarDinero(saldoInicial,montoRetiro)).thenReturn(200L);

        webClient.post()
            .uri("/retiro/{saldo}/{monto}", saldoInicial,montoRetiro)
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class)
            .isEqualTo(valorEsperado);
    }

    @Test
    public void peticionFallida() throws SaldoInsuficienteException {
        long saldoInicial = 100;
        long montoRetiro = 300;

        when(service.retirarDinero(saldoInicial,montoRetiro)).thenThrow(SaldoInsuficienteException.class);

        webClient.post()
            .uri("/retiro/{saldo}/{monto}", saldoInicial,montoRetiro)
            .exchange()
            .expectStatus().is5xxServerError();
    }
    
}

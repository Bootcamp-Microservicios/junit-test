package com.bootcamp.unittests.controller;

import com.bootcamp.unittests.exception.SaldoInsuficienteException;
import com.bootcamp.unittests.service.Retiro;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/retiro")
@RequiredArgsConstructor
public class RetiroController {

    private final Retiro service;

    @PostMapping(value = "/{saldo}/{monto}",
            produces =  MediaType.TEXT_PLAIN_VALUE)
    public String retirar(@PathVariable("saldo") long saldo,
            @PathVariable("monto") long montoRetiro) throws SaldoInsuficienteException {
        return String.valueOf(service.retirarDinero(saldo, montoRetiro));
    }

}

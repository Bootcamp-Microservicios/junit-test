package com.bootcamp.unittests.service.impl;

import com.bootcamp.unittests.exception.SaldoInsuficienteException;
import com.bootcamp.unittests.service.Retiro;

import org.springframework.stereotype.Service;


@Service
public class RetiroImpl implements Retiro {

    @Override
    public long retirarDinero(long saldo, long montoRetiro) throws SaldoInsuficienteException {
        if (saldo < montoRetiro) {
            throw new SaldoInsuficienteException();
        }
        return saldo - montoRetiro;
    }

}

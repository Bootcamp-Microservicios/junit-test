package com.bootcamp.unittests.service;

import com.bootcamp.unittests.exception.SaldoInsuficienteException;

public interface Retiro {

    public long retirarDinero(long saldo, long montoRetiro) throws SaldoInsuficienteException;

}

package br.com.msSaldoTransacoes.service;

import org.springframework.http.ResponseEntity;

import br.com.msSaldoTransacoes.wrapper.SaldoWrapper;


public interface TransacaoService {

	ResponseEntity<SaldoWrapper> verSaldo (SaldoWrapper saldo);

}

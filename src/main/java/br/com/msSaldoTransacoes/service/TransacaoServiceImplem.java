package br.com.msSaldoTransacoes.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.msSaldoTransacoes.entity.SaldoCreditoEntity;
import br.com.msSaldoTransacoes.entity.SaldoDebitoEntity;
import br.com.msSaldoTransacoes.wrapper.SaldoWrapper;

@Service
public class TransacaoServiceImplem implements TransacaoService {

	public ResponseEntity<SaldoWrapper> verSaldo (SaldoWrapper saldo){
		
		Double saldoCredito = null;
		Double saldoDebito = null;
		Double totalSaldo = null;		
		
		SaldoCreditoEntity saldoCreditoEntity = new SaldoCreditoEntity();
		SaldoDebitoEntity saldoDebitoEntity = new SaldoDebitoEntity();
		
		saldoCredito = saldoCreditoEntity.getValorCredito();
		saldoDebito = saldoDebitoEntity.getValorDebito();
		
		totalSaldo = saldoCredito - saldoDebito;
		System.out.println("Saldo = " + totalSaldo);
		
		saldo.setSaldo(totalSaldo);
		
		
		return new ResponseEntity<SaldoWrapper>(saldo, HttpStatus.OK);
	}
	
}

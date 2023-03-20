package br.com.msSaldoTransacoes.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoWrapper {
	
	@JsonProperty("saldo")
	private Double saldo;

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}

package br.com.msSaldoTransacoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msSaldoTransacoes.service.TransacaoService;
import br.com.msSaldoTransacoes.wrapper.SaldoWrapper;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/saldo")
public class msSaldoTransacoesController {
	
	@Autowired
	private TransacaoService transacaoService;
	
	@ApiOperation(value="API para a consulta de saldo")
	@GetMapping(value= "/consulta")
	public ResponseEntity<SaldoWrapper> consultaSaldo (@RequestBody SaldoWrapper saldo) {
		return transacaoService.verSaldo(saldo);
	}
}

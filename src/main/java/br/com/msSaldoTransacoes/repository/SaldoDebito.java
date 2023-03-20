package br.com.msSaldoTransacoes.repository;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import br.com.msSaldoTransacoes.entity.SaldoDebitoEntity;

@Configuration
public class SaldoDebito {
	
	
	@Bean
	public JdbcCursorItemReader<SaldoDebitoEntity> consultaDebito (
			@Qualifier("DataSource")DataSource dataSource){		
		return new JdbcCursorItemReaderBuilder<SaldoDebitoEntity>()
				.name("consultaDebito")
				.dataSource(dataSource)
				.sql(" SELECT TIPO SUM(VALOR) AS DEBITO FROM MYDB.TRANSACOES WHERE TIPO = 'DEBITO' ")
				.rowMapper(rowMapperDebito())
				.build();
	}
	
	private RowMapper<SaldoDebitoEntity> rowMapperDebito(){
		return (rs, rowNum) -> {
			SaldoDebitoEntity credito = new SaldoDebitoEntity();
			
			credito.setValorDebito(rs.getDouble("DEBITO"));
			
			return credito;
		};
	}

}

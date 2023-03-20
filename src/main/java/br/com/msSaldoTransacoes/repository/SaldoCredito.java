package br.com.msSaldoTransacoes.repository;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import br.com.msSaldoTransacoes.entity.SaldoCreditoEntity;


@Configuration
public class SaldoCredito {
	
	@Bean
	public JdbcCursorItemReader<SaldoCreditoEntity> consultaCredito(
			@Qualifier("DataSource")DataSource dataSource){
		
		return new JdbcCursorItemReaderBuilder<SaldoCreditoEntity>()
				.name("consultaCredito")
				.dataSource(dataSource)
				.sql(" SELECT TIPO SUM(VALOR) AS CREDITO FROM MYDB.TRANSACOES WHERE TIPO = 'CREDITO' ")
				.rowMapper(rowMapperCredito())
				.build();
	}
	
	private RowMapper<SaldoCreditoEntity> rowMapperCredito(){
		return (rs, rowNum) -> {
			SaldoCreditoEntity credito = new SaldoCreditoEntity();
			
			credito.setValorCredito(rs.getDouble("CREDITO"));
			
			return credito;
		};
	}

}

package co.com.pascal516.r2dbc.config;


import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MysqlConnectionPool {
    public static final String HOLA = "Vivendum516";

	@Bean
	public ConnectionFactory getConnectionConfig(){
		var configuration = MySqlConnectionConfiguration.builder()
				.host("srv750.hstgr.io")
				.user("u410847206_apto516")
				.password(HOLA)
				.database("u410847206_pascal")
				.build();
		return MySqlConnectionFactory.from(configuration);
	}
}

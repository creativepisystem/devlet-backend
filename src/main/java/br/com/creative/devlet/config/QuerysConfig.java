package br.com.creative.devlet.config;

import br.com.creative.devlet.query.Filter;
import br.com.creative.devlet.query.QueryRepository;
import br.com.creative.devlet.query.SqlQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuerysConfig {

    @Bean(name = "testeQuery")
    public QueryRepository<String> teste(){
        return new SqlQuery<String>()
                .select("")
                .from("")
                .where("")
                .filterableBy( new Filter())
                .into(String.class);

    }
}

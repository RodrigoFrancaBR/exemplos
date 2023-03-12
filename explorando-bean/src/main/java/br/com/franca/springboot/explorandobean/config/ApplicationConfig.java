package br.com.franca.springboot.explorandobean.config;

import br.com.franca.springboot.explorandobean.core.usecase.cliente.ClienteService;
import br.com.franca.springboot.explorandobean.core.usecase.cliente.ClienteServiceImpl;
import br.com.franca.springboot.explorandobean.dataprovider.db.ClienteDao;
import br.com.franca.springboot.explorandobean.dataprovider.db.ClienteDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ClienteDao clienteDao(){
        return new ClienteDaoImpl();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ClienteService clienteService1(final ClienteDao clienteDao){
        ClienteServiceImpl cLienteService = new ClienteServiceImpl();
        cLienteService.setName("Instancia de cliente service 1");
        cLienteService.setClientDao(clienteDao);
        return cLienteService;
    }

    @Bean
    public ClienteService clienteService2(final ClienteDao clienteDao){
        ClienteServiceImpl cLienteService = new ClienteServiceImpl();
        cLienteService.setName("Instancia de cliente service 2");
        cLienteService.setClientDao(clienteDao);
        return cLienteService;
    }
}

package br.com.franca.springboot.explorandospring;

import br.com.franca.springboot.explorandospring.core.usecase.cliente.ClienteService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExplorandoBeanApplication {
	@Autowired
	@Qualifier("clienteService1")
	ClienteService clienteServiceOne;
	@Autowired
	ClienteService clienteService2;

	static Logger logger;

	public static void main(String[] args) {
		logger = LoggerFactory.getLogger("br.com.franca.springboot.explorandospring.ExplorandoBeanApplication");
		logger.debug("Hello World Logback!!");
		SpringApplication.run(ExplorandoBeanApplication.class, args);
	}

	@PostConstruct
	public void init(){
		logger.info("ClienteService1: {} name: {} ", clienteServiceOne, clienteServiceOne.getName());
		clienteServiceOne.printDependencies();
		logger.info("ClienteService2: {} name: {} ", clienteService2, clienteService2.getName());
		clienteService2.printDependencies();
	}

}

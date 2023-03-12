package br.com.franca.springboot.explorandobean;

import br.com.franca.springboot.explorandobean.core.usecase.cliente.ClienteService;
import jakarta.annotation.PostConstruct;
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

	public static void main(String[] args) {
		SpringApplication.run(ExplorandoBeanApplication.class, args);
	}

	@PostConstruct
	public void init(){
		System.out.println("ClienteService1 = " + clienteServiceOne +  "( " + clienteServiceOne.getName() + " )");
		clienteServiceOne.printDependencies();
		System.out.println("ClienteService2 = " + clienteService2 +  "( " + clienteService2.getName() + " )");
		clienteService2.printDependencies();
	}

}

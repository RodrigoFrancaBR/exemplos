package br.com.franca.springboot.explorandobean;

import br.com.franca.springboot.explorandobean.core.usecase.cliente.ClienteService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExplorandoBeanApplication {
	@Autowired
	ClienteService clienteService1;
	@Autowired
	ClienteService clienteService2;

	public static void main(String[] args) {
		SpringApplication.run(ExplorandoBeanApplication.class, args);
	}

	@PostConstruct
	public void init(){
		System.out.println("ClienteService1 = " + clienteService1 +  "( " + clienteService1.getName() + " )");
		clienteService1.printDependencies();
		System.out.println("ClienteService2 = " + clienteService2 +  "( " + clienteService2.getName() + " )");
		clienteService2.printDependencies();
	}

}

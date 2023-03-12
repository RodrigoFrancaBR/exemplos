package br.com.franca.springboot.explorandobean.core.usecase.cliente;

import br.com.franca.springboot.explorandobean.dataprovider.db.ClienteDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteServiceImpl implements ClienteService{
    private String name;

    private ClienteDao clientDao;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public ClienteDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClienteDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void printDependencies() {
        System.out.println("clienteDao = " + clientDao);
    }


    @Override
    @PostConstruct
    public void init() {
        System.out.println("Chamando o método init " + name);
    }

    @Override
    @PreDestroy
    public void destroy() {
        System.out.println("Chamando o método destroy " + name);
    }

}

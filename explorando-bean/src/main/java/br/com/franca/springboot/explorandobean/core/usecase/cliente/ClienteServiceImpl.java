package br.com.franca.springboot.explorandobean.core.usecase.cliente;

import br.com.franca.springboot.explorandobean.dataprovider.db.ClienteDao;

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

    @Override
    public void printDependencies() {
        System.out.println("clienteDao = " + clientDao);
    }

    @Override
    public void setClientDao(ClienteDao clientDao) {
        this.clientDao = clientDao;
    }
}

package br.com.franca.springboot.explorandobean.core.usecase.cliente;

import br.com.franca.springboot.explorandobean.dataprovider.db.ClienteDao;

public interface ClienteService {

    void setName(String name);
    String getName();

    void printDependencies();

    void init();

    void destroy();

}

package br.com.franca.springboot.explorandospring.core.usecase.cliente;

public interface ClienteService {

    void setName(String name);
    String getName();

    void printDependencies();

    void init();

    void destroy();

}

package br.com.franca.testes2024.servicoprincipal.service;

import br.com.franca.testes2024.servicoprincipal.dto.two.DTOTwo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class ServiceTwo {

    public DTOTwo methodOne(String fieldOne) {
        // retorna dado valido ou invalido
        // não lança exception
        return new DTOTwo();
    }

    public void methodTwo(DTOTwo dtoTwo) {
    }

    public void methodThree(DTOTwo dtoTwo) {
        // método lança exception se condição for verdadeira
        //  Mockito.doThrow(ex).when(serviceTwo).methodThree(dtoTwo);
    }

    public Map.Entry<String, List<String>> methodFour(Map<String, List<String>> map) {
        // método lança exception se condição for verdadeira

        return map.entrySet().stream().filter(e -> Objects.equals(Boolean.TRUE, Boolean.TRUE)).findFirst()
            .orElseThrow(this::returnRuntimeException);

    }

    private RuntimeException returnRuntimeException() {
        return new RuntimeException("erro");
    }

    public RuntimeException methodFive(String string, RuntimeException ex) {
        return new RuntimeException();
    }
}

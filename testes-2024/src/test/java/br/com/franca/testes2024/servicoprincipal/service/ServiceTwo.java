package br.com.franca.testes2024.servicoprincipal.service;

import br.com.franca.testes2024.servicoprincipal.dto.two.DTOTwo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ServiceTwo {

    public DTOTwo methodOne(String fieldOne) {
        return new DTOTwo();
    }

    public void methodTwo(DTOTwo dtoTwo) {
    }

    public void methodThree(DTOTwo dtoTwo) {
    }

    public Map.Entry<String, List<String>> methodFour(Map<String, List<String>> map) {
        return null;
    }

    public RuntimeException methodFive(String string, RuntimeException ex) {
        return null;
    }
}

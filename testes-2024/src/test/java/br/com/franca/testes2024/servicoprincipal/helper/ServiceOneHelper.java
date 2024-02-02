package br.com.franca.testes2024.servicoprincipal.helper;

import br.com.franca.testes2024.servicoprincipal.dto.two.DTOTwo;
import br.com.franca.testes2024.servicoprincipal.service.ServiceTwo;
import org.mockito.Mockito;

public class ServiceOneHelper {

    public static void whenMethodOneIsCalledThenReturnDTOTwoWithInvalidFieldTwo(ServiceTwo serviceTwo, String fieldOne, DTOTwo dtoTwo) {
        Mockito.when(serviceTwo.methodOne(fieldOne)).thenReturn(dtoTwo);
    }

    public static void doThrowExceptionWhenMethodThreeIsCalled(ServiceTwo serviceTwo, DTOTwo dtoTwo, RuntimeException ex) {
        Mockito.doThrow(ex).when(serviceTwo).methodThree(dtoTwo);
    }

    public static void whenMethodAAIsCalledThenReturnDTOTwoWithInvalidFieldOne() {
    }
}
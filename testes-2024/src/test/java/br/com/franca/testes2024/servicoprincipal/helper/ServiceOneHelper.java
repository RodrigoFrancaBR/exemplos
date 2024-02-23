package br.com.franca.testes2024.servicoprincipal.helper;

import br.com.franca.testes2024.servicoprincipal.dto.one.DTOOne;
import br.com.franca.testes2024.servicoprincipal.dto.two.DTOTwo;
import br.com.franca.testes2024.servicoprincipal.service.ServiceTwo;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ServiceOneHelper {

    // new

    public static void whenMethodOneIsCalledThenReturnDTOTwoWith(ServiceTwo serviceTwo, String fieldOne, DTOTwo dtoTwoWith) {
        // metodo retorna dado
        // não existe condição para lançar exception
        Mockito.when(serviceTwo.methodOne(fieldOne)).thenReturn(dtoTwoWith);
    }

    public static void doThrowExceptionWhenMethodThreeIsCalled(ServiceTwo serviceTwo, DTOTwo dtoTwo, RuntimeException ex) {
        // método lança exception se condição for verdadeira
        Mockito.doThrow(ex).when(serviceTwo).methodThree(dtoTwo);
    }

    public static void whenMethodAAIsCalledThenReturnDTOTwoWithInvalidFieldOne() {
    }

    public static void doNothingWhenMethodThreeIsCalled(ServiceTwo service, DTOTwo validDTOTwo) {
        // método lança exception se condição for verdadeira
        Mockito.doNothing().when(service).methodThree(validDTOTwo);
    }

    public static void whenMethodFourIsCalledThenReturnValidData(ServiceTwo service, DTOTwo validDTOTwo) {
        // método lança exception se condição for verdadeira
        // aqui podemos chamar o thenCallRealMethod() ou o retorno mocado.
        Optional<Map<String, List<String>>> optional = validDTOTwo.getFieldThree();
        // tem que implementar o método para poder ter o resultado esperado.
        // final var first = optional.get().entrySet().stream().filter(e -> Objects.equals("", "")).findFirst();
        Mockito.when(service.methodFour(optional.get())).thenCallRealMethod();
    }
}
package br.com.franca.testes2024.servicoprincipal;

import br.com.franca.testes2024.servicoprincipal.helper.DTOOneHelper;
import br.com.franca.testes2024.servicoprincipal.helper.DTOTwoHelper;
import br.com.franca.testes2024.servicoprincipal.helper.ServiceOneHelper;
import br.com.franca.testes2024.servicoprincipal.mapper.ServiceMapperOne;
import br.com.franca.testes2024.servicoprincipal.service.ServiceOne;
import br.com.franca.testes2024.servicoprincipal.service.ServiceThree;
import br.com.franca.testes2024.servicoprincipal.service.ServiceTwo;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceOneTest {
    @Mock
    private ServiceMapperOne serviceMapperOne;
    @Mock
    private ServiceThree serviceThree;
    @Mock
    private ServiceTwo serviceTwo;
    @InjectMocks
    private ServiceOne serviceOne;

    @SneakyThrows
    @Test
    void methodOne_shouldReturnDataOneOK_whenDataTwoIsOk() {
        final var validDtoOne = DTOOneHelper.getValidDTOOne();
        final var validDTOTwo = DTOTwoHelper.getValidDTOTwo();
        ServiceOneHelper.whenMethodOneIsCalledThenReturnDTOTwoWith(serviceTwo, validDtoOne.getFieldOne(), validDTOTwo);
        ServiceOneHelper.doNothingWhenMethodThreeIsCalled(serviceTwo, validDTOTwo);
        ServiceOneHelper.whenMethodFourIsCalledThenReturnValidData(serviceTwo, validDTOTwo);
        org.assertj.core.api.Assertions.assertThatCode(() -> serviceOne.methodThree(validDtoOne));
        Mockito.verify(serviceTwo, Mockito.never()).methodFive(Mockito.any(), Mockito.any());
    }

    @SneakyThrows
    @Test
    void methodOne_shouldThrowException_whenInvalidFieldTwo() {
        final var dtoOne = DTOOneHelper.getValidDTOOne();
        final var dtoTwoWithInvalidFieldTwo = DTOTwoHelper.getValidDTOTwo();

        ServiceOneHelper.whenMethodOneIsCalledThenReturnDTOTwoWith(serviceTwo, dtoOne.getFieldOne(), dtoTwoWithInvalidFieldTwo);

        final var ex = new RuntimeException("");
        ServiceOneHelper.doThrowExceptionWhenMethodThreeIsCalled(serviceTwo, dtoTwoWithInvalidFieldTwo, ex);

        final var exception = Assertions.assertThrows(RuntimeException.class,
            () -> serviceOne.methodOne(dtoOne), "");
        Assertions.assertEquals(exception, ex);
    }

}

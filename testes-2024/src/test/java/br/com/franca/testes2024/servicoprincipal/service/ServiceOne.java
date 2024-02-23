package br.com.franca.testes2024.servicoprincipal.service;

import br.com.franca.testes2024.servicoprincipal.dto.one.DTOOne;
import br.com.franca.testes2024.servicoprincipal.dto.three.DTOThree;
import br.com.franca.testes2024.servicoprincipal.dto.two.DTOTwo;
import br.com.franca.testes2024.servicoprincipal.mapper.ServiceMapperOne;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ServiceOne {

    private final ServiceTwo serviceTwo;
    private final ServiceThree serviceThree;
    private final ServiceMapperOne serviceMapperOne;

    public DTOTwo methodOne(DTOOne dtoOne) {
        DTOTwo dtoTwo = serviceTwo.methodOne(dtoOne.getFieldOne());
        serviceTwo.methodTwo(dtoTwo);
        serviceTwo.methodThree(dtoTwo);
        Optional<Map<String, List<String>>> optional = dtoTwo.methodOne();

        final var string = optional.map(serviceTwo::methodFour)
            .map(Map.Entry::getValue)
            .map(e -> e.get(0))
            .orElseThrow(() -> {
                log.info("");
                return serviceTwo.methodFive("", new RuntimeException(""));
            });

        DTOThree dtoThreeV1 = new DTOThree();
        optional.ifPresent(e->{
            final DTOTwo DTOThreeV2 = serviceMapperOne.methodOne(string);
            BeanUtils.copyProperties(DTOThreeV2, dtoThreeV1);
        });

        return serviceThree.methodOne(dtoThreeV1);
    }

    public DTOThree methodThree(DTOOne validDtoOne) {
        return new DTOThree();
    }
}

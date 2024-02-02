package br.com.franca.testes2024.servicoprincipal.helper;

import br.com.franca.testes2024.servicoprincipal.dto.two.DTOTwo;

public class DTOTwoHelper {

    public static DTOTwo getValidDTOTwo() {
        final var json = DTOTwoHelper.getValidDTOTwoOfJson();
        return (DTOTwo) MapperHelper.writeStringAsObject(json, DTOTwo.class).orElse(new DTOTwo());
    }

    private static String getValidDTOTwoOfJson() {
        return """
            { "fieldOne": "valor 1 da DTOTwo",
              "fieldTwo" 2
            }
            """;
    }
}
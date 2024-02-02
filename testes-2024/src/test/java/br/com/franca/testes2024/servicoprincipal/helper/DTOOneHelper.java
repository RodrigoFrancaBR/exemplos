package br.com.franca.testes2024.servicoprincipal.helper;

import br.com.franca.testes2024.servicoprincipal.dto.one.DTOOne;

public class DTOOneHelper {

    public static DTOOne getValidDTOOne() {
        final var json = DTOOneHelper.getValidDTOOneOfJson();
        return (DTOOne) MapperHelper.writeStringAsObject(json, DTOOne.class).orElse(new DTOOne());
    }

    private static String getValidDTOOneOfJson() {
        return """
            { "fieldOne": "valor 1",
              "fieldTwo" 2
            }
            """;
    }
}

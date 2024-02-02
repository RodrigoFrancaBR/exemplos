package br.com.franca.testes2024.servicoprincipal.dto.three;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOThree {
    private String fieldOne;
    private String fieldTwo;
    private DTOAA fieldThree;
}
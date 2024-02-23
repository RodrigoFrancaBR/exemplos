package br.com.franca.testes2024.servicoprincipal.dto.two;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOTwo {
    private String fieldOne;
    private Integer fieldTwo;

    public Optional<Map<String, List<String>>> methodOne() {
        return Optional.empty();
    }

    public Optional<Map<String, List<String>>> getFieldThree() {
        return Optional.of(Map.of("key", List.of("value")));
    }
}
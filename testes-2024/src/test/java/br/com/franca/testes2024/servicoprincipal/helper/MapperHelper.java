package br.com.franca.testes2024.servicoprincipal.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@UtilityClass
public class MapperHelper {

    private final ObjectMapper mapper = MapperHelper.getMapper();

    private static ObjectMapper getMapper() {
        final var mapper = new ObjectMapper().findAndRegisterModules()
            // entender o que essas configs fazem...
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
            .enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)
            .registerModule(new JavaTimeModule());
        return mapper;
    }

    public static Optional<Object> writeStringAsObject(String someString, Class<?> someClass) {
        try {
            final var someObject = mapper.readValue(someString, someClass);
            return Optional.of(someObject);
        } catch (JsonProcessingException e) {
            log.error("Error writeStringAsObject someString: {} someClass: {}", someString, someClass);
            return Optional.empty();
        }
    }
}
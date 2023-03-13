package br.com.franca.springboot.explorandospring.entrypoint.api.logger.contract;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface ILoggerController {
    @GetMapping("/log")
    String index();
}

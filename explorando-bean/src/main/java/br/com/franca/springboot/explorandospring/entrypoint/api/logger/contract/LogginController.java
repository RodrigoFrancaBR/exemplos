package br.com.franca.springboot.explorandospring.entrypoint.api.logger.contract;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class LogginController implements ILoggerController{

    Logger logger = LoggerFactory.getLogger(LogginController.class);

    @Override
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        return "Hello World Rest API";
    }
}

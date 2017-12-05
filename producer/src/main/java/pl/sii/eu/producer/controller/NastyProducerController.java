package pl.sii.eu.producer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sii.eu.contracts.CurrentTime;
import pl.sii.eu.contracts.SystemVersionsWrapper;
import pl.sii.eu.producer.service.CurrentTimeService;

@RestController
@RequestMapping("/nasty/systemversion")
public class NastyProducerController {

    private final CurrentTimeService currentTimeService;

    public NastyProducerController(CurrentTimeService currentTimeService) {
        this.currentTimeService = currentTimeService;
    }

    @PostMapping
    public CurrentTime acknowledgeExistenceOfVersions(@RequestBody SystemVersionsWrapper systemVersionsWrapper) {
        return new CurrentTime(currentTimeService.getCurrentTime());
    }
}

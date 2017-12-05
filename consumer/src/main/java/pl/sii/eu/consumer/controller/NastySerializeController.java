package pl.sii.eu.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.sii.eu.contracts.CurrentTime;
import pl.sii.eu.contracts.SystemVersions;
import pl.sii.eu.contracts.SystemVersionsWrapper;
import pl.sii.eu.contracts.Version;

import java.net.URI;
import java.time.ZoneId;

@RequestMapping("/nasty")
@RestController
public class NastySerializeController {

    private final RestTemplate restTemplate;

    @Autowired
    public NastySerializeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String doNastyThings() {
        Version iPhoneVersion = new Version(11, 2);
        Version androidVersion = new Version(7, 0, 0);
        SystemVersions systemVersions = new SystemVersions(iPhoneVersion, androidVersion);
        SystemVersionsWrapper systemVersionsWrapper = new SystemVersionsWrapper(systemVersions);
        ResponseEntity<CurrentTime> response = restTemplate.exchange(
                RequestEntity.post(URI.create("http://localhost:8090/nasty/systemversion"))
                        .contentType(MediaType.valueOf("application/vnd.nasty-version.request.v1+json;charset=UTF-8"))
                        .accept(MediaType.valueOf("application/vnd.nasty-version.response.v1+json;charset=UTF-8"))
                        .body(systemVersionsWrapper),
                CurrentTime.class);
        return response.getBody().getTime().withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime().toString();
    }
}

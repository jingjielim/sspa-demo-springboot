package sspa.demo.springboot.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    @GetMapping("/super-fast")
    public ResponseEntity<String> getSuperFastApi() {
        log.info("Super-fast API called, replying immediately");

        return ResponseEntity.ok().body("Super-fast response!");
    }

    @GetMapping("/fast")
    public ResponseEntity<String> getFastApi() throws InterruptedException {
        log.info("Fast API called, sleeping for 20 ms");
        Thread.sleep(20); // sleep for 20 milliseconds
        return ResponseEntity.ok().body("I'm fast!");
    }

    @GetMapping("/slow")
    public ResponseEntity<String> getSlowApi() throws InterruptedException {
        log.info("Slow API called, sleeping for 3 seconds");
        Thread.sleep(3000); // sleep for 3 seconds
        return ResponseEntity.ok().body("I'm slow :(!");
    }

    @GetMapping("/super-slow")
    public String getSuperSlowApi() throws InterruptedException {
        log.info("Super slow API... sleeping for 30 seconds");
        Thread.sleep(30000); // sleep for 1 minute!
        log.info("Super slow API... done sleeping... simulating API that may have a error somewhere~");
        return "I'm super slow.";
    }

    @GetMapping("/server-error")
    public ResponseEntity<String> getServerError() {

        log.error("This endpoint returns an error... Multiple debug messages goes here...");
        return ResponseEntity.internalServerError().body("Internal server error");
    }

    @GetMapping("/throw-error")
    public String getError() {

        log.error("This endpoint throws an error... Multiple debug messages goes here...");
        throw new RuntimeException("Something went terribly wrong");
    }
}

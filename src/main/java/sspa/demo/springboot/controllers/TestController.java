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


        return ResponseEntity.ok().body("Super-fast response!");
    }

    @GetMapping("/fast")
    public ResponseEntity<String> getFastApi() throws InterruptedException {

        Thread.sleep(20); // sleep for 20 milliseconds
        return ResponseEntity.ok().body("I'm fast!");
    }

    @GetMapping("/slow")
    public ResponseEntity<String> getSlowApi() throws InterruptedException {

        Thread.sleep(3000); // sleep for 3 seconds
        return ResponseEntity.ok().body("I'm slow :(!");
    }

    @GetMapping("/super-slow")
    public String getSuperSlowApi() throws InterruptedException {

        Thread.sleep(30000); // sleep for 1 minute!
        return "I'm super slow.";
    }

    @GetMapping("/server-error")
    public ResponseEntity<String> getServerError() {
        return ResponseEntity.internalServerError().body("Internal server error");
    }

    @GetMapping("/throw-error")
    public String getError() {
        throw new RuntimeException("Something went terrible wrong");
    }
}

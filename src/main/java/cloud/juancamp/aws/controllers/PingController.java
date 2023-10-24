package cloud.juancamp.aws.controllers;

import cloud.juancamp.aws.services.PingService;
import cloud.juancamp.aws.utils.Context;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PingController {
    private final PingService pingService;

    public PingController(PingService pingService) {
        this.pingService = pingService;
    }

    @GetMapping("/ping")
    public Object ping(HttpServletRequest request) throws IOException {
        final Context context = new Context(request);

        return pingService.getPingInformation(context);
    }
}

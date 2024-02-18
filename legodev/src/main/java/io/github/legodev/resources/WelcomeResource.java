package io.github.legodev.resources;

import com.codahale.metrics.annotation.Timed;
import io.github.legodev.api.WelcomeMessage;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/welcome")
@Produces(MediaType.APPLICATION_JSON)
public class WelcomeResource {

    private final String template;
    private final String defaultName;

    private final AtomicLong visitorId;

    public WelcomeResource(String template, String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.visitorId = new AtomicLong();
    }

    @GET
    @Timed
    public WelcomeMessage getWelcomeMessage(@QueryParam("name") Optional<String> visitorName){
        return new WelcomeMessage(visitorId.incrementAndGet(), String.format(template, visitorName.orElse(defaultName)));
    }
}

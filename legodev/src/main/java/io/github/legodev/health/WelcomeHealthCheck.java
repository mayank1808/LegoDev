package io.github.legodev.health;

import com.codahale.metrics.health.HealthCheck;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WelcomeHealthCheck extends HealthCheck {

    private final String template;

    @Override
    protected Result check() throws Exception {
        final String testName = "TEST";
        String content = String.format(template, testName);
        if(!content.contains(testName)){
            return Result.unhealthy("Template not configured correctly");
        }
        return Result.healthy();
    }
}

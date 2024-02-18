package io.github.legodev;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.github.legodev.health.WelcomeHealthCheck;
import io.github.legodev.resources.WelcomeResource;

public class LegoDevApplication extends Application<LegoDevConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LegoDevApplication().run(args);
    }

    @Override
    public String getName() {
        return "LegoDev";
    }

    @Override
    public void initialize(final Bootstrap<LegoDevConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final LegoDevConfiguration configuration,
                    final Environment environment) {
        WelcomeResource welcomeResource = new WelcomeResource(configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(welcomeResource);

        WelcomeHealthCheck welcomeHealthCheck = new WelcomeHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("WelcomeHealthCheck", welcomeHealthCheck);
    }

}

package org.davide.rest.swagger.test;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * /jaxrs-server/src/gen/java/io/swagger/model location of User generated class
 *
 * @author davide
 */
public class TestApplication extends Application<TestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TestApplication().run(args);
    }

    @Override
    public String getName() {
        return "swagger-test";
    }

    @Override
    public void initialize(final Bootstrap<TestConfiguration> bootstrap) {

    }

    @Override
    public void run(final TestConfiguration configuration,
            final Environment environment) {
        // TODO: implement application
    }

}

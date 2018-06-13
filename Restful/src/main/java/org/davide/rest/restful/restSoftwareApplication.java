package org.davide.rest.restful;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import javax.ws.rs.client.Client;
import org.davide.rest.restful.resources.ClientRestSoftwareResource;
import org.davide.rest.restful.resources.restSoftwareResource;

public class restSoftwareApplication extends Application<restSoftwareConfiguration> {

    public static void main(final String[] args) throws Exception {
        new restSoftwareApplication().run(args);
    }

    @Override
    public String getName() {
        return "restSoftware";
    }

    @Override
    public void initialize(final Bootstrap<restSoftwareConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final restSoftwareConfiguration configuration,
            final Environment environment) {
        environment.jersey().register(new restSoftwareResource());
        // build the client and add the resource to the environment
        final Client client = (Client) new JerseyClientBuilder(environment).build("REST Client");
        environment.jersey().register(new ClientRestSoftwareResource(client));
    }

}

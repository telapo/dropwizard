package org.davide.rest.dropwizard2;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.swagger.jaxrs.config.BeanConfig;
import org.davide.rest.dropwizard2.resources.HelloWorldResource;

public class dropwizard2Application extends Application<dropwizard2Configuration> {

    public static void main(final String[] args) throws Exception {
        new dropwizard2Application().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard2";
    }

    @Override
    public void initialize(final Bootstrap<dropwizard2Configuration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/swagger-ui-master/dist", "/swagger-ui", "index.html", "swagger-ui"));
        bootstrap.addBundle(new AssetsBundle("/assets/swagger-file", "/swagger", "swagger.json", "swagger-file"));
    }

    @Override
    public void run(final dropwizard2Configuration configuration,
            final Environment environment) {
//        environment.jersey().register(new ApiListingResource());
//        environment.jersey().register(new PetResource());
        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        BeanConfig config = new BeanConfig();
        config.setTitle("Swagger sample app");
        config.setVersion("1.0.0");
        config.setResourcePackage("io.swagger.sample.resource");
        config.setScan(true);

        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
    }

}

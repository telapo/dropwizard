package org.davide.rest.swagger.test.api.factories;

import org.davide.rest.swagger.test.api.PetApiService;
import org.davide.rest.swagger.test.api.impl.PetApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-06-11T20:34:10.280+01:00")
public class PetApiServiceFactory {
    private final static PetApiService service = new PetApiServiceImpl();

    public static PetApiService getPetApi() {
        return service;
    }
}

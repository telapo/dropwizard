package org.davide.rest.swagger.test.api.factories;

import org.davide.rest.swagger.test.api.UpdateUserApiService;
import org.davide.rest.swagger.test.api.impl.UpdateUserApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-06-11T20:34:10.280+01:00")
public class UpdateUserApiServiceFactory {
    private final static UpdateUserApiService service = new UpdateUserApiServiceImpl();

    public static UpdateUserApiService getUpdateUserApi() {
        return service;
    }
}

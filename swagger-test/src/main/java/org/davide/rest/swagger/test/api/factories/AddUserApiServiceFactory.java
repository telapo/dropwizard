package org.davide.rest.swagger.test.api.factories;

import org.davide.rest.swagger.test.api.AddUserApiService;
import org.davide.rest.swagger.test.api.impl.AddUserApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-06-11T20:34:10.280+01:00")
public class AddUserApiServiceFactory {
    private final static AddUserApiService service = new AddUserApiServiceImpl();

    public static AddUserApiService getAddUserApi() {
        return service;
    }
}

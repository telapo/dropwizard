package org.davide.rest.swagger.test.api;

import org.davide.rest.swagger.test.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import org.davide.rest.swagger.test.model.User;

import java.util.List;
import org.davide.rest.swagger.test.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-06-11T20:34:10.280+01:00")
public abstract class AddUserApiService {
    public abstract Response addUser(User body,SecurityContext securityContext) throws NotFoundException;
}

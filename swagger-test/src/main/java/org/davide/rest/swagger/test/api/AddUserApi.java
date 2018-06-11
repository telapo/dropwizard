package org.davide.rest.swagger.test.api;

import io.swagger.model.*;
import org.davide.rest.swagger.test.api.AddUserApiService;
import org.davide.rest.swagger.test.api.factories.AddUserApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import org.davide.rest.swagger.test.model.User;

import java.util.Map;
import java.util.List;
import org.davide.rest.swagger.test.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/addUser")


@io.swagger.annotations.Api(description = "the addUser API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-06-11T20:34:10.280+01:00")
public class AddUserApi  {
   private final AddUserApiService delegate;

   public AddUserApi(@Context ServletConfig servletContext) {
      AddUserApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("AddUserApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (AddUserApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = AddUserApiServiceFactory.getAddUserApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add a new user", notes = "", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    public Response addUser(@ApiParam(value = "User object that needs to be added to the store" ,required=true) User body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addUser(body,securityContext);
    }
}

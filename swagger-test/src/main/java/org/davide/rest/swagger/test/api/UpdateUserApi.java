package org.davide.rest.swagger.test.api;

import io.swagger.model.*;
import org.davide.rest.swagger.test.api.UpdateUserApiService;
import org.davide.rest.swagger.test.api.factories.UpdateUserApiServiceFactory;

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

@Path("/updateUser")


@io.swagger.annotations.Api(description = "the updateUser API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-06-11T20:34:10.280+01:00")
public class UpdateUserApi  {
   private final UpdateUserApiService delegate;

   public UpdateUserApi(@Context ServletConfig servletContext) {
      UpdateUserApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("UpdateUserApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (UpdateUserApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = UpdateUserApiServiceFactory.getUpdateUserApi();
      }

      this.delegate = delegate;
   }

    @PUT
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update an existing User", notes = "", response = Void.class, tags={ "updateUser", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Validation exception", response = Void.class) })
    public Response updateUser(@ApiParam(value = "User object that needs to be added to the store" ,required=true) User body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateUser(body,securityContext);
    }
}

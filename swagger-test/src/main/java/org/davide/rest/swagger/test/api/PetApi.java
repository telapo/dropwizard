package org.davide.rest.swagger.test.api;

import io.swagger.model.*;
import org.davide.rest.swagger.test.api.PetApiService;
import org.davide.rest.swagger.test.api.factories.PetApiServiceFactory;

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

@Path("/pet")


@io.swagger.annotations.Api(description = "the pet API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-06-11T20:34:10.280+01:00")
public class PetApi  {
   private final PetApiService delegate;

   public PetApi(@Context ServletConfig servletContext) {
      PetApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("PetApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (PetApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = PetApiServiceFactory.getPetApi();
      }

      this.delegate = delegate;
   }

    @GET
    @Path("/findByName")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Finds User by status", notes = "Multiple status values can be provided with comma separated strings", response = User.class, responseContainer = "List", tags={ "pet", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = User.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid status value", response = Void.class) })
    public Response findUsersByStatus(@ApiParam(value = "Status values that need to be considered for filter",required=true) @QueryParam("status") String status
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findUsersByStatus(status,securityContext);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.davide.rest.restful.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.davide.rest.restful.api.Contact;

/**
 *
 * CRUD operations:
 *
 * POST for creating a resource PUT for updating a resource DELETE for deleting
 * a resource GET for returning the representation of a resource
 *
 * @author davide
 */
@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class restSoftwareResource {

    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {
        /*
        The method Response#ok() accepts an Object instance as the parameter, which is then serialized to our service's response format (defined by the @Produces annotation) accordingly. The usage of this method returns an HTTP 200 OK response code to the client.
         */
        return Response
                .ok(new Contact(id, "John", "Doe", "+123456789"))
                .build();
    }

    @POST
    public Response createContact(
            Contact contact) {
        return Response
                .created(null)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        // delete the contact with the provided id
        // ...
        return Response
                .noContent()
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateContact(
            @PathParam("id") int id,
            Contact contact) {
        /*
        curl -X PUT -d 'firstName=FOO&lastName=BAR&phone=123456' http://localhost:8080/contact/123

        The PUT request we performed in the previous example can now be performed by sending the JSON data to the server and setting the appropriate header, as shown in the following line of code
        curl --header "Content-Type: application/json" -X PUT -d '{"firstName": "FOO", "lastName":"BAR", "phone":"987654321"}' http://localhost:8080/contact/123

         */
        return Response
                .ok(new Contact(id, contact.getFirstName(), contact.getLastName(), contact.getPhone()))
                .build();
    }
}

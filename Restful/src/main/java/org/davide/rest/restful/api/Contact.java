/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.davide.rest.restful.api;

/**
 *
 * Given that our web service needs to produce contact-related information in
 * the JSON format, a sample response would look something like the following
 * code:
 *
 * { id: 1, firstName: "John", lastName: "Doe", phone: "+123-456-789" }
 *
 * We will build our representation class around this JSON string. The class
 * will have the necessary properties (id, firstName, lastName, and phone) along
 * with their getter methods.
 *
 * Instances of this class may now be used in our Jersey-based REST resources as
 * the output. Jackson will handle the transformation from POJO to JSON
 * transparently.
 *
 * You can prevent a property from being a part of the JSON representation by
 * adding the @JsonIgnore annotation to its getter.
 *
 * @author davide
 */
public class Contact {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final String phone;

    public Contact() {
        this.id = 0;
        this.firstName = null;
        this.lastName = null;
        this.phone = null;
    }

    public Contact(int id, String firstName, String lastName, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

}

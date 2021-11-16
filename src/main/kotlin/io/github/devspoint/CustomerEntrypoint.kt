package io.github.devspoint

import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.GET
import javax.ws.rs.PathParam
import javax.transaction.Transactional
import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery


@Transactional
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CustomerEntrypoint {

    @POST
    fun created(customer: CustomerEntity): CustomerEntity {
        customer.persist()
        return customer
    }

    @GET
    @Path("/{id}")
    fun get(@PathParam("id") id: Long): CustomerEntity? {
        return CustomerEntity.findById(id)
    }

    @GET
    fun getList(): List<CustomerEntity> {
        return CustomerEntity.findAll().list()
    }
}
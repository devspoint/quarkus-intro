package io.github.devspoint

import javax.inject.Inject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

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

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: Long) {
        CustomerEntity.deleteById(id)
    }

}
package io.github.devspoint

import io.github.devspoint.springdata.CustomerSpringDataEntity
import io.github.devspoint.springdata.CustomerSpringDataRepository
import javax.inject.Inject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Transactional
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CustomerEntrypoint {

    @Inject
    private lateinit var customerSpringDataRepository: CustomerSpringDataRepository

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

    @PUT
    @Path("/{id}")
    fun update(@PathParam("id") id: Long, customer: CustomerEntity) {
        CustomerEntity.findById(id)?.let {
            it.copy(firstname = customer.firstname, lastname = customer.lastname)
        }?.persist()
    }

    @GET
    @Path("/spring")
    fun getListSpring(@QueryParam("lastname") lastname: String): Iterable<CustomerSpringDataEntity>? {
        return customerSpringDataRepository.findByLastname(lastname)
    }
}
package io.github.devspoint.springdata

import org.springframework.data.repository.CrudRepository

interface CustomerSpringDataRepository : CrudRepository<CustomerSpringDataEntity, Long> {

    fun findByLastname(lastname: String): List<CustomerSpringDataEntity>

}
package io.github.devspoint

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import javax.persistence.Entity

@Entity
data class CustomerEntity(
    var firstname: String? = null,
    var lastname: String? = null
) : PanacheEntity() {

    companion object : PanacheCompanion<CustomerEntity> {
        fun findByFirstname(firstname: String) = CustomerEntity.find("firstname", firstname).firstResult()
    }

}
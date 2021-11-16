package io.github.devspoint

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import javax.persistence.Entity

@Entity
class CustomerEntity : PanacheEntity() {

    companion object : PanacheCompanion<CustomerEntity> {
        fun findByFirstname(firstname: String) = CustomerEntity.find("firstname", firstname).firstResult()
    }

    lateinit var firstname: String
    lateinit var lastname: String
}
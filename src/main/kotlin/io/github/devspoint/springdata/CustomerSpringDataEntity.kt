package io.github.devspoint.springdata

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "CustomerEntity")
data class CustomerSpringDataEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var firstname: String? = null,
    var lastname: String? = null
)
package de.dev.schleis.kotlinspringjpa.persistence.unit

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User(
        @Id @GeneratedValue var id: Long? = null,
        var firstname: String,
        var lastname: String
)
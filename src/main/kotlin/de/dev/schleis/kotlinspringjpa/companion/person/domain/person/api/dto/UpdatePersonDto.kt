package de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api.dto

data class UpdatePersonDto (
        var id: Long,
        var firstname: String,
        var lastname: String
)
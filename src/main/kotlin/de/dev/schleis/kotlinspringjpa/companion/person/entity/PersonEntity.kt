package de.dev.schleis.kotlinspringjpa.companion.person.entity

import de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api.dto.CreatePersonDto
import de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api.dto.PersonDto
import de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api.dto.UpdatePersonDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "person")
internal data class PersonEntity(
        @Id @GeneratedValue val id: Long? = null,
        val firstname: String,
        val lastname: String) {

    fun toDto(): PersonDto = PersonDto(
            id = this.id!!,
            firstname = this.firstname,
            lastname = this.lastname
    )

    companion object {

        fun fromDto(dto: PersonDto) = PersonEntity(
                id = dto.id,
                firstname = dto.firstname,
                lastname = dto.lastname
        )

        fun fromDto(dto: CreatePersonDto) = PersonEntity(
                firstname = dto.firstname,
                lastname = dto.lastname
        )

        fun fromDto(dto: UpdatePersonDto, defaultPerson: PersonEntity) = PersonEntity(
                id = defaultPerson.id!!,
                firstname = dto.firstname,
                lastname = dto.lastname
        )
    }
}

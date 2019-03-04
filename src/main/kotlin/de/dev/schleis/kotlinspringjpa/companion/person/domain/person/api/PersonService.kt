package de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api

import de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api.dto.CreatePersonDto
import de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api.dto.PersonDto
import de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api.dto.UpdatePersonDto

interface PersonService {
    fun retrievePerson(personId: Long): PersonDto?

    fun retrivePersons(): List<PersonDto>

    fun addPerson(person: CreatePersonDto): PersonDto

    fun updatePerson(id: Long, person: UpdatePersonDto): PersonDto?
}
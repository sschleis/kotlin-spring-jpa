package de.dev.schleis.kotlinspringjpa.companion.person

import de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api.PersonService
import de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api.dto.CreatePersonDto
import de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api.dto.PersonDto
import de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api.dto.UpdatePersonDto
import de.dev.schleis.kotlinspringjpa.companion.person.entity.PersonEntity
import de.dev.schleis.kotlinspringjpa.companion.person.repository.PersonRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
internal class JpaPersonService(val personRepository: PersonRepository) : PersonService {

    override fun retrievePerson(personId: Long): PersonDto? {
        println("--DEBUG-- Retrieving person: $personId")

        val findById = personRepository.findById(personId)
        return if(findById.isPresent) findById.get().toDto() else null
    }

    override fun retrivePersons(): List<PersonDto> {
        println("--DEBUG-- Retrieving all persons")

        return personRepository.findAll().map {it.toDto()}
    }

    override fun addPerson(person: CreatePersonDto): PersonDto {
        println("--DEBUG-- Adding person: $person")

        return personRepository.save(PersonEntity.fromDto(person)).toDto()
    }

    override fun updatePerson(id: Long, person: UpdatePersonDto): PersonDto? {
        println("--DEBUG-- Updating person: $id with data: $person")

        val currentPerson = personRepository.findById(id)
        return if (currentPerson.isPresent) personRepository.save(PersonEntity.fromDto(person, currentPerson.get())).toDto()
        else null
    }

}
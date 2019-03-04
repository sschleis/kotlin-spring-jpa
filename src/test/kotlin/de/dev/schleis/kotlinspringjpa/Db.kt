package de.dev.schleis.kotlinspringjpa

import de.dev.schleis.kotlinspringjpa.companion.person.JpaPersonService
import de.dev.schleis.kotlinspringjpa.companion.person.domain.person.api.dto.CreatePersonDto
import de.dev.schleis.kotlinspringjpa.persistence.repository.UserRepository
import de.dev.schleis.kotlinspringjpa.persistence.unit.User
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class Db {

    @Autowired
    lateinit var user: UserRepository

    @Autowired
    private lateinit var person: JpaPersonService

    @Test
    fun test() {
        val findAll = user.findAll()
        println(findAll)
        println("---------")
        user.save(User(firstname = "Han", lastname = "Solo"))
        val findAll1 = user.findAll()
        println(findAll1)
    }

    @Test
    fun testService() {
        println("---------")
        val allPersons = person.retrivePersons()
        println(allPersons)
        println("---------")
        val addPerson = person.addPerson(CreatePersonDto(firstname = "Han", lastname = "Solo"))
        println(addPerson)
        println("---------")
        val retrievePerson = person.retrievePerson(2)
        println(retrievePerson?.firstname!!.toUpperCase())
        println("---------")
    }
}
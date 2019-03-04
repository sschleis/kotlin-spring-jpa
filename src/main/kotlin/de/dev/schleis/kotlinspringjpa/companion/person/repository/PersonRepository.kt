package de.dev.schleis.kotlinspringjpa.companion.person.repository

import de.dev.schleis.kotlinspringjpa.companion.person.entity.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
internal interface PersonRepository : JpaRepository<PersonEntity, Long>
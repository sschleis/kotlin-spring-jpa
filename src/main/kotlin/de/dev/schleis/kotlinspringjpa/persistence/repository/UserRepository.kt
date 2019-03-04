package de.dev.schleis.kotlinspringjpa.persistence.repository

import de.dev.schleis.kotlinspringjpa.persistence.unit.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>
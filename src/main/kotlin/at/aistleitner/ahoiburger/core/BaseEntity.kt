package at.aistleitner.ahoiburger.core

import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import java.util.*

@MappedSuperclass
abstract class BaseEntity(
    @Id
    val id: UUID = UUID.randomUUID()
)
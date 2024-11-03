package at.aistleitner.ahoiburger.drink.entity

import at.aistleitner.ahoiburger.core.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "drink")
data class Drink(
    val name: String,
    val description: String? = null,
    val image: String? = null,
    val price: BigDecimal,
    val available: Boolean = true,
) : BaseEntity()

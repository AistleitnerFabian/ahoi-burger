package at.aistleitner.ahoiburger.burger.entity

import at.aistleitner.ahoiburger.core.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "burger")
data class Burger(
    val name: String,
    val description: String? = null,
    val image: String? = null,
    val price: BigDecimal,
    val weight: BigDecimal? = null,
    val vegetarian: Boolean = false,
    val available: Boolean = true,

    @Column(name = "special_ingredients", columnDefinition = "TEXT[]")
    val specialIngredients: List<String> = emptyList(),

    @Column(name = "allergens", columnDefinition = "TEXT[]")
    val allergens: List<Allergen> = emptyList()
) : BaseEntity()

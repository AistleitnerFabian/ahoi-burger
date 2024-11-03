package at.aistleitner.ahoiburger.burger.dto

import java.math.BigDecimal
import at.aistleitner.ahoiburger.burger.entity.Allergen
import at.aistleitner.ahoiburger.burger.entity.Burger
import java.util.*

data class BurgerResponse(
    val id: UUID?,
    val name: String,
    val description: String? = null,
    val image: String? = null,
    val price: BigDecimal,
    val weight: BigDecimal? = null,
    val vegetarian: Boolean = false,
    val available: Boolean = true,
    val specialIngredients: List<String> = emptyList(),
    val allergens: List<Allergen> = emptyList()
)

fun Burger.toResponse(): BurgerResponse {
    return BurgerResponse(
        id = this.id,
        name = this.name,
        description = this.description,
        image = this.image,
        price = this.price,
        weight = this.weight,
        vegetarian = this.vegetarian,
        available = this.available,
        specialIngredients = this.specialIngredients,
        allergens = this.allergens
    )
}
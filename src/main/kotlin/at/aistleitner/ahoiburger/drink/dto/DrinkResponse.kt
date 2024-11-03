package at.aistleitner.ahoiburger.drink.dto

import java.math.BigDecimal
import java.util.*
import at.aistleitner.ahoiburger.drink.entity.Drink

data class DrinkResponse(
    val id: UUID,
    val name: String,
    val description: String? = null,
    val image: String? = null,
    val price: BigDecimal,
    val available: Boolean = true
)

fun Drink.toResponse(): DrinkResponse {
    return DrinkResponse(
        id = this.id,
        name = this.name,
        description = this.description,
        image = this.image,
        price = this.price,
        available = this.available
    )
}

package at.aistleitner.ahoiburger.drink

import at.aistleitner.ahoiburger.drink.dto.DrinkResponse
import at.aistleitner.ahoiburger.drink.dto.toResponse
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.util.UUID

@RestController
@RequestMapping("/drinks")
class DrinkController(val drinkService: DrinkService) {

    @GetMapping
    fun getAllDrinks(): List<DrinkResponse> {
        return drinkService.getAllDrinks().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getDrinkById(@PathVariable id: UUID): DrinkResponse {
        return drinkService.getDrinkById(id).toResponse()
    }
    @GetMapping("/search")
    fun searchDrinks(
        @RequestParam name: String? = null,
        @RequestParam minPrice: BigDecimal? = null,
        @RequestParam maxPrice: BigDecimal? = null
    ): List<DrinkResponse> {
        return drinkService.searchDrinks(name, minPrice, maxPrice).map { it.toResponse() }
    }
}
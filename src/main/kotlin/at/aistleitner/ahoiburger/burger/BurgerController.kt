package at.aistleitner.ahoiburger.burger

import at.aistleitner.ahoiburger.burger.dto.BurgerResponse
import at.aistleitner.ahoiburger.burger.dto.toResponse
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.util.UUID

@RestController
@RequestMapping("/burgers")
class BurgerController(private val burgerService: BurgerService) {
    @GetMapping
    fun getAllBurgers(): List<BurgerResponse> {
        return burgerService.getAllBurgers().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getBurgerById(@PathVariable id: UUID): BurgerResponse {
        return burgerService.getBurgerById(id).toResponse()
    }

    @GetMapping("/search")
    fun searchBurgers(
        @RequestParam name: String? = null,
        @RequestParam minPrice: BigDecimal? = null,
        @RequestParam maxPrice: BigDecimal? = null
    ): List<BurgerResponse> {
        return burgerService.searchBurgers(name, minPrice, maxPrice).map { it.toResponse() }
    }
}
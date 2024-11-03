package at.aistleitner.ahoiburger.drink

import at.aistleitner.ahoiburger.drink.dto.DrinkResponse
import at.aistleitner.ahoiburger.drink.dto.toResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
}
package at.aistleitner.ahoiburger.burger

import at.aistleitner.ahoiburger.burger.dto.BurgerResponse
import at.aistleitner.ahoiburger.burger.dto.toResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
}
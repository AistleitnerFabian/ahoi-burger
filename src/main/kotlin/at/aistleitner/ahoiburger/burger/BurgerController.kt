package at.aistleitner.ahoiburger.burger

import at.aistleitner.ahoiburger.burger.entity.Burger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/burgers")
class BurgerController(private val burgerService: BurgerService) {

    @GetMapping
    fun getAllBurgers(): List<Burger> {
        return burgerService.getAllBurgers()
    }

    @GetMapping("/{id}")
    fun getBurgerById(@PathVariable id: UUID): Burger? {
        return burgerService.getBurgerById(id)
    }
}
package at.aistleitner.ahoiburger.burger

import at.aistleitner.ahoiburger.burger.entity.Burger
import org.springframework.stereotype.Service
import java.util.*

@Service
class BurgerService(val burgerRepository: BurgerRepository) {
    fun getAllBurgers(): List<Burger> {
        return emptyList()
    }

    fun getBurgerById(id: UUID): Burger? {
        return null
    }
}
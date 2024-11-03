package at.aistleitner.ahoiburger.burger

import at.aistleitner.ahoiburger.burger.entity.Burger
import at.aistleitner.ahoiburger.burger.exception.BurgerNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class BurgerService(val burgerRepository: BurgerRepository) {
    fun getAllBurgers(): List<Burger> {
        return burgerRepository.findAll()
    }

    fun getBurgerById(id: UUID): Burger {
        return burgerRepository.findByIdOrNull(id) ?: throw BurgerNotFoundException(id)
    }

    fun searchBurgers(name: String?, minPrice: BigDecimal?, maxPrice: BigDecimal?): List<Burger> {
        return burgerRepository.searchByNameAndPriceRange(name, minPrice, maxPrice)
    }
}
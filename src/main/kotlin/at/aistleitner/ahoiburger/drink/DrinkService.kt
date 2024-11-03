package at.aistleitner.ahoiburger.drink

import at.aistleitner.ahoiburger.drink.entity.Drink
import at.aistleitner.ahoiburger.drink.exception.DrinkNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class DrinkService(val drinkRepository: DrinkRepository) {
    fun getAllDrinks(): List<Drink> {
        return drinkRepository.findAll()
    }

    fun getDrinkById(id: UUID): Drink {
        return drinkRepository.findByIdOrNull(id) ?: throw DrinkNotFoundException(id)
    }

    fun searchDrinks(name: String?, minPrice: BigDecimal?, maxPrice: BigDecimal?): List<Drink> {
        return drinkRepository.searchByNameAndPriceRange(name, minPrice, maxPrice)
    }
}
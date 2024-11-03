package at.aistleitner.ahoiburger.drink

import at.aistleitner.ahoiburger.drink.entity.Drink
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DrinkRepository : JpaRepository<Drink, UUID> {}

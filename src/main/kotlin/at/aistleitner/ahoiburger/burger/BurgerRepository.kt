package at.aistleitner.ahoiburger.burger

import at.aistleitner.ahoiburger.burger.entity.Burger
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BurgerRepository : JpaRepository<Burger, UUID> {}

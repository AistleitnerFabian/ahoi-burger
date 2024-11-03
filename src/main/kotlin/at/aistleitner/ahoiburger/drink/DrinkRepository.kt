package at.aistleitner.ahoiburger.drink

import at.aistleitner.ahoiburger.drink.entity.Drink
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.math.BigDecimal
import java.util.*

interface DrinkRepository : JpaRepository<Drink, UUID> {

    @Query("""
        SELECT d FROM Drink d 
        WHERE (:name IS NULL OR d.name ILIKE CONCAT('%', CAST(:name AS text), '%'))
        AND (:minPrice IS NULL OR d.price >= :minPrice) 
        AND (:maxPrice IS NULL OR d.price <= :maxPrice)
    """)
    fun searchByNameAndPriceRange(
        @Param("name") name: String?,
        @Param("minPrice") minPrice: BigDecimal?,
        @Param("maxPrice") maxPrice: BigDecimal?
    ): List<Drink>
}

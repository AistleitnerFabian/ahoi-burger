package at.aistleitner.ahoiburger.burger

import at.aistleitner.ahoiburger.burger.entity.Burger
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.math.BigDecimal
import java.util.UUID

interface BurgerRepository : JpaRepository<Burger, UUID> {

    @Query(
        """
    SELECT b FROM Burger b 
    WHERE (:name IS NULL OR b.name ILIKE CONCAT('%', CAST(:name AS text), '%'))
    AND (:minPrice IS NULL OR b.price >= :minPrice) 
    AND (:maxPrice IS NULL OR b.price <= :maxPrice)
"""
    )
    fun searchByNameAndPriceRange(
        @Param("name") name: String?,
        @Param("minPrice") minPrice: BigDecimal?,
        @Param("maxPrice") maxPrice: BigDecimal?
    ): List<Burger>
}

package at.aistleitner.ahoiburger.drink

import at.aistleitner.ahoiburger.TestcontainersConfiguration
import at.aistleitner.ahoiburger.Testdata
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestcontainersConfiguration::class)
@Sql("/insert-drinks.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
class DrinkControllerIT @Autowired constructor(
    private val mockMvc: MockMvc,
) {

    @Test
    fun `GET all drinks - should return a list of drinks`() {
        mockMvc.get("/drinks") {
            header("X-Api-Key", Testdata.API_KEY)
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.length()") { value(3) }

                jsonPath("$[0].name") { value("Coca-Cola") }
                jsonPath("$[0].description") { value("Classic cola drink") }
                jsonPath("$[0].price") { value(1.99) }
                jsonPath("$[0].available") { value(true) }

                jsonPath("$[1].name") { value("Orange Juice") }
                jsonPath("$[1].description") { value("Freshly squeezed orange juice") }
                jsonPath("$[1].price") { value(2.99) }
                jsonPath("$[1].available") { value(true) }

                jsonPath("$[2].name") { value("Water") }
                jsonPath("$[2].description") { value("Still mineral water") }
                jsonPath("$[2].price") { value(0.99) }
                jsonPath("$[2].available") { value(true) }
            }
    }

    @Test
    fun `GET drink by ID - should return the specific drink`() {
        val drinkId = UUID.fromString("22222222-2222-2222-2222-222222222222")

        mockMvc.get("/drinks/$drinkId") {
            header("X-Api-Key", Testdata.API_KEY)
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }

                jsonPath("$.name") { value("Coca-Cola") }
                jsonPath("$.description") { value("Classic cola drink") }
                jsonPath("$.price") { value(1.99) }
                jsonPath("$.available") { value(true) }
            }
    }

    @Test
    fun `GET drink by ID not exists - should return 400 BAD REQUEST`() {
        val drinkId = UUID.fromString("00000000-0000-0000-0000-000000000000")

        mockMvc.get("/drinks/$drinkId") {
            header("X-Api-Key", Testdata.API_KEY)
        }
            .andExpect {
                status { isBadRequest() }
            }
    }

    @Test
    fun `SEARCH drinks by name - should return drinks matching name`() {
        mockMvc.get("/drinks/search") {
            header("X-Api-Key", Testdata.API_KEY)
            param("name", "Coca-Cola")
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.length()") { value(1) }

                jsonPath("$[0].name") { value("Coca-Cola") }
                jsonPath("$[0].description") { value("Classic cola drink") }
                jsonPath("$[0].price") { value(1.99) }
                jsonPath("$[0].available") { value(true) }
            }
    }

    @Test
    fun `SEARCH drinks by price range - should return drinks within range`() {
        mockMvc.get("/drinks/search") {
            header("X-Api-Key", Testdata.API_KEY)
            param("minPrice", "1.50")
            param("maxPrice", "3.00")
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.length()") { value(2) }

                jsonPath("$[0].name") { value("Coca-Cola") }
                jsonPath("$[0].price") { value(1.99) }

                jsonPath("$[1].name") { value("Orange Juice") }
                jsonPath("$[1].price") { value(2.99) }
            }
    }

    @Test
    fun `SEARCH drinks by name and price range - should return filtered results`() {
        mockMvc.get("/drinks/search") {
            header("X-Api-Key", Testdata.API_KEY)
            param("name", "Juice")
            param("minPrice", "2.00")
            param("maxPrice", "3.00")
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.length()") { value(1) }

                jsonPath("$[0].name") { value("Orange Juice") }
                jsonPath("$[0].description") { value("Freshly squeezed orange juice") }
                jsonPath("$[0].price") { value(2.99) }
                jsonPath("$[0].available") { value(true) }
            }
    }
}
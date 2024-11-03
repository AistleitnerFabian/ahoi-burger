package at.aistleitner.ahoiburger.burger

import at.aistleitner.ahoiburger.TestcontainersConfiguration
import at.aistleitner.ahoiburger.Testdata
import at.aistleitner.ahoiburger.burger.entity.Allergen
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
@Sql("/insert-burgers.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
class BurgerControllerIT @Autowired constructor(
    private val mockMvc: MockMvc,
) {

    @Test
    fun `GET all burgers - should return a list of burgers`() {
        mockMvc.get("/burgers") {
            header("X-Api-Key", Testdata.API_KEY)
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.length()") { value(3) }

                jsonPath("$[0].name") { value("Cheeseburger") }
                jsonPath("$[0].description") { value("A classic cheeseburger with melted cheese") }
                jsonPath("$[0].price") { value(5.99) }
                jsonPath("$[0].vegetarian") { value(false) }
                jsonPath("$[0].available") { value(true) }
                jsonPath("$[0].specialIngredients[0]") { value("Cheese") }
                jsonPath("$[0].specialIngredients[1]") { value("Lettuce") }
                jsonPath("$[0].allergens[0]") { value(Allergen.DAIRY.name) }

                jsonPath("$[1].name") { value("Veggie Burger") }
                jsonPath("$[1].description") { value("A delicious vegetarian option") }
                jsonPath("$[1].price") { value(7.99) }
                jsonPath("$[1].vegetarian") { value(true) }
                jsonPath("$[1].available") { value(true) }
                jsonPath("$[1].specialIngredients[0]") { value("Avocado") }
                jsonPath("$[1].specialIngredients[1]") { value("Lettuce") }
                jsonPath("$[1].allergens[0]") { value(Allergen.SOY.name) }

                jsonPath("$[2].name") { value("Double Bacon Burger") }
                jsonPath("$[2].description") { value("A double-patty burger with crispy bacon") }
                jsonPath("$[2].price") { value(9.99) }
                jsonPath("$[2].vegetarian") { value(false) }
                jsonPath("$[2].available") { value(true) }
                jsonPath("$[2].specialIngredients[0]") { value("Bacon") }
                jsonPath("$[2].specialIngredients[1]") { value("Cheese") }
                jsonPath("$[2].allergens[0]") { value(Allergen.DAIRY.name) }
                jsonPath("$[2].allergens[1]") { value(Allergen.GLUTEN.name) }
            }
    }

    @Test
    fun `GET burger by ID - should return the specific burger`() {
        val burgerId = UUID.fromString("11111111-1111-1111-1111-111111111111")

        mockMvc.get("/burgers/$burgerId") {
            header("X-Api-Key", Testdata.API_KEY)
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }

                jsonPath("$.name") { value("Cheeseburger") }
                jsonPath("$.description") { value("A classic cheeseburger with melted cheese") }
                jsonPath("$.price") { value(5.99) }
                jsonPath("$.vegetarian") { value(false) }
                jsonPath("$.available") { value(true) }
                jsonPath("$.specialIngredients[0]") { value("Cheese") }
                jsonPath("$.specialIngredients[1]") { value("Lettuce") }
                jsonPath("$.allergens[0]") { value(Allergen.DAIRY.name) }
            }
    }

    @Test
    fun `GET burger by ID not exists - should return 400 BAD REQUEST`() {
        val burgerId = UUID.fromString("00000000-0000-0000-0000-000000000000")

        mockMvc.get("/burgers/$burgerId") {
            header("X-Api-Key", Testdata.API_KEY)
        }
            .andExpect {
                status { isBadRequest() }
            }
    }
}

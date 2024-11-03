package at.aistleitner.ahoiburger.core

import at.aistleitner.ahoiburger.TestcontainersConfiguration
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestcontainersConfiguration::class)
class ApiKeyFilterIT @Autowired constructor(
    private val mockMvc: MockMvc,
) {

    @Test
    fun `GET all drinks with no ApiKey - should return 403`() {
        mockMvc.get("/drinks")
            .andExpect {
                status { isForbidden() }
            }
    }


    @Test
    fun `GET all burgers with wrong ApiKey - should return 403`() {
        mockMvc.get("/burgers") {
            header("X-Api-Key", "wrong")
        }
            .andExpect {
                status { isForbidden() }
            }
    }
}
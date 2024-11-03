package at.aistleitner.ahoiburger.burger.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Burger does not exist")
class BurgerNotFoundException(id: UUID) : RuntimeException("Burger with ID $id not found")
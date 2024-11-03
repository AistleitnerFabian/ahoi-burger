package at.aistleitner.ahoiburger.drink.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Drink does not exist")
class DrinkNotFoundException(id: UUID) : RuntimeException("Drink with ID $id not found")
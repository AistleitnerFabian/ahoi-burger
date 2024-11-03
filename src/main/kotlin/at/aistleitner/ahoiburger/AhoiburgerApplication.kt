package at.aistleitner.ahoiburger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AhoiburgerApplication

fun main(args: Array<String>) {
	runApplication<AhoiburgerApplication>(*args)
}

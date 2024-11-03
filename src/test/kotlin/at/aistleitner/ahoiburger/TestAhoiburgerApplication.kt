package at.aistleitner.ahoiburger

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<AhoiburgerApplication>().with(TestcontainersConfiguration::class).run(*args)
}

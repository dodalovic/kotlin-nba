package rs.dodalovic.nba

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinNbaApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinNbaApplication::class.java, *args)
}

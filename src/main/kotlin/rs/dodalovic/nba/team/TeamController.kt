package rs.dodalovic.nba.team

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/teams")
class TeamController(val teamRepository: TeamRepository) {

    @RequestMapping
    fun getAll() = teamRepository.getAll()
}
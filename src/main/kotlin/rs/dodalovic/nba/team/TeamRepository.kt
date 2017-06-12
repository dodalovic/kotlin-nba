package rs.dodalovic.nba.team

import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import rs.dodalovic.nba.model.Team

val oddTeams = listOf("World", "West", "USA Celebrities", "USA", "Shanghai", "Real Madrid", "Haifa", "East",
        "Canada Celebrities", "Buenos Aires", "Barcelona")
val allTeamsEndpoint = "http://data.nba.net/data/10s/prod/v1/2016/teams.json"

@Repository
class TeamRepository(val template: RestTemplate) {
    fun getAll() = template.getForObject(allTeamsEndpoint, Map::class.java).extractTeams().nbaOnly().map { it.toTeam() }
}

private fun Map<*, *>.extractTeams() = (this.get("league") as Map<String, *>).get("standard") as List<Map<String, String>>
private fun Map<String, String>.toTeam() = Team(get("teamId")!!, get("city")!!, get("nickname")!!)
private fun List<Map<String, String>>.nbaOnly() = filterNot { rs.dodalovic.nba.team.oddTeams.contains(it["city"]) }
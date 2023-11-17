package com.example.seniorproject.data

import com.example.seniorproject.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/*
object DataSource {
    val leagues = listOf(
        "Monday Night Trios",
        "Northrock Mixers")

    val tournaments = listOf(
        "Tournament A",
        "Tournament B")
}*/

data class League(
    val name: String,
    val startDate: String,
    val numOfWeeks: Int,
    val gamesPerWeek: Int,
    val gamesPerSeries: Int
)
val league1 = League("Monday Night Trios", "11/15/2023", 17, 3, 3)
val league2 = League("Northrock Mixers", "11/14/2023", 15, 3, 3)

data class Tournament(
    val name: String,
//    val startDate: String,
    val gamesPerSeries: Int
)
val tournament1 = Tournament("t1", /*"11/15/2023",*/ 3)
val tournament2 = Tournament("t2", /*"11/14/2023",*/ 3)

sealed class ContentForProfessional {
    data class LeagueContent(val league: League) : ContentForProfessional()
    data class TournamentContent(val tournament: Tournament) : ContentForProfessional()
}
var professionalContentList: List<ContentForProfessional> = listOf(
    ContentForProfessional.LeagueContent(league1),
    ContentForProfessional.LeagueContent(league2),
    ContentForProfessional.TournamentContent(tournament1),
    ContentForProfessional.TournamentContent(tournament2)
)

data class Game(
    val date: String,
    val type: String,
    val mode: String,
    val hand: String,
    val score: Int
) {
    companion object {
        fun createFromInputFields(
            // other parameters...
            pickedDate: LocalDate,
            type: String = "", // Provide default values for other parameters if needed
            mode: String = "",
            hand: String = "",
            score: Int = 0
        ): Game {
            val formattedDate = DateTimeFormatter
                .ofPattern("MM/dd/yyyy")
                .format(pickedDate)

            return Game(
                date = formattedDate,
                type = type,
                mode = mode,
                hand = hand,
                score = score
            )
        }
    }
}
val game1 = Game("11/14/2023", "Practice", "Final Score", "Right", 150)
val game2 = Game("11/15/2023", "League", "Frame-by-Frame", "Right", 200)
val game3 = Game("11/16/2023", "Tournament", "Frame-by-Frame", "Right", 200)

val games = listOf(game1, game2, game3)

sealed class ContentForPractice {
    data class GameContent(val game: Game) : ContentForPractice()
}
var practiceContentList: List<ContentForPractice> = listOf(
    ContentForPractice.GameContent(game1),
    ContentForPractice.GameContent(game2),
    ContentForPractice.GameContent(game3),
)

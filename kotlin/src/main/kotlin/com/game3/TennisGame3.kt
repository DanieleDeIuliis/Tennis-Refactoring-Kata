package com.game3

import TennisGame
import kotlin.math.abs

class TennisGame3(private val playerOneName: String, private val playerTwoName: String) : TennisGame {

    private var playerTwoScore: Int = 0
    private var playerOneScore: Int = 0

    override fun getScore(): String {
        val notAdvantageGamePhase = playerOneScore < 4 && playerTwoScore < 4
        val gameWillGoInAdvantagePhase = playerOneScore + playerTwoScore == 6
        return if (notAdvantageGamePhase && !gameWillGoInAdvantagePhase) handleNormalGamePhase()
            else handleAdvantageAndEndPhase()

    }

    private fun handleAdvantageAndEndPhase(): String {
        if (playerOneScore == playerTwoScore)
            return "Deuce"
        val currentScore = if (playerOneScore > playerTwoScore) playerOneName else playerTwoName
        return if (abs(playerOneScore - playerTwoScore) == 1) "Advantage $currentScore" else "Win for $currentScore"
    }

    private fun handleNormalGamePhase(): String {
        val descriptionPoints = arrayOf("Love", "Fifteen", "Thirty", "Forty")
        var currentScore = descriptionPoints[playerOneScore]
        return if (playerOneScore == playerTwoScore) "$currentScore-All" else "$currentScore-${descriptionPoints[playerTwoScore]}"
    }

    override fun wonPoint(playerName: String) {
        if (playerName === "player1")
            this.playerOneScore += 1
        else
            this.playerTwoScore += 1

    }

}

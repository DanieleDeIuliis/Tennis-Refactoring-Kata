package com.game1

import TennisGame
import kotlin.math.abs

class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var playerOneScore: Int = 0
    private var playerTwoScore: Int = 0
    private val intToStringMap = mapOf(0 to "Love", 1 to "Fifteen", 2 to "Thirty", 3 to "Forty")

    override fun wonPoint(playerName: String) {
        if (playerName === player1Name)
            playerOneScore++
        else if(playerName === player2Name)
            playerTwoScore++
    }

    override fun getScore(): String {
        if (playerOneScore == playerTwoScore) {
            return if(playerOneScore < 3) intToStringMap[playerOneScore] + "-All" else "Deuce"
        }
        val differenceInScoreValue = playerOneScore - playerTwoScore
        val isMaximumNormalScoreReached = playerOneScore >= 4 || playerTwoScore >= 4
        if(abs(differenceInScoreValue) >= 2 && isMaximumNormalScoreReached){
            return computeFinalScore(differenceInScoreValue)
        }
        if (isMaximumNormalScoreReached) {
            return computeNextScoreInAdvantagePhase(differenceInScoreValue)
        }
        return intToStringMap[playerOneScore] + "-" + intToStringMap[playerTwoScore]
    }

    private fun computeFinalScore(differenceInScoreValue: Int): String {
        if(differenceInScoreValue > 0){
            return "Win for player1"
        }
        return "Win for player2"
    }

    private fun computeNextScoreInAdvantagePhase(differenceInScoreValue: Int): String {
        if(differenceInScoreValue > 0)
            return "Advantage player1"
        return "Advantage player2"
    }
}

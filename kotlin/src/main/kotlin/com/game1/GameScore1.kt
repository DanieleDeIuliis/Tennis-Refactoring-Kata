package com.game1

class GameScore1(private var playerOneScore: Int = 0, private var playerTwoScore: Int = 0) {

    fun updatePlayerScore(playerName: String) {
        if (playerName === "player1")
            playerOneScore++
        else
            playerTwoScore++
    }

    fun computeCurrentScore(): String {
        return when {
            playerOneScore == playerTwoScore -> handleSameScore()
            playerOneScore >= 4 || playerTwoScore >= 4 -> handleAdvantageOrWin()
            else -> handleGeneralCase()
        }
    }

    private fun handleGeneralCase(): String {
        return """${getStringScoreValue(playerOneScore)}-${getStringScoreValue(playerTwoScore)}"""
    }

    private fun getStringScoreValue(tempScore: Int): String {
        return when (tempScore) {
            0 ->  "Love"
            1 ->  "Fifteen"
            2 -> "Thirty"
            else -> "Forty"
        }
    }

    private fun handleAdvantageOrWin(): String {
        val minusResult = playerOneScore - playerTwoScore
        return when {
            minusResult == 1 -> "Advantage player1"
            minusResult == -1 -> "Advantage player2"
            minusResult >= 2 -> "Win for player1"
            else -> "Win for player2"
        }
    }

    private fun handleSameScore(): String {
        return if(playerOneScore <= 2) getStringScoreValue(playerOneScore) + "-All" else "Deuce"
    }
}
package com.game2

class GameScore2(val playerOnePoint: TennisPoint = TennisPoint(), val playerTwoPoint: TennisPoint = TennisPoint()) {

    fun handleSameScore(score: String): String {
        var score1 = score
        if (playerOnePoint.value < 4) {
            if (playerOnePoint.value == 0)
                score1 = "Love"
            if (playerOnePoint.value == 1)
                score1 = "Fifteen"
            if (playerOnePoint.value == 2)
                score1 = "Thirty"
            score1 += "-All"
        }
        if (playerOnePoint.value >= 3)
            score1 = "Deuce"
        return score1
    }

    fun handleAdvantage(score: String): String {
        var score1 = score
        if (playerOnePoint.value > playerTwoPoint.value && playerTwoPoint.value >= 3) {
            score1 = "Advantage player1"
        }

        if (playerTwoPoint.value > playerOnePoint.value && playerOnePoint.value >= 3) {
            score1 = "Advantage player2"
        }
        return score1
    }

    fun handleWin(score: String): String {
        var score1 = score
        if (playerOnePoint.value >= 4 && playerTwoPoint.value >= 0 && playerOnePoint.value - playerTwoPoint.value >= 2) {
            score1 = "Win for player1"
        }
        if (playerTwoPoint.value >= 4 && playerOnePoint.value >= 0 && playerTwoPoint.value - playerOnePoint.value >= 2) {
            score1 = "Win for player2"
        }
        return score1
    }

    fun handleGreaterScoreLessThanMax(): String {
        if (playerOnePoint.value > playerTwoPoint.value) {
            handleGreaterScoreLessThanMax(playerOnePoint,playerTwoPoint)
        }
        else {
            handleGreaterScoreLessThanMax(playerTwoPoint,playerOnePoint)
        }
        return "${playerOnePoint.stringResult}-${playerTwoPoint.stringResult}"
    }

    fun handleGreaterScoreLessThanMax(greaterPoint: TennisPoint, smallerPoint: TennisPoint){
        if (greaterPoint.value == 2)
            greaterPoint.stringResult = "Thirty"
        else if (greaterPoint.value == 3)
            greaterPoint.stringResult = "Forty"
        if (smallerPoint.value == 1)
            smallerPoint.stringResult = "Fifteen"
        else if (smallerPoint.value == 2)
            smallerPoint.stringResult = "Thirty"
    }

    fun handleOneScoreIsZero(): String {
        if (playerOnePoint.value > 0) {
            handleOneScoreIsZero(playerOnePoint, playerTwoPoint)
        }else {
            handleOneScoreIsZero(playerTwoPoint, playerOnePoint)
        }
        return "${playerOnePoint.stringResult}-${playerTwoPoint.stringResult}"
    }

    fun increasePlayerOnePoint(){
        playerOnePoint.value++
    }

    fun increasePlayerTwoPoint(){
        playerTwoPoint.value++
    }

    private fun handleOneScoreIsZero(greaterThanZeroPoint: TennisPoint, zeroPoint: TennisPoint) {
        greaterThanZeroPoint.stringResult = computeResultScoreForPlayer(greaterThanZeroPoint.value)
        zeroPoint.stringResult = "Love"
    }

    private fun computeResultScoreForPlayer(playerPoint: Int): String{
        var result = ""
        when (playerPoint) {
            1 -> result = "Fifteen"
            2 -> result = "Thirty"
            3 -> result = "Forty"
        }
        return result
    }
}
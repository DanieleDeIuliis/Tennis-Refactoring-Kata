package com.game2

import TennisGame

class TennisGame2() : TennisGame {

    private val gameScore: GameScore2 = GameScore2()

    override fun getScore(): String {
        var score = ""
        if(gameScore.playerOnePoint.value == gameScore.playerTwoPoint.value)
            score = gameScore.handleSameScore(score)
        else if(gameScore.playerOnePoint.value == 0 || gameScore.playerTwoPoint.value == 0)
            score = gameScore.handleOneScoreIsZero()
        else if(gameScore.playerOnePoint.value < 4 || gameScore.playerTwoPoint.value < 4)
            score = gameScore.handleGreaterScoreLessThanMax()

        score = gameScore.handleAdvantage(score)

        score = gameScore.handleWin(score)
        return score
    }

    override fun wonPoint(player: String) {
        if (player === "player1")
            gameScore.increasePlayerOnePoint()
        else
            gameScore.increasePlayerTwoPoint()
    }
}
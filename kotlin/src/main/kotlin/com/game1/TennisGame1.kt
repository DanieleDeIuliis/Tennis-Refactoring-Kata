package com.game1

import TennisGame

class TennisGame1 : TennisGame {
    private val score: GameScore1 = GameScore1()

    override fun wonPoint(playerName: String) {
        score.updatePlayerScore(playerName)
    }

    override fun getScore(): String {
        return score.computeCurrentScore()
    }
}

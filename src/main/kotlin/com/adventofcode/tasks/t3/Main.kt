package com.adventofcode.tasks.t3

import com.adventofcode.Util

fun main() {
    part1() // 2572
    part2() // 2631
}

private fun part1() {
    val moves = Util.readInputForTaskAsLines().first()

    val visitedHouses = getVisitedHouses(moves)
    val result = visitedHouses.count()

    println(result)
}

private fun part2() {
    val allMoves = Util.readInputForTaskAsLines().first()

    val moves1 = allMoves.filterIndexed { index, _ -> index % 2 == 0 }
    val moves2 = allMoves.filterIndexed { index, _ -> index % 2 != 0 }

    val visitedHouses = getVisitedHouses(moves1) + getVisitedHouses(moves2)
    val result = visitedHouses.count()

    println(result)
}

private fun getVisitedHouses(moves: String): Set<Point> {
    var pos = Point(0, 0)

    val stats = mutableSetOf<Point>()
    stats.add(pos)

    moves.forEach { direction ->
        pos = when(direction) {
            '<' -> pos.left()
            '>' -> pos.right()
            '^' -> pos.up()
            'v' -> pos.down()

            else -> throw Exception("Unexpected direction $direction")
        }

        stats.add(pos)
    }

    return stats
}

data class Point(val x: Int, val y: Int) {
    fun up(): Point {
        return copy(y = y - 1)
    }
    fun down(): Point {
        return copy(y = y + 1)
    }
    fun left(): Point {
        return copy(x = x - 1)
    }
    fun right(): Point {
        return copy(x = x + 1)
    }
}

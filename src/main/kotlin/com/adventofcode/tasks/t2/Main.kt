package com.adventofcode.tasks.t2

import com.adventofcode.Util


fun main() {
    part1() // 1588178
    part2() // 3783758
}

private fun part1() {
    val result = forEachFigure { l, w, d ->
        calculateRequiredPaper(l, w, d)
    }.sum()

    println(result)
}


private fun part2() {
    val result = forEachFigure { l, w, d ->
        calculateRequiredRibbon(l, w, d)
    }.sum()

    println(result)
}

private fun forEachFigure(action: (l: Int, w: Int, d: Int) -> Int): List<Int> {
    val r = """(\d+)x(\d+)x(\d+)""".toRegex()

    val result = Util.readInputForTaskAsLines().map {
        val parsed = r.find(it)!!

        val length = parsed.groupValues[1].toInt()
        val width = parsed.groupValues[2].toInt()
        val depth = parsed.groupValues[3].toInt()

        action(length, width, depth)
    }

    return result
}

private fun calculateRequiredPaper(l: Int, w: Int, d: Int): Int {
    val side1 = l * w
    val side2 = l * d
    val side3 = w * d

    val area = side1 * 2 + side2 * 2 + side3 * 2
    return area + listOf(side1, side2, side3).min()
}

private fun calculateRequiredRibbon(l: Int, w: Int, d: Int): Int {
    val smallestPerimeter = listOf(l, w, d)
        .sorted()
        .take(2)
        .sumOf { side ->
            side * 2
        }

    val volume = l * w * d

    return smallestPerimeter + volume
}
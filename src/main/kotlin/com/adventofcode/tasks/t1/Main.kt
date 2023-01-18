package com.adventofcode.tasks.t1

import com.adventofcode.Util

fun main() {
    part1() // 138
    part2() // 1771
}

fun part1() {
    val input = Util.readInputForTaskAsLines().first()

    var floor = 0

    input.forEach { char ->
        when (char) {
            '(' -> floor++
            ')' -> floor--
            else -> throw Exception("Unexpected $char")
        }
    }

    println(floor)
}

fun part2() {
    val input = Util.readInputForTaskAsLines().first()

    var pos = 0
    var floor = 0

    input.forEach { char ->
        pos++
        when (char) {
            '(' -> floor++
            ')' -> floor--
            else -> throw Exception("Unexpected $char")
        }

        if (floor == -1) {
            println(pos)
            return
        }
    }

    throw Exception("Never entered basement")
}
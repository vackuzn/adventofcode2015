package com.adventofcode.tasks.t4

import java.math.BigInteger
import java.security.MessageDigest

fun main() {
    part1() //   254_575
    part2() // 1_038_736
}

fun part1() {
    val input = "bgvyzdsv"

    val res = findMd5Zeros(input, 5)
    println(res)
}

fun part2() {
    val input = "bgvyzdsv"

    val res = findMd5Zeros(input, 6)
    println(res)
}

private fun findMd5Zeros(input: String, zerosCount: Int): Long {
    var addNum = 0L

    while (true) {
        addNum++

        val md5 = md5(input + addNum.toString())
        if (md5.take(zerosCount) == "0".repeat(zerosCount)) {
            return addNum
        }
    }
}

private fun md5(input:String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}
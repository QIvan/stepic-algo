package ru.stepik.algo.intro.task12

import java.util.*

fun euclidean(a: Long, b: Long): Long {
    if (a == 0L) {
        return b
    }
    if (b == 0L) {
        return a
    }

    if (a > b) {
        return euclidean(a % b, b)
    } else {
        return euclidean(a, b % a)
    }
}

fun main(args: Array<String>): Unit {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextLong()
    val b = scanner.nextLong()
    val res = euclidean(a, b)

    println(res)
}
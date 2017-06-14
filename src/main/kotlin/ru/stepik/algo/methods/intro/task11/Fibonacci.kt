package ru.stepik.algo.methods.intro.task11

import java.util.*

fun fibonacci(n: Int): Long {
    if (n == 0) return 1L
    if (n == 1) return 1L
    var first = 1L
    var second = 1L
    for (i in 2..n) {
        val temp = second
        second += first
        first = temp
    }
    return second
}

fun fibonacciModM(n: Long, m: Long): Long {
    if (n == 0L) return 1L
    if (n == 1L) return 1L
    var first = 1L
    var second = 1L
    for (i in 2..n) {
        val temp = second
        second += first
        second %= m
        first = temp
        if (second == 1L && first == 1L) {
            return fibonacciModM(n % (i - 1), m)
        }
    }
    return second
}

fun fibonacciLastNumber(n: Long): Long {
    return fibonacciModM(n, 10)
}

fun main(args: Array<String>): Unit {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    val m = scanner.nextLong()
    val res = fibonacciModM(n, m)

    println("$res")
}
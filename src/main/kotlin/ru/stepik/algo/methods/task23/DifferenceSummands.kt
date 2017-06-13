package ru.stepik.algo.methods.task23

import java.util.*

/**
 * @author Ivan Zemlyanskiy
 */
data class Result(val lastNumber: Int, val biggestNumber: Int)


fun differenceSummands(n: Int): Result {
    var sum = 0
    var lastNum = 0
    for (i in 1..n) {
        sum += i
        if (n - sum < i + 1) {
            return Result(lastNum, n - sum + i)
        }
        lastNum = i
    }

    return Result(0, 0)
}

fun main(args: Array<String>): Unit {
    
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val result = differenceSummands(n)
    println(result.lastNumber + 1)
    for (i in 1..result.lastNumber) {
        print("$i ")
    }
    print(result.biggestNumber)

}
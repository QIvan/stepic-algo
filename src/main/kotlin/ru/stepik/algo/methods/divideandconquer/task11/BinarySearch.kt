package ru.stepik.algo.methods.divideandconquer.task11

import java.util.*

/**
 * @author Ivan Zemlyanskiy
 */
// да, тут схалтурил )
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val searchArray = scanArray(scanner)
    val inputArray = scanArray(scanner)
    inputArray
            .map { element -> searchArray.binarySearch { it.compareTo(element) } }
            .map { if (it < 0) -1 else it + 1 }
            .forEach { print("$it ") }
}

private fun scanArray(scanner: Scanner): List<Int> {
    val n = scanner.nextInt()
    val resultArray = arrayListOf<Int>()
    for (i in 1..n) {
        resultArray.add(scanner.nextInt())
    }
    return resultArray
}

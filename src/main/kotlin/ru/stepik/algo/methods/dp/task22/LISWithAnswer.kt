package ru.stepik.algo.methods.dp.task22

import java.util.*

/**
 * @author Ivan Zemlyanskiy
 */
//todo check with tests
typealias LISAnswer = Pair<Int, IntArray>

fun LISWithAnswer(input: List<Int>): LISAnswer {
    val dpCache = IntArray(input.size) { 1 }

    for (i in 0 until input.size - 1) {
        val j = upperBound(dpCache, input[i], i + 1, input.size - 1)
        if (input[i] <= input[j]) {
            break
        }
        dpCache[j] = maxOf(dpCache[j], dpCache[i] + 1)
    }

    return findAnswer(input, dpCache)
}

fun upperBound(array: IntArray, x: Int, leftIndex: Int = 0, rightIndex: Int = array.size - 1): Int {
    var lo = leftIndex
    var hi = rightIndex
    while (lo < hi) {
        val mid: Int = (lo + hi) / 2
        if (x < array[mid]) {
            hi = mid
        } else {
            lo = mid + 1
        }
    }
    return lo
}

private fun sequenceCondition(lessIndex: Int, moreIndex: Int) = lessIndex >= moreIndex

fun findAnswer(input: List<Int>, dpCache: IntArray): LISAnswer {
    val max = dpCache.max() ?: 0
    var currMax = max
    var indexOfMax = dpCache.indexOf(max)
    val resultArray = IntArray(max)
    for (index in dpCache.size - 1 downTo 0) {
        if (dpCache[index] == currMax && sequenceCondition(input[index], input[indexOfMax])) {
            indexOfMax = index
            currMax--
            resultArray[currMax] = index
        }
    }

    return LISAnswer(max, resultArray)
}


fun main(args: Array<String>) {
    val input = scanArray(Scanner(System.`in`))
    val answer = LISWithAnswer(input)
    println(answer.first)
    answer.second.forEach { print("${it + 1} ") }
}

private fun scanArray(scanner: Scanner): List<Int> {
    val n = scanner.nextInt()
    val resultArray = ArrayList<Int>(n)
    for (i in 1..n) {
        resultArray.add(scanner.nextInt())
    }
    return resultArray
}
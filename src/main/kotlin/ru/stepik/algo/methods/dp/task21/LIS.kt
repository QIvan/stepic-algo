package ru.stepik.algo.methods.dp.task21

import java.util.*

/**
 * @author Ivan Zemlyanskiy
 */
fun LIS(arr: List<Int>): Int {
    val dpCache = IntArray(arr.size, { 1 })

    for (i in 0 until arr.size - 1) {
        for (j in i + 1 until arr.size) {
            if (arr[j] % arr[i] == 0) {
                dpCache[j] = maxOf(dpCache[j], dpCache[i] + 1)
            }
        }
    }

    return dpCache.max() ?: -1
}

fun main(args: Array<String>) {
    val input = scanArray(Scanner(System.`in`))
    print(LIS(input))
}

private fun scanArray(scanner: Scanner): List<Int> {
    val n = scanner.nextInt()
    val resultArray = ArrayList<Int>(n)
    for (i in 1..n) {
        resultArray.add(scanner.nextInt())
    }
    return resultArray
}
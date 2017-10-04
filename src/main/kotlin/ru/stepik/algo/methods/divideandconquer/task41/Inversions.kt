package ru.stepik.algo.methods.divideandconquer.task41

import java.util.*
import kotlin.collections.ArrayList

/**
 * @author Ivan Zemlyanskiy
 * тут забил в итоге на оптимальность по памяти и всё такое. Уж больно унылый код получался
 */
typealias InversionsResult = Pair<List<Int>, Long>

fun inversionsCount(inputArray: List<Int>): InversionsResult {

    if (inputArray.size <= 1) {
        return Pair(inputArray, 0)
    }

    val middle = inputArray.size / 2
    val (leftArray, leftInversions) = inversionsCount(inputArray.subList(0, middle))
    val (rightArray, rightInversions) = inversionsCount(inputArray.subList(middle, inputArray.size))
    val (mergeArray, mergeInversions) = merge(leftArray, rightArray)
    return Pair(mergeArray, leftInversions + rightInversions + mergeInversions)

}

fun merge(leftArray: List<Int>, rightArray: List<Int>): InversionsResult {

    val resultArray = ArrayList<Int>(leftArray.size + rightArray.size)
    var resultInversion: Long = 0

    var l = 0
    var r = 0
    while (l != leftArray.size || r != rightArray.size) {
        if (rightArray[r] < leftArray[l]) {
            resultInversion += leftArray.size - l
            resultArray += rightArray[r++]
        } else {
            resultArray += leftArray[l++]
        }

        if (l == leftArray.size) {
            resultArray += rightArray.slice(r until rightArray.size)
            r = rightArray.size
        }
        if (r == rightArray.size) {
            resultArray += leftArray.slice(l until leftArray.size)
            l = leftArray.size
        }

    }

    return Pair(resultArray, resultInversion)
}


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val inputArray = scanArray(scanner)
    println("${inversionsCount(inputArray).second}")
}

private fun scanArray(scanner: Scanner): List<Int> {
    val n = scanner.nextInt()
    val resultArray = ArrayList<Int>(n)
    for (i in 1..n) {
        resultArray.add(scanner.nextInt())
    }
    return resultArray
}

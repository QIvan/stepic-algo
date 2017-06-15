package ru.stepik.algo.methods.greedy.queues.tasl31

import java.util.*

/**
 * @author Ivan Zemlyanskiy
 */
enum class Operation {
    Insert,
    ExtractMax
}

class MaxHeap(n: Int) {
    val queue: IntArray = IntArray(n)
    var lastIndex = -1

    fun insert(value: Int) {
        lastIndex += 1
        queue[lastIndex] = value

        var currentIndex = lastIndex
        var continueFlag = true
        while (continueFlag) {
            val parentId = parentId(currentIndex)
            continueFlag = swap(parentId, currentIndex)
            currentIndex = parentId
        }

    }

    fun extractMax(): Int? {
        val result = queue[0]
        queue[0] = queue[lastIndex]
        lastIndex--

        var currentIndex = 0
        var continueFlag = true
        while (continueFlag) {
            val biggestChildId = biggestChildId(currentIndex)
            continueFlag = swap(currentIndex, biggestChildId)
            currentIndex = biggestChildId
        }


        return result
    }


    private fun swap(upper: Int, down: Int): Boolean {
        assert(upper <= down)

        val upperValue = queue[upper]
        val downValue = queue[down]

        if (upperValue < downValue) {
            val temp = queue[upper]
            queue[upper] = queue[down]
            queue[down] = temp
            return true
        } else {
            return false
        }
    }

    private fun parentId(child: Int): Int {
        return (child - 1) / 2
    }

    private fun biggestChildId(parent: Int): Int {
        val leftChildId = parent * 2 + 1
        if (leftChildId > lastIndex) {
            return parent
        }

        val rightChildId = parent * 2 + 2
        if (rightChildId > lastIndex) {
            return leftChildId
        }

        return if (queue[leftChildId] < queue[rightChildId]) rightChildId else leftChildId
    }
}

fun main(args: Array<String>): Unit {
    val operationList = Operation.values().associateBy { it.toString().toLowerCase() }

    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val queue = MaxHeap(n)
    for (i in 0..n) {
        val split = scanner.nextLine().split(" ")
        val operation = split[0]
        when (operationList[operation.toLowerCase()]) {
            Operation.Insert -> {
                val value = split[1].toInt()
                queue.insert(value)
            }
            Operation.ExtractMax -> {
                val max = queue.extractMax()
                println(max)
            }
        }
    }

}
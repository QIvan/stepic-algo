package ru.stepik.algo.structs.base.task14

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class MaxStackK(count: Int = 100) {
    private val stack: Deque<Int> = ArrayDeque(count)
    private val maxStack: Deque<Int> = ArrayDeque(count)

    fun push(value: Int) {
        stack.addFirst(value)
        if (maxStack.isEmpty() || maxStack.first < value) {
            maxStack.addFirst(value)
        } else {
            maxStack.addFirst(maxStack.first)
        }
    }

    fun pop(): Int {
        maxStack.removeFirst()
        return stack.removeFirst()
    }

    fun max(): Int {
        return maxStack.first
    }

}

fun main(args: Array<String>) {
    val scanner = BufferedReader(InputStreamReader(System.`in`))
    val count = scanner.readLine().toInt()
    val stack = MaxStackK(count)
    for (i in 0 until count) {
        val nextLine = scanner.readLine().split(" ")
        val op = nextLine.first()
        when (op) {
            "max" -> println(stack.max())
            "pop" -> stack.pop()
            "push" -> stack.push(nextLine[1].toInt())
        }
    }
}

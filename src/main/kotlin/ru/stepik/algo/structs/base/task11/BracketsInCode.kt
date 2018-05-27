package ru.stepik.algo.structs.base.task11

import java.util.*
import kotlin.NoSuchElementException

fun solve(line: String): Int {

    val stack = ArrayDeque<Pair<Char, Int>>()
    line.forEachIndexed { index, ch ->
        if (ch in oppositeBrackets.keys) {
            stack.addFirst(Pair(ch, index))
        }
        if (ch in oppositeBrackets.values) {
            try {
                val bracket: Char = stack.removeFirst().first
                if (!isOpposite(bracket, ch)) {
                    return index
                }
            } catch (e: NoSuchElementException) {
                return index
            }
        }
    }
    return if (stack.isEmpty()) -1 else stack.removeFirst().second
}

val oppositeBrackets = mapOf('{' to '}', '(' to ')', '[' to ']')
fun isOpposite(left: Char, right: Char): Boolean {
    return oppositeBrackets[left] == right
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val line = scanner.nextLine()

    val result = solve(line)
    print(if (result == -1) "Success" else (result + 1).toString())
}

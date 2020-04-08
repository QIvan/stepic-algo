package ru.stepik.algo.structs.hashtable.task31

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @author Ivan Zemlyanskiy
 */
fun main(args: Array<String>) {
    val scanner = BufferedReader(InputStreamReader(System.`in`))
    val count = scanner.readLine().toInt()
    val dict = mutableMapOf<Int, String>()
    for (i in 0 until count) {
        val nextLine = scanner.readLine().split(" ")
        val op = nextLine.first()
        when (op) {
            "add" -> dict[nextLine[1].toInt()] = nextLine[2]
            "find" -> {
                println(dict[nextLine[1].toInt()] ?: "not found")
            }
            "del" -> dict.remove(nextLine[1].toInt())
        }
    }
}




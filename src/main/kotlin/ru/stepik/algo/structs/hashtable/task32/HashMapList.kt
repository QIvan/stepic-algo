package ru.stepik.algo.structs.hashtable.task32

import java.util.*

/**
 * @author Ivan Zemlyanskiy
 */
enum class Operation {
    Add,
    Del,
    Find,
    Check
}

class HashMapList(private val size: Int) {
    private val values = Array(size, { LinkedList<String>() })

    private fun position(key: String): Int = (hash(key) % size).toInt()

    fun add(key: String) = values[position(key)].addFirst(key)

    fun check(index: Int): MutableList<String> = values[index]

    fun find(key: String): Boolean = values[position(key)].contains(key)

    fun delete(key: String) = values[position(key)].remove(key)
}

fun pow(number: Long) = sequence { 
    yield(1L)
    var result: Long = number
    while (true) {
        yield(result)
        result *= number
    }
}

fun hash(string: String): Long {
    val x = 263L
    val p = 1_000_000_007
    val pow: Iterator<Long> = pow(x).iterator()
    pow.next()
    return string.map { c -> c.toLong() }.reduce { acc, char -> acc + char * pow.next() } % p
}


fun main(args: Array<String>) {
    val operationList = Operation.values().associateBy { it.toString().toLowerCase() }

    var scanner = Scanner(System.`in`)
    val size = scanner.nextInt()
    val m = scanner.nextInt()
    val map = HashMapList(size)
    for (i in 0..m) {
        scanner = Scanner(System.`in`)
        val split = scanner.nextLine().split(" ")
        val operation = split[0]
        val arg = split[1]
        when (operationList[operation.toLowerCase()]) {
            Operation.Add -> map.add(arg)
            Operation.Check -> print(map.check(arg.toInt()).joinToString(", "))
            Operation.Find -> print(if (map.find(arg)) "yes" else "no")
            Operation.Del -> map.delete(arg)
        }
    }
}

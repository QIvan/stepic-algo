package ru.stepik.algo.methods.greedy.intro.task21

import java.util.*

data class Segment(val start: Int, val end: Int) {

    fun pointInside(point: Int?): Boolean {
        return point in start..end
    }
}

fun findPointsForSegments(segments: List<Segment>): List<Int> {
    val result = arrayListOf<Int>()
    segments.sortedBy { it.end }.forEach { segment ->
        val lastPoint = result.getOrNull(result.size - 1)
        if (!segment.pointInside(lastPoint)) {
            result.add(segment.end)
        }
    }

    return result
}


fun main(args: Array<String>): Unit {

    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val inputSegments = arrayListOf<Segment>()
    for (i in 1..n) {
        inputSegments.add(Segment(scanner.nextInt(), scanner.nextInt()))
    }
    val points = findPointsForSegments(inputSegments)
    println(points.size)
    for (p in points) {
        print("$p ")
    }

}
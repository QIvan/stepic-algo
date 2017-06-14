package ru.stepik.algo.methods.greedy.intro.task21

import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * @author Ivan Zemlyanskiy
 */
class SegmentsTest {

    @Test
    fun findPointsForSegmentsSampleInput1() {
        val testData = arrayListOf(
                Segment(1, 3),
                Segment(2, 5),
                Segment(3, 6)
        )

        assertEquals(listOf(3), findPointsForSegments(testData))
    }

    @Test
    fun findPointsForSegmentsSampleInput2() {
        val testData = arrayListOf(
                Segment(4, 7),
                Segment(1, 3),
                Segment(2, 5),
                Segment(5, 6)
        )

        assertEquals(listOf(3, 6), findPointsForSegments(testData))
    }

    @Test
    fun findPointsForSegmentsBigInput() {
        val random = Random()
        val testData = arrayListOf<Segment>()
        for (i in 1..100) {
            testData.add(Segment(random.nextInt(Int.MAX_VALUE), random.nextInt(Int.MAX_VALUE)))
        }

        assertTrue(findPointsForSegments(testData).isNotEmpty())
    }

}
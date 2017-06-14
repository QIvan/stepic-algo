package ru.stepik.algo.methods.task21

import org.junit.Test

import org.junit.Assert.*

/**
 * @author Ivan Zemlyanskiy
 */
class SegmentsTest {

    @Test
    fun name() {
        assertTrue(Segment(0, 10).pointInside(5))

    }

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
}
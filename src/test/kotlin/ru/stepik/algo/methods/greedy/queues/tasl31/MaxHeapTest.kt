package ru.stepik.algo.methods.greedy.queues.tasl31

import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * @author Ivan Zemlyanskiy
 */
class MaxHeapTest {
    @Test
    fun testSampleInput() {
        val heap = MaxHeap(6)
        heap.insert(200)
        heap.insert(10)
        assertEquals(200, heap.extractMax())
        heap.insert(5)
        heap.insert(500)
        assertEquals(500, heap.extractMax())
    }

    @Test
    fun testAllMaxValues() {
        val heap = MaxHeap(6)
        heap.insert(200)
        heap.insert(10)
        heap.insert(5)
        heap.insert(500)
        assertEquals(500, heap.extractMax())
        assertEquals(200, heap.extractMax())
        assertEquals(10, heap.extractMax())
        assertEquals(5, heap.extractMax())
    }


    @Test
    fun testRandomInput() {
        val random = Random()
        val n = 100_000
        val maxValueStep = 5
        val maxValCount = n / maxValueStep
        val maxValue = 1_000_000_000 - maxValCount
        val heap = MaxHeap(n + maxValCount)
        for (i in 1..n) {
            if (i % maxValueStep == 0) {
                heap.insert(maxValue + (i / maxValueStep))
            }
            heap.insert(random.nextInt(maxValue))
        }
        for (i in n downTo 1 step maxValueStep) {
            assertEquals(maxValue + (i / maxValueStep), heap.extractMax())
        }
    }

}
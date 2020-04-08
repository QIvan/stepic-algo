package ru.stepik.algo.methods.dp.task21

import org.junit.Test

import org.junit.Assert.*

/**
 * @author Ivan Zemlyanskiy
 */
class LISTest {
    @Test
    fun sampleInput() {
        assertEquals(3, LIS(arrayListOf(3, 6, 7, 12)))
    }


    @Test
    fun otherInputs() {
        assertEquals(6, LIS(arrayListOf(1, 3, 2, 4, 8, 16, 32, 6, 7, 12)))
        assertEquals(8, LIS(arrayListOf(1, 1, 3, 9, 2, 4, 27, 54, 1, 108, 8, 324, 123)))
    }
}
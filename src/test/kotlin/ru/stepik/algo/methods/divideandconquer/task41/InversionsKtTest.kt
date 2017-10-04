package ru.stepik.algo.methods.divideandconquer.task41

import org.junit.Test

import org.junit.Assert.*

/**
 * @author Ivan Zemlyanskiy
 */
class InversionsKtTest {
    @Test
    fun sampleInput() {

        assertEquals(2, inversionsCount(arrayListOf(2, 3, 9, 2, 9)).second)
    }

    @Test
    fun largeInputAsc() {
        val input = ArrayList<Int>(10_000)
        input += 1..10_000
        assertEquals(0, inversionsCount(input).second)
    }


    @Test
    fun inputDesc() {
        val initialCapacity = 10_000.0
        val input = ArrayList<Int>(initialCapacity.toInt())
        input += initialCapacity.toInt() downTo 1
        assertEquals((initialCapacity * ((initialCapacity - 1) / 2.0)).toLong(), inversionsCount(input).second)
    }

    @Test
    fun theSameNumbers() {
        val input = IntArray(100, { 5 }).asList()
        assertEquals(0, inversionsCount(input).second)
    }


}
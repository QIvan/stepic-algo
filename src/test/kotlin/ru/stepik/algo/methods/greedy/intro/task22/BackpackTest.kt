package ru.stepik.algo.methods.greedy.intro.task22

import org.junit.Test

import org.junit.Assert.*

/**
 * @author Ivan Zemlyanskiy
 */
class BackpackTest {
    @Test
    fun calcPriceSampleInput() {
        val backpack = Backpack(50)
        backpack.put(Thing(60,20))
        backpack.put(Thing(100,50))
        backpack.put(Thing(120,30))
        assertEquals(180.0, backpack.calcPrice(), 0.0001)
    }

    @Test
    fun calcPriceTest() {
        val backpack = Backpack(123)
        backpack.put(Thing(1,1))
        backpack.put(Thing(1,1))
        backpack.put(Thing(1,1))
        assertEquals(3.0, backpack.calcPrice(), 0.0001)
    }
}
package ru.stepik.algo.structs.hashtable.task32

import org.junit.Assert.*
import org.junit.Test

/**
 * @author Ivan Zemlyanskiy
 */
class HashMapListTest {


    @Test
    fun powTest() {
        val iterator = pow(2).iterator()
        assertEquals(1, iterator.next())
        assertEquals(2, iterator.next())
        assertEquals(4, iterator.next())
        assertEquals(8, iterator.next())
        assertEquals(16, iterator.next())
    }

    @Test
    fun hashTest() {
        val expectWorld: Long = (119L +
                111L * 263 +
                114L * 263 * 263 +
                108L * 263 * 263 * 263 +
                100L * 263 * 263 * 263 * 263) % 1_000_000_007
        assertEquals(expectWorld, hash("world"))

        val expectHello: Long = ('H'.toLong() +
                'e'.toLong() * 263 +
                'l'.toLong() * 263 * 263 +
                'l'.toLong() * 263 * 263 * 263 +
                'O'.toLong() * 263 * 263 * 263 * 263) % 1_000_000_007
        assertEquals(expectHello, hash("HellO"))
    }

    @Test
    fun checkMap() {
        val map = HashMapList(5)
        map.add("world")
        map.add("HellO")
        assertEquals(listOf("HellO", "world"), map.check(4))
        map.find("world")
        assertFalse(map.find("World"))
        map.delete("world")
        assertEquals(listOf( "HellO"), map.check(4))
        map.add("luck")
        map.add("GooD")
        assertEquals(listOf("GooD", "luck"), map.check(2))

    }
}
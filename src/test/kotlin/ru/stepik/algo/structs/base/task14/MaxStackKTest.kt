package ru.stepik.algo.structs.base.task14

import org.junit.Assert.*
import org.junit.Test

/**
 * @author Ivan Zemlyanskiy
 */
class MaxStackKTest{


    @Test
    fun sample1() {
        val maxStack = MaxStackK()
        maxStack.push(2)
        maxStack.push(1)
        assertEquals(2, maxStack.max())
        maxStack.pop()
        assertEquals(2, maxStack.max())
    }


    @Test
    fun sample2() {
        val maxStack = MaxStackK()
        maxStack.push(1)
        maxStack.push(2)
        assertEquals(2, maxStack.max())
        maxStack.pop()
        assertEquals(1, maxStack.max())
    }

    @Test
    fun sample3() {
        val maxStack = MaxStackK()
        maxStack.push(2)
        maxStack.push(3)
        maxStack.push(9)
        maxStack.push(7)
        maxStack.push(2)
        assertEquals(9, maxStack.max())
        assertEquals(9, maxStack.max())
        maxStack.pop()
        assertEquals(9, maxStack.max())
        maxStack.pop()
        maxStack.pop()
        assertEquals(3, maxStack.max())
    }

    @Test
    fun downTo() {
        val maxStack = MaxStackK()
        for (i in 0..400000) {
            maxStack.push(i)
        }
        for (i in 400000 downTo 0) {
            assertEquals(i, maxStack.max())
            assertEquals(i, maxStack.max())
            assertEquals(i, maxStack.max())
            assertEquals(i, maxStack.max())
            assertEquals(i, maxStack.max())
            maxStack.pop()
        }
    }

    @Test
    fun toUp() {
        val maxStack = MaxStackK()
        for (i in 400000 downTo 0) {
            maxStack.push(i)
        }
        for (i in 400000 downTo 0) {
            assertEquals(400000, maxStack.max())
            maxStack.pop()
        }
    }
}
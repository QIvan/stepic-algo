package ru.stepik.algo.structs.base.task11

import org.junit.Test

import org.junit.Assert.*

/**
 * @author Ivan Zemlyanskiy
 */
class BracketsInCodeTest {

    @Test
    fun solveTest() {
        assertEquals(-1, solve("(())"))
        assertEquals(-1, solve("(())()"))
        assertEquals(-1, solve("((asdf))()"))
        assertEquals(2, solve("[])"))
        assertEquals(0, solve("([]"))
        assertEquals(0, solve("))))"))
        assertEquals(2, solve("{}))"))
        assertEquals(4, solve("(())}"))
        assertEquals(6, solve("{{[()]]"))
        assertEquals(2, solve("({)}{{[()]]"))
    }
}
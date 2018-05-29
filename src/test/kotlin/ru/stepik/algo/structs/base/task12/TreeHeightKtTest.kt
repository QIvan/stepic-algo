package ru.stepik.algo.structs.base.task12

import org.junit.Test

import org.junit.Assert.*

/**
 * @author Ivan Zemlyanskiy
 */
class TreeHeightKtTest {

    @Test
    fun treeHeightTest() {
        assertEquals(4, treeHeight(arrayListOf(9, 7, 5, 5, 2, 9, 9, 9, 2, -1)))
        assertEquals(3, treeHeight(arrayListOf(4, -1, 4, 1, 1)))
        assertEquals(4, treeHeight(arrayListOf(-1, 0, 4, 0, 3)))
    }
}
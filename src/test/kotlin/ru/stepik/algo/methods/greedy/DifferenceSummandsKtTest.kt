package ru.stepik.algo.methods.greedy

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author Ivan Zemlyanskiy
 */
class DifferenceSummandsKtTest {
    @Test
    fun differenceSummandsTest() {
        assertEquals(Result(2, 3), differenceSummands(6))
        assertEquals(Result(3, 5), differenceSummands(11))
        assertEquals(Result(0, 1), differenceSummands(1))
        assertEquals(Result(0, 0), differenceSummands(0))

    }

}
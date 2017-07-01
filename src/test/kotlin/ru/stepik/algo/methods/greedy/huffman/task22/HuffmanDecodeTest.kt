package ru.stepik.algo.methods.greedy.huffman.task22

import org.junit.Test

import org.junit.Assert.*

/**
 * @author Ivan Zemlyanskiy
 */
class HuffmanDecodeTest {
    @Test
    fun sampleInput1() {
        val huffmanDecode = HuffmanDecode()
        val decode = huffmanDecode.decode(mapOf('a' to byteArrayOf(0)), listOf(0))
        assertEquals("a", decode)
    }

    @Test
    fun sampleInput2() {
        val huffmanDecode = HuffmanDecode()
        val decode = huffmanDecode.decode(
                mapOf(
                        'a' to byteArrayOf(0),
                        'b' to byteArrayOf(1, 0),
                        'c' to byteArrayOf(1, 1, 0),
                        'd' to byteArrayOf(1, 1, 1)
                ),
                listOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1))
        assertEquals("abacabad", decode)
    }

}
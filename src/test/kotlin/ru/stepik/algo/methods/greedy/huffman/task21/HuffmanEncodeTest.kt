package ru.stepik.algo.methods.greedy.huffman.task21

import org.junit.Assert.*
import org.junit.Test
import java.lang.StringBuilder
import java.util.*
import java.util.Random




/**
 * @author Ivan Zemlyanskiy
 */
class HuffmanEncodeTest {


    @Test
    fun sampleInput1() {
        val huffman = HuffmanEncode()
        val encode = huffman.encode("a")

        assertArrayEquals(byteArrayOf(0), huffman.letterCodes['a'])
        assertArrayEquals(listOf<Byte>(0).toByteArray(), encode.toByteArray())
    }


    @Test
    fun sampleInput2() {
        val huffman = HuffmanEncode()
        val encode = huffman.encode("abacabad")

        assertArrayEquals(byteArrayOf(0), huffman.letterCodes['a'])
        assertArrayEquals(byteArrayOf(1, 0), huffman.letterCodes['b'])
        assertArrayEquals(byteArrayOf(1, 1, 0), huffman.letterCodes['c'])
        assertArrayEquals(byteArrayOf(1, 1, 1), huffman.letterCodes['d'])
        assertArrayEquals(listOf<Byte>(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1).toByteArray(), encode.toByteArray())
    }

    @Test
    fun largeInput() {
        val huffman = HuffmanEncode()
        val input = StringBuilder()
        for (i in 0..1000) {
            input.append(('a'.toInt() + (i % 26)).toChar())
        }
        val encode = huffman.encode(input.toString())
        assertEquals(26, huffman.letterCodes.size)
        assertFalse(encode.isEmpty())
    }


    @Test
    fun largeInputOnlyA() {
        val huffman = HuffmanEncode()
        val input = StringBuilder()
        for (i in 0 until 1000) {
            input.append('a')
        }
        val encode = huffman.encode(input.toString())
        assertEquals(1, huffman.letterCodes.size)
        assertArrayEquals(byteArrayOf(0), huffman.letterCodes['a'])
        assertArrayEquals(List<Byte>(1000, { 0 }).toByteArray(), encode.toByteArray())
    }
}
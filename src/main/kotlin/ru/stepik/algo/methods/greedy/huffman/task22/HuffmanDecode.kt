package ru.stepik.algo.methods.greedy.huffman.task22

import java.util.*


class HuffmanDecode {

    fun decode(letterCodes: Map<Char, ByteArray>, input: List<Byte>): String {
        val huffmanTree = HuffmanTree(letterCodes)
        val result = StringBuilder()

        var currentTreePosition: HuffmanLetter? = huffmanTree.root
        for (byte in input) {
            currentTreePosition =
                    if (byte.toInt() == 0) {
                        currentTreePosition?.left
                    } else {
                        assert(byte.toInt() == 1)

                        currentTreePosition?.right
                    }

            currentTreePosition?.letter?.let {
                result.append(it)
                currentTreePosition = huffmanTree.root
            }
        }
        return result.toString()
    }


    private class HuffmanTree(letterCodes: Map<Char, ByteArray>) {
        var root: HuffmanLetter
            private set

        init {
            root = HuffmanLetter()
            letterCodes.forEach { (letter, code: ByteArray) ->
                var currentRoot = root
                for (byte in code) {
                    if (byte.toInt() == 0) {
                        currentRoot.left = currentRoot.left ?: HuffmanLetter()
                        currentRoot = currentRoot.left!!
                    } else {
                        assert(byte.toInt() == 1)

                        currentRoot.right = currentRoot.right ?: HuffmanLetter()
                        currentRoot = currentRoot.right!!
                    }
                }
                currentRoot.letter = letter
            }

        }


    }

    data class HuffmanLetter(var letter: Char? = null) {
        var left: HuffmanLetter? = null
        var right: HuffmanLetter? = null
    }

}

fun main(args: Array<String>): Unit {

    val scanner = Scanner(System.`in`)
    val letterCount = scanner.nextLine().split(' ')[0].toInt()
    val letterCodes = mutableMapOf<Char, ByteArray>()
    for (i in 1..letterCount) {
        val (letter, code) = scanner.nextLine().split(':')
        letterCodes.put(
                letter[0],
                code.trim().map { it.toString().toByte() }.toByteArray()
        )
    }
    val input = scanner.nextLine().map { it.toString().toByte() }.toList()

    val huffmanDecode = HuffmanDecode()
    val decode = huffmanDecode.decode(letterCodes, input)
    print(decode)

}

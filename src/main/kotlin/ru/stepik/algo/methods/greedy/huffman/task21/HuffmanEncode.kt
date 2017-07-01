package ru.stepik.algo.methods.greedy.huffman.task21

import java.util.*


class HuffmanEncode {
    private val _letterCodes: MutableMap<Char, ByteArray> = mutableMapOf()

    val letterCodes: Map<Char, ByteArray>
    get() = _letterCodes

    fun encode(inputString: String): List<Byte> {
        val letterStatistic = createLetterStatistic(inputString)

        val huffmanTree = HuffmanTree(letterStatistic)

        createLetterCodes(huffmanTree.root, ArrayDeque<Byte>())

        return inputString
                .map { _letterCodes.getOrElse(it, { throw IllegalStateException("No code for letter $it") }) }
                .flatMap { it.asIterable() }
                .toList()
    }

    private fun createLetterStatistic(inputString: String): Map<Char, Int> {
        val letterStatistic = mutableMapOf<Char, Int>()
        for (char in inputString) {
            letterStatistic.compute(char, { _, stat -> stat?.inc() ?: 1 })
        }
        return letterStatistic
    }

    private fun createLetterCodes(root: HuffmanLetter, currentCode: Deque<Byte>) {
        if (root.letter != null) {
            val code =
                    if (currentCode.isEmpty())
                        byteArrayOf(0)
                    else
                        currentCode.toByteArray()
            _letterCodes.put(root.letter, code)
            return
        }

        val left = root.left
        if (left != null) {
            currentCode.addLast(0)
            createLetterCodes(left, currentCode)
            currentCode.pollLast()
        }

        val right = root.right
        if (right != null) {
            currentCode.addLast(1)
            createLetterCodes(right, currentCode)
            currentCode.pollLast()
        }

    }


    //todo поле statistic сохраняется в классе. Как сделать чтобы не сохранялось?
    private class HuffmanTree(statistic: Map<Char, Int>) {
        var root: HuffmanLetter
        private set

        init {
            val queue = statistic
                    .map { (letter, stat) -> HuffmanLetter(stat, letter) }
                    .toCollection(PriorityQueue<HuffmanLetter>(compareBy { it.statistic }))

            while (queue.size != 1) {
                val minLetter = queue.poll()
                val nextMinLetter = queue.poll()

                val parent = HuffmanLetter(minLetter.statistic + nextMinLetter.statistic)
                parent.left = minLetter
                parent.right = nextMinLetter
                queue.add(parent)
            }
            root = queue.poll()
        }


    }

    data class HuffmanLetter(val statistic: Int, val letter: Char? = null) {
        var left: HuffmanLetter? = null
        var right: HuffmanLetter? = null
    }

}

fun main(args: Array<String>): Unit {

    val scanner = Scanner(System.`in`)
    val inputString = scanner.nextLine()

    val huffman = HuffmanEncode()
    val encode = huffman.encode(inputString)
    println("${huffman.letterCodes.size} ${encode.size}")
    huffman.letterCodes.forEach { letter, code: ByteArray ->
        print("$letter: ")
        code.forEach { print(it) }
        println()
    }
    encode.forEach { print(it) }
}

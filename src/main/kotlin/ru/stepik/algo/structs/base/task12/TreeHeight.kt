package ru.stepik.algo.structs.base.task12

import java.util.*

//мутабельный говнокод, конечно, но зато быстро

data class Node(val parentIndex: Int, var height: Int? = null)

fun treeHeight(input: List<Int>): Int {
    val tree = input.map { Node(it) }
    var resultHeight = 0

    tree.forEachIndexed { index, node ->
        if (node.height != null) {
            return@forEachIndexed
        }

        var height = 0
        var currentIndex = node.parentIndex
        while (currentIndex != -1) {
            height++
            val currentHeight = tree[currentIndex].height
            if (currentHeight != null) {
                height += currentHeight
                break
            }
            currentIndex = tree[currentIndex].parentIndex
        }

        currentIndex = index
        for (h in height downTo 0) {
            if (tree[currentIndex].height != null) {
                break
            }
            tree[currentIndex].height = h
            currentIndex = tree[currentIndex].parentIndex
        }

        if (resultHeight < height) {
            resultHeight = height
        }
    }

    return resultHeight + 1
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    scanner.nextLine()
    val input = scanner.nextLine().trim().split(" ").toList().map { it.toInt()}

    
    print(treeHeight(input))
}

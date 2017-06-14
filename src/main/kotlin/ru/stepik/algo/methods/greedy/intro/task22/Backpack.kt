package ru.stepik.algo.methods.greedy.intro.task22

import java.util.*

/**
 * @author Ivan Zemlyanskiy
 */
data class Thing(val price: Int, val volume: Int) : Comparable<Thing> {
    override fun compareTo(other: Thing): Int {
        return priceByVolumeUnit().compareTo(other.priceByVolumeUnit())
    }

    fun priceByVolumeUnit(): Double {
        return  price.toDouble() / volume.toDouble()
    }

}


class Backpack(val volume: Int) {

    val things = arrayListOf<Thing>()

    fun put(thing: Thing) {
        things.add(thing)
    }


    fun calcPrice(): Double {
        var price = 0.0
        var currentVolume = volume
        things.sorted().reversed().forEach {
            if (it.volume < currentVolume) {
                price += it.price
                currentVolume -= it.volume
            } else {
                price += currentVolume * it.priceByVolumeUnit()
                return price
            }
        }
        return price
    }

}


fun main(args: Array<String>): Unit {

    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val backpack = Backpack(scanner.nextInt())
    for (i in 1..n) {
        backpack.put(Thing(scanner.nextInt(), scanner.nextInt()))
    }
    print(String.format("%.3f", backpack.calcPrice()))


}
package arihunta.advent2018

import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

fun day02_01() {

    val pair = Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-02.txt").toURI()))
            .stream()
            .map { it.toCharArray() }
            .map {
                val frequencies = HashMap<Char, Int>()
                for (value in it) {
                    frequencies[value] = frequencies[value]?.let { it + 1 } ?: 1
                }
                Pair(if (frequencies.values.contains(2)) 1 else 0, if (frequencies.values.contains(3)) 1 else 0)
            }
            .reduce { acc: Pair<Int, Int>, it: Pair<Int, Int> ->
                Pair(acc.first + it.first, acc.second + it.second)
            }.orElse(Pair(0, 0))

    println("The checksum is ${pair.first * pair.second}")

}

fun day02_02() {

    val readAllLines: MutableList<String> = Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-02.txt").toURI()))
    for (i in 0 until readAllLines.size) {
        for (j in 0 until readAllLines.size) {
            if ((0 until readAllLines[i].length).map {
                        if (readAllLines[i][it] == readAllLines[j][it])
                            0
                        else
                            1
                    }.sum() == 1) {
                println("our strings are ${readAllLines[i]} and ${readAllLines[j]}")
            }
        }
    }
}

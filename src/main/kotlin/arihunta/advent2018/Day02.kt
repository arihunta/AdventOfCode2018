package arihunta.advent2018

import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

fun day02_01(): Int {

    val pair = Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-02.txt").toURI()))
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
            }

    return pair.first * pair.second

}

fun day02_02(): String {

    val lines = Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-02.txt").toURI()))

    for (i in 0 until lines.size) {
        for (j in 0 until lines.size) {
            if ((0 until lines[i].length)
                            .map {
                                if (lines[i][it] == lines[j][it]) {
                                    0
                                } else {
                                    1
                                }
                            }
                            .sum() == 1) {
                println("our strings are ${lines[i]} and ${lines[j]}")
            }
        }
    }

    return "your face"

}

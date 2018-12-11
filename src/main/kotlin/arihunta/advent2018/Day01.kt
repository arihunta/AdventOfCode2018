package arihunta.advent2018

import java.nio.file.Files
import java.nio.file.Paths
import java.util.HashSet

fun day01_01(): Int {

    return Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-01.txt").toURI()))
            .map { Integer.parseInt(it) }
            .sum()

}

fun day01_02(): Int {

    val lines = Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-01.txt").toURI()))
            .map { Integer.parseInt(it) }

    val encounteredFrequencies = HashSet<Int>()

    var idx = 0
    var currentFrequency = 0

    while (!encounteredFrequencies.contains(currentFrequency)) {
        encounteredFrequencies.add(currentFrequency)
        currentFrequency += lines[idx]
        idx++
        if (idx >= lines.size) {
            idx = 0
        }
    }

    return currentFrequency

}

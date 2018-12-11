package arihunta.advent2018

import java.nio.file.Files
import java.nio.file.Paths

fun day03_01(): Int {

    val regex = Regex("#(\\d*)\\s@\\s(\\d*),(\\d*):\\s(\\d*)x(\\d*)")

    val spots = Array(1_100) { IntArray(1_100) }

    Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-03.txt").toURI()))
            .map { regex.find(it) }
            .filterNotNull()
            .map { it.groups }
            .filter { it.size == 6 }
            .map { grps -> (1 until 6).map { grps[it]?.value }.filterNotNull() }
            .map { it -> it.map { Integer.parseInt(it) } }
            .forEach {
                for (i in it[1] until (it[1] + it[3])) {
                    for (j in it[2] until (it[2] + it[4])) {
                        spots[i][j] += 1
                    }
                }
            }

    return spots.map { array -> array.filter { value -> value > 1 }.count() }.sum();

}

fun day03_02(): Int {

    val regex = Regex("#(\\d*)\\s@\\s(\\d*),(\\d*):\\s(\\d*)x(\\d*)")

    val spots = Array(1_100) { IntArray(1_100) }

    val claims: List<List<Int>> = Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-03.txt").toURI()))
            .map { regex.find(it) }
            .filterNotNull()
            .map { it.groups }
            .filter { it.size == 6 }
            .map { grps -> (1 until 6).map { grps[it]?.value }.filterNotNull() }
            .map { it -> it.map { Integer.parseInt(it) } }

    claims.forEach {
        for (i in it[1] until (it[1] + it[3])) {
            for (j in it[2] until (it[2] + it[4])) {
                spots[i][j] += 1
            }
        }
    }

    return claims.filter { it ->
        for (i in it[1] until (it[1] + it[3])) {
            for (j in it[2] until (it[2] + it[4])) {
                if (spots[i][j] > 1) {
                    return@filter false
                }
            }
        }
        true
    }[0][0];

}

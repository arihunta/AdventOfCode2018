package arihunta.advent2018

import java.nio.file.Files
import java.nio.file.Paths

fun day04_01(): Int {

    val logEntry = Regex("\\[\\d\\d\\d\\d-\\d\\d-\\d\\d\\s\\d\\d:(\\d\\d)] (.*)")
    val guardId = Regex("Guard #(\\d*).*")
    val sleeps = Regex("falls asleep")
    val wakes = Regex("wakes up")

    val guardSleeps = HashMap<Int, IntArray>()
    var currentGuardArray: IntArray? = IntArray(0)
    var currentSleepTime: Int? = 0

    Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-04.txt").toURI()))
            .sorted()
            .map { logEntry.find(it) }
            .filterNotNull()
            .map { it.groups }
            .filter { it.size >= 3 }
            .map { Pair(it[1]!!.value, it[2]!!.value) }
            .forEach {
                if (guardId.matches(it.second)) {
                    val id = guardId.find(it.second)!!.groups[1]!!.value.toInt()
                    if (!guardSleeps.containsKey(id)) {
                        guardSleeps[id] = IntArray(60)
                    }
                    currentGuardArray = guardSleeps[id]
                    currentSleepTime = 0
                } else if (sleeps.matches(it.second)) {
                    currentSleepTime = it.first.toInt()
                } else if (wakes.matches(it.second)) {
                    (currentSleepTime!! until it.first.toInt()).forEach { currentGuardArray!![it]++ }
                }
            }

    val sleepiestGuard = guardSleeps.toSortedMap(compareBy { guardSleeps[it]!!.sum() }).lastKey()

    return sleepiestGuard * guardSleeps[sleepiestGuard]!!.indexOf(guardSleeps[sleepiestGuard]!!.max()!!)

}

fun day04_02(): Int {

    val logEntry = Regex("\\[\\d\\d\\d\\d-\\d\\d-\\d\\d\\s\\d\\d:(\\d\\d)] (.*)")
    val guardId = Regex("Guard #(\\d*).*")
    val sleeps = Regex("falls asleep")
    val wakes = Regex("wakes up")

    val guardSleeps = HashMap<Int, IntArray>()
    var currentGuardArray: IntArray? = IntArray(0)
    var currentSleepTime: Int? = 0

    Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-04.txt").toURI()))
            .sorted()
            .map { logEntry.find(it) }
            .filterNotNull()
            .map { it.groups }
            .filter { it.size >= 3 }
            .map { Pair(it[1]!!.value, it[2]!!.value) }
            .forEach {
                if (guardId.matches(it.second)) {
                    val id = guardId.find(it.second)!!.groups[1]!!.value.toInt()
                    if (!guardSleeps.containsKey(id)) {
                        guardSleeps[id] = IntArray(60)
                    }
                    currentGuardArray = guardSleeps[id]
                    currentSleepTime = 0
                } else if (sleeps.matches(it.second)) {
                    currentSleepTime = it.first.toInt()
                } else if (wakes.matches(it.second)) {
                    (currentSleepTime!! until it.first.toInt()).forEach { currentGuardArray!![it]++ }
                }
            }

    val sleepiestGuard = guardSleeps.toSortedMap(compareBy { guardSleeps[it]!!.max() }).lastKey()

    return sleepiestGuard * guardSleeps[sleepiestGuard]!!.indexOf(guardSleeps[sleepiestGuard]!!.max()!!)

}

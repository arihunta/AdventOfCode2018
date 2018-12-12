package arihunta.advent2018

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.math.abs
import kotlin.math.min

fun day05_01(): Int {

    var poly = Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-05.txt").toURI()))[0]

    poly = reduce(poly)

    return poly.length

}

fun day05_02(): Int {

    val poly = Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-05.txt").toURI()))[0]

    var shortest = 9202

    (0..25).forEach {
        shortest = min(shortest, reduce(poly.replace('A'.plus(it).toString(), "").replace('a'.plus(it).toString(), "")).length)
    }

    return shortest

}


fun reduce(og: String) : String {
    var poly = og
    var polySize: Int
    var newPolySize = poly.length

    do {
        polySize = newPolySize

        val tmpArr = poly.toCharArray()

        (0 until polySize - 1).forEach {
            if(abs(tmpArr[it].minus(tmpArr[it + 1])) == 32) {
                tmpArr[it] = ' '
                tmpArr[it + 1] = ' '
            }
        }

        poly = kotlin.text.String(tmpArr).replace(" ", "")

        newPolySize = poly.length

    } while (polySize != newPolySize)
    return poly
}

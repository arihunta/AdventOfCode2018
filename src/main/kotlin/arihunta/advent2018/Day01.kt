package arihunta.advent2018

import java.nio.file.Files
import java.nio.file.Paths
import java.util.HashSet
import java.util.stream.Collectors

fun day01_01() {
	val lines = Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-01.txt").toURI()))
	println("The sum is ${lines.stream().mapToInt(Integer::parseInt).sum()}")
}

fun day01_02() {

	val lines = Files.readAllLines(Paths.get(ClassLoader::class.java.getResource("/arihunta/advent2018/input-day-01.txt").toURI())).stream().map(Integer::parseInt).collect(Collectors.toList())
	val encounteredFreqs = HashSet<Int>()

	var idx = 0
	var currentFrequency = 0

	while (!encounteredFreqs.contains(currentFrequency)) {
		encounteredFreqs.add(currentFrequency)
		currentFrequency += lines[idx]
		idx++
		if (idx >= lines.size)
			idx = 0
	}

	println("The repeated freq is $currentFrequency")

}

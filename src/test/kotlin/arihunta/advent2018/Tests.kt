package arihunta.advent2018

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek

object AdventTests : Spek({

    group("Day 01") {

        test("Task 01") {
            assertEquals(427, day01_01())
        }

        test("Task 02") {
            assertEquals(341, day01_02())
        }

    }

    group("Day 02") {

        test("Task 01") {
            assertEquals(9139, day02_01())
        }

        test("Task 02") {
            assertEquals("uqcidadzwtnhsljvxyobmkfyr", day02_02())
        }

    }

    group("Day 03") {

        test("Task 01") {
            assertEquals(117505, day03_01())
        }

        test("Task 02") {
            assertEquals(1254, day03_02())
        }

    }

})

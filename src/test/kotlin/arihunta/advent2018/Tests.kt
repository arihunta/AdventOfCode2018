package arihunta.advent2018

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek

object AdventTests : Spek({

    group("Day 01") {

        test("Task 01") {
            assertEquals(day01_01(), 427)
        }

        test("Task 02") {
            assertEquals(day01_02(), 341)
        }

    }

    group("Day 02") {

        test("Task 01") {
            assertEquals(day02_01(), 9139)
        }

        test("Task 02") {
            assertEquals(day02_02(), "uqcidadzwtnhsljvxyobmkfyr")
        }

    }

})

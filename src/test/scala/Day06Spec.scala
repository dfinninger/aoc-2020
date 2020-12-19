import Day06.{part1, part2}
import org.scalatest.wordspec.AnyWordSpec

class Day06Spec extends AnyWordSpec {
  var input = List(
    "abc",
    "",
    "a",
    "b",
    "c",
    "",
    "ab",
    "ac",
    "",
    "a",
    "a",
    "a",
    "a",
    "",
    "b "
  )

  "part 1" should {
    "be correct" in {
      assert(part1(input) == 11)
    }
  }

  "part 2" should {
    "be correct" in {
      assert(part2(input) == 6)
    }
  }
}

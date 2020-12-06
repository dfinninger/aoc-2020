import org.scalatest.wordspec.AnyWordSpec

class Day02Spec extends AnyWordSpec {
  var input = List(
    "1-3 a: abcde",
    "1-3 b: cdefg",
    "2-9 c: ccccccccc"
  )

  "part 1" should {
    "be right" in {
      assert(Day02.part1(input) == 2)
    }
  }

  "part 2" should {
    "be right" in {
      assert(Day02.part2(input) == 1)
    }
  }
}

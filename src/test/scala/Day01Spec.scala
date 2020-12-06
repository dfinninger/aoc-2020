import org.scalatest.wordspec.AnyWordSpec

class Day01Spec extends AnyWordSpec {
  var nums = List(1721, 979, 366, 299, 675, 1456)

  "part 1" should {
    "generate the right number" in {
      assert(Day01.part1(nums).contains(514579))
    }
  }

  "part 2" should {
    "generate the right number" in {
      assert(Day01.part2(nums).contains(241861950))
    }
  }
}

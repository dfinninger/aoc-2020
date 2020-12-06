import org.scalatest.wordspec.AnyWordSpec

class Day03Spec extends AnyWordSpec {
  var input = List(
    "..##.......",
    "#...#...#..",
    ".#....#..#.",
    "..#.#...#.#",
    ".#...##..#.",
    "..#.##.....",
    ".#.#.#....#",
    ".#........#",
    "#.##...#...",
    "#...##....#",
    ".#..#...#.#"
  )

  "part 1" should {
    "be right" in {
      assert(Day03.part1(input) == 7)
    }
  }

  "part 2" should {
    "right 1 down 1" in {
      assert(Day03.part2(input, 1, 1) == 2)
    }
    "right 3 down 1" in {
      assert(Day03.part2(input, 3, 1) == 7)
    }
    "right 5 down 1" in {
      assert(Day03.part2(input, 5, 1) == 3)
    }
    "right 7 down 1" in {
      assert(Day03.part2(input, 7, 1) == 4)
    }
    "right 1 down 2" in {
      assert(Day03.part2(input, 1, 2) == 2)
    }
  }
}

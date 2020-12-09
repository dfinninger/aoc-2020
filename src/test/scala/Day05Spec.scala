import Day05.BoardingPass
import org.scalatest.wordspec.AnyWordSpec

class Day05Spec extends AnyWordSpec {
  var input = List()

  "part 1" should {
    "be correct" in {
      assert(BoardingPass("FBFBBFFRLR").seatId == 357)
      assert(BoardingPass("BFFFBBFRRR").seatId == 567)
      assert(BoardingPass("FFFBBBFRRR").seatId == 119)
      assert(BoardingPass("BBFFBBFRLL").seatId == 820)
    }
  }

  "part 2" should {
    "be correct" in {}
  }
}

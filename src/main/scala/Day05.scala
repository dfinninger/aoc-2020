import scala.annotation.tailrec
import scala.io.Source

object Day05 extends App {

  case class BoardingPass(seat: String) {
    def seatNumber: (Double, Double) = {
      val (rowStr, colStr) = seat.splitAt(7)

      @tailrec
      def calcBinary(input: String, sum: Double = 0): Double = {
        if (input.isEmpty) sum
        else {
          val (head, tail) = input.splitAt(1)
          val mult = head match {
            case "F" | "L" => 0
            case "B" | "R" => 1
            case _ => throw new RuntimeException(s"unknown mult: $head")
          }

          calcBinary(tail, sum + mult * Math.pow(2, tail.length))
        }
      }

      (calcBinary(rowStr), calcBinary(colStr))
    }

    def seatId: Double = {
      val (row, col) = seatNumber
      row * 8 + col
    }
  }

  def part1(input: List[String]): Int = {
    val ids = for (item <- input) yield BoardingPass(item).seatId
    ids.reduceLeft((s1, s2) => if (s1 > s2) s1 else s2).toInt
  }

  def part2(input: List[String]): Int = {
    val ids = for (item <- input) yield BoardingPass(item).seatId

    @tailrec
    def findMissing(input: List[Double]): Double = {
      val head :: tail = input
      if (head + 1 == tail.head) findMissing(tail)
      else head + 1
    }

    findMissing(ids.sorted).toInt
  }

  private val input = Source.fromResource("d5p1.txt").getLines().toList
  println(s"Day 05 part 1 = ${part1(input)}")
  println(s"Day 05 part 2 = ${part2(input)}")
}

import scala.annotation.tailrec
import scala.io.Source

object Day03 extends App {

  private def indexModulo(str: String, idx: Int): Char = str(idx % str.length)

  def part1(input: List[String]): Int = {
    val res = for ((item, idx) <- input.zipWithIndex) yield {
      indexModulo(item, idx * 3) == '#'
    }
    res.count(_ == true)
  }

  def part2(input: List[String], right: Int, down: Int): Int = {
    val res = for ((item, idx) <- input.sliding(1, down).map(_.head).zipWithIndex) yield {
      indexModulo(item, idx * right) == '#'
    }
    res.count(_ == true)
  }

  private val input = Source.fromResource("d3p1.txt").getLines().toList
  println(s"Day 03 part 1: ${part1(input)}")
  val p2: BigInt =
    BigInt(part2(input, 1, 1)) * // force BigInt
      part2(input, 3, 1) *
      part2(input, 5, 1) *
      part2(input, 7, 1) *
      part2(input, 1, 2)
  println(s"Day 03 part 2: $p2")
}

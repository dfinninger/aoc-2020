import scala.io.Source

object Day06 extends App {

  private def chunkedInput(input: List[String]): List[List[String]] =
    input
      .map(s => if (s.trim == "") "|" else s.trim)
      .mkString(" ")
      .split('|')
      .map(_.trim.split(' ').toList)
      .toList

  def part1(input: List[String]): Int =
    chunkedInput(input)
      .map(_.mkString.distinct.length)
      .sum

  def part2(input: List[String]): Int =
    chunkedInput(input)
      .map(_.map(_.toSet))
      .map(_.reduce((set1, set2) => set1.intersect(set2)))
      .map(_.size)
      .sum

  private val input = Source.fromResource("d6p1.txt").getLines().toList
  println(s"Day 06 part 1 = ${part1(input)}")
  println(s"Day 06 part 2 = ${part2(input)}")
}

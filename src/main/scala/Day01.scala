import scala.annotation.tailrec
import scala.io.Source

object Day01 extends App {

  def part1(nums: List[Int]): Option[Int] = {
    val numset = nums.toSet
    for (i <- nums) {
      val res = 2020 - i
      if (numset.contains(res)) return Some(i * res)
    }
    None
  }

  def part2(nums: List[Int]): Option[Int] = {
    val numset = nums.toSet
    for (i <- nums;
         j <- nums) {
      val res = 2020 - i - j
      if (numset.contains(res)) return Some(i * j * res)
    }
    None
  }

  private val nums = Source.fromResource("d1p1.txt").getLines().map(_.toInt).toList
  println(s"Day 01 part 1: ${part1(nums)}")
  println(s"Day 01 part 2: ${part2(nums)}")
}


import scala.io.Source
import scala.util.{Failure, Success, Try}

object Day02 extends App {
  lazy private val pattern = "(\\d+)-(\\d+) (\\w): (\\w+)".r

  case class Policy(lowerBound: Int, upperBound: Int, letter: Char) {
    def matchesP1(password: String): Boolean = {
      val num = password.count(_ == letter)
      lowerBound <= num && num <= upperBound
    }

    def matchesP2(password: String): Boolean = {
      val l = password(lowerBound - 1) == letter
      val u = password(upperBound - 1) == letter
      l ^ u
    }
  }

  private def parseInput(input: String): Try[(Policy, String)] = {
    input match {
      case pattern(l, u, c, s) => Success((Policy(l.toInt, u.toInt, c.toCharArray.head), s))
      case _ => util.Failure(new RuntimeException(input))
    }
  }

  def part1(input: List[String]): Int = {
    val res = for (item <- input) yield {
      parseInput(item) match {
        case Success((policy, password)) => policy.matchesP1(password)
        case Failure(f) => println(f)
      }
    }
    res.count(_ == true)
  }

  def part2(input: List[String]): Int = {
    val res = for (item <- input) yield {
      parseInput(item) match {
        case Success((policy, password)) => policy.matchesP2(password)
        case Failure(f) => println(f)
      }
    }
    res.count(_ == true)
  }

  private val input = Source.fromResource("d2p1.txt").getLines().toList
  println(s"Day 02 part 1: ${part1(input)}")
  println(s"Day 02 part 2: ${part2(input)}")
}

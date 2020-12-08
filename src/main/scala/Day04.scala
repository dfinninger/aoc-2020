import scala.annotation.tailrec
import scala.io.Source

object Day04 extends App {

  case class Passport(
      birthYear: String = null,
      issueYear: String = null,
      expiryYear: String = null,
      height: String = null,
      hairColor: String = null,
      eyeColor: String = null,
      passportId: String = null,
      countryId: String = null
  ) {

    /** We can ignore Country ID */
    def isValid: Boolean = {
      birthYear != null &&
      issueYear != null &&
      expiryYear != null &&
      height != null &&
      hairColor != null &&
      eyeColor != null &&
      passportId != null
    }

    def isValidP2: Boolean = {
      isValid &&
      birthYear.length == 4 && "1920" <= birthYear && birthYear <= "2020" &&
      issueYear.length == 4 && "2010" <= issueYear && issueYear <= "2020" &&
      expiryYear.length == 4 && "2020" <= expiryYear && expiryYear <= "2030" &&
      ((height.endsWith("cm") && "150" <= height.dropRight(2) && height
        .dropRight(2) <= "193") ||
      (height.endsWith("in") && "59" <= height.dropRight(2) && height.dropRight(
        2
      ) <= "76")) &&
      hairColor.matches("^#[0-9a-f]{6}$") &&
      Set("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(eyeColor) &&
      passportId.matches("^\\d{9}$")

    }
  }

  /** Expects the input to be a single string */
  private def passportsFromInput(input: List[String]): Seq[Passport] = {

    val rawPassports = input
      .map(s => if (s.trim == "") "|" else s.trim)
      .mkString(" ")
      .split('|')
      .map(_.trim.split(' ').toList)

    @tailrec
    def inner(
        parts: List[String],
        passport: Passport = Passport()
    ): Passport = {
      if (parts.isEmpty) passport
      else {
        val head :: tail = parts
        head.split(':') match {
          case Array("byr", byr) => inner(tail, passport.copy(birthYear = byr))
          case Array("iyr", iyr) => inner(tail, passport.copy(issueYear = iyr))
          case Array("eyr", eyr) => inner(tail, passport.copy(expiryYear = eyr))
          case Array("hgt", hgt) => inner(tail, passport.copy(height = hgt))
          case Array("hcl", hcl) => inner(tail, passport.copy(hairColor = hcl))
          case Array("ecl", ecl) => inner(tail, passport.copy(eyeColor = ecl))
          case Array("pid", pid) => inner(tail, passport.copy(passportId = pid))
          case Array("cid", cid) => inner(tail, passport.copy(countryId = cid))
          case _                 => throw new RuntimeException(s"unknown match: $head")
        }
      }
    }

    for (line <- rawPassports) yield inner(line)
  }

  def part1(input: List[String]): Int =
    passportsFromInput(input).count(_.isValid)

  def part2(input: List[String]): Int =
    passportsFromInput(input).count(_.isValidP2)

  private val input = Source.fromResource("d4p1.txt").getLines().toList
  println(s"Day 04 part 1 = ${part1(input)}")
  println(s"Day 04 part 2 = ${part2(input)}")
}

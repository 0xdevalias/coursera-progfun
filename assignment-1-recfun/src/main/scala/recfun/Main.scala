package recfun
import common._
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 | c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec def loop(isOpen: Boolean, count: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) !isOpen && count == 0
      else {
        chars.head match {
          case '(' => loop(true, count + 1, chars.tail)
          case ')' => loop(false, count - 1, chars.tail)
          case _ => loop(isOpen, count, chars.tail)
        }
      }
    }
    
    loop(false, 0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    money match {
      case _ if money < 0 => 0
      case _ if money == 0 => 1
      case _ if coins.isEmpty => 0
      case _ => countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
}

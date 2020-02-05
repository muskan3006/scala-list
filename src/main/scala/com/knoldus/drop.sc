
def drop(n: Int, list: List[Int]): List[Int] = {
  val length = list.length
  val x = List()

  @scala.annotation.tailrec
  def help(list1: List[Int], list2: List[Int], n1: Int, l: Int): List[Int] = {
    list2 match {
      case Nil => list1
      case first :: rest => if (n1 > 0 && l < length) help(list1 ::: List(first), rest, n1 - 1, l + 1)
      else if (n1 == 0 && l < length) help(list1, rest, n - 1, l + 1)
      else list1
    }
  }

  help(x, list, n - 1, 0)

}


drop(2, List(1, 2, 3, 4))
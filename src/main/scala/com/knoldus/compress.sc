def compress(list: List[Int]): List[Int] = {
  @scala.annotation.tailrec
  def compressHelp(l: List[Int], ll: List[Int]): List[Int] = {
    list match {
      case Nil => ll
      case first :: Nil => l
      case first :: second :: rest => if (first == second) {
        compressHelp(List(second) ::: rest, ll)
      }
      else compressHelp(List(second) ::: rest, List(first) ::: ll)
    }
  }

  compressHelp(list, List())
}

compress(List(1, 1, 1, 2, 3, 4, 4))
def myReverse(list: List[Int]): List[Int] = list match {
  case Nil => list
  case first :: Nil => list
  case first :: rest => myReverse(rest) ::: List(first)
}

myReverse(List(1,2,3,4))
def addDuplicates(list:List[Int]):List[Int] = list match{
  case Nil => list
  //  case first :: Nil => list
  case first :: rest => List(first) ::: List(first) ::: addDuplicates(rest)
}

addDuplicates(List(1))
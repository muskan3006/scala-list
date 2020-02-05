

@scala.annotation.tailrec
def firstEven(list:List[Int]):Int={
  list match{
    case Nil => 0
    //case first :: Nil=> first
    case first :: rest => if(first % 2 == 0) first else firstEven(rest)
  }
}

firstEven(List(1))
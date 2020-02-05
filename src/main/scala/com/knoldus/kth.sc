@scala.annotation.tailrec
def kth(list:List[Int],k:Int):Int={
  list match{
    case Nil => 0
    //case first :: Nil=> first
    case first :: rest => if(k <= 0) first else kth(rest,k-1)
  }
}

kth(List(1,3,3,4,5),0)
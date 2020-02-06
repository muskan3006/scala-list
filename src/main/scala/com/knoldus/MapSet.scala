package com.knoldus

class MapSet {
  //Assumed that if the list is empty then 0 will be the output
  def last(list:List[Int]):Int = {
    list.foldLeft(0)((first,lastElement) => lastElement)
  }

  def sumConditional(map:Map[String,Int],str:String):Int={
    val keys = map.keySet
    keys.foldLeft(0){
      (sum,element)=> if(element.contains(str)){
        sum + map(element)
      }
      else sum
    }
  }

}

object Driver extends App{
  val obj = new MapSet
  val map = Map("anurag" -> 24, "daniel" -> 23, "anushka" -> 30)
  val str= "anu"
  val sum = obj.sumConditional(map,str)
  println(sum)
  val list = List(1, 1, 2, 3, 5, 8)
  val lastElem = obj.last(list)
  println(lastElem)

}


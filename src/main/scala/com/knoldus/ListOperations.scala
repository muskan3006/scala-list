package com.knoldus

class ListOperations {

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

  def addDuplicates(list: List[Int]): List[Int] = list match {
    case Nil => list
    case first :: rest => List(first) ::: List(first) ::: addDuplicates(rest)
  }

  def firstEven(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case first :: rest => if (first % 2 == 0) first else firstEven(rest)
    }
  }

  def kth(list: List[Int], k: Int): Int = {
    list match {
      case Nil => 0
      case first :: rest => if (k <= 0) first else kth(rest, k - 1)
    }
  }

  def myReverse(list: List[Int]): List[Int] = list match {
    case Nil => list
    case first :: Nil => list
    case first :: rest => myReverse(rest) ::: List(first)
  }

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

  def palindrome(list: List[Int]): Boolean = {
    val ll = myReverse(list)

    @scala.annotation.tailrec
    def palindromeHelp(l1: List[Int], l2: List[Int]): Boolean = {
      l1 match {
        case Nil => false
        case first :: Nil => true
        case first :: rest => l2 match {
          case f :: r => if (first == f) {
            palindromeHelp(rest, r)
          }
          else false

        }

      }
    }

    palindromeHelp(list, ll)
  }


}


object MyList extends App {
  val myList = new ListOperations()
  val list = List(1,3,5,6,2)
  val number = 3
  myList.addDuplicates(list)
  myList.compress(list)
  myList.drop(number,list)
  myList.firstEven(list)
  myList.kth(list,number)
  myList.myReverse(list)
  myList.palindrome(list)
}
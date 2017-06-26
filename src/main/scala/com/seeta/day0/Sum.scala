package com.seeta.day0


object IntMonoid {
  def mappend(a: Int, b: Int): Int = a + b
  def zero: Int = 0
}

trait Monoid[A] {
  def map(a: A, b: A): A
  def zero: A
}

object Monoid {
  implicit val intMonoid = new Monoid[Int] {
    override def map(a: Int, b: Int): Int = a + b
    override def zero: Int = 0
  }

  implicit val stringMonoid = new Monoid[String] {
    override def map(a: String, b: String): String = a + b
    override def zero: String = ""
  }
}

object Sums {
  def sum1(l: List[Int]): Int = l.foldLeft(0)(_ + _)

  def sum2(l: List[Int]): Int = l.foldLeft(IntMonoid.zero)(IntMonoid.mappend)

  def sum3[A](l: List[A])(implicit m: Monoid[A]): A = l.foldLeft(m.zero)(m.map)


  def sum4[A: Monoid](l: List[A]): A = {
    val m = implicitly[Monoid[A]]
    l.foldLeft(m.zero)(m.map)
  }

}

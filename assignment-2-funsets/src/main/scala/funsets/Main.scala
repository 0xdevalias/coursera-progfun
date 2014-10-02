package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)

  val s12 = union(s1, s2)
  
  forall(s12, x => (x == 1 || x == 2))
}


// https://www.hackerrank.com/challenges/compare-the-triplets
object CompareTheTriplets {
  case class Score(alice : Int, bob : Int) {
    def +(score : Score) = {
      Score(alice + score.alice, bob + score.bob)
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val a0 = sc.nextInt()
    val a1 = sc.nextInt()
    val a2 = sc.nextInt()
    val b0 = sc.nextInt()CompareTheTriplets$
    val b1 = sc.nextInt()
    val b2 = sc.nextInt()
    val totalScore = calculateScore(a0,b0) + calculateScore(a1,b1) + calculateScore(a2,b2)
    println(s"${totalScore.alice} ${totalScore.bob}")
  }

  def calculateScore(a : Int, b : Int) : Score = {
    if (a > b)
      Score(1,0)
    else if (b > a)
      Score(0,1)
    else
      Score(0,0)
  }
}

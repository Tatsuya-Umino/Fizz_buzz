import scala.annotation.tailrec
import scala.io.StdIn.readLine

object fizzBuzz {
    def main(args: Array[String]): Unit = {

        while(true){
//            print("数値を入力してください : ")
//            var input = readLine()
            val input = readLine("数値を入力してください：") // 再代入しない値は定数（val）で宣言します

            if(input == "fin"){
                return
            }

            if (input == "" || !input.matches("^[0-9]*$")){
                println("整数を入力してください")
            }else{
//              fizzBuzz(input.toInt)
              println(fizzBuzz4(input.toInt)) // printlnはなるべくメソッドの外に追いやります
            }
        }

      // Scalaではwhile構文は使わずに末尾再帰処理を書くことが多い
      waitInput()
        
    }

    def fizzBuzz(input: Int){
        if (input % 3 == 0 && input % 5 == 0){
            println("FizzBuzz")    
        }else if (input % 3 == 0){
            println("Fizz")
        }else if (input % 5 == 0){
            println("Buzz")
        }else{
            println("not fizz or buzz")
        }
    }

  // publicなメソッドは戻り値の型を明示的に書きます（UnitはJavaのvoidのように戻り値がないことを表す）
  def fizzBuzz1(input: Int): Unit = {
    if (input % 3 == 0 && input % 5 == 0){
      println("FizzBuzz")
    }else if (input % 3 == 0){
      println("Fizz")
    }else if (input % 5 == 0){
      println("Buzz")
    }else{
      println("not fizz or buzz")
    }
  }

  // ifの条件が多いときはパターンマッチ構文を使うとすっきりします
  def fizzBuzz2(input: Int): Unit = input match {
    case i if i % 3 == 0 && i % 5 == 0 => println("FizzBuzz")
    case i if i % 3 == 0 => println("Fizz")
    case i if i % 5 == 0 => println("Buzz")
    case _ => println("not fizz or buzz")
  }

  // Scalaではなるべくメソッドの戻り値にUnitを使わないようにします（printlnなど、Unitを返すメソッドはテストがしにくい）
  def fizzBuzz3(input: Int): String = input match {
    case i if i % 3 == 0 && i % 5 == 0 => "FizzBuzz"
    case i if i % 3 == 0 => "Fizz"
    case i if i % 5 == 0 => "Buzz"
    case _ => "not fizz or buzz"
  }

  // FizzBuzzはタプル型を使うと完結に書けます
  def fizzBuzz4(input: Int): String = {
    // 計算結果をタプル型(x, y)に詰める
    (input % 3, input % 5) match {
      // inputが15の場合、(0, 0)
      case (0, 0) => "FizzBuzz"
      // inputが3の場合、(0, 6)
      // "_"はなんでもOKであることを表す
      case (0, _) => "Fizz"
      // inputが5の場合、(2, 0)
      case (_, 0) => "Buzz"
      // それ以外
      case _ => "not fizz or buzz"
    }
  }

  // あまり例が良くないですが、手続き型を避けるためwhileやforが書きたくなったら末尾再帰処理で書けないか検討します
  @tailrec
  def waitInput(): Unit = {
    val input = readLine("数値を入力してください：")
    input match {
      case "fin" =>
      case _ =>
        val res = try {
          fizzBuzz4(input.toInt)
        } catch {
          case e: Exception => "整数を入力してください"
        }
        println(res)
        waitInput()
    }
  }
}

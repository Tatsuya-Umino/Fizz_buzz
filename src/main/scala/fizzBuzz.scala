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
              fizzBuzz(input.toInt)
            } 
        }
        
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
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {


    fun rectangleArea(a: Int, b: Int) = (a+b)*2
    println(rectangleArea(5, 10))

    fun isEveb(a: Int): Boolean {
        if (a % 2 == 0){
            return true
        }
        return false
    }
    println(isEveb(10))

    fun factorial(a: Int): Long{
        var sum: Long = 1
        for(i in 1..a){
            sum*= i
        }
        return sum
    }

    fun giaiThua (a: Int): Int{
        if(a==0){
            return 1
        }else{
            return a * giaiThua(a - 1)
        }
    }
    println(giaiThua(5))


//    fun findMax(vararg numbers: Int): Int {
//        var max = Int.MIN_VALUE
//        for(number in numbers){
//            if (number >= max){
//               max = number
//            }
//        }
//        return max
//    }
//
//    println(findMax(1,2,3,99009090,5,43432))

    fun findMax(vararg numbers: Int): Int = numbers.maxOrNull() ?: Int.MIN_VALUE








}
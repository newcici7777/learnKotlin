interface Base3{
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl3(val x:Int): Base3{
    override fun printMessage() {
        println(x)
    }
    override fun printMessageLine() {
        println(x)
    }
}
class Derived3(b: Base3): Base3 by b {
    override fun printMessage() {
        print("abc")
    }
}

fun main() {
    val b = BaseImpl3(10)
    Derived3(b).printMessage()//abc 印出Derived3的實現
    //10 若Derived3沒有實現MessageLine，就會呼叫BaseImpl3
    Derived3(b).printMessageLine()

}
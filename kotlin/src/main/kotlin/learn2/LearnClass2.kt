package learn2

//open讓它被繼承
open class A1{
    //protected
    //外部不能訪問此方法，但子類可以訪問到方法
    protected fun print(){

    }
}
class B1:A1(){
    fun print2(){
        print()//這時候是可以用A1父類保護的print的方法
    }

}

fun main() {
    //直接實例化，是找不到print的方法
    //A().print()

    //建立接口對象 要用object:
    A6().test(object:Callback{
        //重寫裡面的方法
        override fun finish() {
            super.finish()
        }
    })
}

//abstract不能被實例化，只能被繼承
abstract class A2{}

//不能被繼承的一個類
final class A3{}

//kotlin 默認是final class
//要加open才可以被繼承
//kotlin所有的變量、方法、變數默認就是final，要設成open
//才可以被繼承、被覆寫
//可以被繼承的類
open class A4 {
    //可以被重寫的方法
    open fun print(){
    }
}



class B2:A4() {
    override fun print() {
        super.print()
    }
}

enum class Menu{
    HOME
}

//內部類
class A5{
    var b = 1
    inner class B{
        fun print(){
            //調用外部類b屬性
            //this@類名
            this@A5.b
        }
    }
}

//匿名內部類
//創建接口來定義
interface Callback{
    fun finish(){

    }
}

class A6{
    fun test(callBack:Callback) {
        callBack.finish()
    }
}
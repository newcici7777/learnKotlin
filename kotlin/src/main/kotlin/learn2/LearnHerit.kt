package learn2

fun main() {
    val b = BB1()
    b.printInfo()
    println(b.b)
//    info
//    3

}

//繼承一定要去執行父類的主構造方法，P()，括號代表主構造方法
//父類的主構造方法預設是沒寫constructor()
class BB1:P(){
    //重寫b屬性
    override var b: Int
        get() = 3
        set(value) {}

    //重寫printInfo方法
    override fun printInfo() {
        super.printInfo()
    }
}

//父類的主構造方法預設是沒寫constructor()
//open class P constructor(){
open class P{
    //kotlin所有的變量、方法、變數默認就是final，要設成open
    // 才可以被繼承、被覆寫
    open var b = 1//屬性可以繼承重寫
    open fun printInfo(){
       println("info")
    }
}

//abstract不能被實例化，只能被繼承
abstract class P2{
    //若希望方法被繼承，方法前面也要abstract, 不然預設會是final
    //抽象方法不能有方法體
    abstract fun test()
}

//繼承抽象類必須重寫它的方法
class BB2:P2(){
    override fun test() {
        TODO("Not yet implemented")
    }

}

interface Callback2{
    //interface的方法，是可以有方法體，跟java不一樣
    fun finish(){

    }
}
class BB3:Callback2{
    //子類可以選擇性的實現接口的方法finish，也可以不實現它
    //這裡選擇不實現finish
    fun test(){
        super.finish() //執行父類finish
    }
}

interface Callback3{
    //var b:Int = 1
    var b:Int //Interface的屬性不能設置默認的初值
}

//可以在子類的構造方法重寫Callback3的b值
class BB9(override var b: Int) :Callback3{

}

class BB10:Callback3{
    //可以在本體重寫Callback3 b的屬性
    override var b: Int
        get() = TODO("Not yet implemented")
        set(value) {}
}


interface Callback4{
    fun finish(){
        println("finish1")
    }
}
interface Callback5{
    fun finish(){
        println("finish2")
    }
}
//implement 二個Interface都有同樣的方法
//要重寫相同的方法
class BB11:Callback4,Callback5{
    override fun finish() {
        super<Callback4>.finish()
        super<Callback5>.finish()
    }
}

open class P3(name: String, age: Int) {
    constructor(name:String):this(name, 10)
}
//繼承時要執行父類的構造方法，所以要把構造參數代給父類的構造參數
class BB4(name:String, age:Int): P3(name, age) {

}

//若子類沒構造方法，要從次構造函數，把參數代給父類的主構造函數
class BB5:P3 {
    //通過super 關鍵字，把參數代給父類的主構造函數
    constructor(name:String, age:Int):super(name, age)
}

//若子類沒構造方法，要從次構造函數，把參數代給父類的主構造函數
class BB6:P3 {
    //通過super 關鍵字，把參數代給父類的次構造函數
    constructor(name:String, age:Int):super(name)
}

//若父類沒主構造方法，只有次構造方法
open class P4{
    constructor(name:String)
}
//若子類沒構造方法,父類沒主構造方法，要從次構造函數，把參數代給父類的次構造函數
class BB7:P4 {
    //通過super 關鍵字，把參數代給父類的次構造函數
    constructor(name:String, age:Int):super(name)
}

//若父類沒主構造方法，只有2個次構造方法
open class P5{
    constructor(name:String)
    constructor(name:String ,age:Int)
}

//若子類沒構造方法,父類沒主構造方法，要從次構造函數，把參數代給父類的次構造函數
class BB8:P5 {
    //通過super 關鍵字，把參數代給父類的次構造函數
    //並不會報錯，會在父類的2個次構造方法選一個
    constructor(name:String, age:Int):super(name)
}
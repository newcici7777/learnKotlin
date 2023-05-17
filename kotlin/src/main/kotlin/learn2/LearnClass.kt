package learn2

fun main() {
    //kotlin 實例化沒關鍵字，很像函數
    val a = A()
    println(a.b)
//    2
//    原本1 +1

    a.b = 3
    //因為get沒有給b設值，只有回傳field + 1
    //所以b一直是1，沒更改過
    //set b時，又把b(1) - 1 =0 ，把0設到b的變數中
    //get時，又把b(0) + 1，回傳出去
    println(a.b)
//    1

    val b = B()
    //b.set = 3 因B類的b屬性的set改為私有，就讀取不到這個方法
    //但B.b屬性默認為public ，但不能在public的屬性 寫private在get()上面

    val c = C()
    //c.c = 10  Val cannot be reassigned

    val d = D()
    d.d = 10

    val e = E()
    //對於沒初始化，執行時會報錯 UninitializedPropertyAccessException
    //e.e.forEach {  }

    val f = F("Test")
    //呼叫順序，先call 次構造->次構造->主構造->init

    val f1 = F(20,"Test")
    //呼叫順序，先call 主構造->init

    val g = G(20, "AA")
    g.printInfo()
// name: AA , age: 20

    //參數可代null,可為空
    val h = H(null, "ddd")

}
class A{
    var b:Int = 1
        //這邊的field就是b這個屬性
        get() = field + 1 //取得b+1
        set(value) { //設定
            println("inner:$field")
            field -=1 //b-1
        }
}

class B{
    var b:Int = 1
        //這邊的field就是b這個屬性
        get() = field + 1 //取得b+1
        private set(value) { //設定
            println("inner:$field")
            field -=1 //b-1
        }
}

class C{
    //val 常量沒有set
    val c:Int = 1
        //這邊的field就是c這個屬性
        get() = field + 1 //取得c+1
}

class D{
    //不寫set get，默認有set get
    //但值一定要初始化
    var d:Int = 1
}

class E{
    //對於集合類型可以延遲初始化
    //但對於還沒初始化就被foreach讀取，會報錯
    lateinit var e:Array<Int>
}

//寫在類名後面是主構造函數
class F(age:Int, name:String) {

    //age name是常量，沒有給值但卻沒有報錯，是因為在init的時候有給值
    //若沒有init給值就會報錯
    private val age: Int
    private val name: String
    //次構造函數是用constructor來命名，但最後要呼叫主構造函數
    constructor(age:Int, name:String, id:String) : this(age,name){
    }
    //呼叫上一個次構造函數
    constructor(name:String) : this(20, name, "aaa"){
    }


    //kotlin初始化操作在init
    //先走主構造函數，再走init
    init{
        this.age = age
        this.name = name
    }
}

//傳主構造函數時，順便 屬性定義
class G(var age:Int,var name:String) {
    fun printInfo() {
        //透過this.屬性 可以對屬性進行訪問
        this.age = 90
        println("name: $name , age: $age")
    }
}

//構造函數的參數可以設類型為空，並代入預設值為null
class H(var age:Int? = null ,var name:String) {
    fun printInfo() {
        //透過this.屬性 可以對屬性進行訪問
        this.age = 90
        println("name: $name , age: $age")
    }
}
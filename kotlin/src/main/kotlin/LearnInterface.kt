//    一個接口可以從其他接口繼承
//    這裏定義了一個 Named 命名接口
interface Named {
    val name:String
}
//    這個接口Person(人) 繼承上面的Named（命名） 接口
interface Person :Named{ //繼承其它
    //    這個接口定義了2個抽象屬性
    val firstName:String
    val lastNamed:String
    //    這個接口 重寫了上面接口的 屬性
    override val name: String
        get() = "$firstName $lastNamed"
}
//    這個數據類Employee （雇员） 實現了接口Person
//    在數據類 主構造方法裏 重寫了接口Person的抽象屬性
//    不必實現“name”
//    因爲Person接口已經實現Named的抽象屬性了
data class Employee(
    override val firstName: String,
    override val lastNamed: String
):Person

//實現多個接口，可能會遇到同一方法繼承多個實現問題
//    接口A和接口B 都有foo()和bar()
interface A{
    fun foo() { //默認函數 因為它有函數體
        print("A")
    }
    fun bar() //抽象函數
}
interface B{
    fun foo() {//默認函數
        println("B")
    }
    fun bar() {//默認函數
        println("bar")
    }
}

//    class C 實現接口A
//接口和抽象類一樣不能直接使用，需用實現類(子類)來實現
class C: A {
    //    重寫了A的抽象方法
    override fun bar() { //抽象函數必須要實現
        print("bar")
    }
}

class D : A,B{ //實作 A, B
    //重寫foo 抽象方法
    //遇到繼承多個interface都有相同foo()的默認方法，
    //必須實作A和B都有的foo的默認方法
    override fun foo() {
        //用super< > 分別實現抽象方法
        super<A>.foo()
        super<B>.foo()
    }

    //bar()的抽象方法也需重寫
    override fun bar() {
        super<B>.bar()
        //因C已經實現了A的抽象方法，這裡不用實現
    }
}
//    class D 同時 實現了 接口A和B
//    7:53
//    重寫foo()的抽象方法
//    7:56
//    用super< > 分別實現抽象方法
//    8:03
//    同理 bar()的抽象方法也需重寫
//    8:08
//    因C已經實現了A的抽象方法,這裡不用實現
//    8:19

fun main() {
    //    實例一臺 電腦
    val computer = Computer()
    computer.bootUp()
    //實例 滑鼠
    val mouse = Mouse()
    //    電腦使用設備
    //    提示傳入一個 USB引用數據類型的設備
    //    填入上面實例出來的鼠標
    computer.useEquipment(mouse)
    //    同樣 實例 一個鍵盤
    val keyBoard = KeyBoard()
    //    電腦使用 鍵盤 設備
    computer.useEquipment(keyBoard)
    //    電腦關機
    computer.shutDown()
}

fun foo() {} //無參數，無回傳值的函式

//有參數，有回傳值的函式
fun sum(a:Int, b:Int): Int{
    return a+b
}

//使用函式表達式
//表達式可以當成值被指派或回傳
//也就是可以放在指派符號 = 的右邊
//直接用 = 來指定回傳值
fun plus(a: Int, b: Int) : Int = a+b

//參數的預設值，指派符號 = 指定它的預設值
fun sum2(a: Int = 0, b:Int = 3, c:Int){
    println(a + b + c)
}
//fun main() {
//    sum2(a = 3, c = 6)//使用參數名稱指定值，略過有預設值的B
//    sum2(c = 5) //略過有預設值的a和b
//    sum2(c = 9, a = 1, b = 3 ) //以名稱指定參數的值，就可以忽略原始參數的順序
//}
//內部函式
//在函式中宣告另一個函式
fun plus2(a: Int, b:Int): Int{
    var result = a + b
    fun showResult(){
        println(result)//參考了外部函式的變數時，就形成了閉包Closure
    }
    showResult()
    return result
}
//成員函式
//在一個類裡面宣告一個函式
//成員(MEMBER)是一種術語 類別裡的變數或函式的一個統稱
//成員函式又可稱為方法
class Foo(){
    fun plus(a: Int, b:Int) = a + b
}

//數量不固定的參數(Varargs)
//在參數名稱前加上vararg關鍵字 代表此參數的數量是不固定的
//一個函式只能有一個vararg參數
//將 vararg參數移到最後面 避免錯誤
fun sum3(vararg num:Int){
    var total = 0
    for(i in num.indices){
        total += num[i]
    }
}
fun main() {
    val numbers = intArrayOf(3,7,8,10)
    //把陣列代進不固定參數的函式，要在陣列前放上
    sum3(*numbers)
    //展開(spread)運算子
    //比如剛好有一個陣列數組，反而會無法指定給vararg參數
    //kotlin在陣列數組前面加上星號

    //中綴表示法(Infix notation)
    //使用 infix關鍵字
    infix fun Int.plus(x:Int) = this + x
    println(1.plus(3)) //呼叫方法
    println(1 plus 3) //替代原本的.plus
    /**
     * infix函式有幾個要求:
     * 必須是成員函式(類別的方法) 或擴充函式
     * 必須有 且只有一個參數
     * 參數不能是數量不固定的vararg參數
     * 參數不能有預設值 
     */
}
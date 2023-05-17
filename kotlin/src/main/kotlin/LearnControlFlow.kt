fun main() {
    var a = 3
    val b = 9
    if (a > b) {
        println("number:$a")
    } else {
        println("number:$b")
    }

    //表達式(if-expressions)
    //表達式可以被當成值指派給變數或函式中回傳
    //表達式可以放在指派符號的右邊
    val chooseMax1 = if (a > b) println("number:$a") else println("number:$b")

    //如果if表達式內的程式碼不只一行
    //必須把結果放在最後一行，而且不可以加return
    //使用if表達式的時候，一定要有else區塊，因為任何時候都有值，才能指派給變數
    val chooseMax = if (a > b) {
        println("a最大")
        a //結果值放在最後一行，不要加return
    } else {
        println("b最大")
    }
}
//在函式中 一般函式的寫法
fun chooseMax(a:Int, b:Int) : Int {
    if(a > b) {
        return a
    } else {
        return b
    }
}
//if表達式的寫法
fun chooseMax2(a:Int, b:Int):Int{
    return if (a > b) a else b
}

//函式表達式的寫法
fun chooseMax3(a:Int, b:Int) = if (a > b) a else b
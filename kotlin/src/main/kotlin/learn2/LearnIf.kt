package learn2

fun main() {
    //kotlin什麼時候會判斷if是要有返回值的？
    //拿變量去接收它會自動判斷if是要去獲取返回值的
    //但一定要帶上else，因為它要判斷如果if條件不相等，要帶上其它值
    val b:Any = 1
    val res:Int = if(b == 1){
        3
    }else if(b ==3){
        1
    }else{
        2
    }
    println(res)

    //when每個代碼塊是用->箭頭指向代碼塊
    when(b) {
        1,2 ->{ //判斷b == 1 or b== 2，可以寫在同一排
            println("是1")
        }
        is String ->{//要把b設成Any，就不會自動推導Int，若沒設Any，會有型別錯誤
            println(" is str")
        }
        in 1..10 ->{//判斷是不是在1到10的區間中

        }
        else ->{

        }
    }
    //拿變量去接收它會自動判斷when是要去獲取返回值的
    //預設區塊的最後一行是返回值
    //但一定要帶上else，若之前的條件都不滿足，要有個else取得默認的回傳值

    val res2 =     when(b) {
        1,2 ->{ //判斷b == 1 or b== 2，可以寫在同一排
            2
        }
        is String ->{//要把b設成Any，就不會自動推導Int，若沒設Any，會有型別錯誤
            3
        }
        in 1..10 ->{//判斷是不是在1到10的區間中
            4
        }
        else ->{
            5
        }
    }
    println(res2)
    //如果只有一行，就不用寫花括號
    //if也是一樣
    println(
        when (b) {
            1, 2 -> 2
            is String -> 3
            in 1..10 -> 4
            else -> 5
        }
    )

    //kotlin沒有三元表達式
    //換成沒有花括號的lambda
    val res3:Boolean = if(b==1) true else false
    println(res3)

    //區間
    //使用in關鍵字，判斷是否有在區間中
    val range1 = 1 .. 10
    val c = 5
    println(c in range1) //true

    val charRange = 'a' .. 'z' //全包區間
    val intRange = 1 until 10 //半包區間，不包含10
    val downtoRange = 10 .. 1
    val stepRange = 1 .. 10 step 2
    //in 關鍵字可以拿到 if for while when裡用
    val res4 =if (c in range1) {
        "yes" //在區間中
    }else{
        "no" //不在區間中
    }
    println(res4)
}
//when敘述來取代switch
fun main() {
    var x: Any = 1

    when {
        //x 等於1的時候執行，箭頭表示符合時要如何處理
        x == 1 -> println("x 是 1")
        //x 等於2,3或者等於4的時候
        x == 2 || x == 3 || x == 4 -> println("x 可能是2 3 4")
        //x 在 5-10 的時候執行
        x in 5..10 -> println("x 在 5-10 的時候執行")
        //x 是 int的類型
        x is Int -> println("x是整數")
        //其它情況
        else -> println("無法判斷")
    }

    //把x放在when的參數裡
    when(x) {
        1 -> println("x 是 1")
        2,3,4 -> println("x 可能是2 3 4")
        in 5..10 -> println("x 在 5-10 的時候執行")
        is Int -> println("x是整數")
        else -> println("無法判斷")
        //如果所有可能條件都列出時，可以省略else
    }

    //表達式
    val message = when(x) {
        1 -> println("x 是 1")
        2,3,4 -> println("x 可能是2 3 4")
        in 5..10 -> println("x 在 5-10 的時候執行")
        is Int -> println("x是整數")
        else -> {
            //可以寫很多東西，要記得把結果放在最後一行
            println("無法判斷")
        }
    }
    //when的條件判斷不會像 java的switch自動向下執行
    //所以不必使用break來終止
    //當if - else條件過多時，建議改用when

}
//先判斷條件是否符合才執行的while迴圈
//do while則是先執行才判斷條件是否符合
fun main() {
    var i = 0
    while(i < 6) {
        println(i)
        i++
    }

    i = 0
    while(i < 6) println(i++)
//    0
//    1
//    2
//    3
//    4
//    5

    //加1放在前面表示先加1再加上自己
    i = 0
    while(i < 6) println(++i)
//    1
//    2
//    3
//    4
//    5
//    6
    //即使條件不滿足，也至少執行一次
    i = 6
    do{
        println(i)
        i++
    }while(i < 6)
//    6

    //跳過4
    for(i in 1..10) {
        if(i == 4) continue
        println(i)
    }
//    1
//    2
//    3
//    5
//    6
//    7
//    8
//    9
//    10


    //i == 5離開目前的迴圈
    //break只會中斷並離開靠近它的迴圈
    for(i in 1..10) {
        if(i == 5) break;
        println(i)
    }
//    1
//    2
//    3
//    4

    //某些情況下我們想離開外面的那個迴圈
    //標籤名稱@ 指定要跳離的迴圈
    i = 0
    outer@ do{
        println("out loop $i")
        i++
        var j = 0
        while(j < 3) {
            println("-- in loop $j")
            j++
            break@outer
        }
    }while(i < 6)
    //外迴圈、內迴圈只跑一次
    //    out loop 0
    //    -- in loop 0


    i = 0
    outer@ do{
        println("out loop $i")
        i++
        var j = 0
        while(j < 3) {
            println("-- in loop $j")
            j++
            continue@outer
        }
    }while(i < 6)
    //外迴圈跑一遍，內迴圈參與一次
//    out loop 0
//    -- in loop 0
//    out loop 1
//    -- in loop 0
//    out loop 2
//    -- in loop 0
//    out loop 3
//    -- in loop 0
//    out loop 4
//    -- in loop 0
//    out loop 5
//    -- in loop 0

    //repeat 重覆執行某段程式碼一定的次數
    repeat(3){
        println("hello")
    }

    //return 會跳離迴圈最接近的函式
    //不管是否為巢狀迴圈
    //永遠會跳離最接近的函式
    fun foo(){
        for(i in 0..1){
            println("for i start: $i")
            for(j in 0..3){
                println("for j start: $j")
                if(j == 2){
                    println("out foo()")
                    return
                }
                println("for j finish: $j")
            }
            println("for i finish $i")
        }
        println("finish foo()")
    }

    foo()
//    for i start: 0
//    for j start: 0
//    for j finish: 0
//    for j start: 1
//    for j finish: 1
//    for j start: 2
//    out foo()

}
fun main() {
    //kotlin的for 迴圈以範圍來決定徝環次數
    //以疊代的方式遍歷陣列或集合中的每個項目
    //kotlin沒有像Java，從C語言一直延續到現在的傳統for 迴圈
    //包含尾端的值
    for(i in 0..6) {
        //in關鍵字會將變數i的值限制在指定範圍內
        //在每次徝環時取得一個累進1的值
        println(i)
    }
//    0
//    1
//    2
//    3
//    4
//    5
//    6
    //不包含尾端的值
    for(i in 0 until 6) {
        println(i)
    }
//    0
//    1
//    2
//    3
//    4
//    5

    //徝環順序要反過來由大到小，使用downTo
    for(i in 6 downTo 0) {
        println(i)
    }
//    6
//    5
//    4
//    3
//    2
//    1
//    0

    for(i in 0..6 step 2) {
        println(i)
    }
//    0
//    2
//    4
//    6
    //疊代陣列或集合
    var names:List<String> = listOf("Tom","Jack","lucy")
    for(name in names) {
        println(name)
    }
//    Tom
//    Jack
//    lucy

    //要索引值使用withIndex()方法
    var names2:List<String> = listOf("Tom","Jack","lucy")
    for((index,name) in names.withIndex()) {
        println("$index:$name")
    }
//    0:Tom
//    1:Jack
//    2:lucy

    //indices會回傳陣列或集合的範圍
    for(index in names.indices) {
        println("$index: ${names[index]}")
    }
//    0: Tom
//    1: Jack
//    2: lucy
    for(i in 'a' .. 'z')
        println(i)



}
package learn2

fun main() {

    val arr = arrayOf(1,2)
    //通過Iterator拿到數組中每一項
    //透過Array中的iterator()拿到 Iterator<T>的接口
    //next()拿array的第一個元素
    //hasNext()是否還有下一個元素讓你拿
    println(arr.iterator().next()) //1
    println(arr.iterator().hasNext()) //true

    for (i in arr) {
        println(i)
    }
    //1
    //2

    //indices為index的複數，傳回array的索引值
    for (i in arr.indices) {
        println(i)
    }
//    0
//    1

    //同時想拿到index跟valaue
    //可以使用withIndex.返回一個對象有index跟value的屬性
    for(i in arr.withIndex()) {
        println("index:${i.index}, value:${i.value}")
    }
//    index:0, value:1
//    index:1, value:2

    arr.forEach { it ->
        println(it)
    }
    //1
    //2

    arr.forEachIndexed{
        index,i ->
        println("$index $i")
    }
//    0 1
//    1 2

    val range = 0 .. 10
    var a = 1
    //如果a 在 range中就返回true，否則返回false
    while(a in range) {
        a++
        println("$a")
    }
//    2
//    3
//    4
//    5
//    6
//    7
//    8
//    9
//    10
//    11

    //@跳出標籤
    //中斷跳出最外面的for，在外面的for前面定義名字a@
    a@ for(i in 0 .. 4) {
        for(j in 0 .. 4) {
            if(i == 2 && j == 2)
                break@a
            println("$i $j")
        }
    }
    println("結束了")
//    0 0
//    0 1
//    0 2
//    0 3
//    0 4
//    1 0
//    1 1
//    1 2
//    1 3
//    1 4
//    2 0
//    2 1
//    結束了

    //不要印出2，遇到2就continue下一個for loop，其它的都要印
    (0 .. 10).forEach b@{
        if(it == 2)
            return@b
        println(it)
    }
    //沒有印2
//    1
//    3
//    4
//    5
//    6
//    7
//    8
//    9
//    10

    //要跳出整個foreach lambda如何使用？使用run, run也是lambda ,結束run這個循環在run的循環加上標注
    run c@{
        (0 .. 10).forEach {
            if(it == 2)
                return@c
            println(it)
        }
    }
    //0
    //1
}



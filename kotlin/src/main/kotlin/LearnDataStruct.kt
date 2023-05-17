fun main() {
    //用宣告int類型的array arrayOf初始化一個array
    //arrayOf 通過<T>泛型，來決定返回的類型
    //arrayOf<Int>(1,2,3) 其中的<Int>不用寫，會自動透過1,2,3的值來推導返回類型
    //public inline fun <reified @PureReifiable T> arrayOf
    var a: Array<Int> = arrayOf(1,2,3)
    for(i in a) {
        println(i)
    }
    //可用IntArray，宣告int類型的array
    //但不能用arrayOf了，要用intArrayOf
    var a1: IntArray = intArrayOf(1,2,3)
    for(i in a1) {
        println(i)
    }

    var d1: DoubleArray = doubleArrayOf(1.0,2.0,3.0)
    for(i in d1) {
        println(i)
    }

    //定義一個空的array
    val a2 = arrayOf<Int>()

    //指定大小，但值為0的 int array
    //Creates a new array of the specified [size], with all elements initialized to zero.
//    public class IntArray(size: Int) {
    val a3:IntArray = IntArray(10)
    for(i in a3){
        println(i)
    }
//    0
//    0
//    0
//    0
//    0
//    0
//    0
//    0
//    0
//    0

    //kotlin可以透過下標拿字串中的字母
    var s = "asd"
    println(s.get(2))
    //d

    println(s[2])
    //d
    //快速鍵s.for，就會有迴圈的指令
    for (c in s) {
        println(c)
    }
//    a
//    s
//    d
    println(s.toSortedSet())//對字串排序
    //[a, d, s]

    var s1 = "871"
    println(s1.toSortedSet())//對字串排序
    //[1, 7, 8]

    var s2 = "871aka"
    println(s2.toSortedSet())
    //[1, 7, 8, a, k]
    //排序後剩下一個a，因為是set

    val b = 1
    //可直接連接數字，變成字串
    val s3 = "876"+ 1 +"aka"
    println(s3) //8761aka
    //但改用$字號連接字串
    val s4 = "876${b}aka"//要相連一起要使用花括號才不會把aka也視為變數的其中之一
    //預設會把$符號後面字母設為一個變數

    //建立空的list
    val list:List<Int> = listOf()
    println(list)
    //[]
    //List是不可變的，只能在初始的時候，把值定義好
    val list1:List<Int> = listOf(1,3,4)
    //只能get，不能add跟remove
    println(list1.get(2)) //4

    //可變的 可增刪改
    val list2:MutableList<Int> = mutableListOf(1,2,3)
    list2.add(4)
    //第0個位置變成9
    list2.add(0,9)
    println(list2) //[9, 1, 2, 3, 4]
    list2.remove(4)
    println(list2)//[9, 1, 2, 3]
    list2.clear()//全清掉
    println(list2) //[]

    //判斷list size，但建議用isEmpty
    // list.size == 0.if
    //就會變成下面
    if (list.size == 0) {

    }
    // list.isEmpty().if
    if (list.isEmpty()) {

    }
    if (list.isNotEmpty()) {

    }
    //list.for
    for (i in list) {
        println(list[i])
    }

    //map的key跟value是透過to這個關鍵字進行關聯
    //可變
    val map = mutableMapOf<String,Int>("123" to 1)
    //不可變
    val map2 = mapOf<String,Int>("456" to 2)
    //map2.get("456").sout
    println(map2.get("456")) //2
    //可直接換成括號取值，list也可這樣取
    println(map2["456"]) //2

    //可透過first second 取值，定義Pair的類型
    //public data class Pair<out A, out B>( 定義泛型，二個值傳進來
    val pair = Pair<String,Int>("123",123)
    //pair.first.sout
    println(pair.first)
    println(pair.second)

    val myPair = MyPair<String,Int>("123",123)
    //pair.first.sout
    println(myPair.first)
    println(myPair.second)
    println(myPair.toString())
//    123
//    123
//    123123

    val triple = Triple<String,Int,Float>("abc",123,22f)
    println(triple.first)
    println(triple.second)
    println(triple.third)
    println(triple)
    //abc
    //123
    //22.0
    //(abc, 123, 22.0)


}

//定義自己的元組
data class MyPair<A,B>(
    val first:A,
    val second:B
){
    override fun toString(): String {
        return "${first}${second}"
    }
}
package learn2

fun a(): Int {
    return 1
}
//省略花括號 可簡化成
fun b():Int = 1
//可再簡化，類型可推斷，省略類型
fun c() = 1


//放lambda 在參數
fun d(e:() -> Unit) {

}
fun main(){
    val a:Int = a()
    println(a)
    val data: Unit = d({})
    //若lambda是在函數參數最後一個，花括號寫後面
    //()之後有花括號就知道是函數參數的lambda表達式
    val data1: Unit = d(){}
    //可把括號省略
    val data2:Unit = d{}

    //lambda 不在參數最後
    g({

    },1)

    //參數有默認值
    val res1 = g1({

    })
    println("res1:$res1")
    //res1:2

    //泛型就可以寫在g3的後面
    val res2 = g3<Int>({

    })

    //泛型也可以透過值定值，自動推導泛型是什麼值
    val res3= g3({

    },2)

    val res4 = g4(1,2,3,4)
//    1
//    2
//    3
//    4

    //多參又遇到同樣類型int的第二個參數，要指定參數名
    val res5 = g5(1,2,3,4, b = 5)

    //vararg前面有參數預設值，vararg如何代入??
    //直接用參數名 = 代入成數組
    val res6 = g6(s= intArrayOf(1,2,3), b = 5)
}

//lambda 不在參數最後
fun g(e:() -> Unit, c:Int) {

}

//lambda 不在參數最後
fun g1(e:() -> Unit, c:Int = 2)  = c

//函數泛型 在fun後面加上<T>, c宣告泛型 但不能代預設值，因為不知什麼類型，不能代預設值
fun <T> g2(e:() -> Unit, c:T)  = c

//T可帶空 問號?寫在類型後，代表這個類型可能是空的 T? 預設代null
//因為不代預設值為null，使用g3的函數就一定要被指定值，因T?是不可以為空
fun <T> g3(e:() -> Unit, c:T?=null)  = c

//多參數使用vararg
fun g4(vararg s:Int){
    s.forEach { println(it) }
}

fun g5(vararg s:Int , b:Int){
    s.forEach { println(it) }
}

//vararg前面有參數預設值，vararg如何代入??
fun g6(c:Int = 10, vararg s:Int , b:Int){
    s.forEach { println(it) }
}
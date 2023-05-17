//Lambda可以分配給變量
//Lambda可以傳遞給函數
//Lambda是匿名 不需要名稱
//{x:Int -> x + 5}
//用花括號{}開始跟結束，使用->將參數跟主體分開，參數可以單個、多個、或沒有
//主體可以有多行，最後計算的表達式作為Lambda返回值是  例返回x + 5的結果
//->用於分隔任何參數
//如果Lambda沒有參數，可以省略->
//->後面要返回的結果
fun main() {
//sum是Lambda的類型
//            參數         返回參數類型           -> 返回的結果
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

//也可以省略Lambda的類型，可以推斷變數的類型是Lambda
    val sum2 = { x: Int, y: Int -> x + y }

//Lambda類型的形式
//(parameters參數) -> 返回的類型 return_type

//msg的類型是 (Int) -> String
    val msg = { x: Int -> "The value is $x" }

    val addSix = {x:Int -> x + 3}
    //有帶參數記得加上花括號印出${}
    println("pass 6 to addSix:${addSix(6)}")
    //pass 6 to addSix:9

    //it 單個參數的隱式名稱
    //單個參數x可以省略，使用it關鍵字取代x
    //但要把Lambda類型: (Int) -> Int寫上，才可以用it
    val addSix2: (Int) -> Int = {it + 3}
    //有帶參數記得加上花括號印出${}
    println("pass 6 to addSix2:${addSix2(6)}")
    //pass 6 to addSix2:9

    val addInts = {x: Int, y: Int -> x + y}
    val result: Int = addInts(6,9)
    println("pass 6,9 to addInts:$result")
    //pass 6,9 to addInts:15

    //有寫Lambda類型，花括號中的x , y參數就可以省略類型，可以由前面的宣告類型推斷
    val intLambda:(Int, Int) -> Int = {x,y -> x * y}
    //有帶參數記得加上花括號印出${}
    println("pass 9,10 to intLambda:${intLambda(9,10)}")
    //pass 9,10 to intLambda:90

    //反回類型為Unit，Unit代表ambda沒有返回值
    val calculation: (Int, Int) -> Unit = {x,y -> x + y}

    //有帶參數記得加上花括號印出${}
    println("pass 9,10 to calculation:${calculation(9,10)}")
    //pass 9,10 to calculation:kotlin.Unit
    //運行結果沒有返回結果

    //省略Lambda類型，若沒有參數可以省略箭頭->
    val myLambda = { println("kotlin") }
    //即使沒有參數，其Lambda類型定義為()括號,Unit代表ambda沒有返回值
    myLambda()
    //kotlin

    //使用函數一樣有Lambda同樣功能
    //    val addSix = {x:Int -> x + 3}
    //    println("pass 6 to addSix:${addSix(6)}")
    fun calculation(x: Int): Int{
        return x + 3
    }
    val useFunc:Int = calculation(6)
    println("use function:$useFunc")

    //匿名函數 沒有名字的函數
    //沒有函數名
    //保留fun關鍵字聲明
    val useAnonymousFun = fun(x: Int): Int{
        return x + 3
    }

    //有帶參數記得加上花括號印出${}
    println("use AnonymousFun:${useAnonymousFun(6)}")
    //use AnonymousFun:9

    val useLambda : (Int) -> Int = {
        it + 3 // 最後一行表達式的值作為lambda表達式返回值
        //改成it代表單個參數的lambda
    }
    //有帶參數記得加上花括號印出${}
    println("use Lambda:${useLambda(6)}")
    //use Lambda:9

    //成員引用或方法引用，使用::運算符表示, ::右側為函數名稱
    val memberReference = ::calculation
    println("memberReference ${memberReference(6)}")
    //memberReference 9

    //參數沒使用，用_代表
    val useLambda2:(Int, Int) -> Unit = { x, _ ->
        println("First:$x")
    }
    useLambda2(6,9)

}

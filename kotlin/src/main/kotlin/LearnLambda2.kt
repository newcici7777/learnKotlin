//使用Lambda作為參數，為高偕函數
//函數的返回類型是Double
fun convert(x:Double, converter:(Double) -> Double): Double{
    val result:Double = converter(x)
    println(" $x 轉換成華氏度$result")
    return result
}

//只有一個Lambda作為參數
fun convert2( converter:(Double) -> Double): Double{
    val result:Double = converter(30.0)
    println(" 30.0轉換成華氏度$result")
    return result
}

//函數的返回是Lambda
fun getconversion(str:String) : (Double) -> Double {
    if(str == "a") {
        return {it * 1.8 + 32} // 返回Lambda的結果
    } else if(str == "b") {
        return {it/1000}
    } else if (str == "c") {
        return {it/500}
    } else {
        return {it}
    }
}

//創建一個名為combine的函數，二個參數都是Lambda，回傳值也是Lambda
fun combine(lambda1:(Double) -> Double ,
            lambda2:(Double) -> Double) : (Double) -> Double
{
    //反回Lambda
    //x值為1.0
    //lambda1(1.0) => 1*1000.0 = 1000.0的結果 代入 lambda2
    //lambda2(1000.0)  => 1000.0/ 500.0 = 2.0
    //最終返回2.0
    return {x -> lambda2(lambda1(x))}
}

//typealias 將Lambda類型 宣告成替代名稱
//typealias 為任何類型提供替代名稱，不僅只是Lambda類型
typealias doubleConversion = (Double) -> Double

//創建一個名為combine的函數，二個參數都是Lambda，回傳值也是Lambda
fun combine2(lambda1:doubleConversion ,
            lambda2:doubleConversion) : doubleConversion
{
    //反回Lambda
    //x值為1.0
    //lambda1(1.0) => 1*1000.0 = 1000.0的結果 代入 lambda2
    //lambda2(1000.0)  => 1000.0/ 500.0 = 2.0
    //最終返回2.0
    return {x -> lambda2(lambda1(x))}
}
fun main(){
    //第二個參數是lambda類型，用花括號表示使用lambda，
    // lambda第一參數寫c
    convert(30.0, {c-> c *1.8 +32})
    // x 轉換成華氏度86.0

    //拖尾lambda表達式
    //將第二個參數lambda類型移出括號()，將花括號移到最後面
    //如果函數的最後一個參數是lambda
    //那麼作為相應參數傳入的lambda表達式可以放在圓括號之外
    convert(30.0){c-> c *1.8 +32}
    // x 轉換成華氏度86.0

    //因為二個參數lambda類型，只有一個c參數，可以用it代替c
    convert(30.0) { it * 1.8 + 32}
    // x 轉換成華氏度86.0

    //完全刪除括號()，針對只有一個lambda類型參數
    //函數只有一個參數，而該參數是一個lambda，使用該函數可以完全省略括號
    convert2{ it * 1.8 + 32}
    // 30.0轉換成華氏度86.0

    //將lambda傳回的結果放進temperature變數中
    val temperature = getconversion("a")(30.0)
    println("$temperature") //86.0

    //將lambda傳回的結果放進 函數的參數中
    convert(30.0 , getconversion("a"))
    convert(1000.0 , getconversion("b"))
    convert(500.0 , getconversion("c"))

    val toGrams = {x:Double -> x * 1000.0}
    val toGatties = {x:Double -> x / 500.0}
    val combineNum = combine(toGrams, toGatties)

    //把1.0作為toGrams跟toGatties的lambda 參數的x值
    val result1 = combineNum(1.0)
    println("$result1") //2.0

    //把1.0作為toGrams跟toGatties的lambda 參數的x值
    val combineNum2 = combine2(toGrams, toGatties)
    val result2 = combineNum2(1.0)
    println("$result2") //2.0
}
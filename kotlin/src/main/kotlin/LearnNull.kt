fun testNull() {
    var name: String = "Tom" //在宣告變數時就能確定它是有值的
    //null不能是非空類型字符串的值 編譯錯誤
    //name = null
    var name2:String? = "Tom"//表示此變數接受null值
    //因此這個變數的值有二種情況:值或null
    //當我們在使用這個變數時就必須額外檢查null
    //否則編譯器不會讓這個程式碼通過
    name2 = null

    var a: String = "Tom"
    println(a.length)

    val b: String? = "Tom"
    //編譯失敗
    //println(b.length)
    //對於變數B有風險，立即被編譯器發現而編譯失敗
    //我們必須檢查該變數的值是否為null,編譯器才能讓我們繼續
    if(b != null && b.isNotEmpty()) {
        //isNotEmpty可以檢查null並呼叫其成員(類別中的屬性和方法
        println(b.length)
    }
    //替代上面IF的方法
    //使用?.符號來安全呼叫成員
    println(b?.length) //如果B有值就存取它的length屬性
    //如果是null就不要做任何動作
    //如果變數B有值就存取它的length屬性

    //一旦我們使用了一個安全呼叫，在其後的呼叫鏈也必須使用安全呼叫
    //如果有一個是NULL 其後的都不執行
    //使用「安全呼叫」有個小缺點 最後的結果值還是NULL 最後還是得判
    //斷是不是NULL 離不開if 條件判斷
    //kotlin提供一個方便的貓王(Elvis)運算符號?:
    //它可以讓我們在得到null結果時指定預設值
    //這樣就能讓整個安全呼叫鏈一氣呵成
    println(b?.uppercase()?.replace("T","J")?.length ?: "is null")

    //危險的強制呼叫
    //確定有值，不打算使用安全呼叫，使用雙驚嘆號!!
    //若該變數是null會引發NPE
    var c: String? = null
    //println(c!!.length)
    //c是NULL，強制執行讀取length的屬性
    //產生 Exception in thread "main" java.lang.NullPointerException
}
fun main() {
    testNull()

    //安全轉型及預設值
    //使用as轉型時，如何轉型失敗會丟出ClassCastException
    //建議使用安全的轉型as?
    val a: Any = 123
    //數字強制轉String會產生null
    println(a as? String) //null

    //使用貓王處理null
    println(a as? String ?: "cannot convert to string")

    //相等比較
    //位址相等:二個物件指向同一個位置，使用連續三個等號 ===
    //若不相等使用!==

    //只判斷值(結構)是否相等，不管位址是否相等
    //使用equals()方法 來比較結構(值)
    //或是使用 == 等號
    //!=則判斷不相等
    val d = 1
    val e = 1L
    val f = 1.0
    println(d.toLong() == e) //true
    println(e.toDouble() == f) //true
    //對於不同的數值型別，必須轉換成相同型別才能比較

    //或者使用CompareTo方法
    //compareTo()的結果 0表示相等 -1表示小於 1表示大於
    println(d.compareTo(e)) //0
    println(d.compareTo(f)) // 0

    //kotlin的 == 和 java 的 == 行為是不同的
    //kotlin 使用 == 或 equals() 比較值
    //使用 === 比較位址

    val x = LearnNull("Tom")
    val y = LearnNull("Tom")
    val z = x //同一個物件 即相同位置
    println(x === y) //false
    println(x === z) //true
    println(x == y) //true
}

//物件的比較
//比較二個物件是否屬於同一個參考(位置)必須使用 ===
data class LearnNull(val name:String)
//data class 幫我們做了equal()方法
//比較值時才會相等
//使用其它類別又沒有equals()方法 比較值的結果等同於比較位址的結果
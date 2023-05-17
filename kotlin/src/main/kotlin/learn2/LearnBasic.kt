package learn2/*
基本數據類型 分為布林跟數值類型
布林Boolean

數值類型包含字元類型、浮點類型、整數類型
字元Char

浮點類型
Float
Double

整數類型  大小(bit數)  最小值 最大值
Byte  -128  127
Short  -32768  32767
Int  -2147483648(-2^31)  2147483647(-2^31-1)
Long  -2^63  2^63-1

kotlin未超出Int，最大值默認Int
kotlin超出Int最大值，推斷為Long類型

Unit 物件，等同java的void
Any 是kotlin中所有類別的根
Array 為陣列，取值get()，給值set*/
fun main() {
    val one = 1  //默認Int類型
    val threeBillion = 30000000000 //Long類型 超出Int最大
    val oneLong = 1L  //大寫L表示Long類型
    val oneByte:Byte = 1 //指定為Byte的類型

    //不能不同類型隨便轉換，使用toXXX()才能轉換
    /*
    toByte()
    toShort()
    toInt()
    toLong()
    toFloat()
    toDouble()
    toChar()
     */

    val a: Int = 1
    //val b: Long = a //error Type mismatch.
    val b: Long = a.toLong()

    var a11: Int = 1
    var c:Byte = 2
    a11 = c.toInt()

    //字串與數字相連，先把數字toString，才能用+加號 連起來
    val b1:String = "asd"
    println(a11.toString() + b1)

    /*
    浮點類型
    Float
    Double
    有小數點，編譯器默認為Double
    若要指定為浮點數，後面要加f或F
    */
    val pi = 3.14 //Double
    val e = 2.7182818384 //Double
    val eFloat = 2.7182818384f //Float 但精度丟失 只到2.7182817
    println(eFloat)

    //kotlin沒有自動轉型
    fun printDouble(d:Double) {
        println(d)
    }

    var i = 1
    val d = 1.1
    var f = 1.1f

    printDouble(d)
    //printDouble(i)//error Type mismatch.
    //printDouble(f)//error Type mismatch.

    //Char表示宣告單個字元
    //必須用''來表示
    var char1:Char
    char1 = 'a'
    //數值不能塞char
    //char1 = 1 //The integer literal does not conform to the expected type Char
    println("char $char1")

    //在kotlin不能把字元拿來跟數字比
    val a1 = 'a'
    //if(a1 == 97)  //Operator '==' cannot be applied to 'Char' and 'Int'
    //必須寫 if(a1.toInt() == 97)

    //字元型可透過toXXX()轉成其它類型
    var var1 = char1.toByte()
    var var2 = char1.toInt()
    var var3 = char1.toString()
    var var4 = char1.toFloat()
    println("var1 => $var1")
    println("var2 => $var2")
    println("var3 => $var3")
    println("var4 => $var4")
//    var1 => 97
//    var2 => 97
//    var3 => a
//    var4 => 97.0
    //字元類型支持大小寫轉換
    //toUpperCase()
    //toLowerCase()
}
fun main() {
    println("hello")
    val name: String = "Tom"
//    name = "jack"
    var age: Int = 18
    age = 19
    println("My name is $name, I'm $age")
    //要取用該變數的屬性或做任何的運算，只要額外使用大括號{}把它包圍即可
    println("My name have ${name.length} char")
    println("1+2=${1+2}")
    //4字串模板
    //輸出一段經過排版的文字
    val code = """ 
       val names = arrayOf("Tome","GG")
        |for(name in names)
         |println(name)
    """
    println(code)

    //不要有多餘的縮排及空行，用trimMargin()函式消除
    //trimMargin使用行的開頭，默認使用| 符號，做為每一行的開頭
    val code2 = """ 
       |val names = arrayOf("Tome","GG")
        |for(name in names)
         |println(name)
    """.trimMargin()
    println(code2)

    //也可以換成其它的符號>，做為替換行的符號
    val code3 = """ 
       >val names = arrayOf("Tome","GG")
        >for(name in names)
         >println(name)
    """.trimMargin(">")
    println(code3)
}
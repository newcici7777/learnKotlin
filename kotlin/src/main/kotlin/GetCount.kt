class GetCount {
    companion object{
        fun plus(a: Int, b: Int) : Int = a+b

        //參數的預設值，指派符號 = 指定它的預設值
        fun sum2(a: Int = 0, b:Int = 3, c:Int){
            println(a + b + c)
        }
    }
}
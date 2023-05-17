package learn2

//數據類跟普通的類差不多，但前面多了data關鍵字
//data class屬性必須要有val或var關鍵字
data class Info(val name:String,val age:Int){
    //這裡可以寫私有屬性
}
fun main(){
    val info = Info("test",1)
    println(info.toString())
}
//抽象可以分:抽像類、抽象方法、抽象屬性
//抽象不能實際被實體化
//如果屬性的值和方法的實現未知，則將該類抽象化
//使用abstract來定義一個抽象類

//residents因人數是變化的 所以寫var 用 INT類型
//private 僅對該類可見(並且可以在內部使用)
//如果不用抽象類，就要每個子類都要重覆的寫hasRoom的方法，如果還有很多子類就要寫很多重覆的代碼
abstract class Dwelling(private var residents:Int){//residents房屋可以住多少人
    abstract val buildingMeterial:String //不明確的材料用abstract，沒有初始值
    abstract val capacity:Int//房間的容量

    //居民是否有足夠房間可用
    fun hasRoom():Boolean {//因有return 所以要定義返回類型
        //居民人數 小於 房間容量 如果成立返回TRUE否則返回FALSE
        return residents < capacity
    }
}
//抽象類需通過子類實例化
//繼承抽象類, 為了讓父類別的risidents的值更加靈活，
// 子類別的建構子要新增(risidents:Int)
class SquareCabin(risidents:Int) : Dwelling(risidents){
    override val buildingMeterial: String //實作抽象屬性 IDEA自動添加override
        get() = "wood"
    override val capacity: Int//實作抽象屬性 IDEA自動添加override
        get() = 10
}

//給其它子類繼承要用OPEN
open class RoundHut(risidents:Int) : Dwelling(risidents){
    override val buildingMeterial = "straw"
    override val capacity = 6
}

class RoundTower(risidents:Int) : RoundHut(risidents){//繼承其它子類
    override val buildingMeterial = "stone"
    override val capacity = 7
}

fun main() {
    //抽象類不能直接實例化，實例化會報錯
    //val dwelling = Dwelling

    val squareCabin = SquareCabin(8)
    val roundHut = RoundHut(8)
    val roundTower = RoundTower(8)
    println("\n Square Cabin \n")
    println("building meterial:${squareCabin.buildingMeterial}")
    println(" Square Cabin :${squareCabin.capacity}")
    println(" has room? :${squareCabin.hasRoom()}")

    //with 對該實例對象執行以下所有操作
    with(roundHut) {
        println("\n Square Cabin \n")
        println("building meterial:${buildingMeterial}")
        println(" Square Cabin :${capacity}")
        println(" has room? :${hasRoom()}")
    }

    with(roundTower) {
        println("\n Square Cabin \n")
        println("building meterial:${buildingMeterial}")
        println(" Square Cabin :${capacity}")
        println(" has room? :${hasRoom()}")
    }
}
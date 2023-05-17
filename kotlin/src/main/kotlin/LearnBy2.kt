//接口或抽象類
interface GamePlayer{
    fun rank() //排名
    fun upgrade() //升級
}

//代練的實作類
class PowerLeveling(val name:String) : GamePlayer{
    override fun rank() {
        println("$name 開始排名")
    }

    override fun upgrade() {
        println("$name 升級了")
    }
}

class DelegatePlayer(val player:GamePlayer):GamePlayer by player

fun main(){
    val powerLeveling = PowerLeveling("cici")
    DelegatePlayer(powerLeveling).rank()//代練者CICI 幫忙衝排名
    DelegatePlayer(powerLeveling).upgrade()//代練者CICI 幫忙升級
}
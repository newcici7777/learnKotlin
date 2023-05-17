open class Toy(
    private val brand: String = "null",
    private val engine:String = "BMW"
){
    open fun start(){
        println("car brand:$brand Engine:$engine ")
    }
}

class Toy1(brand: String, engine: String) : Toy(brand, engine) ,ABS{
    override fun start(){ // 父類別的 start必須加上open才可以覆蓋
        super<Toy>.start() //有許多父類都有start()，要用<>指名是那個父類的start()
        super<ABS>.start()
        println("xxxx")
    }
}

interface ABS{
    fun start(){
        println("ABS all ready")
    }
}
fun main(){
    val toy1 = Toy1("lego","bmw")
    toy1.start()

}
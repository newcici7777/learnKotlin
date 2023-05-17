//接口或抽象類
interface Base{
    fun print()
}
//接口實現類(Impl implement實現)
class BaseImpl(val x:Int) : Base{
    override fun print() {
        print(x)
    }
}

//如果不用BY，則還需要實現接口裡面的方法
//使用BY後 不用實現接口，而是委托給實現接口類的對象來實現接口，從而減少代碼的重覆
class Derived(val b:Base):Base by b

fun main() {
    val b = BaseImpl(10)
    //委托B的print來處理
    Derived(b).print()
}
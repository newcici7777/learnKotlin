//宣告一個名為Car的類別
//class Car

//建構式：就是建立物件的函式
//通過呼叫類別的建構式來產生一個物件
//任何類別都至少有一個建構式，即使我們沒有宣告任何建構式
//都會默認自動產生一個空的建構式

//kotlin的建構式分成主要建構式(primary constructor)
//和次要建構式(secondary constructors)
//主要建構式只能有一個,次要建構式則可以有多個

//主要建構式是類別宣告的一部分
//在類別名稱之後，以關鍵字constructor來宣告
//沒有任何注釋或存取修飾字則可以省略
//class Car constructor(){
//}
//省略之後變成以下
class Car(brand: String) {
    val engine = "BMW"
    //主要建構式不能包含任何程式碼
    //如果需要，使用init關鍵字來建立初始化區塊

    //主要建構式的參數會最先建立
    //然後才依序建立屬性及初始化區塊
    //因此我們可以在屬性中使用主要建構式的參數
    val id = brand;

    //主要建構式的參數不是屬性
    //因此離開了初始化階段就無法存取
    //須在初始化階段將其指派給屬性
    val carBrand = brand
    fun showBrand() = println("$carBrand")
    init {
        //初始化區塊屬於主要建構式的一部分
        //因此可以使用主要建構式中的參數
        println("Brand: $brand")

        println("Engine: $engine")
        //如果初始化區塊中要使用類別的屬性
        //必須將該屬性放在初始化區塊之前
        //否則會出現屬性未初始化的錯誤警告
    }
}

//kotlin 允許主建構式的參數直接宣告為屬性
//使用val或var 來宣告主建構式的參數即可
class Cat(val name: String) {
    fun showName() = println("$name")
}

//改變參數預設值就能做到建構式多載的行為????
class Car2(val brand: String = "",
           val engine: String = "",
           val color: String = "") {
    fun showBrand() = println("$brand,$engine,$color")
}

class Car3(
    //屬性可以設置存取修飾子private
    //默認為public
    private val brand: String = "",
           val engine: String = "",
           val color: String = "") {
    fun showBrand() = println("$brand,$engine,$color")
}

//如果主要建構式前面有注釋或存取修飾字
//必須把constructor寫出來
class Car4 public constructor(
    //屬性可以設置存取修飾子private
    //默認為public
    private val brand: String = "",
    val engine: String = "",
    val color: String = "") {
    fun showBrand() = println("$brand,$engine,$color")
}

//如果不想使用主要建構式
//可以在類別裡使用constructor關鍵字宣告次要建構式
//主建構式、次建構式們之間參數不能一樣
//要委派其他建構式使用this關鍵字
class Car5(brand: String) {
    init{
        //初始化區塊是屬於主要建構式的一部分
        //初始化區塊的內容會比主要建構式先執行
        println("Init: $brand")
    }

    //次要建構式
    //次履建構式會直接或間接委派主建構式
    //只能在主要建構式中使用val或var
    constructor(brand: String, engine: String) : this(brand) {//委派主建構式
        println("second:$brand,$engine")
    }
    constructor(brand: String, engine: String, color: String) : this(brand, engine) {//委派上面的建構式
        println("second:$brand,$engine,$color")
    }
}

//如果不想讓類別實體化，可以將建構式宣告為私有(private)
class Car6 private constructor() {
}

//建構式預設默認一個不帶參數的公開的(public)建構式
//這樣才能被實體化
class Car7{
    fun showColor() = println("RED")
}
fun main() {
    //有了建構式就能用來建立類別實體也就是物件
    val car = Car("BMW")
    val car2 = Car2("LYNK", "BMW")
    val car3 = Car2("LYNK", "BMW","RED")

    //透過.存取屬性
    car3.showBrand()

    val car7 = Car7()
    car7.showColor()
}
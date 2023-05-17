interface USB {
    //抽象函數，沒有方法體
    //抽象都是默認公開的public
    //    告訴後面記得 實現它
    fun enable()//    方法後面沒有 方法體 是抽象的
    fun close()
    //抽象屬性 默認屬性
    val derivedName: String
//    需使用get()的方法
    get() = "USB"

//    除了有默認屬性 也有默認函數
//    這裏隨便添加一個默認方法（不是抽象的）
    //默認函數，因為它有函數體
//    新添加的默認方法 在下面的實現類並不用 重寫
//    通過默認方法default method 解決 接口"升級"的問題 ??
//    JAVA 默認方法 使用 public default
    fun printDeriveName() {
        println(derivedName) //    打印這個USB名字
    }
}

//    寫一個滑鼠的類來實現接口
//    需要重寫接口類的抽象函數和屬性
//
class Mouse: USB{
    //    默認屬性可以不用重寫
    //    當然我們也可以重寫這個屬性
    override val derivedName: String
        get() = "mouse"
    override fun enable() {
        println("Mouse inserted")
    }

    override fun close() {
        println("unplugged the mouse")
    }

    //    下面的實現類可以選擇升級
//    實現類 添加這個升級的方法
    override fun printDeriveName() {
        println(derivedName)
    }
}
//    再添加一個鍵盤的實現類（創建了一個鍵盤）
class KeyBoard: USB{
    override fun enable() {
        println("KeyBoard inserted")
    }

    override fun close() {
        println("unplugged the KeyBoard")
    }

    override val derivedName: String
        get() = "KeyBoard"
}
class Computer{
    fun bootUp() { //開機
        println("Computer boot up")
    }
    fun shutDown() {//關機
        println("Computer shut down")
    }
    //    參數 寫上 :使用USB接口
    fun useEquipment(usb:USB){
        usb.enable() //usb開啟
        usb.close() //usb 關閉
    }
}

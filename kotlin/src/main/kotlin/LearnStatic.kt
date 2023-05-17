//Java interface static method
//Java 的靜態方法 在 interface
//靜態方法屬於類 通過類名 . 來調用
//java8 支持static 靜態方法
//public interface MyInterfaceStatic{
//    javad的public staic 修飾符 必須寫
//    public static void methodStatic(){
//          System.out.println("接口靜態方法")
//    }
//}


//    kotlin 沒有static
//    使用 伴侶（伴生）對象 替換java的static方法
interface MyInterfaceStatic {
    companion object{
        fun staticMethod(){
            methodCommon()
        }
        fun staticMethod2(){
            methodCommon()
        }
        // 伴侶對象裏面 沒有抽象方法
        //    硬是寫的話會報錯,以下 都報錯
        //fun method()
        //abstract fun method() 抽象函數需在抽像類裡

        //    寫一個共同方法 methodCommon
        //    但是這個共同方法會 暴露出來
        //    只需加上private 修飾 即可
    //    private定義了 本類/文件才能使用
        private fun methodCommon(){
            println("接口靜態方法")
        }
    }
}
//靜態方法屬於類 通過類名 . 來調用
//接口和抽像類一樣不能直接使用，需用實現類(子類)來實現
class MyInterfaceStaticImplementation: MyInterfaceStatic{
    //    因沒有抽象方法 不用實現
}

//函數式接口
//只有一個抽像方法
//用fun修飾符聲明一個函數式接口
fun interface KRunnable{
    fun invoke()//只有一個抽像方法
    //可以有多個默認方法 非抽象方法
}
fun main() {
    //    通過接口名稱 直接調用伴侶對象 的靜態方法
    MyInterfaceStatic.staticMethod()
    MyInterfaceStatic.staticMethod2()
//    接口靜態方法
//接口靜態方法
}


//    10:20
//    列表裏面是找不到的
//    10:25
//    硬寫的話報錯
//    10:32
//    所以這樣實例的話也是多餘的
//    10:35
//    注釋/刪除
//    10:58
//    CTRL+D 複製
//    11:10
//    這裏存在重複代碼
//    11:15

//    11:20
//    複製
//    11:24
//    但是這個共同方法會 暴露出來
//    11:33
//    使用接口類名
//    11:36
//    直接 點 可以看到有3個方法
//    11:40
//    我們並不希望它被看到
//    11:48
//    只需加上private 修飾 即可
//    11:55
//    private定義了 本類/文件才能使用
//    12:02
//    這回共用方法不見了
//    12:20
//    或者全部替換
//    12:23
//    這樣就更少重複代碼了
//    12:36
//    用fun修飾符聲明一個函數式接口
//    12:51
//    SAM轉換 在學習lambda后再講解

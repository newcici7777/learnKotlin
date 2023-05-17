fun main() {
    val names = arrayOf("Tom","Kevin","Lucy")
    //${數組變量名[索引]}
    println("First elements:${names[0]}") //First elements:Tom
    println("First elements:${names[1]}") //First elements:Kevin
    println("First elements:${names[2]}") //First elements:Lucy
    //println("First elements:${names[5]}") //Index 5 out of bounds for length 3

    //使用Last表示最後一個元素位置
    println("last of elements:${names.last()}") //last of elements:Lucy
    println("names elements:${names.size}") //names elements:3

    //names = arrayOf("") // val cannot be reassigned

    names[0] = "Julien"
    println("First elements:${names[0]}")//原來的tom改成julien  //First elements:Julien
    println("First elements:${names[0][1]}")//印出Julien第二個字母u //First elements:u
    println("Length of Julien:${names[0].length}")//印出長度 //Length of Julien:6

    var number = arrayOf(1,2,3,'Y')
    number[0] = 'A' // char 類型
    println("First elements:${number[0]}")//First elements:A

    number[0] = "TEST" // String 類型
    println("First elements:${number[0]}")//First elements:TEST

    var number2 = arrayOf(arrayOf(1,2,3),arrayOf(4,5,6),arrayOf(7,8,9))
    println("Number:${number2[2][1]}") //Number:8
}
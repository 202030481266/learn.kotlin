package basic_type.string

fun main() {
    val s = "Hello World"

    println("循环遍历 $s")
    for (c in s) {
        print("$c ")
    }
    println()

    println("字符串是不可变的：")
    println("s.uppercase() = " + s.uppercase())
    println("s.lowercase() = " + s.lowercase())
    println("s still is $s")

    val x = "abc"
    val y = "def"
    println("x + y = ${x + y}")
}
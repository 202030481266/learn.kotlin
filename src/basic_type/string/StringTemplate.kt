package basic_type.string

fun main() {
    val i = 10
    println("i = $i")

    val letters = listOf("a", "b", "c", "d", "e", "f")
    println("Letters: $letters")

    val s = "definable"
    println("$s.length is ${s.length}")

    val integerNumber = String.format("%07d", 31416)
    println(integerNumber)

    val floatNumber = String.format("%.4f", 3.1415926)
    println(floatNumber)

    val helloWorld = String.format("%S %S", "hello", "world")
    println(helloWorld)

    val negativeNumber = String.format("%(d means %1\$d", -31416)
    println(negativeNumber)
}
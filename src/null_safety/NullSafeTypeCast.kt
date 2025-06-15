package null_safety

fun main() {
    val a : Any = "hello world"
    val aInt : Int? = a as? Int  // null
    val aString : String? = a as? String
    println(aInt)
    println(aString)
}
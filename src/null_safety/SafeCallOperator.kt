package null_safety

fun main() {
    val a : String? = "abc"
    val b : String? = null
    println(a?.length)
    println(b?.length)
}
package null_safety

fun main() {
    val b : String? = "abc"
    val l : Int = b?.length ?: 0
    println(l)
}
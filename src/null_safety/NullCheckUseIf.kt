package null_safety

fun main() {
    val b : String? = null
    val l = if (b != null) b.length else 0
    println(l)

    val a : String? = "Kotlin"
    if (a != null && a.length > 0) {
        println("String length of $a is ${a.length}")
    } else {
        println("Empty String")
    }
}
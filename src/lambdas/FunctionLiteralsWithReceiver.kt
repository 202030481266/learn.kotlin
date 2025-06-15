package lambdas

// 非常有用的特性

fun main() {
    val sum = fun Int.(other: Int): Int = this + other
    val a = 2
    println(a.sum(3))
}
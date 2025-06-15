package lambdas

// 相比lambda具有更好的返回值控制能力

fun main() {
    val sum = fun(x: Int, y: Int) = x + y
    println(sum(1, 2))
}
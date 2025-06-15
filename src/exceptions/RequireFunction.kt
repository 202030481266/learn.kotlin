package exceptions

fun getIndices(count: Int): List<Int> {
    require(count > 0)
    return List(count) { it + 1 }
}

fun main() {
    println(getIndices(0))
}
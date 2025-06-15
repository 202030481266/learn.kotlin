package null_safety

fun main() {
    val b : String? = "abc"
    val l : Int = b!!.length // b = null的时候会抛出NPE异常, !!会强制转换为非空值
    println(l)
}
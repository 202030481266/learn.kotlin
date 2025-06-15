package null_safety

fun main() {
    val a = "abc"
    // a = null 会报错，因为String的常规变量是不能为空的，因此a的方法可以直接调用
    val l = a.length
    println(l)

    var b : String? = "abc"
    // println(b.length) 会导致报错，因为b是允许空的，所以必须要进行安全检查才能访问
    b = null
    println(b)
}
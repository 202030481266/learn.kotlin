package lambdas


fun main() {
    val sum = { x: Int, y: Int -> x + y } // lambda function
    println(sum(1, 2))

    var counter = 0
    val increment = { // closure, lambda function with context, capture references
        counter++
        println("Counter: $counter")
    }
    increment()
    increment()

    val funcs = mutableListOf<() -> Unit>()
    for (i in 1..3) {
        funcs.add { println(i) }
    }
    funcs.forEach { it() } // 当只有一个值的时候，会有一个默认的it参数
}
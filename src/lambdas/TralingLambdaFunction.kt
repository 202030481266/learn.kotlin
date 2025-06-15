package lambdas

// kotlin风格特性之一，当lambda参数是最后一个参数的时候可以这样写提高可读性

fun doSomething(name: String, action: () -> Unit) {
    println("Hello, $name!")
    action()
}

fun runTask(task: () -> Unit) {
    println("Start Task!")
    task()
    println("End Task!")
}

fun main() {
    doSomething("John", { println("This is an action") }) // normal style
    doSomething("John") { println("This is an action") } // trailing style
    runTask() { println("processing task...") }
    runTask { println("processing task...") } // 更加简单的形式

    val strings = listOf("apple", "banana", "grape", "mango", "pear", "melon")
    val sortStrings = strings.filter { it.length == 5 } .sortedBy { it } .map { it.lowercase() }
    println(sortStrings)
}
package exceptions

fun printNonNullString(str: String?) {
    check(str != null)
    println(str.length)
}

fun main() {
    printNonNullString("<UNK>")
}
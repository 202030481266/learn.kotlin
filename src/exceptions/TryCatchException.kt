package exceptions

fun main() {
    val num: Int = try {
        count()
    } catch (e: ArithmeticException) {
        -1
    }
    println(num)
    divideOrNull(0)
}

fun count(): Int {
    val a = 1
    return 1 / a
}

fun divideOrNull(a: Int): Int {

    // The try block is always executed
    // An exception here (division by zero) causes an immediate jump to the catch block
    try {
        val b = 44 / a
        println("try block: Executing division: $b")
        return b
    }

    // The catch block is executed due to the ArithmeticException (division by zero if a ==0)
    catch (e: ArithmeticException) {
        println("catch block: Encountered ArithmeticException $e")
        return -1
    }
    finally {
        println("finally block: The finally block is always executed")
    }
}
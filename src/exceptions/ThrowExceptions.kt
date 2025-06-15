package exceptions

fun throwException() {
    throw IllegalArgumentException()
}

fun throwExceptionWithCause() {
    val cause = IllegalArgumentException("Original Cause : illegal state")
    throw cause
}

fun main() {
    throwExceptionWithCause()
}
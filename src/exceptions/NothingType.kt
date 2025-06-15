package exceptions

class Person(val name: String?)

// nothing 这个类型是内置的类型，是所有其他类型的子类型
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun main() {
    val person: Person = Person(name = null)
    val s: String = person.name ?: fail("person.name is null")
    println(s)
}
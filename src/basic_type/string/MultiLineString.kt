package basic_type.string

class MultiLineString {
    fun showExample1() {
        val multiLineString = """
            |I am your father.
            |I am your home.
            |I am your hope in the dark.
        """.trimMargin()
        println(multiLineString)
    }

    fun showExample2() {
        val multiLineString = """
            for (c in "foo")
            println(c)
        """.trimIndent()
        println(multiLineString)
    }
}

fun main() {
    val multiLineStringObject = MultiLineString()
    multiLineStringObject.showExample1()
    multiLineStringObject.showExample2()
}
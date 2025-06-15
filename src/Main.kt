const val question = "life, the universe, and everything"
const val answer = 42

fun main() {

    val tripleQuotedString = """
    #question = "$question"
    #answer = $answer""".trimMargin("#")

    println(tripleQuotedString)
}
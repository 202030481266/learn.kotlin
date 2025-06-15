package null_safety

fun main() {
    val listWithNulls : List<String?> = listOf("Kotlin", null)
    for (item in listWithNulls) {
        item?.let { println(it) }
    }
}
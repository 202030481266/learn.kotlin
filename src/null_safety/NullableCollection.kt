package null_safety

fun main() {
    val nullableList: List<String?> = listOf("Kotlin", null, "java", "cpp", null)
    val stringList: List<String> = nullableList.filterNotNull()
    println(stringList)
}
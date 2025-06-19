package cp_algorithm.leetcode

class Solution3581 {
    fun countOddLetters(nn: Int): Int {
        var n = nn
        val mp = mapOf(
            0 to "zero",
            1 to "one",
            2 to "two",
            3 to "three",
            4 to "four",
            5 to "five",
            6 to "six",
            7 to "seven",
            8 to "eight",
            9 to "nine"
        )
        val array : Array<Int> = Array(26) { 0 }
        while (n > 0) {
            val x = n % 10
            n /= 10
            for (c in mp.getValue(x)) {
                array[c - 'a']++
            }
        }
        var ans = 0
        for (i in 0 until array.size) {
            if (array[i] % 2 == 1) {
                ans++
            }
        }
        return ans
    }
}

fun main() {
    val solution = Solution3581()
    println(solution.countOddLetters(41))
    println(solution.countOddLetters(20))
}


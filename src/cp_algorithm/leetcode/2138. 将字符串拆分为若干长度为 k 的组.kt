package cp_algorithm.leetcode

class Solution {
    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        var i = 0
        var cnt = 0
        val n = s.length
        val m = (n + k - 1) / k
        val ans = Array(m) { "" }
        while (cnt < m) {
            val cur = if (i + k - 1 < n) {
                s.substring(i, i + k)
            } else {
                s.substring(i, n) + fill.toString().repeat(k - n + i)
            }
            ans[cnt] = cur
            i = i + k
            ++cnt
        }
        return ans
    }
}

fun main() {
    val solution = Solution()
    val ans1 = solution.divideString("abcdefghi", 3, 'x')
    val ans2 = solution.divideString("abcdefghij", 3, 'x')
    for (s in ans1) {
        println(s)
    }
    for (s in ans2) {
        println(s)
    }
}


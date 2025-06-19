package cp_algorithm.leetcode

class Solution3571 {
    fun shortestSuperstring(s1: String, s2: String): String {
        // check s1 suffix and s2 prefix
        val n = s1.length
        val m = s2.length
        var ans = s1 + s2
        for (i in 0 until n) {
            var x = i
            var j = 0
            while (x < n && j < m && s1[x] == s2[j]) {
                ++x
                ++j
            }
            if (j == m) {
                ans = s1
                break
            }
            else if (x == n) {
                if (m + i < ans.length) {
                    ans = s1.substring(0, i) + s2
                }
                break
            }
        }
        for (i in 0 until m) {
            var x = i
            var j = 0
            while (x < m && j < n && s2[x] == s1[j]) {
                ++x
                ++j
            }
            if (j == n) {
                if (ans.length > m) {
                    ans = s2
                }
                break
            }
            else if (x == m) {
                if (n + i < ans.length) {
                    ans = s2.substring(0, i) + s1
                }
                break
            }
        }
        return ans
    }
}

fun main() {
    val solution = Solution3571()
    println(solution.shortestSuperstring("aba", "bab"))
    println(solution.shortestSuperstring("aa", "aaa"))
    println(solution.shortestSuperstring("m", "azmvzfh"))
}
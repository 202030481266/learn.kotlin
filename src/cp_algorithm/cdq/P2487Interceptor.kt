package cp_algorithm.cdq

import java.io.IOException
import java.io.InputStream
import java.io.OutputStreamWriter
import java.io.PrintWriter

class P2487Interceptor {
    companion object {
        private const val MAXN = 50001
        private var n = 0
        private var s = 0
        private val h = IntArray(MAXN)
        private val v = IntArray(MAXN)
        private val sortv = IntArray(MAXN)
        private val arr = Array(MAXN) { IntArray(3) }
        private val treeCnt = DoubleArray(MAXN)
        private val treeVal = IntArray(MAXN)
        private val dp1 = IntArray(MAXN)
        private val dp2 = IntArray(MAXN)
        private val cnt1 = DoubleArray(MAXN)
        private val cnt2 = DoubleArray(MAXN)
        private var queryVal = 0
        private var queryNum = 0.0

        private fun lowbit(i: Int): Int = i and -i

        private fun lower(value: Int): Int {
            var l = 0
            var r = s + 1
            while (l + 1 < r) {
                val mid = l + (r - l) / 2
                if (sortv[mid] >= value) r = mid
                else l = mid
            }
            return r
        }

        private fun update(pos: Int, value: Int, num: Double) {
            var i = pos
            while (i <= s) {
                when {
                    value > treeVal[i] -> {
                        treeVal[i] = value
                        treeCnt[i] = num
                    }
                    value == treeVal[i] -> treeCnt[i] += num
                }
                i += lowbit(i)
            }
        }

        private fun query(pos: Int) {
            var i = pos
            queryNum = 0.0
            queryVal = 0
            while (i > 0) {
                when {
                    treeVal[i] > queryVal -> {
                        queryVal = treeVal[i]
                        queryNum = treeCnt[i]
                    }
                    treeVal[i] == queryVal -> queryNum += treeCnt[i]
                }
                i -= lowbit(i)
            }
        }

        private fun clear(pos: Int) {
            var i = pos
            while (i <= s) {
                treeVal[i] = 0
                treeCnt[i] = 0.0
                i += lowbit(i)
            }
        }

        private fun cdq1(l: Int, r: Int) {
            if (l == r) return
            val mid = l + (r - l) / 2
            cdq1(l, mid)
            for (i in l..r) {
                arr[i][0] = i
                arr[i][1] = h[i]
                arr[i][2] = v[i]
            }
            arr.sortWith(compareByDescending { it[1] }, l, mid + 1)
            arr.sortWith(compareByDescending { it[1] }, mid + 1, r + 1)
            var p1 = l - 1
            for (p2 in mid + 1..r) {
                while (p1 + 1 <= mid && arr[p1 + 1][1] >= arr[p2][1]) {
                    p1++
                    update(s - arr[p1][2] + 1, dp1[arr[p1][0]], cnt1[arr[p1][0]])
                }
                query(s - arr[p2][2] + 1)
                when {
                    queryVal + 1 > dp1[arr[p2][0]] -> {
                        dp1[arr[p2][0]] = queryVal + 1
                        cnt1[arr[p2][0]] = queryNum
                    }
                    queryVal + 1 == dp1[arr[p2][0]] -> cnt1[arr[p2][0]] += queryNum
                }
            }
            for (i in l..p1) {
                clear(s - arr[i][2] + 1)
            }
            cdq1(mid + 1, r)
        }

        private fun cdq2(l: Int, r: Int) {
            if (l == r) return
            val mid = l + (r - l) / 2
            cdq2(l, mid)
            for (i in l..r) {
                arr[i][0] = i
                arr[i][1] = h[i]
                arr[i][2] = v[i]
            }
            arr.sortWith(compareBy { it[1] }, l, mid + 1)
            arr.sortWith(compareBy { it[1] }, mid + 1, r + 1)
            var p1 = l - 1
            for (p2 in mid + 1..r) {
                while (p1 + 1 <= mid && arr[p1 + 1][1] <= arr[p2][1]) {
                    p1++
                    update(arr[p1][2], dp2[arr[p1][0]], cnt2[arr[p1][0]])
                }
                query(arr[p2][2])
                when {
                    queryVal + 1 > dp2[arr[p2][0]] -> {
                        dp2[arr[p2][0]] = queryVal + 1
                        cnt2[arr[p2][0]] = queryNum
                    }
                    queryVal + 1 == dp2[arr[p2][0]] -> cnt2[arr[p2][0]] += queryNum
                }
            }
            for (i in l..p1) {
                clear(arr[i][2])
            }
            cdq2(mid + 1, r)
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val reader = FastReader(System.`in`)
            val pw = PrintWriter(OutputStreamWriter(System.out))
            n = reader.nextInt()
            for (i in 1..n) {
                h[i] = reader.nextInt()
                v[i] = reader.nextInt()
            }
            if (n >= 0) {
                System.arraycopy(v, 1, sortv, 1, n)
            }
            sortv.sort(1, n + 1)
            s = 1
            for (i in 2..n) {
                if (sortv[s] != sortv[i]) {
                    sortv[++s] = sortv[i]
                }
            }
            for (i in 1..n) {
                v[i] = lower(v[i])
            }
            for (i in 1..n) {
                dp1[i] = 1
                cnt1[i] = 1.0
                dp2[i] = 1
                cnt2[i] = 1.0
            }
            cdq1(1, n)
            for (i in 1..n/2) {
                val j = n - i + 1
                h[i] = h[j].also { h[j] = h[i] }
                v[i] = v[j].also { v[j] = v[i] }
            }
            cdq2(1, n)
            for (i in 1..n/2) {
                val j = n - i + 1
                dp2[i] = dp2[j].also { dp2[j] = dp2[i] }
                cnt2[i] = cnt2[j].also { cnt2[j] = cnt2[i] }
            }
            var maxLength = 0
            var total = 0.0
            for (i in 1..n) {
                when {
                    dp1[i] > maxLength -> {
                        maxLength = dp1[i]
                        total = cnt1[i]
                    }
                    dp1[i] == maxLength -> total += cnt1[i]
                }
            }
            pw.println(maxLength)
            for (i in 1..n) {
                if (dp1[i] + dp2[i] - 1 < maxLength) {
                    pw.print("0 ")
                } else {
                    if (total == 0.0) {
                        pw.print("0 ")
                    } else {
                        pw.printf("%.5f ", (cnt1[i] * cnt2[i]) / total)
                    }
                }
            }
            pw.println()
            pw.flush()
        }
    }
}

class FastReader(private val inputStream: InputStream) {
    private val buffer = ByteArray(1 shl 20)
    private var pos = 0
    private var len = 0

    @Throws(IOException::class)
    private fun readByte(): Int {
        if (pos >= len) {
            len = inputStream.read(buffer)
            pos = 0
            if (len <= 0) return -1
        }
        return buffer[pos++].toInt() and 0xFF
    }

    @Throws(IOException::class)
    fun nextInt(): Int {
        var c: Int
        do {
            c = readByte()
        } while (c <= ' '.code && c != -1)

        val isNegative = c == '-'.code
        if (isNegative) {
            c = readByte()
        }

        var value = 0
        while (c > ' '.code) {
            value = 10 * value + (c - '0'.code)
            c = readByte()
        }

        return if (isNegative) -value else value
    }
}

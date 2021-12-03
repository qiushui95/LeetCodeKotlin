package problem438

import assertEquals


fun main() {
    assertEquals(Solution().findAnagrams("cbaebabacd", "abc"), listOf(0, 6))
    assertEquals(Solution().findAnagrams("abab", "ab"), listOf(0, 1, 2))
}

/**
 * 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val sLength = s.length
        val pLength = p.length

        val list = mutableListOf<Int>()

        if (pLength > sLength || sLength == 0 || pLength == 0) return list

        val sInput = IntArray(26)
        val pInput = IntArray(26)

        for (i in 0 until pLength) {
            sInput[s[i] - 'a']++
            pInput[p[i] - 'a']++
        }

        if (sInput.contentEquals(pInput)) {
            list.add(0)
        }

        for (i in pLength until sLength) {
            sInput[s[i - pLength] - 'a']--
            sInput[s[i] - 'a']++

            if (sInput.contentEquals(pInput)) {
                list.add(i-pLength+1)
            }
        }

        return list
    }
}
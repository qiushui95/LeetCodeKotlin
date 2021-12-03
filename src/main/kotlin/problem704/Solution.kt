package problem704

import assertEquals

fun main() {
    val solution = Solution()

    assertEquals(solution.search(intArrayOf(-1, 0, 3, 5, 9, 12), 9), 4)
    assertEquals(solution.search(intArrayOf(-1, 0, 3, 5, 9, 12), 2), -1)
    assertEquals(solution.search(intArrayOf(-1, 0, 3, 5, 9, 12), 13), -1)
}

/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * 链接：https://leetcode-cn.com/problems/binary-search
 */
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1

        var left = 0
        var right = nums.size-1

        while (left <= right) {
            val mid = (left + right) / 2

            val midNum = nums[mid]

            if (midNum == target) return mid
            else if (midNum < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return -1
    }
}
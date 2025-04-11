package src.dsa

fun main() {
    findSecondLargestNumber()
}

fun findSecondLargestNumber() {
    val nums = listOf(5, 1, 8, 3, 8, 2)
    val secondLargest = findSecondLargest(nums)

    if (secondLargest != null) {
        println("Angka terbesar kedua adalah: $secondLargest")
    } else {
        println("Data tidak cukup untuk mencari angka terbesar kedua")
    }
}

fun findSecondLargest(nums: List<Int>): Int? {
    val unique = nums.distinct()
    val sorted = unique.sortedDescending()
    return if (sorted.size >= 2) sorted[1] else null
}
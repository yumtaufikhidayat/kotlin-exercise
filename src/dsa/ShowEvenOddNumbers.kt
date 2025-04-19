package src.dsa

fun main() {
    showEvenOrOddNumber()
    showGroupedEvenOddNumber()
}

fun showEvenOrOddNumber() {
    val nums = listOf(2, 5, 7, 8, 10, 13, -1, -3, 2, -13, 9, 9)
    println("Count of even number = ${countEvenNumbers(nums)}")
    println("Count of odd number = ${countOddNumbers(nums)}")
}

fun countEvenNumbers(nums: List<Int>): Int = nums.count { it % 2 == 0 }
fun countOddNumbers(nums: List<Int>): Int = nums.count { it % 2 != 0 }

fun showGroupedEvenOddNumber() {
    val nums = listOf(2, 5, 7, 8, 10, 13)
    val grouped = nums.groupEvenOdd()
    grouped.forEach { (key, values) ->
        println("$key: $values")
    }
}

fun List<Int>.groupEvenOdd(): Map<String, List<Int>> = this.groupBy { if (it % 2 == 0) "Even" else "Odd" }
package src.dsa

fun main() {
    removeDuplicatedNumber()
}

fun removeDuplicatedNumber() {
    val nums = listOf(3, 5, 3, 2, 5, 8, 2, 1)
    println("List unik: ${nums.removeDuplicate().joinToString(", ")}")
}

fun List<Int>.removeDuplicate() = this.distinct().sortedDescending()
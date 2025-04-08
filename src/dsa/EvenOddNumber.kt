package src.dsa

fun main() {
    countEvenOddNumber()
    partitionNext()
    getNumberMoreThanFive()
    getNumberMoreThanFiveNext()
}

fun countEvenOddNumber() {
    val listOfNumber = listOf(2, 4, 7, 5, 8, 9, 10)
    val (genap, ganjil) = listOfNumber.partition { it % 2 == 0 }
    println("List angka genap: ${genap.joinToString(", ")} (total: ${genap.sum()})")
    println("List angka ganjil: ${ganjil.joinToString(", ")} (total: ${ganjil.sum()})")
}

fun partitionNext() {
    val listOfNumber = listOf(10, -5, 8, -2, 3, -7, 0)
    val (positive, negative) = listOfNumber.partition { it >= 0 }

    val averagePositive = "%.2f".format(positive.average())
    val averageNegative = "%.2f".format(negative.average())

    println("Angka positif: ${positive.joinToString(", ")}")
    println("Total: ${positive.sum()}")
    println("Rata-rata: $averagePositive")
    println()

    println("Angka negatif: ${negative.joinToString(", ")}")
    println("Total: ${negative.sum()}")
    println("Rata-rata: $averageNegative")
}

fun getNumberMoreThanFive() {
    val listOfNumber = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val filter = listOfNumber.filter { it > 5 }
    val (even, odd) = filter.partition { it % 2 == 0 }
    val avgEven = "%.2f".format(even.average())
    val evenCount = even.count()
    val totalEven = even.sum()
    val avgOdd = "%.2f".format(odd.average())
    val oddCount = odd.count()
    val totalOdd = odd.sum()

    println("Angka Genap (>5): ${even.joinToString(", ")}")
    println("Jumlah: $evenCount")
    println("Total: $totalEven")
    println("Rata-rata: $avgEven")
    println()

    println("Angka Ganjil (>5): ${odd.joinToString(", ")}")
    println("Jumlah: $oddCount")
    println("Total: $totalOdd")
    println("Rata-rata: $avgOdd")
}

fun getNumberMoreThanFiveNext() {
    val listOfNumber = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val filter = listOfNumber.filter { it > 5 }
    val sortedDesc = filter.sortedDescending()

    val (even, odd) = sortedDesc.partition { it % 2 == 0 }

    val avgEven = even.average()
    val avgEvenStr = "%.2f".format(even.average())
    val evenCount = even.count()
    val totalEven = even.sum()
    val topTwoEvenNumber = even.take(2)

    val avgOdd = odd.average()
    val avgOddStr = "%.2f".format(odd.average())
    val oddCount = odd.count()
    val totalOdd = odd.sum()
    val topTwoOddNumber = odd.take(2)

    println("Angka Genap (>5): ${even.joinToString(", ")}")
    println("Jumlah: $evenCount")
    println("Total: $totalEven")
    println("Rata-rata: $avgEvenStr")
    println("Dua angka teratas: $topTwoEvenNumber")
    println()

    println("Angka Ganjil (>5): ${odd.joinToString(", ")}")
    println("Jumlah: $oddCount")
    println("Total: $totalOdd")
    println("Rata-rata: $avgOddStr")
    println("Dua angka teratas: $topTwoOddNumber")

    println("Is odd's average > even's average?: ${avgOdd > avgEven}")
}
package src.dsa

fun main() {
    splitPositiveNegativeNumber()
    splitData()
}

fun splitPositiveNegativeNumber() {
    val numbers = listOf(10, -5, 0, 3, -2, 8, -9)
    val (positive, negative) = numbers.partition { it > -1 }
    println("Angka positif: $positive")
    println("Angka negatif: $negative")
}

fun transactionData(): List<Transaction> = listOf(
    Transaction(100),
    Transaction(-50),
    Transaction(0),
    Transaction(75),
    Transaction(-30)
)

fun splitData() {
    val transactionData = transactionData()
    val (positive, negative) = transactionData
        .sortedBy { it.amount }
        .partition { it.amount >= 0 }
    val positiveData = positive.joinToString(", ") { "Rp${it.amount}" }
    val negativeData = negative.joinToString(", ") { "Rp${it.amount}" }
    println("Transfer masuk: $positiveData\nTransfer keluar: $negativeData")
}

data class Transaction(val amount: Int)
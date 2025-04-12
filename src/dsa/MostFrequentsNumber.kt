package src.dsa

fun main() {
    val angka = listOf(1, 3, 5, 3, 7, 1, 3, 5, 5, 5)
    val (angkaTerbanyak, jumlah) = angka.mostFrequentNumber()
    println("Angka terbanyak: $angkaTerbanyak ($jumlah kali)")
}

fun List<Int>.mostFrequentNumber(): Pair<Int, Int> {
    return this.groupBy { it }.mapValues { it.value.size }.maxByOrNull { it.value }?.toPair() ?: (0 to 0)
}
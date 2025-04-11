package src.dsa

fun main() {
    val text = "Programming is powerful"
    val (char, count) = text.mostFrequentChar()
    println("Karakter terbanyak dalam '$text' adalah '$char' dan muncul sebanyak $count kali")
}

fun String.mostFrequentChar(): Pair<Char, Int> {
    val clean = this.lowercase().filter { it.isLetterOrDigit() }
    require(clean.isNotEmpty()) { "String tidak boleh kosong atau hanya berisi simbol" }

    return clean
        .filter { it.isLetterOrDigit() }
        .groupBy { it }
        .mapValues { it.value.size }
        .maxByOrNull { it.value }
        ?.toPair() ?: error("")
}
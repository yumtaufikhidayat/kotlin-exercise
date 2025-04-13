package src.dsa

fun main() {
    println("aaaa".isAnagramOf("abaa"))
    println("listen".isAnagramOf("sentil"))
    println("race".isAnagramOf("care"))
    println("hello".isAnagramOf("world"))
    println("aba".isAnagramOf("baa"))
    println("123saya".isAnagramOf("saya321"))
}

fun String.isAnagramOf(otherString: String): Boolean = this.sortedString() == otherString.sortedString()
fun String.sortedString(): List<Char> = this.lowercase().filter { it.isLetterOrDigit() }.toList().sorted()
package src.dsa

fun main() {
    showVowels()
    checkWord()
}

fun wordData(): List<Char> = listOf('A', 'B', 'C', 'Z', 'U', 'X', 'E')

fun showVowels() {
    println(wordData().getVowels())
}

fun List<Char>.getVowels(): List<Char> {
    return this.sorted()
        .filter {
            it == 'A' || it == 'I' || it == 'U' || it == 'E' || it == 'O'
        }
}

fun checkWord() {
    val str = "Ini budi123"
    println("${str.hasVowel()}\n${str.hasConsonant()}")
}

fun String.hasVowel(): Boolean =
    this.any { it.isLetterOrDigit() && it.isVocal() }

fun String.hasConsonant(): Boolean =
    this.any { it.isLetterOrDigit() && !it.isVocal() }

fun Char.isVocal(): Boolean = this.uppercaseChar() in vocals()

fun vocals(): List<Char> = listOf('A', 'I', 'U', 'E', 'O')
package src.dsa

fun main() {
    showVowels()
}

fun vowelsData(): List<String> = listOf("A", "B", "C", "Z", "U", "X", "E")

fun showVowels() {
    println(vowelsData().getVowels())
}

fun List<String>.getVowels(): List<String> {
    return this.sorted()
        .filter {
            it == "A" || it == "I" || it == "U" || it == "E" || it == "O"
        }
}
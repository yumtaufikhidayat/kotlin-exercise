package src.dsa

fun main() {
    println(studentData().toReadableString())

    val minChar = 4
    println("Total siswa dengan nama >$minChar huruf: ${minChar.checkStudentNamesMoreThanN()}")
}

fun studentData(): List<String> = listOf("Andi", "Budi", "Citra", "Dika", "Nathan")

fun Int.checkStudentNamesMoreThanN(): String {
    val student4Chars = studentData().showStudent4Chars(this)
    val names = student4Chars.keys.joinToString(", ")
    val total = student4Chars.values.sum()
    val student4CharsLetter = student4Chars.values.joinToString(", ")
    return if (total > this || names.isNotBlank()) "$names ($student4CharsLetter huruf)" else "Tidak ada data"
}

fun List<String>.mapStudent(): Map<String, Int> = this.associate { it to it.length }
fun List<String>.toReadableString(): String = mapStudent().map { "${it.key}: ${it.value} huruf" }.joinToString("\n")
fun List<String>.showStudent4Chars(n: Int): Map<String, Int> = mapStudent().filter { it.value > n }
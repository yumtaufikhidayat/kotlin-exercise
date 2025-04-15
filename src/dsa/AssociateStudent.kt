package src.dsa

fun main() {
    println(studentData().toReadableString())

    val minChar = 4
    println("Total siswa dengan nama >$minChar huruf: ${minChar.checkStudentNamesMoreThanN()}")

    println(getAllStudentNim().getStudentInfoByNim())
    println(getAllStudentData().searchStudentNameByChar('D'))
    println(getAllStudentData().searchStudentNameByName("Citra"))
    println(anotherStudentData().markIfNameIsLongerThan(minChar))
    println(anotherStudentData().showLongName(5))
    println(anotherStudentData().toLengthLabel(5))
}

fun studentData(): List<String> = listOf("Andi", "Budi", "Citra", "Dika", "Nathan")

fun anotherStudentData(): List<String> = listOf("Andi", "Budi", "Citra", "Nathan", "Ana")

fun getAllStudentNim() = listOf(
    Student("A001", "Andi"),
    Student("A002", "Budi"),
    Student("A003", "Citra"),
    Student("A004", "Dika")
)

fun getAllStudentData() = listOf(
    Siswa(1, "Andi"),
    Siswa(2, "Budi"),
    Siswa(3, "Citra"),
    Siswa(4, "Dika")
)

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

fun List<Student>.getStudentInfoByNim(): Map<String, Student> = this.associateBy { it.nim }

fun List<Siswa>.searchStudentNameByChar(char: Char): String {
    val map = this.associateBy { it.name.first() }
    return map[char]?.let { data ->
        "Huruf $char → ${data.name} (id: ${data.id})"
    } ?: run {
        "Tidak ditemukan siswa dengan huruf $char"
    }
}

fun List<Siswa>.searchStudentNameByName(name: String): String {
    val key = name.first()
    val map = this.associateBy { it.name.first() }
    val student = map[key]
    return if (student != null) "$name ditemukan dengan ID: ${student.id}" else "Siswa tidak ditemukan"
}

fun List<String>.markIfNameIsLongerThan(n: Int): Map<String, Boolean> = this.associateWith { it.length > n }

fun List<String>.showLongName(n: Int): String {
    val result = this.associateWith { it.length }.filterValues { it > n }.maxByOrNull { it.value > n }
    return if (result != null) {
        "Nama terpanjang yang lebih dari $n huruf: ${result.key} (${result.value} huruf)"
    } else {
        "Tidak ada nama yang lebih panjang dari $n huruf"
    }
}

fun List<String>.toLengthLabel(n: Int): Map<String, String> = this.associateWith {
    if (it.length > n) "panjang" else "pendek"
}

data class Student(val nim: String, val name: String)
data class Siswa(val id: Int, val name: String)
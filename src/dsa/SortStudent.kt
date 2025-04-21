package src.dsa

fun main() {
    val listStudent = listOf(
        StudentName(0, "Hafidz Nur Pradigda"),
        StudentName(1, "Hafidz Nur Pradigda"),
        StudentName(2, "Aulia Salsabila"),
        StudentName(3, "Hafidz Nur Pradigda"),
        StudentName(4, "Archy Gia Destara"),
        StudentName(5, "Nurul Burhan"),
        StudentName(6, "Muhammad Faza Lamik"),
        StudentName(7, "Agista Septiyanto"),
        StudentName(8, "Niko"),
        StudentName(9, "Riezki Maisyar"),
        StudentName(10, "Alfino Hasan"),
        StudentName(11, "Fakhrul Ghozali Akbar Simangunsong"),
        StudentName(12, "Hafidz Nur Pradigda"),
        StudentName(13, "Hafidz Nur Pradigda"),
    )

    println("Jumlah mentee unik yang di-mentor: ${listStudent.showStudentSummary()}")
    listStudent.showDetailedSummary()

    listStudent.sortedByName(isAscending = true)
}

fun List<StudentName>.showStudentSummary(): Int = this.distinctBy { it.name }.count()

fun List<StudentName>.showDetailedSummary() {
    val uniqueCount = this.distinctBy { it.name }.size
    val total = this.size
    println("Total mentee: $total | Unik berdasarkan nama: $uniqueCount | Duplikat: ${total - uniqueCount} (${this.findDuplicates().toReadableString()})")
}

fun List<StudentName>.sortedByName(isAscending: Boolean) {
    val sorted = this.distinctBy { it.name }.let {
        if (isAscending) it.sortedBy { s -> s.name }
        else it.sortedByDescending { s -> s.name }
    }
    val label = if (isAscending) "naik" else "turun"
    val result = sorted.joinToString(", ") { it.name }
    println("Urut $label: $result")
}

fun List<StudentName>.findDuplicates(): Map<String, Int> =
    this.groupingBy { it.name }
        .eachCount()
        .filter { it.value > 1 }

fun Map<String, Int>.toReadableString(): String = this.map { "${it.key} muncul ${it.value} kali" }.joinToString("")

data class StudentName(val id: Int, val name: String)
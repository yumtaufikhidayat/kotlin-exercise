package src.dsa

fun main() {
    showSortedStudentName()
}

fun studentNameData(): List<String> = listOf(
    "Andi", "Budi", "Citra", "Alya", "Dedi", "Bella", "Ardi"
)

fun showSortedStudentName() {
    val sortedStudentName = studentNameData().groupNamesByFirstLetter()
        .toSortedMap()
        .forEach { (key, value) ->
            println("$key: $value")
        }
    println(sortedStudentName)
}

fun List<String>.groupNamesByFirstLetter(): Map<Char, List<String>> = this.groupBy { it.first() }
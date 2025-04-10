package src.dsa

fun main() {
    val nums = listOf(12, 345, 2, 6, 7896)
    println("Jumlah angka genap: ${nums.findEvenDigitCount()}")
    println("Jumlah angka genap: ${nums.findEvenDigit()}")
    println("Panjang digit setiap angka: ${nums.countDigitLength().joinToString(", ")}")
}

fun List<Int>.findEvenDigitCount(): Int = this.map { it.toString().length }.count { it % 2 == 0 }

fun List<Int>.findEvenDigit(): Int = this.count { it.toString().length % 2 == 0 }

fun List<Int>.countDigitLength() = this.map { it.toString().length }
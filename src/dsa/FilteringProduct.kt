package src.dsa

fun main() {
    showCategoryOfFruits()
    println()
    getTheMostExpensiveProduct()
    println()
    getTopThreeProducts()
}

fun showCategoryOfFruits() {
    println("Category and amount of fruits:\n${categoryOfFruits()}")
}

fun categoryOfFruits(): String {
    val fruits = listOf("Apple", "Grapes", "Banana", "Orange", "Papaya", "Apple", "Papaya", "Orange")
    return fruits.groupBy { it }
        .mapValues { it.value.size }
        .toList()
        .sortedBy { it.first }
        .distinctBy { it.first }
        .mapIndexed { index, value ->
            "${index + 1}. $value"
        }.joinToString("\n")
}

fun getTheMostExpensiveProduct() {
    println(productData().filterTheMostExpensiveProduct())
}

fun getTopThreeProducts() {
    println(productData().filterTopThreeProducts())
}

fun List<Product>.filterTheMostExpensiveProduct(): String {
    val expensiveProduct = this.maxByOrNull { it.price }
    return if (expensiveProduct != null) "The most expensive product is ${expensiveProduct.name} (${expensiveProduct.price})"
    else "No product available"
}

fun List<Product>.filterTopThreeProducts(): String {
    val sortedProduct = this
        .sortedByDescending { it.price }
        .distinctBy { it.name }
        .take(3)

    val result = sortedProduct.mapIndexed { index, product ->
        "${index + 1}. ${product.name} (Rp${product.price})"
    }.joinToString("\n")

    return "Top three expensive products:\n$result"
}

data class Product(val name: String, val price: Int)

fun productData(): List<Product> = listOf(
    Product("Apple", 10_000),
    Product("Apple", 20_000),
    Product("Orange", 5_000),
    Product("Grapes", 25_000),
    Product("Banana", 15_000),
    Product("Pineapple", 35_000),
    Product("Mango", 15_000),
    Product("Durians", 10_000)
)
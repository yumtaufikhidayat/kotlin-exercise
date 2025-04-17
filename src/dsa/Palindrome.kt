package src.dsa

fun main() {
    println("Is \"racecar\" palindrome?: ${"racecar".isPalindrome()}")
    println("Is \"level\" palindrome?: ${"level".isPalindrome()}")
    println("Is \"hello\" palindrome?: ${"hello".isPalindrome()}")
    println("Is \"madam\" palindrome?: ${"madam".isPalindrome()}")
    println("Is \"kasurrusak\" palindrome?: ${"kasurrusak".isPalindrome()}")
    println("Is \"Was it a car or a cat I saw\" palindrome?: ${"Was it a car or a cat I saw".isStrictPalindrome()}")
    println("Is \"A man, a plan, a canal: Panama\" palindrome?: ${"A man, a plan, a canal: Panama".isStrictPalindrome()}")
}

fun String.isPalindrome(): Boolean = this == this.reversed()

fun String.isStrictPalindrome(): Boolean {
    val cleaned = this.lowercase().filter { it.isLetterOrDigit() }
    return cleaned == cleaned.reversed()
}
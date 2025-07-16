

// BÀI TẬP 3: Higher-Order Functions



fun main() {

    // 3.1: Viết function thực hiện operation trên hai số
    fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

    // 3.2: Viết function filter tùy chỉnh
    fun <T> customFilter(list: List<T>, predicate: (T) -> Boolean): List<T> {
        val result = mutableListOf<T>()
        for (item in list) {
            if (predicate(item)) {
                result.add(item)
            }
        }
        return result
    }

    // 3.3: Viết function map tùy chỉnh
    fun <T, R> customMap(list: List<T>, transform: (T) -> R): List<R> {
        // TODO: Implement custom map without using built-in map
        val result = mutableListOf<R>()
        for(item in list){
           result.add(transform(item))
        }
        return result
    }

    // 3.4: Viết function nhận lambda và thực hiện n lần
    fun repeat(times: Int, action: (Int) -> Unit) {
        // TODO: Thực hiện action n lần, truyền index làm parameter
        for(i in 1..times){
            action(i)
        }
    }

    // 3.5: Viết function trả về lambda
    fun createMultiplier(factor: Int): (Int) -> Int {
        // TODO: Trả về lambda nhân với factor
        return { it * factor }
    }


    println("=== TEST HIGHER-ORDER FUNCTIONS ===")

    // Test 3.1
    val sum = calculate(5, 3) { a, b -> a + b }
    val product = calculate(5, 3) { a, b -> a * b }
    println("Sum: $sum, Product: $product") // Expected: Sum: 8, Product: 15

    // Test 3.2
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenNumbers = customFilter(numbers) { it % 2 == 0 }
    println("Even numbers: $evenNumbers") // Expected: [2, 4, 6, 8, 10]

    // Test 3.3
    val squared = customMap(numbers) { it * it }
    println("Squared: $squared") // Expected: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]

    // Test 3.4
    println("Repeating 5 times:")
    repeat(5) { index -> println("Iteration $index") }

    // Test 3.5
    val multiplyBy3 = createMultiplier(3)
    println("7 * 3 = ${multiplyBy3(7)}") // Expected: 21


}

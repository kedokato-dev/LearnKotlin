/**
 * Tên file: Collection.kt
 * Người tạo: Tran Anh Quan
 * Ngày tạo: 7/17/2025
 * Mô tả: File thực hành các phương thức Collection trong Kotlin
 */

fun main() {
    println("=== KOTLIN COLLECTION PRACTICE ===\n")

    // Uncomment từng phần để test từng chức năng

    // listOperations()
    // setOperations()
    // mapOperations()
    // filterAndMapOperations()
    sequenceOperations()
}

/**
 * 1. LIST OPERATIONS - Các thao tác với List
 */
fun listOperations() {
    println("1. LIST OPERATIONS:")
    println("==================")

    val colors = mutableListOf("red", "blue", "green", "violet", "violet", "red")
    println("Original colors: $colors")

    // Remove operations
    println("\n--- Remove Operations ---")
    val colorsCopy = colors.toMutableList()

    // colorsCopy.removeAt(2)                    // Remove by index
    // colorsCopy.remove("violet")               // Remove first occurrence
    // colorsCopy.removeAll { it == "violet" }   // Remove all matching condition
    // colorsCopy.clear()                        // Remove all elements

    println("After remove operations: $colorsCopy")

    // List arithmetic operations
    println("\n--- List Arithmetic ---")
    val numbers = listOf("1", "2", "3", "4", "5")
    val toRemove = "3"
    val result = numbers - toRemove
    println("Original: $numbers")
    println("After removing '$toRemove': $result")

    // Partition and SubList
    println("\n--- Partition & SubList ---")
    val (matching, notMatching) = numbers.partition { it == "3" }
    println("Matching '3': $matching")
    println("Not matching '3': $notMatching")

    val subNumbers = numbers.subList(2, numbers.size)
    println("SubList from index 2: $subNumbers")

    println()
}

/**
 * 2. SET OPERATIONS - Các thao tác với Set
 */
fun setOperations() {
    println("2. SET OPERATIONS:")
    println("==================")

    val number1 = mutableSetOf(1, 2, 3, 4, 5)
    val number2 = mutableSetOf(1, 2, 9, 0)

    println("Set 1: $number1")
    println("Set 2: $number2")

    // Union operation
    number1.addAll(number2)
    println("After union: ${number1.sorted()}")

    println()
}

/**
 * 3. MAP OPERATIONS - Các thao tác với Map
 */
fun mapOperations() {
    println("3. MAP OPERATIONS:")
    println("==================")

    val cityMap = mutableMapOf(
        21 to "Hai Duong",
        19 to "Phu Tho",
        29 to "Ha Noi"
    )

    println("Original map: $cityMap")

    // Update value
    cityMap[19] = "Phu Tho City"
    println("After update: $cityMap")

    // Filter map
    val filteredCities = cityMap.filter { (key, value) ->
        key > 20 && value.length > 3
    }

    println("\nFiltered cities (key > 20 and value.length > 3):")
    filteredCities.forEach { (key, value) ->
        println("$key = $value")
    }

    println()
}

/**
 * 4. FILTER & MAP OPERATIONS - Các thao tác Filter và Map (Eager Evaluation)
 */
fun filterAndMapOperations() {
    println("4. FILTER & MAP OPERATIONS (Eager):")
    println("====================================")

    val words = "xin chao caccc bannn nhe huhu".split(" ")
    println("Original list: $words")

    println("\n--- Processing steps ---")
    val lengths = words.filter {
        println("Filtering: $it")
        it.length > 3
    }.map {
        println("Mapping: ${it.length}")
        it.length
    }.take(4)

    println("Final result: $lengths")
    println()
}

/**
 * 5. SEQUENCE OPERATIONS - Các thao tác với Sequence (Lazy Evaluation)
 */
fun sequenceOperations() {
    println("5. SEQUENCE OPERATIONS (Lazy):")
    println("===============================")

    val words = "xin chao caccc bannn nhe huhu".split(" ")
    println("Original list: $words")

    println("\n--- Processing steps (Lazy evaluation) ---")
    val sequence = words.asSequence()

    val lengths = sequence.filter {
        println("Filtering: $it")
        it.length > 3
    }.map {
        println("Mapping: ${it.length}")
        it.length
    }.take(4)

    println("Final result: ${lengths.toList()}")

    println("\n--- Sequence vs List comparison ---")
    println("- List: Eager evaluation - xử lý toàn bộ collection ngay lập tức")
    println("- Sequence: Lazy evaluation - chỉ xử lý khi cần thiết (terminal operation)")
    println()
}

/**
 * 6. ADDITIONAL UTILITY FUNCTIONS - Các hàm tiện ích bổ sung
 */
fun additionalOperations() {
    println("6. ADDITIONAL OPERATIONS:")
    println("=========================")

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // Chunked
    println("Chunked by 3: ${numbers.chunked(3)}")

    // Windowed
    println("Windowed size 3: ${numbers.windowed(3)}")

    // Zip
    val letters = listOf("a", "b", "c", "d", "e")
    println("Zip numbers with letters: ${numbers.zip(letters)}")

    // GroupBy
    val fruits = listOf("apple", "banana", "cherry", "apricot", "blueberry")
    val groupedByFirstLetter = fruits.groupBy { it.first() }
    println("Grouped by first letter: $groupedByFirstLetter")

    println()
}
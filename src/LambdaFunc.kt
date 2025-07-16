import java.time.LocalDateTime

// BÀI TẬP 2: Lambda Functions cơ bản

fun lambdaBasicExercises() {
    println("=== LAMBDA BASIC EXERCISES ===")

    // 2.1: Tạo lambda tính bình phương
    val square: (Int) -> Int = { q -> q * q }

    // 2.2: Tạo lambda kiểm tra chuỗi có chứa ký tự 'a'
    val containsA: (String) -> Boolean = { it.contains("a") ?: true }

    // 2.3: Tạo lambda nối hai chuỗi
    val concatenate: (String, String) -> String = { s1, s2 -> s1.plus(s2) }

    // 2.4: Tạo lambda không có tham số trả về thời gian hiện tại
    val getCurrentTime: () -> String = { LocalDateTime.now().toString() }

    // 2.5: Tạo lambda tính tổng hai số và nhân với một hệ số
    val sumAndMultiply: (Int, Int, Int) -> Int = { a, b, factor -> (a +b) * factor  }

    // Test lambdas
    println("Square of 6: ${square(6)}") // Expected: 36
    println("'banana' contains 'a': ${containsA("banana")}") // Expected: true
    println("'hello' contains 'a': ${containsA("hello")}") // Expected: false
    println("Concatenate 'Hello' + ' World': ${concatenate("Hello", " World")}")
    println("Current time: ${getCurrentTime()}")
    println("Sum(3,4) * 2: ${sumAndMultiply(3, 4, 2)}") // Expected: 14
}

fun main(){
    lambdaBasicExercises()
}
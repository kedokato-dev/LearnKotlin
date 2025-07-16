/**
 * Tên file: CollectionWithLambda.kt
 * Người tạo: Tran Anh Quan
 * Ngày tạo: 7/16/2025
 * Mô tả:  BÀI TẬP 4: Collections với Lambda
 */

data class Student(val name: String, val age: Int, val grade: Double, val subject: String)
data class Book(val title: String, val author: String, val pages: Int, val price: Double)

fun main() {
    println("=== COLLECTIONS WITH LAMBDA EXERCISES ===")

    val students = listOf(
        Student("Alice", 20, 8.5, "Math"),
        Student("Bob", 19, 7.2, "Physics"),
        Student("Carol", 21, 9.1, "Math"),
        Student("David", 20, 6.8, "Physics"),
        Student("Eve", 22, 8.9, "Math")
    )

    val books = listOf(
        Book("Kotlin Guide", "John Doe", 300, 29.99),
        Book("Android Dev", "Jane Smith", 450, 39.99),
        Book("Web Design", "Bob Johnson", 250, 24.99),
        Book("Data Science", "Alice Brown", 500, 49.99)
    )

    println("---------------4.1 TEST-------------")
    // 4.1: Tìm tất cả học sinh học Math
    val mathStudents = students.filter {
        it.subject == "Math"
    }
    for (mathStudent in mathStudents) {
        println("name: ${mathStudent.name}, subject: ${mathStudent.subject}")
    }
    println("---------------4.1 TEST-------------")



    println("---------------4.2 TEST-------------")
    // 4.2: Tìm học sinh có điểm cao nhất
    val topStudent = students.maxByOrNull {
        it.grade
    }
    println("name: ${topStudent?.name ?: "Empty"}, grade: ${topStudent?.grade ?: "Empty"}")
    println("---------------4.2 TEST-------------")




    println("---------------4.3 TEST-------------")
    // 4.3: Tính điểm trung bình của tất cả học sinh

    val averageGrade = students.map {
        it.grade
    }.average()
    println("Average grade: $averageGrade")
    println("---------------4.3 TEST-------------")

    println("---------------4.4 TEST-------------")
    // 4.4: Nhóm học sinh theo môn học
    val studentsBySubject = students.groupBy {
        it.subject
    }

    for (item in studentsBySubject){
        println("subject: ${item.key}")
        for(item in item.value){
            println("name: ${item.name}")
        }
    }
    println("---------------4.4 TEST-------------")


    // 4.5: Tìm sách có nhiều trang nhất và ít trang nhất
    val mostPages = books.maxByOrNull {
        it.pages
    }
    val leastPages = books.minByOrNull {
        it.pages
    }
    println("Most pages: ${mostPages?.title}, page: ${mostPages?.pages}")
    println("Least pages:${leastPages?.title}, page: ${leastPages?.pages}")

    // 4.6: Tính tổng giá trị của tất cả sách
    val totalValue = books.sumOf {
        it.price
    }
    println("Total books value: $totalValue")

    // 4.7: Tìm tất cả sách có giá > 30
    val expensiveBooks = books.filter {
        it.price > 30
    }
    println("Expensive books: $expensiveBooks")

    // 4.8: Tạo map từ tên sách đến tác giả
    val titleToAuthor = books.associate {
        it.title to it.author }
    println("Title to Author: $titleToAuthor")

    // 4.9: Kiểm tra có học sinh nào dưới 20 tuổi không
    val hasYoungStudent = students.any {
        it.age < 20
    }
    println("Has student under 20: $hasYoungStudent")

    // 4.10: Kiểm tra tất cả sách có ít hơn 600 trang không
    val allBooksShort = books.all {
        it.pages < 600
    }

    val sumBookPape = books.sumOf {
        it.pages
    }
    println("All books under 600 pages: $allBooksShort")
}
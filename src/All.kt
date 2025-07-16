// BÀI TÂP 6: Thực hành tổng hợp

data class Transaction(
    val id: String,
    val amount: Double,
    val type: String, // "income" or "expense"
    val category: String,
    val date: String
)

class BankAccount(private val transactions: List<Transaction>) {

    // 6.1: Tính tổng thu nhập
    fun getTotalIncome(): Double {
        // TODO: Sử dụng filter và sumOf
        return transactions.filter { it.type == "income" }.sumOf { it.amount }
    }

    // 6.2: Tính tổng chi tiêu
    fun getTotalExpenses(): Double {
        // TODO: Sử dụng filter và sumOf
        return transactions.filter { it.type == "expense" }.sumOf { it.amount }

    }

    // 6.3: Lấy số dư hiện tại
    fun getBalance(): Double {
        // TODO: Thu nhập - Chi tiêu
        return getTotalIncome() + getTotalExpenses()
    }

    // 6.4: Nhóm giao dịch theo loại
    fun getTransactionsByType(): Map<String, List<Transaction>> {
        // TODO: Sử dụng groupBy
        return  transactions.groupBy { it.type }
    }

    // 6.5: Tìm giao dịch lớn nhất theo từng loại
    fun getLargestTransactionByType(): Map<String, Transaction?> {
        // TODO: Combine groupBy và maxByOrNull
        val res =  transactions.maxByOrNull { it.amount }
        return emptyMap()
    }

    // 6.6: Lấy top N giao dịch chi tiêu lớn nhất
    fun getTopExpenses(n: Int): List<Transaction> {
        val expensesList = transactions.filter { it.type == "expense" }.sortedBy { it.amount }
        val result = mutableListOf<Transaction>()
        var count = 0;
        for (item in expensesList){
            if(count < n){
                result.add(item)
            }
            count ++
        }
         return result
    }

    // 6.7: Tính tổng theo danh mục
    fun getTotalByCategory(): Map<String, Double> {
        // TODO: GroupBy category, sum amounts
         val groupCategory =  transactions.groupBy { it.category }
         val res = mutableMapOf<String, Double>()
        for(item in groupCategory ){
            res.put(item.key, item.value[1].amount)
        }
        return emptyMap()
    }

    // 6.8: Kiểm tra có giao dịch nào trong ngày cụ thể
    fun hasTransactionOnDate(date: String): Boolean {
        // TODO: Use any
        return false
    }

    // 6.9: Custom filter với nhiều điều kiện
    fun filterTransactions(
        minAmount: Double? = null,
        maxAmount: Double? = null,
        type: String? = null,
        category: String? = null
    ): List<Transaction> {
        // TODO: Apply multiple filters using lambda
        return emptyList()
    }

    // 6.10: Tạo báo cáo tóm tắt
    fun generateSummary(): String {
        // TODO: Sử dụng các function đã implement để tạo báo cáo
        return ""
    }
}

fun main() {
    println("=== COMPREHENSIVE PRACTICE ===")

    val transactions = listOf(
        Transaction("1", 1000.0, "income", "salary", "2025-07-01"),
        Transaction("2", -50.0, "expense", "food", "2025-07-02"),
        Transaction("3", -200.0, "expense", "shopping", "2025-07-03"),
        Transaction("4", 500.0, "income", "freelance", "2025-07-04"),
        Transaction("5", -30.0, "expense", "food", "2025-07-05"),
        Transaction("6", -100.0, "expense", "transport", "2025-07-06"),
        Transaction("7", 200.0, "income", "bonus", "2025-07-07")
    )

    val account = BankAccount(transactions)

    println("Total Income: ${account.getTotalIncome()}")
    println("Total Expenses: ${account.getTotalExpenses()}")
    println("Balance: ${account.getBalance()}")
    println("Transactions by type: ${account.getTransactionsByType()}")
    println("Largest by type: ${account.getLargestTransactionByType()}")
    println("Top 2 expenses: ${account.getTopExpenses(2)}")
    println("Total by category: ${account.getTotalByCategory()}")
    println("Has transaction on 2025-07-05: ${account.hasTransactionOnDate("2025-07-05")}")

    val filteredTransactions = account.filterTransactions(
        minAmount = 100.0,
        type = "expense"
    )
    println("Filtered transactions: $filteredTransactions")

    println("\n--- SUMMARY REPORT ---")
    println(account.generateSummary())
}
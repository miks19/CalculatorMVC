package Models

class CalculatorModel {
  private val history= mutableListOf<String>()

  fun addHistory(calculation: String){
    history.add(calculation)
  }
  fun getHistory(): List<String> = history

  fun deleteHistory(index: Int){
    history.removeAt(index)
  }

  //Attributes
    var num1: Double = 0.0
    var num2: Double = 0.0

    //Operations
    fun add(): Double = num1 + num2

    fun subtract(): Double = num1 - num2

    fun multiply(): Double = num1 * num2

    fun divide(): Double {
        return if (num2 != 0.0) num1 / num2 else 0.0
    }

}
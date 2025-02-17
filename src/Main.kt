import kotlin.system.exitProcess
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    println("***  Console Calculator  ***")

    //input collection
    println("\nEnter two numbers (or one number for square root):\n")
    val number1 = readDoubleInput("First number: ")
    var number2 = 0.0

    //operation selection
    showChoices()
    val operation = getArithmeticOperation()
    if(operation != "√") {
        number2 = readDoubleInput("\nSecond number: ")
    }

    //calculation
    val result = performCalculation(number1, number2, operation)

    //result display
    if(operation == "√") {
        println("\nResult:\n√$number1 = $result")
    } else {
        println("\nResult:\n" + "$number1 $operation $number2 = $result")
    }
}

fun readDoubleInput(prompt: String): Double {
    print(prompt)
    val num = readln()

    //check input validity
    try {
        return num.toDouble()
    } catch (e: Exception) {
        println("Error reading input: ${e.message}")
        exitProcess(1)
    }
}

fun showChoices() {
    println("\nOperation Options:")
    println("1. Addition (+)")
    println("2. Subtraction (-)")
    println("3. Multiplication (*)")
    println("4. Division (/)")
    println("5. Modulo (%)")
    println("5. Power (x^n)")
    println("5. Square root (√)")
}

fun getArithmeticOperation(): String {
    print("\nEnter an arithmetic operation (+, -, *, /, %, ^, √): ")
    val operation = readln()

    if(!"+-*/%^√".contains(operation, true)){
        println("\nInvalid operation. Exiting.")
        exitProcess(2) //exit the program
    }
    return operation
}

fun performCalculation(number1: Double, number2: Double, operation: String): Double {
    return when (operation) {
        "+" -> number1 + number2
        "-" -> number1 - number2
        "*" -> number1 * number2
        "/" -> if(number2 != 0.0) number1 / number2
        else {
            println("\nDivision by zero is not allowed. Exiting.")
            exitProcess(3)
        }
        "%" -> if(number2 != 0.0) number1 % number2
        else {
            println("\nModulo by zero is not allowed. Exiting.")
            exitProcess(4)
        }
        "^" -> number1.pow(number2)
        "√" -> if(number1 >= 0) sqrt(number1)
        else {
            println("\nSquare root of a negative number is not allowed. Exiting.")
            exitProcess(5)
        }
        else -> {
            println("\nUnexpected error encountered. Exiting.")
            exitProcess(6)
        }
    }
}
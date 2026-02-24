package files

import java.io.File

fun main() {
    val file = File("test.txt")
    val operationCodes = OperationCode.entries
    while (true) {
        //fileProductCards.appendText("$item\n") // Добавление текста в файл, если нам надо переписать файл то есть метод writeText()
        print("Enter operation code: ")
        for ((index, title) in operationCodes.withIndex()) {
            print("$index - ${title.title}")
            if (index < operationCodes.size - 1) print(", ")
            else print(": ")
        }

        val operationIndex = readln().toInt()
        val operationCode = operationCodes[operationIndex]

        when (operationCode) {
            OperationCode.EXIT -> break
            OperationCode.ADD_ITEM -> {
                print("Enter a new item: ")
                val item = readln()
                file.appendText("$item\n")
            }

            OperationCode.SHOW_LIST -> {

                val content = file.readText().trim()  //trim() метод который обрезает лишние пробелы в начале и конце файла
                val items = content.split("\n")
                for ((index, item) in items.withIndex()){
                    println("$index - $item")
                }
            }
        }
    }
}

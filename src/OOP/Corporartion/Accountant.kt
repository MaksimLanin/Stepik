package OOP.Corporartion

import java.io.File

class Accountant(
    id: Int,
    name: String,
    age: Int
) : Worker(id, name, age, Position.ACCOUNTANT) {
    val cards = mutableListOf<ProductCard>()
    val items = mutableListOf<ProductCard>()
    private val fileProductCards = File("product_cards.txt")
    private val fileWorkers = File("workers.txt")

    override fun work() {
        val operationCodes = OperationCode.entries
        while (true) {

            for ((index, code) in operationCodes.withIndex()) {
                print("$index - ${code.title}")
                if (index < operationCodes.size - 1) println(", ")
                else println(". ")

            }
            print("Enter the operation code: ")
            val operationIndex = readln().toInt()
            val operationCode = operationCodes[operationIndex]
            when (operationCode) {

                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> shawAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_WORKER -> registerNewEmployee()
                OperationCode.FIRE_EMPLOYEE -> fireEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> shawAllEmployees()
            }
        }
    }

    private fun registerNewEmployee() {
        val positions = Position.entries
        for ((index, type) in positions.withIndex()) {
            print(("$index - ${type.title}"))
            if (index < positions.size - 1) print(", ")
            else print(": ")
        }

        val positionIndex = readln().toInt()
        val position = positions[positionIndex]

        print("Enter id: ")
        val id = readln().toInt()
        fileWorkers.appendText("$id%")

        print("Enter name: ")
        val name = readln()
        fileWorkers.appendText("$name%")

        print("Enter age: ")
        val age = readln().toInt()
        fileWorkers.appendText("$age%")
        val worker = when (position) {
            Position.ACCOUNTANT -> Accountant(id, name, age)
            Position.CONSULTANT -> Consultant(id, name, age)
            Position.DIRECTOR -> Director(id, name, age)
            Position.ASSISTANT -> Assistant(id, name, age)
        }
        saveWorkerToFile(worker)
    }

    private fun shawAllEmployees() {
        val employees = loadAllEmployees()
        for (employee in employees){
           employee.printInfo()

        }
    }

    private fun fireEmployee() {
        println("Enter employee id to fire: ")
        val id = readln().toInt()
        val employees = loadAllEmployees()
        fileWorkers.writeText("")
        for (employee in employees){
            if (employee.id !== id) {
              saveWorkerToFile(employee)
            }
        }



    }

    private fun loadAllEmployees(): MutableList<Worker> {
        val employees = mutableListOf<Worker>()

        if (!fileWorkers.exists()) {
            fileWorkers.createNewFile()
        }
        val content = fileWorkers.readText().trim()

        if (content.isEmpty()) return employees

        val employeesAsText = content.split("\n")
        for (employeeAsText in employeesAsText) {
            val properties = employeeAsText.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val positionAsText = properties.last()
            val position = Position.valueOf(positionAsText)
            val worker = when (position) {
                Position.ACCOUNTANT -> Accountant(id, name, age)
                Position.CONSULTANT -> Consultant(id, name, age)
                Position.DIRECTOR -> Director(id, name, age)
                Position.ASSISTANT -> Assistant(id, name, age)
            }
            employees.add(worker)
        }
        return employees
    }

    private fun saveWorkerToFile(worker: Worker) {
        fileWorkers.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.position}\n")

    }


    private fun removeProductCard() {
        val cards = loadAllCadrs()
        print("Enter name of card for removing: ")
        val name = readln()

        for (card in cards) {
            if (card.name == name) {
                cards.remove(card)
                break
            }
        }
        fileProductCards.writeText("")


    }

    private fun loadAllCadrs(): MutableList<ProductCard> {
        val cards: MutableList<ProductCard> = mutableListOf()

        if (!fileProductCards.exists()) fileWorkers.createNewFile()

        val content = fileProductCards.readText().trim()
        val cardsAsString = content.split("\n")
        for (card in cardsAsString) {
            val properties = card.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    private fun shawAllItems() {
        val content = fileProductCards.readText().trim()
        val cardsAsString = content.split("\n")
        for (card in cardsAsString) {
            val properties = card.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            productCard.printInfo()
        }
    }

    private fun saveProductCardToFile(productCard: ProductCard) {
        fileProductCards.appendText("${productCard.name}%")
        fileProductCards.appendText("${productCard.brand}%")
        fileProductCards.appendText("${productCard.price}%")

        when (productCard) {
            is FoodCard -> {
                val caloric = readln().toInt()
                fileProductCards.appendText("$caloric%${ProductType.FOOD}\n")

            }

            is ShoeCard -> {
                val size = readln().toFloat()
                fileProductCards.appendText("$size%${ProductType.SHOE}\n")

            }

            is ApplianceCard -> {
                val wattage = readln().toInt()
                fileProductCards.appendText("$wattage%${ProductType.APPLIANCE}\n")
            }
        }

        fileProductCards.appendText("$productCard\n")
    }

    private fun registerNewItem() {
        val productTypes = ProductType.entries
        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < productTypes.size - 1) print(", ")
            else print(": ")
        }

        val productTypeIndex = readln().toInt()
        val productType = productTypes[productTypeIndex]

        print("Enter product name: ")
        val productName = readln()
        fileProductCards.appendText("$productName%")

        print("Enter product brand: ")
        val productBrand = readln()
        fileProductCards.appendText("$productBrand%")

        print("Enter product price: ")
        val productPrice = readln().toInt()
        fileProductCards.appendText("$productPrice%")

        when (productType) {

            ProductType.FOOD -> {
                print("Enter the caloric: ")
                val caloric = readln().toInt()
                fileProductCards.appendText("$caloric%")
            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().toInt()
                fileProductCards.appendText("$wattage%")
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().toFloat()
                fileProductCards.appendText("$size%")
            }
        }
        fileProductCards.appendText("$productType\n")
    }
}
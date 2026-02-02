package OOP.Corporartion

import java.io.File

class Accountant(
    name: String,
    age: Int
) : Worker(name, age) {
    val cards = mutableListOf<ProductCard>()
    val items = mutableListOf<ProductCard>()
    val file = File("product_cards.txt")

    override fun work() {
        val operationCodes = OperationCode.entries
        while (true) {

            print("Enter the operation code. ")
            for ((index, code) in operationCodes.withIndex()) {
                print("$index - ${code.title}")
                if (index < operationCodes.size - 1) print(", ")
                else print(": ")

            }
            val operationIndex = readln().toInt()
            val operationCode = operationCodes[operationIndex]
            when (operationCode) {

                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> shawAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> TODO()
            }
        }
    }

    fun removeProductCard() {
        val cards = loadAllCadrs()
        print("Enter name of card for removing: ")
        val name = readln()

        for (card in cards) {
            if (card.name == name) {
                cards.remove(card)
                break
            }
        }
        file.writeText("")


    }

    fun loadAllCadrs(): MutableList<ProductCard> {
        val cards: MutableList<ProductCard> = mutableListOf()
        val content = file.readText().trim()
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

    fun shawAllItems() {
        val content = file.readText().trim()
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

    fun saveProductCardToFile(productCard: ProductCard) {
        file.appendText("${productCard.name}%")
        file.appendText("${productCard.brand}%")
        file.appendText("${productCard.price}%")

        when (productCard) {
            is FoodCard -> {
                val caloric = readln().toInt()
                file.appendText("$caloric%${ProductType.FOOD}\n")

            }

            is ShoeCard -> {
                val size = readln().toFloat()
                file.appendText("$size%${ProductType.SHOE}\n")

            }

            is ApplianceCard -> {
                val wattage = readln().toInt()
                file.appendText("$wattage%${ProductType.APPLIANCE}\n")
            }
        }

        file.appendText("$productCard\n")
    }

    fun registerNewItem() {
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
        file.appendText("$productName%")

        print("Enter product brand: ")
        val productBrand = readln()
        file.appendText("$productBrand%")

        print("Enter product price: ")
        val productPrice = readln().toInt()
        file.appendText("$productPrice%")

        when (productType) {

            ProductType.FOOD -> {
                print("Enter the caloric: ")
                val caloric = readln().toInt()
                file.appendText("$caloric%")
            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().toInt()
                file.appendText("$wattage%")
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().toFloat()
                file.appendText("$size%")
            }
        }
        file.appendText("$productType\n")
    }
}
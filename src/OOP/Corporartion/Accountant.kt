package OOP.Corporartion

import javax.lang.model.type.PrimitiveType

class Accountant(
    name: String,
    age: Int
) : Worker(name, age) {
    override fun work() {

        while (true) {
            print("Enter the operation code. 0 - exit, 1 - register new item: ")
            val operation = readln().toInt()
            when (operation) {
                0 -> break

                1 -> {
                    registerNewItem()
                }
            }
        }
    }

    fun registerNewItem() {
        val productTypes = ProductType.entries
        print("Enter the product type. ")
        for((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}")
            if(index< productTypes.size - 1) {
                print(", ")
            } else{
                print(": ")
            }
        }
        //print("Enter the product type. ${productTypes[0].title} - Food, ${productTypes[1].title} - Appliance, ${productTypes[2].title} - Shoe: ")
        val productTypeIndex = readln().toInt()
        val productType = productTypes[productTypeIndex]

        print("Enter product name: ")
        val productName = readln()

        print("Enter product brand: ")
        val productBrand = readln()

        print("Enter product price: ")
        val productPrice = readln().toInt()

        val card = when (productType) {

            ProductType.FOOD -> {
                print("Enter the caloric:")
                val caloric = readln().toInt()
                FoodCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    caloric = caloric
                )
            }
            ProductType.APPLIANCE -> {
                print("Enter the wattage:")
                val wattage = readln().toInt()
                ApplianceCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    wattage = wattage
                )
            }
            ProductType.SHOE -> {
                print("Enter the size:")
                val size = readln().toInt()
                ShoeCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    size = size
                )
            }
        }
        card.printInfo()
    }
}
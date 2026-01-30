package OOP.Corporartion

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
        print("Enter the product type. 0 - Food, 1 - Appliance, 2 - Shoe: ")
        val productType = readln().toInt()

        print("Enter product name: ")
        val productName = readln()

        print("Enter product brand: ")
        val productBrand = readln()

        print("Enter product price: ")
        val productPrice = readln().toInt()

        val card = when (productType) {
            0 -> {
                print("Enter the caloric:")
                val caloric = readln().toInt()
                FoodCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    caloric = caloric
                )

            }

            1 -> {
                print("Enter the wattage:")
                val wattage = readln().toInt()
                ApplianceCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    wattage = wattage
                )

            }

            else -> {
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
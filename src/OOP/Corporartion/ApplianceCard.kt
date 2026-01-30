package OOP.Corporartion

class ApplianceCard(
    name: String,
    brand: String,
    price: Int,
    val wattage: Int
): ProductCard(name = name, brand = brand, price = price) {

    override fun printInfo() {
        super.printInfo() // super тут мы обращаемся к методам родительского класса
        println("Caloric: ${this.wattage}")
    }
}
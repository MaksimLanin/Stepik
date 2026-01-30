package OOP.Corporartion

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int
): ProductCard(name = name, brand = brand, price = price) {

    override fun printInfo() {
        super.printInfo() // super тут мы обращаемся к методам родительского класса, т.е. мы выполняем сначала функцию родительского класса,
        // а потом уже доп функционал, для избежания дублирования кода
        println("Caloric: ${this.caloric}")
    }
}
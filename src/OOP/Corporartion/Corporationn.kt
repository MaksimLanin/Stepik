package OOP.Corporartion

fun main() {
    print("Enter name: ")
    val name = readln()
    print("Enter brand: ")
    val brand = readln()
    print("Enter size: ")
    val size = readln().toFloat()
    print("Enter price: ")
    val price = readln().toInt()

    val productCard = ProductCard(name, brand, size, price)
    productCard.printInfo()
}

class ProductCard {
    val name: String
    val brand: String
    val size: Float
    val price: Int

    constructor(name: String, brand: String, size: Float, price: Int){
        this.name = name
        this.brand = brand
        this.size = size
        this.price = price
    }

    fun printInfo() {
        println("Name: ${this.name}, Brand: ${this.brand}, Size: ${this.size}, Price: ${this.price}")
    }
}
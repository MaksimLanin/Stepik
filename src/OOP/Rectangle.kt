package OOP

class Rectangle {
    val width: Int
    val height: Int

    constructor(with: Int, height: Int) {
        this.width = with
        this.height = height
    }

    constructor(size: Int) : this(size, size)



    fun draw() {
        for (i in 0..height) {
            for (i in 0..width) {
                print("*  ")
            }
            println()
        }
    }
}


fun main() {
    val rectangle = Rectangle(8)
    rectangle.draw()
}
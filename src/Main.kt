fun main() {
    val brands = listOf<String>("Toyota", "Mazda", "Opel", "Toyota")
    val searchName = readln()
    for (name in brands) {
        if (searchName == name) {
            println(true)
            break
        } else {
            println(false)
            break
        }
    }

}
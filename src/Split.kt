fun main(){
    //Прога ждет ряд чисел, и по разделителю формирует из них коллекцию, и складыывает эллементы
    val input = readln().split(" ").sumOf { it.toInt() }

    println(input)
}
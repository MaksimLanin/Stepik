package OOP.cats

fun main(){
    val cat = Cat("Sam")
    println(cat.legsCount)
    println(cat.name)
    val lion = Lion(30)
    cat.playWithMouse()
}
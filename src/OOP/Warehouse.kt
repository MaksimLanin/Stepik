package OOP

class  DeliveryObject(
    val length: Int,
    val width: Int,
    val height: Int,
    val weight: Double,
)

class Pack(
    val length: Int,
    val width: Int,
    val height: Int,
    val type: String = "Картонная коробка",
    val weight: Double,
)

class Cargo(
    val length: Int,
    val width: Int,
    val height: Int,
    val typePackaging: String,
    val netWeight: Double,
    val grossWeight: Double,
){
    fun printInfo(){
        println("Длина: $length")
        println("Ширина: $width")
        println("Высота: $height")
        println("Тип упаковки: $typePackaging")
        println("Вес нетто: $netWeight")
        println("Вес брутто: $grossWeight")
    }
}

class Warehouse {
    fun getPack(deliveryObject: DeliveryObject): Pack{
        return Pack(
            length = deliveryObject.length + 1,
            width = deliveryObject.width + 1,
            height = deliveryObject.height + 1,
            weight = 0.3
        )
    }

    fun packCargo(deliveryObject: DeliveryObject): Cargo{
        val pack = getPack(deliveryObject)
        return Cargo(
            length = pack.length,
            width = pack.width,
            height = pack.height,
            typePackaging = pack.type,
            netWeight = deliveryObject.weight,
            grossWeight = deliveryObject.weight + pack.weight
        )
    }
}

fun task3() {
    val input = readln()
    val parts = input.split(" ")

    val length = parts[0].toInt()
    val width = parts[1].toInt()
    val height = parts[2].toInt()
    val weight = parts[3].toDouble()

    val deliveryObject = DeliveryObject(length, width, height, weight)
    val warehouse = Warehouse()
    val cargo = warehouse.packCargo(deliveryObject)
    cargo.printInfo()
}

fun main(){
    task3()
}

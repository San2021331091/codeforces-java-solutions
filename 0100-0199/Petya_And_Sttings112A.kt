fun Char.toLower():Int {
    return when(this){
        in 'A' .. 'Z' -> this.code + 32
        else -> this.code
    }
}

fun main() {

    val first = readln()
    val second = readln()
    var comparison = 0

    for (k in first.indices){

        if(first[k].toLower() < second[k].toLower()){
            comparison = -1
            break
        }
        if(first[k].toLower() > second[k].toLower()){
            comparison = 1
            break
        }
    }

    println(comparison)

}
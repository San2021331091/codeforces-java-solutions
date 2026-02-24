fun main() {

    val inp = readln()
    val trump = inp[0]
    val input = readln()
    var output = "NO"
    val value = HashMap<Char, Int>()
    value.putIfAbsent('6', 6)
    value.putIfAbsent('7', 7)
    value.putIfAbsent('8', 8)
    value.putIfAbsent('9',9)
    value.putIfAbsent('T', 10)
    value.putIfAbsent('J', 11)
    value.putIfAbsent('Q', 12)
    value.putIfAbsent('K', 13)
    value.putIfAbsent('A', 14)
    if (input[1] == trump && input[4] != trump) {
        output = "YES"; }
    else if (input[1] == input[4] && value.getOrDefault(input[0],0) > value.getOrDefault(input[3],0)) {
        output = "YES"; }

    println(output)


}
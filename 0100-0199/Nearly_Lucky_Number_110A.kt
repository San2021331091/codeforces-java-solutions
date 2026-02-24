fun main() {

    val number = readln()
    var output = 0
    for(k in number){
        if(k == '4' || k == '7')
            ++output
    }

    println( if (output == 4 || output == 7) "YES" else
    "NO")

}
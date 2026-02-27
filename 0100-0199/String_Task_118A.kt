fun Char.isVowel() = this.lowercaseChar() in listOf('a', 'e', 'i', 'o', 'u','y')
fun Char.isSpace() = this == ' '

fun main() {

val reader = System.`in`.bufferedReader()
val writer = System.`out`.bufferedWriter()
val temp = reader.readLine()
for(c in temp){
    if(!c.isVowel() && !c.isSpace()){
        writer.write(".${c.lowercase()}")
    }
}

    writer.write("\n")
    reader.close()
    writer.flush()
    writer.close()
}
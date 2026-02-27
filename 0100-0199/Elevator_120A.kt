import java.io.File

fun main() {
   val input = File("input.txt").readText().split("\\s+".toRegex())
   val door = input[0]
   val rail = input[1]
   val res = when{
       door == "front" && rail == "1" -> "L"
       door == "front" && rail == "2" -> "R"
       door == "back" && rail == "1" -> "R"
       door == "back" && rail == "2" -> "L"
       else -> ""
   }
    val output = File("output.txt")
    output.writeText(res)
}
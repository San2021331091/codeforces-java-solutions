import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))

    var (hours, minutes) = reader.readLine().trim().split(":".toRegex()).map { it.toInt() }
    var nextMinutes = 10 * (hours % 10) + (hours / 10);
    if (nextMinutes !in (minutes + 1)..59) {
        ++hours
        if (hours % 10 > 5) {
            hours -= hours % 10; hours += 10
        }
        hours %= 24
    }
    nextMinutes = 10 * (hours % 10) + (hours / 10);

    println("${hours/10}${hours%10}:${nextMinutes/10}${nextMinutes%10}")

    reader.close()
}



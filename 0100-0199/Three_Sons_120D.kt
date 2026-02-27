import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.PrintStream

fun main() {

    System.setIn(FileInputStream("input.txt"))
    System.setOut(PrintStream(FileOutputStream("output.txt")))

    val reader = System.`in`.bufferedReader()
    val output = System.`out`.bufferedWriter()
    val (n,m) = reader.readLine().trim().split("\\s+".toRegex()).map { it.toLong() }.toLongArray()
    val a = Array((n+1L).toInt()) { LongArray((m+1).toInt()) { 0L } }
    val s = Array((n+1L).toInt()){ LongArray((m+1L).toInt()) { 0L } }
    val c = MutableList(3) { 0L }
    var cnt = 0L
    for (p in 1L..n) {
        val line = reader.readLine().trim().split("\\s+".toRegex()).map { it.toLong() }
        for (q in 1L..m) {
            a[p.toInt()][q.toInt()] = line[(q - 1).toInt()]
            s[p.toInt()][q.toInt()] = s[p.toInt()][(q - 1).toInt()] + s[(p - 1).toInt()][q.toInt()] - s[(p - 1).toInt()][(q - 1).toInt()] + a[p.toInt()][q.toInt()]
        }
    }

    val lines = reader.readLine().trim().split("\\s+".toRegex()).map { it.toLong() }.toLongArray()
    c[0] = lines[0]
    c[1] = lines[1]
    c[2] = lines[2]
    c.sort()

    for(p in 1L until n){
        for(q in p+1L until n){
            val u = MutableList(3) { 0L }
            u[0] = s[p.toInt()][m.toInt()]
            u[1] = s[q.toInt()][m.toInt()]-s[p.toInt()][m.toInt()]
            u[2] = s[n.toInt()][m.toInt()]-s[q.toInt()][m.toInt()]
            u.sort()
            if(u == c){

                cnt++
            }
        }
    }


    for(p in 1L until m){
        for (q in p+1L until m){
            val u = MutableList(3) { 0L }
            u[0] = s[n.toInt()][p.toInt()]
            u[1] = s[n.toInt()][q.toInt()]-s[n.toInt()][p.toInt()]
            u[2] = s[n.toInt()][m.toInt()]-s[n.toInt()][q.toInt()]

            u.sort()
            if(u == c){
                cnt++
            }

        }
    }

    output.write(cnt.toString()+"\n")
    reader.close()
    output.flush()
    output.close()

}
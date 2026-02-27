fun gcd(a:Int,b:Int) : Int{
    return if (b==0) a else gcd(b,a%b)
}
fun main() {

val reader = System.`in`.bufferedReader()
val printer = System.`out`.bufferedWriter()
var (a,b,n) = reader.readLine().trim().split("\\s+".toRegex()).map { it.toInt() }.toIntArray()
while (true){
    n -= gcd(a,n)
    if(n<=0)
    {
        printer.write("0\n")
        break
    }
    n -= gcd(b,n)
    if(n<=0){
        printer.write("1\n")
        break
    }
}

    reader.close()
    printer.flush()
    printer.close()

}
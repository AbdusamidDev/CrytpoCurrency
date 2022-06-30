import java.util.*

fun main() {
    var service = Service()
    var scanner = Scanner(System.`in`)
    println("\tHello Welcome To Our Mining Center!!!\n")
    var number = 0
    do {
        println(
            """
            1.Sigh Up
            2.View Minings
            3.Convert Minings To USD
            4.Delete Minings
            0.Exit
            Which Fun You Want To Use: 
            
        """.trimIndent()
        )
        when (scanner.nextInt()) {
            1 -> service.sighUp()
            2 -> service.viewMining()
            3 -> service.converteToUSD()
            4 -> service.deleteMinings()
            0 -> service.exit()
        }
    } while (number == 0)
}
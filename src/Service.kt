import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileWriter
import java.util.*
import kotlin.collections.ArrayList

class Service : Plan, Thread() {
    var scanner = Scanner(System.`in`)
    var arrayList = ArrayList<Data>()
    var pcComp = "core i9,4tb"
    var pcComp2 = "core i7,3tb"
    var pcComp3 = "core i5,2tb"
    var random = Random().nextDouble(1.0, 50.0)

    override fun sighUp() {
        println("Enter Your Name: ")
        var name = scanner.next()

        println("Enter Your Surname: ")
        var surname = scanner.next()

        println("Enter Your Age: ")
        var age = scanner.nextByte()

        println("Enter Your PC Brand: ")
        var pcName = scanner.nextLine()

        println("Enter Your PC Components: [$pcComp;$pcComp2;$pcComp3] ")
        var pcComponent = scanner.nextLine()
        if (pcComp == pcComponent || pcComp2 == pcComponent || pcComp3 == pcComponent) {
            arrayList.add(Data(name, surname, age, pcName, pcComponent))
            sleep(350)
            println("Mining Started!!!")
        } else {
            println("Error")
        }
    }

    override fun viewMining() {
        if (arrayList.isEmpty()) {
            println("NO MININGS YET!!!")
        } else {
            sleep(150)
            arrayList.forEach {
                println("${it.name} Mined ${random + 1.1219912} Btc")
            }
        }
    }

    override fun converteToUSD() {
        var scanner = Scanner(System.`in`)
        viewMining()
        var btc = 40000
        println("Enter Currency: ")
        var currency = scanner.nextDouble()
        for (valyuta in arrayList) {
            var convertation = "$currency Equals To ${btc * currency} USD"
            println(convertation)

        }
    }


    override fun search() {
        println("Wait")
        sleep(7000)
        for (i in 0 until arrayList.size) {
            println("$i ${arrayList[i]}")
        }
        println("Choose number:")
        var t = scanner.nextInt()
        println("$t : ${arrayList[t]}")
    }

    override fun deleteMinings() {
        for (i in 0 until arrayList.size) {
            println("$i ${arrayList[i]}")
        }
        var t = scanner.nextInt()
        arrayList.removeAt(t)
        sleep(500)
        println("Deleted!!")
    }

    override fun exit(): Int {
        return (-1)
    }

    override fun readFile(): ArrayList<String> {
        var list = ArrayList<String>()
        val file = File("Mining.txt")
        file.createNewFile()
        val lines = file.readLines()
        val type = object : TypeToken<ArrayList<String>>() {}.type
        if (lines.isNotEmpty())
            list = Gson().fromJson(lines[0], type)

        return list
    }

    override fun writeFile(list: List<String>) {
        val listStr = Gson().toJson(list)
        val filewriter = FileWriter("Mining.txt")
        filewriter.write(listStr)
        filewriter.close()
    }
}

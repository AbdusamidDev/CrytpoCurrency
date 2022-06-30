interface Plan {
    fun sighUp()
    fun viewMining()
    fun converteToUSD()
    fun search()
    fun deleteMinings()
    fun exit(): Int

    fun readFile(): ArrayList<String>
    fun writeFile(list: List<String>)
}
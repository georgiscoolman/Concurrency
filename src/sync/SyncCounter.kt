package sync

class SyncCounter() {
    var i = 0
        @Synchronized
        private set

    @Synchronized
    fun increase(){
        i++
        printCounter()
    }

    @Synchronized
    fun decrease(){
        i--
        printCounter()
    }

    private fun printCounter() {
        println("${Thread.currentThread().name} at ${System.nanoTime()} $i")
    }
}
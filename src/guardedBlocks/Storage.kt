package guardedBlocks

class Storage {

    private var value: String? = null

    @Synchronized
    fun take(): String{
        while (value == null){
            (this as java.lang.Object).wait()
        }
        val toTake = value
        value = null
        (this as java.lang.Object).notify()
        println("${Thread.currentThread()} take $toTake")
        return toTake!!
    }

    @Synchronized
    fun put(input: String){
        while (value != null){
            (this as java.lang.Object).wait()
        }
        value = input
        println("${Thread.currentThread()} put $input")
        (this as java.lang.Object).notify()
    }

}
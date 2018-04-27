package deadLock

class Sync(private val name: String) {

    @Synchronized
    fun takeLock(sync: Sync){
        println("${Thread.currentThread().name} take lock on $name")
        sync.takeLockTo(this)
    }

    @Synchronized
    private fun takeLockTo(sync: Sync){
        println("${Thread.currentThread().name} try to take lock on $name from ${sync.name}")
    }

}
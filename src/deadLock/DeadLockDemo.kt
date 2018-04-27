package deadLock

fun main(args: Array<String>){
    val a = Sync("a")
    val b = Sync("b")

    Thread(Runnable {
        a.takeLock(b)
    }, "t1").start()

    Thread(Runnable {
        b.takeLock(a)
    }, "t2").start()
}
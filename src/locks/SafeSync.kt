package locks

import java.util.concurrent.locks.ReentrantLock



class SafeSync(private val name: String) {

    private val lock = ReentrantLock()

    fun takeLock(sync: SafeSync){
        if (lock.tryLock()) {
            val currThreadName = Thread.currentThread().name
            println("$currThreadName take lock on $name")
            if (sync.lock.tryLock()) {
                println("$currThreadName take lock on ${sync.name} from $name")
                sync.lock.unlock()
                println("$currThreadName release lock on ${sync.name} from $name")
            }
            lock.unlock()
            println("$currThreadName release lock on $name")
        }
    }
}
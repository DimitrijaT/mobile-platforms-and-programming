package mk.ukim.finki.findbyagegroup.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


// runBlocking is only written ONCE!
fun main() = runBlocking {
    doWorld()
}

suspend fun doWorld() = coroutineScope {
    val job1 = launch {
        delay(1000)
        println("World1")
    }
    val job2 = launch {
        delay(1000)
        println("World2")
    }
    println("Hello")
    job1.join()
    job2.join()
    println("Done!")
}




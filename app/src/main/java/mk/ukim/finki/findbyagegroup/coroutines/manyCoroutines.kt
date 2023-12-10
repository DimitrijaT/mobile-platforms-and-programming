package mk.ukim.finki.findbyagegroup.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.time.measureTime

fun main() = runBlocking {
    val time = measureTime {
        testTimeCoroutinesIODispatcher()
    }
    println(time)
}

suspend fun testTimeCoroutinesIODispatcher() = coroutineScope {
    repeat(100_000) {
        launch(Dispatchers.IO) {
            delay(100)
            println(Thread.currentThread().name)
        }
    }
}


suspend fun testTimeCoroutines() = coroutineScope {
    repeat(100_000) {
        launch() {
            delay(100)
            println(Thread.currentThread().name)
        }
    }
}

suspend fun testTimeCoroutinesDefaultDispatcher() = coroutineScope {
    repeat(100_000) {
        launch(Dispatchers.Default) {
            delay(100)
            println(Thread.currentThread().name)
        }
    }
}


fun testTimeThread() {
    repeat(100_000) {
        thread {
            Thread.sleep(100)
            println(Thread.currentThread().name)
        }
    }
}




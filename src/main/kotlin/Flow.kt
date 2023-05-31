import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import java.sql.Time


//fun simple(): Flow<Int> = flow {
//    for (i in 1..3) {
//        delay(1000)
//        emit(i)
//    }
//}
//
//fun main() = runBlocking<Unit> {
//    println("Calling simple function...")
//     simple().collect { value:Int -> print(value) }
//}


// Flow time out

fun simple(): Flow<Int> = flow {
    for (i in 1..3){
        delay(50L)
        println("Emiiting $i")
        emit(i)
    }
}

suspend fun perFormRequest(request: Int): String{
    delay(1000L)
    return "response $request"
}

fun numbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    } finally {
        println("Finally in numbers")
    }
}

fun main() = runBlocking<Unit> {
//    withTimeoutOrNull(250){
//        simple().collect{ value -> println(value) }
//    }
//    println("Done")
//
//    (1..3).asFlow().collect() { value -> println(value) }
//    (1..3).asFlow() // a flow of requests
//        .transform { request ->
//            emit("Making request $request")
//            emit(perFormRequest(request))
//            emit("Making request $request")
//            emit(perFormRequest(request))
//        }
//        .collect { response -> println(response) }
//
//    numbers()
//        .take(3) // take only the first two
//        .collect { value -> println(value) }


//
//    val num = (1..5).asFlow()
//        .map { it * it }
//        .reduce { a, b -> a + b}
//    println(num)

    (1..5).asFlow()
        .filter {
//            println("Filter $it")
            it % 1 == 0
        }
        .map {
            println("Map $it")
             "$it"
        }.collect {
            println("Collect $it")
        }
}
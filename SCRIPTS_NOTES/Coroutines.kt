// Coroutines

// kotlinx.coroutines

fun main(args: Array<String>) = runBlocking<Unit> {
	val jobs = List(100_000) {
		launch(CommonPool) {
			delay(1000L)
			print(".")
		}
	}
	jobs.forEach { it.join() }
}

// -------------------

suspend fun preparePost(): Token = 
	makeRequst(
		composeTokenRequest()
	).parseToken()

suspend fun preparePost() {
	val request = composeTokenRequest()
	val result = makeRequst(request)
	return result.parseToken()
}

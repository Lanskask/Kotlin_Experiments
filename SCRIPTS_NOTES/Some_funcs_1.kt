// FunctionalProgramming

class ErrorProcessor {
	private val freshErrorId 
		get() = UUID.randomUUID()

	private val ignoredErrorTypes = mutableSetOf<ErrorType>()

	fun buildErrorDescList(): List<String> = 
		getErrorList()
			.filter { it.type !in ignoredErrorTypes }
			.map { freshErrorId to it }
			.map { (id, error) -> "[$id] ${error.msg}" }

}

// --
class ErrorProcessor {
	fun buildErrorDesc(e: Error): String = e.toString()

	fun buildErrorDescList(): List<String> {
		val errorList = getError()
		// or
		return stringifyList(errorList, ::anyToString) // anyToString - it's a function
		// or
		return stringifyList(errorList, this::buildErrorDesc)
		// or
		return stringifyList(errorList, 
			{e: Error -> e.toString() })
			// or
			{e -> e.toString() })
			// or
			fun(e) = e.toString())
		// or
		return stringifyList(errorList) {
			e -> e.toString()
		}
		// or
		return stringifyList(errorList) { it.toString() }
	}


}

fun <T> stringifyList(list: List<T>, f: (T) -> String): List<String> {
	val res = mutableListOf<String>()
	for (e in list) {
		res.add(f(e))
	}
	return res
}
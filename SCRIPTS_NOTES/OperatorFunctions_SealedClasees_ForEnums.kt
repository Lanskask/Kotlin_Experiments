// OperatorFunctions_SealedClasees_ForEnums 

// operator functions
//	plus/minus/times/driver
//	get/set []
//	rangeTo ..
//	contains in
//	compareTo <=>
//	componentN

class BAD_REQUEST(reason: String): HttpCodeEx(400, reason) {
	companion object {
		infix fun because(reason: String) = BAD_REQUEST(reason)
	}
}

fun handleExceptiom(ex: Exception): HttpCodeEx = 
	when(ex) {
		is IllegalArgumentException ->
			BAD_REQUEST because (ex.message ?: "Oops")
		else ->
			INTERNAL_SERVER_ERROR("Oops") 
	}

// -------
enum class HttpCode(val code: Int) {
	OK(200),
	BAD_REQUEST(400),
	FORBIDDEN(403),
	IM_A_TEAPOT(418) {
		override fun isOfficial() = false
	},
	INTERNAL_SERVER_ERROR(500);

	override fun rangeTo(other: HttpCode) = 
		HttpCode.values().slice(ordinal_other.ordinal)
	
	infix fun until(other: HttpCode) = 
		HttpCode.values()
			.slice(ordinal..other.ordinal - 1)
}

fun main(args: Array<String>) {
	for(code in BAD_REQUEST..IM_A_TEAPOT) {
		println("$code")
	}
}

// Sealed clasees

fun httpCodeToHttpMessage(code: HttpCode): Unit = 
	when(code) {
		is HttpCodeEx.IM_A_TEAPOT -> code.boilMeSomeWater()
		else -> Unit
		// .....
	}

sealed class HttpCodeEx(val code: Int, val msg: String) {
	object OK: HttpCodeEx(200, "OK")
	class BAD_REQUEST(reason: String): HttpCodeEx(400, reason)
	class FORBIDDEN(reason: String): HttpCodeEx(403, reason)
	class IM_A_TEAPOT(reason: String): HttpCodeEx(418, reason)
	class INTERNAL_SERVER_ERROR(reason: String): HttpCodeEx(500, reason)
}

// for enums
enum class HttpCode(val code: Int) {
	OK(200),
	BAD_REQUEST(400),
	FORBIDDEN(403),
	IM_A_TEAPOT(418) {
		override fun isOfficial() = false
	},
	INTERNAL_SERVER_ERROR(500);

	open fun isOfficial() = true
}


fun httpCodeToHttpMessage(code: HttpCode): String = 
	when(code) {
		HttpCode.OK -> "OK",
		HttpCode.BAD_REQUEST -> "BAD_REQUEST",
		// .....
	}

fun httpCodeToHttpMessage(code: HttpCode): String = code.name
fun httpCodeToHttpCode(code: HttpCode): Int = code.ordinal

fun httpCodeToHttpCode(code: Int): HttpCode = HttpCode.values()[code]
fun httpCodeToHttpCode(msg: String): HttpCode = HttpCode.values(msg)


// ---------------------

open class A {
	open fun foo(a: Int = 1, b: Int = 2): String = "$a$b"
}

class B: A() {
	override fun foo(b: Int, a: Int): String = super.foo(a, b)
}

fun main(args: Array<String>) {
	val a: A = B()
	println(a.foo(a = 1)) // ?)
}

// -------------------
fun fixSignUpMsg(msg: SignUpMsg): SignUpMsg = msg.copy(
	password = computePwdHash(msg.password)
)

class MyPOKO(val value: String) {
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if(other == null || javaClass != other.javaClass)
			return false

		val myPOKO = ther as MyPOKO

		return value == myPOKO.value
	}

	override fun hashCode(): Int = value.hashCode()
	override fun toString(): String = "MyPOKO{'$value'}"
}
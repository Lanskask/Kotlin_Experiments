// Kotlin

// Arrays
val fibs = arrayOf(1,1,2,3,5,8,13)

val sqrt = Array(7) { i -> i + i }

val fastFib = intArrayOf(1,1,2,3,5,8,13)

// -----------
// in Java
final String[] oops = {"aa", "bb", "cc"}
final Object[] year = oops;

year[1] = 42;

// ---------------
// Strings
val reg = "asf \" asd \" \b "
val raw = """
asf \" asd \" \b 
"""
val raw = """
	${'$'} asf \" asd \" \b 
"""

// ------------
a == b /*<->*/ a?.equals(b) ?: (b == null)

// Ссылочное равенство
a === b
// BUT
fun main() {
	val a: Int? = 127
	val b: Int? = 127
	println(a === b)
}

fun main() {
	val a: Int? = 255
	val b: Int? = 255
	println(a === b)
}

// ---------------------------
fun buildGreeting(info: Array<String>) {
	val firstName = getFirstName(info) ?: "John"
	val lastName = getlastName(info) ?: "Doe"
	val maritalStatus = getMaritalStatus(info)
	val sex = guessSex(info)

	println("Hello, ${honorify(sex, maritalStatus)} ${shorten(firstName)} $lastName")
}

fun main(args: Array<String>) {
	for (arg in args) {
		val info = arg.split(" ")
		println(buildGreeting(info))
	}
}

fun main(args: Array<String>) {
	// for (i in 0..args.lastIndex) {
	// for (i in 0 until args.size) {
	for (i in args.indices) {
		val info = args[i].split(" ")
		println(buildGreeting(info))
	}
}




// --------------
enum class Sex {
	Male, 
	Female,
	NonBinary
}

enum class MaritalStatus {
	Married,
	NotMaried,
	Unknown
}

fun honorify(sex: Sex, maritalStatus: MaritalStatus) = 
	when (Pair(sex, maritalStatus)) {
		Pair(Sex.Male, MaritalStatus.Married),
		Pair(Sex.Male, MaritalStatus.NotMarried),
		Pair(Sex.Male, MaritalStatus.Unknown) -> "Mr."

		Pair(Sex.Female, MaritalStatus.Married) -> "Mrs."
		Pair(Sex.Female, MaritalStatus.NotMarried) -> "Miss."
		Pair(Sex.Female, MaritalStatus.Unknown) -> "Ms."
		
		Pair(Sex.NonBinary, MaritalStatus.Married),
		Pair(Sex.NonBinary, MaritalStatus.NotMarried),
		Pair(Sex.NonBinary, MaritalStatus.Unknown) -> "Mx."

		else throw IllegalArgumentException(
			"Unknown combination of ($sex, $maritalStatus)")
	}

fun honorify(sex: Sex, maritalStatus: MaritalStatus) = 
	when (sex to maritalStatus) {
		Sex.Male to MaritalStatus.Married,
		Sex.Male to MaritalStatus.NotMarried,
		Sex.Male to MaritalStatus.Unknown -> "Mr."

		Sex.Female to MaritalStatus.Married -> "Mrs."
		Sex.Female to MaritalStatus.NotMarried -> "Miss."
		Sex.Female to MaritalStatus.Unknown -> "Ms."
		
		Sex.NonBinary to MaritalStatus.Married,
		Sex.NonBinary to MaritalStatus.NotMarried,
		Sex.NonBinary to MaritalStatus.Unknown -> "Mx."

		else throw IllegalArgumentException(
			"Unknown combination of ($sex, $maritalStatus)")
	}

import Sex.Male
import Sex.Female

import MaritalStatus.Married
// ...

fun honorify(sex: Sex, maritalStatus: MaritalStatus) = 
	when (sex to maritalStatus) {
		Male to Married,
		Male to NotMarried,
		Male to Unknown -> "Mr."

		Female to Married -> "Mrs."
		Female to NotMarried -> "Miss."
		Female to Unknown -> "Ms."
		// ...
	}

import Sex.Male as M
import Sex.Female as F

import MaritalStatus.Married as MM
// ...

fun honorify(sex: Sex, maritalStatus: MaritalStatus) = 
	when (sex to maritalStatus) {
		M to MM, M to MN, M to MU -> "Mr."
		F to MM -> "Mrs."
		F to MN -> "Miss."
		F to MU -> "Ms."
		// ...
	}

fun main(args: Array<String>) {
	val firstName = getFirstName(args) ?: "John"
	val lastName = getlastName(args) ?: "Doe"
	val maritalStatus = getMaritalStatus(args)
	val sex = guessSex(args)

	println("Hello, ${honorify(sex, maritalStatus)} ${shorten(firstName)} $lastName")
}



// --------------
fun shorten(name: String?): String {
	if (true == name?.isNotEmpty()) {
		// return name!!.get(0) + "." 
		return name[0] + "." // smartcast
	} else {
		return ""
	}
}

fun shorten(name: String?) = 
	if(true == name?.isNotEmpty()) name[0] + "." else ""

fun shorten(name: String?) = 
	if(true == name?.isNotEmpty()) "${name[0]}." else ""

fun main(args: Array<String>) {
	val firstName = getFirstName(args) ?: "John"
	val lastName = getlastName(args) ?: "Doe"
	println("Hello, ${shorten(firstName)} $lastName")
}



// --------------------
fun getFirstName(names: Array<String>): String? {
	if (args.size > 0) return args[0]
	else return null
}

fun getFirstName(names: Array<String>): String? {
	return if (args.size > 0) args[0] else null
}

fun getFirstName(names: Array<String>): String? = 
	if (args.size > 0) args[0] else null

fun getFirstName(names: Array<String>) = 
	if (args.size > 0) args[0] else null

fun main(args: Array<String>) {
	val firstName = getFirstName(args)
	val lastName = getlastName(args)
	println("Hello, $firstName $lastName")
}

fun main(args: Array<String>) {
	val firstName = getFirstName(args) ?: "John"
	val lastName = getlastName(args) ?: "Doe"
	println("Hello, $firstName $lastName")
}


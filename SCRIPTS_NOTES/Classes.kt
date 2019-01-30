// ------------------
// Kotlin classes

// Inheritance
open class SqlQuery(...) {...}

class SelectQuery(sqlDialect: String) : SqlQuery(sqlDialect)

// ------------
class SqlQuery(val sqlDialect: String) {
    val config: SqlConfig

    init {
        config = SqlConfig()
    }
}

class SqlQuery(sqlDialect: String) {
    val config = SqlConfig()
    val dialect = SqlDialect(sqlDialect)

    constructor() : this("") {
        config.hasCaching = false
    }

}

// ---------
class SqlQuery 

class SqlQuery @ShouldNotBeOptimized constructor(sqlDialect: String)

class SqlQuery(sqlDialect: String)

class SqlQuery(sqlDialect: String) {
    val _sqlDealect = sqlDialect
}

class SqlQuery(sqlDialect: String)

class SqlDialect(val name: String) {
    val isDefault: Boolean
        get() {
            return "" == name
        }

    // or
    val isDefault: Boolean
        get() = "" == name

    // or
    val isDefault
        get() = "" == name

    var hasCaching = falce
        get() {
            println("Getting hasCaching: $field")
            return field
        }
        set(value) // ...

        //or
        set(value) {
            if (value == field) return
            println("Setting hasCaching: $field")
            if (value) {
                // do some caching staff
            } else {
                // do some non-caching staff
            }
            field = value
        }
}



// Classes_Inner_SomeOther


class SelectQuery(...): SqlQuery(sqlDialect), LoggingExecutable {
	override fun execute(): Int {

		// ?: - else if operator
		// if conn == null - SqlException
		conn ?: throw SqlException("SQL connection failed!")

		return try {
			// ...
			recordCount
		} catch(ex: SqlExeption) {
			log.error("Opps, exeption: ${ex.message}")
		} finally {
			doingSomeUsefulSideEffectStuff()
		}
	}
}

class SqlRunner {

	val pool: ExecuteService = Executor.newCachedThreadPool()

	fun run(exec: Executable): Int {
		return WorkItem(exec).call()
	}

	fun runAsync(exec: Executable): Future<Int> {
		return pool.submit(WorkItem(exec))
	}

	open class WorkItem(...) {...}

	inner class AsyncWorkItem(exec: Executable) : WorkItem(exec) {
		fun submit(): Future<Int> = this@SqlRunner.pool.submit(this)
	}

}


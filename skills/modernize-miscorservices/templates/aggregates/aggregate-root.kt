package example.domain

class ExampleAggregate private constructor(
    val id: ExampleId,
    private var status: ExampleStatus,
) {
    companion object {
        fun create(id: ExampleId): ExampleAggregate = ExampleAggregate(id, ExampleStatus.NEW)
    }

    fun activate() {
        require(status == ExampleStatus.NEW)
        status = ExampleStatus.ACTIVE
    }
}

enum class ExampleStatus {
    NEW,
    ACTIVE,
}
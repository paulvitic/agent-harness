package example.domain

interface ExampleRepository {
    fun load(id: ExampleId): ExampleAggregate
    fun save(aggregate: ExampleAggregate)
}
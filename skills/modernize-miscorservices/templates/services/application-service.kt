package example.application

class ExampleApplicationService(
    private val repository: ExampleRepository,
) {
    fun handle(command: ExampleCommand) {
        val aggregate = repository.load(command.id)
        aggregate.activate()
        repository.save(aggregate)
    }
}
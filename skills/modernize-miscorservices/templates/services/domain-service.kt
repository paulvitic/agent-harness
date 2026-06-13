package example.domain

class ExampleDomainService {
    fun decide(input: ExampleValue): Boolean = input.amount > 0
}
package example.domain

@JvmInline
value class ExampleId(val value: String)

data class ExampleValue(
    val name: String,
    val amount: Long,
)
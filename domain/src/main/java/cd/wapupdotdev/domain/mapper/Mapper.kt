package cd.wapupdotdev.domain.mapper

interface Mapper<I, O> {
  fun map(input: I): O
}
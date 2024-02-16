package domain.mappers

interface BaseMapper<From, To> {

    fun mapToUIModel(from: From): To

    fun mapFromUIModel(to: To): From

    fun mapToUIModelList(fromList: List<From>): List<To>

    fun mapFromUIModelList(toList: List<To>): List<From>
}
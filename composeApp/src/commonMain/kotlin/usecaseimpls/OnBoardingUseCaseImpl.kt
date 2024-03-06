package usecaseimpls

import domain.repositories.DataStoreRepository
import domain.usecases.OnBoardingUseCase


class OnBoardingUseCaseImpl(
    private val dataStoreRepository: DataStoreRepository,
) : OnBoardingUseCase {

    override suspend fun setOnBoardingSeen(onBoardingSeen: Boolean) {
        return dataStoreRepository.setOnBoardingSeen(true)
    }
}
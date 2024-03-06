package domain.usecases

interface OnBoardingUseCase {

    suspend fun setOnBoardingSeen(onBoardingSeen: Boolean)
}
package com.example.rst_test.domain.usecases

import com.example.rst_test.domain.repository.RoomRepository
import javax.inject.Inject

class GetRoomsDataUseCase @Inject constructor(private val roomRepository: RoomRepository) {

    suspend fun invoke(url: String) = roomRepository.getRoomsData(url)
}
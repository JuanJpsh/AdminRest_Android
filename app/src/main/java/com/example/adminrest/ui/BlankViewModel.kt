package com.example.adminrest.ui

import androidx.lifecycle.ViewModel
import com.example.adminrest.data.BlankUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BlankViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(BlankUiState())
    val uiState: StateFlow<BlankUiState> = _uiState.asStateFlow()
}
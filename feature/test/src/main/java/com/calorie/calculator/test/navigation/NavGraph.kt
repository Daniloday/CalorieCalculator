package com.calorie.calculator.test.navigation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.calorie.calculator.ui_kit.navigation.composable
import androidx.navigation.compose.rememberNavController
import com.calorie.calculator.domain.TestUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.koin.core.KoinApplication.Companion.init

@Composable
fun NavGraph() {


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.FirstScreen) {
        composable<Routes.FirstScreen> {
            FirstScreen(onClick =  {
                navController.navigate(Routes.SecondScreen(param = "11") )
                println("yesssss")
            })
        }
        composable<Routes.SecondScreen, String> { t ->
            println("noooo")
            SecondScreen(param = t, onClick =  {
                navController.navigate(Routes.FirstScreen)
            })
        }
    }


}

@Composable
fun FirstScreen(onClick: () -> Unit, vm: SecondViewModel = koinViewModel()) {

    val uiState = vm.uiState.collectAsState()

    Button(onClick = onClick) {
        Text(text = "First screen ${uiState.value}")
    }
}

@Composable
fun SecondScreen(param: String, onClick: () -> Unit, vm: SecondViewModel = koinViewModel()) {

    val uiState = vm.uiState.collectAsState()

    Button(onClick = onClick) {
        Text(text = "$param Second screen $uiState")
    }
}

class SecondViewModel(
//    ioDispatcher: CoroutineDispatcher
    testUseCase: TestUseCase
): ViewModel() {

    private val _uiState: MutableStateFlow<String> = MutableStateFlow("")
    val uiState: StateFlow<String> = _uiState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                testUseCase().value
            }
        }
    }


}

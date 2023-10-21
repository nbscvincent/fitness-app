import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessApp(
    viewModel: ScreenViewModel by viewModels,
    navController: NavHostController = rememberNavController()
) {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
        }
        NavHost(
            navController = navController,
            startDestination = MainScreen.Login.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = MainScreen.Login.name) {
                LogInScreen(
                    onNextButtonClicked = {
                        navController.navigate(MainScreen.Home.name)
                    },
                )
            }
        }
    }
}

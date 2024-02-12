package com.abudnitski.currencyconversion.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abudnitski.currencyconversion.R
import com.abudnitski.currencyconversion.ui.list.ListScreen
import com.abudnitski.currencyconversion.ui.main.MainScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {
            if (navController.equals(Screen.ListUi.route)) {
                TopAppBar(
                    title = { Text(text = stringResource(R.string.currency_conversion)) },
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                )
            }
        }
    )
    { padding ->
        NavHost(navController = navController, startDestination = Screen.ConversionUi.route, modifier.padding(padding)) {
            composable(Screen.ConversionUi.route) {
                val currencyField = it.arguments?.getString(CURRENCY_FIELD_KEY)
                val currencyCode = it.arguments?.getString(CURRENCY_CODE_KEY)
                MainScreen(
                    onClickScreenOne = {
                        navController.navigate(
                            Screen.ListUi.route.replace(
                                oldValue = "{$CURRENCY_FIELD_KEY}",
                                newValue = "${1}"
                            )
                        )
                    },
                    onClickScreenTwo = {
                        navController.navigate(
                            Screen.ListUi.route.replace(
                                oldValue = "{$CURRENCY_FIELD_KEY}",
                                newValue = "${2}"
                            )
                        )
                    },
                    currencyField = currencyField?.toInt(),
                    currencyCode = currencyCode
                )
            }
            composable(Screen.ListUi.route) { it ->
                val currencyField = it.arguments?.getString(CURRENCY_FIELD_KEY)
                ListScreen(
                    onClick = {
                        navController.navigate(
                            "conversion?currencyField=$currencyField&currencyCode=$it"
                        )
                    },
                    onBackClick = {
                        navController.navigate(Screen.ConversionUi.route)
                    },
                )
            }
        }
    }
}

const val CURRENCY_FIELD_KEY = "currencyField"
const val CURRENCY_CODE_KEY = "currencyCode"

enum class Screen(val route: String) {

    ListUi("list/{$CURRENCY_FIELD_KEY}"),
    ConversionUi("conversion?currencyField={$CURRENCY_FIELD_KEY}&currencyCode={$CURRENCY_CODE_KEY}");
}

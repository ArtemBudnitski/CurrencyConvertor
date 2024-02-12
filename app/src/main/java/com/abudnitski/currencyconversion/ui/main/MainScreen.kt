package com.abudnitski.currencyconversion.ui.main

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abudnitski.currencyconversion.App
import com.abudnitski.currencyconversion.R
import com.abudnitski.currencyconversion.presentation.main.MainScreenViewModel
import com.abudnitski.currencyconversion.presentation.main.MainScreenViewModelFactory
import com.abudnitski.currencyconversion.ui.dialogAlert.AlertDialogComponent

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onClickScreenOne: (String) -> Unit,
    onClickScreenTwo: (String) -> Unit,
    currencyField: Int? = null,
    currencyCode: String? = null
) {
    val app = LocalContext.current.applicationContext as App
    val viewModel: MainScreenViewModel = viewModel(factory = MainScreenViewModelFactory(app.repository, currencyField, currencyCode))
    val screenUiState = viewModel.uiState.collectAsState().value

    if (screenUiState.isDataLoading) {
        Column(Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
    } else {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = modifier.weight(0.5f))
            Displays(
                mainScreenUiState = screenUiState,
                onClickScreenOne = onClickScreenOne,
                onClickScreenTwo = onClickScreenTwo
            )
            Spacer(modifier = modifier.weight(0.5f))
            Keyboard(mainScreenUiState = screenUiState)
            if (screenUiState.showDialog) {
                AlertDialogComponent(
                    onDismissRequest = { screenUiState.onDialogClosed() },
                    onConfirmation = { screenUiState.onDialogClosed() },
                    dialogTitle = stringResource(id = R.string.Warning),
                    dialogText = stringResource(id = R.string.dialog_zero_message),
                    icon = Icons.Default.Info,
                    isDismissButtonActive = false,
                    confirmButtonText = stringResource(id = R.string.ok),
                    onDismiss2Request = {}
                )
            }
            if (screenUiState.isDataError) {
                val activity = (LocalContext.current as? Activity)
                AlertDialogComponent(
                    onDismissRequest = { screenUiState.onDialogClosed() },
                    onConfirmation = { screenUiState.tryAgainButton() },
                    dialogTitle = stringResource(id = R.string.dialog_title),
                    dialogText = stringResource(id = R.string.dialog_message),
                    icon = Icons.Default.Info,
                    isDismissButtonActive = true,
                    confirmButtonText = stringResource(id = R.string.try_again),
                    dismissButtonText = stringResource(id = R.string.exit),
                    onDismiss2Request = { activity?.finish() }
                )
            }
        }
    }
}

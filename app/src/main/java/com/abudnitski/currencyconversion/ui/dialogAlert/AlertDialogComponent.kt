package com.abudnitski.currencyconversion.ui.dialogAlert

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.abudnitski.currencyconversion.R

@Composable
fun AlertDialogComponent(
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
    isDismissButtonActive: Boolean,
    confirmButtonText: String,
    dismissButtonText: String = "",
    onDismissRequest: () -> Unit,
    onDismiss2Request: () -> Unit,
    onConfirmation: () -> Unit

) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = stringResource(R.string.warning))
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(text = confirmButtonText)
            }
        },
        dismissButton = {
            if (isDismissButtonActive) {
                TextButton(
                    onClick = {
                        onDismiss2Request()
                    }
                ) {
                    Text(text = dismissButtonText)
                }
            }
        }
    )
}

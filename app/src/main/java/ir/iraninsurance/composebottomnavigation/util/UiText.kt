package ir.iraninsurance.composebottomnavigation.util

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UiText {
    data class StringValue(val str: String) : UiText()

    class StringResource(
        @StringRes val resourceId: Int,
        vararg val args: Any
    ) : UiText()

    @Composable
    fun asString(): String {
        return when (this) {
            is StringValue -> {
                str
            }

            is StringResource -> {
                stringResource(id = resourceId, formatArgs = args)
            }
        }
    }
}

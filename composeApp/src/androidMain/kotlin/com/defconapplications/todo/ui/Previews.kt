package com.defconapplications.todo.ui

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "large font",
    fontScale = 2f
)
@Preview(
    name = "small font",
    fontScale = 0.7f
)
@Preview(
    name = "dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class Previews
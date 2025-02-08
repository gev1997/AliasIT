package com.aliasit.ui.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.aliasit.ui.backgroundColor
import com.aliasit.ui.buttonColor
import com.aliasit.ui.textColor

class RenameDialog(title: String) {
    @Composable
    fun Init(initialTextFieldValue: String, onConfirm: (String) -> Unit) {
        if (!mShowDialog.value) return

        var textFieldValue by remember { mutableStateOf(initialTextFieldValue) }

        Dialog(mOnDismiss) {
            Card(Modifier.fillMaxWidth(), MaterialTheme.shapes.medium) {
                // Main Column
                Column(Modifier.fillMaxWidth().height(200.dp).background(backgroundColor).padding(16.dp), Arrangement.SpaceBetween) {
                    // Title Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("$mTitle name", color = textColor, style = MaterialTheme.typography.titleLarge)
                    }

                    // Text Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedTextField(textFieldValue, { textFieldValue = it }, Modifier.fillMaxWidth(), colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = textColor, unfocusedBorderColor = textColor), textStyle = TextStyle(textColor), singleLine = true)
                    }

                    // Buttons Column
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(Modifier.fillMaxWidth(), Arrangement.End) {
                            Button(mOnDismiss, colors = ButtonDefaults.buttonColors(buttonColor), shape = MaterialTheme.shapes.small) {
                                Text("Cancel", color = textColor)
                            }

                            Button({ onConfirm(textFieldValue); mOnDismiss() }, colors = ButtonDefaults.buttonColors(buttonColor), shape = MaterialTheme.shapes.small) {
                                Text("Rename", color = textColor)
                            }
                        }
                    }
                }
            }
        }
    }

    fun show() {
        mShowDialog.value = true
    }

    private var mTitle = title
    private var mShowDialog = mutableStateOf(false)
    private var mOnDismiss = { mShowDialog.value = false }
}

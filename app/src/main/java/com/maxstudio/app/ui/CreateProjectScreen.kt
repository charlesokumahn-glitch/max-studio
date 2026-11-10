package com.maxstudio.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.maxstudio.app.data.VideoFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateProjectScreen(onBack: () -> Unit) {
    var projectName by remember { mutableStateOf("") }
    var selectedFormat by remember { mutableStateOf(VideoFormat.PORTRAIT) }
    var created by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("New project") },
                navigationIcon = { TextButton(onClick = onBack) { Text("Back") } }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Text("Start with the basics", style = MaterialTheme.typography.headlineSmall, color = Color.White)
            Text("Choose a name and format. You can adjust these later.", color = Color(0xFFB4B5C4))
            OutlinedTextField(
                value = projectName,
                onValueChange = { projectName = it; created = false },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Project name") },
                placeholder = { Text("e.g. Summer travel short") },
                singleLine = true
            )
            Text("VIDEO FORMAT", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.secondary)
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                VideoFormat.entries.forEach { format ->
                    val isSelected = selectedFormat == format
                    Button(
                        onClick = { selectedFormat = format; created = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                            contentColor = if (isSelected) Color.White else Color(0xFFD4D5DF)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) { Text(format.label) }
                }
            }
            Spacer(Modifier.height(4.dp))
            Button(
                onClick = { if (projectName.isNotBlank()) created = true },
                enabled = projectName.isNotBlank(),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            ) { Text("Create project") }
            if (created) {
                Text("Project created — editor setup is next.", color = MaterialTheme.colorScheme.secondary)
            }
        }
    }
}

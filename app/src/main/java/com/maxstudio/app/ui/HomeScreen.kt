package com.maxstudio.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxstudio.app.data.Project
import com.maxstudio.app.data.SampleProjects

@Composable
fun HomeScreen(onCreateProject: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 28.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("MAX STUDIO", fontSize = 14.sp, color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
                    Text("Your next story starts here", style = MaterialTheme.typography.titleMedium, color = Color.White)
                }
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(Color(0xFF252333), RoundedCornerShape(14.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("M", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                }
            }
        }
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
            ) {
                Column(
                    modifier = Modifier
                        .background(Brush.linearGradient(listOf(Color(0xFF32245F), Color(0xFF171A2B))))
                        .padding(22.dp)
                ) {
                    Text("MAKE SOMETHING\nUNFORGETTABLE", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.ExtraBold, color = Color.White)
                    Spacer(Modifier.height(8.dp))
                    Text("Bring your video idea to life with MAX STUDIO.", color = Color(0xFFD4D1E2))
                    Spacer(Modifier.height(18.dp))
                    Button(
                        onClick = onCreateProject,
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("＋  Create a project", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Recent projects", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                TextButton(onClick = {}) { Text("See all") }
            }
        }
        items(SampleProjects) { project ->
            ProjectCard(project = project, onClick = {})
        }
        item { Spacer(Modifier.height(12.dp)) }
    }
}

@Composable
private fun ProjectCard(project: Project, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(width = 86.dp, height = 72.dp)
                    .background(Brush.linearGradient(listOf(Color(0xFF5746A5), Color(0xFF172F43))), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) { Text("▶", color = Color.White, fontSize = 22.sp) }
            Column(modifier = Modifier.padding(start = 14.dp)) {
                Text(project.name, fontWeight = FontWeight.SemiBold, color = Color.White)
                Spacer(Modifier.height(5.dp))
                Text("${project.format}  ·  ${project.status}", color = Color(0xFFB4B5C4), style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

package com.example.hardwareapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun PerformanceGauge(score: Float) {
    Canvas(modifier = Modifier.size(150.dp)) {

        drawArc(
            color = Color.LightGray,
            startAngle = 135f,
            sweepAngle = 270f,
            useCenter = false,
            style = Stroke(width = 15f, cap = StrokeCap.Round),
            size = Size(size.width, size.height)
        )

        val sweepAngle = (score / 100f) * 270f
        val gaugeColor = if (score > 80) Color.Green else if (score > 50) Color.Yellow else Color.Red

        drawArc(
            color = gaugeColor,
            startAngle = 135f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = 15f, cap = StrokeCap.Round),
            size = Size(size.width, size.height)
        )
    }
}
package com.shadow.grooveum

import MainActivity
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews

class GrooveumMusicWidget : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }
}

internal fun updateAppWidget(context: Context, appWidgetManager:AppWidgetManager, appWidgetId: Int) {
    val widgetText = context.getString(R.string.appwidget_text)
    val views = RemoteViews(context.packageName, R.layout.grooveum_music_widget)
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("app://grooveum/play"))

    val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
    views.setOnclickPendingIntent(R.id.button_play_pause, pendingIntent)

    appWidgetManager.updateAppWidget(appWidgetId, views)
}

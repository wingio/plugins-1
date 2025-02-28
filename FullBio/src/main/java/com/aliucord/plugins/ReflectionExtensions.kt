package com.aliucord.plugins

import com.discord.databinding.WidgetSettingsUserProfileBinding
import com.discord.databinding.WidgetUserSheetBinding
import com.discord.widgets.settings.profile.WidgetSettingsUserProfile
import com.discord.widgets.user.usersheet.WidgetUserSheet
import java.lang.reflect.Method

object ReflectionExtensions {
    private lateinit var settingsBioBinding: Method
    private lateinit var userBioBinding: Method

    fun init() {
        settingsBioBinding = WidgetSettingsUserProfile::class.java.getDeclaredMethod("getBinding").apply { isAccessible = true }
        userBioBinding = WidgetUserSheet::class.java.getDeclaredMethod("getBinding").apply { isAccessible = true }
    }

    val WidgetSettingsUserProfile.binding: WidgetSettingsUserProfileBinding
        get() = settingsBioBinding.invoke(this) as WidgetSettingsUserProfileBinding

    val WidgetUserSheet.binding: WidgetUserSheetBinding
        get() = userBioBinding.invoke(this) as WidgetUserSheetBinding
}
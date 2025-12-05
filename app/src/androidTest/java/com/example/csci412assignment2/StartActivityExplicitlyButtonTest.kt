package com.example.csci412assignment2
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StartActivityExplicitlyButtonTest {
    @Test
    fun testStartActivityExplicitlyButton() = uiAutomator {
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).pressHome()
        onElement { textAsString() == "CSCI 412 Assignment 2"}.click()

        waitForAppToBeVisible("com.example.csci412assignment2")

        onElement { textAsString() == "Start Activity Explicitly" }.click()

        onElement { textAsString() == "1. Device fragmentation" }
    }
}


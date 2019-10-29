package com.example.compbox;

import android.content.Context;

import androidx.test.internal.runner.listener.InstrumentationRunListener;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
//import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.compbox", appContext.getPackageName());
    }

    @Test
    public void useAppContext2() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("/data/app/com.example.compbox-6icnybNRhd6I7qcA42GE9w==/base.apk", appContext.getPackageResourcePath());
    }

    @Test
    public void user_can_enter_f_name(){


    }
}

package com.example.compbox;


import android.app.Activity;
import android.content.Context;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    MainActivity mainActivity = new MainActivity();

    @Test
    public void checklogin() {

        //BackgroundWorker bw = new BackgroundWorker(mainActivity);
        //String Result = bw.doInBackground("login", "admin", "admin");
        //assertEquals("Login success", Result);

    }
}
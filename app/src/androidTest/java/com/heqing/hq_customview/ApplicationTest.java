package com.heqing.hq_customview;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.heqing.hq_customview.model.People;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void test(){
        People people = new People("Jack", "中国武汉", 30);
        try {
            //序列化过程
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(people);
            out.close();

            //反序列化过程
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(byteOut.toByteArray()));
            People clonePeople = (People) in.readObject();
            in.close();
            byteOut.close();
            Log.i("tag",clonePeople.getName() + clonePeople.getAddress() + clonePeople.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
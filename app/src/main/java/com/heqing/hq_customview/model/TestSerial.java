package com.heqing.hq_customview.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by 何清 on 2016/7/16 0016.
 *
 * @description
 */
public class TestSerial {

    public static void main(String[] args) {
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
            System.out.print(clonePeople.getName()+clonePeople.getAddress()+clonePeople.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}

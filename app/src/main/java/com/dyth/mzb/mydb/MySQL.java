package com.dyth.mzb.mydb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lenovo on 2018/12/28.
 */

public class MySQL extends SQLiteOpenHelper {


//    private static MySQL mySQL;
//
//    private  MySQL(){
//
//    }


    public MySQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "my.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String sql = "create table demo(id integer primary key autoincrement,title text)";
       db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

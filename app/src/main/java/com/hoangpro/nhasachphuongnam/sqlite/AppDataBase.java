package com.hoangpro.nhasachphuongnam.sqlite;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.hoangpro.nhasachphuongnam.model.Bill;
import com.hoangpro.nhasachphuongnam.model.BillDetail;
import com.hoangpro.nhasachphuongnam.model.Book;
import com.hoangpro.nhasachphuongnam.model.BookType;
import com.hoangpro.nhasachphuongnam.model.User;
import com.hoangpro.nhasachphuongnam.sqlite.DAO.AppDataDAO;

@Database(entities = {User.class, BookType.class, Book.class, Bill.class, BillDetail.class},version = 2)
public abstract class AppDataBase extends RoomDatabase {
    public abstract AppDataDAO getDao();
    public static AppDataBase instance;

    public static AppDataBase getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context, AppDataBase.class, "BookManager.db")
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
    public static void destroyIntance(){
        instance=null;
    }
}

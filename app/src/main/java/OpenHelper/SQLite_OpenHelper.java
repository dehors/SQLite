package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SLAM24 on 10/13/2017.
 */

public class SQLite_OpenHelper extends SQLiteOpenHelper{
    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table users(_ID integer primary key autoincrement, Name text, District text, Email text, Password text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Allow it opened the DB
    public  void  open(){
        this.getReadableDatabase();
    }
    //Allow it closed the DB
    public  void  close_(){
        this.close();
    }
    //Allow it insert rows on BD
    public void insertRow(String name, String districti, String email, String password){
        ContentValues values = new ContentValues();
        values.put("Name",name);
        values.put("District",districti);
        values.put("Email",email);
        values.put("Password",password);

        this.getWritableDatabase().insert("users",null,values);
    }
    //Allow validate if user exist
    public Cursor login(String usu, String pass) throws SQLiteException{
        Cursor mcursor = null;
        mcursor = this.getReadableDatabase().query("users",new String[]{"_ID","Name","District","Email","Password"},"Email like '"+usu+"' and Password like '"+pass+"'",null,null,null,null);
        return mcursor;
    }
}

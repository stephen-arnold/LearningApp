package edu.unh.cs.cs791;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Tay on 3/10/2015.
 */
public class ObserveDB {
    //id
    //each time we enter something into our database
    // it is going to create a row, starting at 1, 2, 3, etc
    //just a way to reference that
    public static final String KEY_ROWID = "_id";
    public static final String KEY_CLASSROOM = "observe_classroom";
    public static final String KEY_BUILDING = "observe_building";



    // database name is going to reference our database
    public static final String DATABASE_NAME = "ObserveDB";
    //in our database we can hold multiple tables
    //this is our Observe Table, and it will hold the three values above
    public static final String DATABASE_TABLE = "ObserveTable"; //within
    public static final int DATABASE_VERSION = 2;


    private DbHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;




    //do not want to set up database on a user interface thread

    //instead do it here
    private static class DbHelper extends SQLiteOpenHelper
    {

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_CLASSROOM + " TEXT NOT NULL, " +
                            KEY_BUILDING + " TEXT NOT NULL);"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE );
            onCreate(db);
        }
    }
    public ObserveDB( Context c) {
        ourContext = c;
    }

    public ObserveDB open() throws SQLiteException {
        ourHelper = new DbHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        ourHelper.close();

    }

    public long createEntry(String classroom, String building) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_CLASSROOM, classroom);
        cv.put(KEY_BUILDING, building);

        return ourDatabase.insert(DATABASE_TABLE, null, cv);
    }


    public long deleteEntry(String tableName, String whereClause, String[] args) {

        return ourDatabase.delete(tableName, whereClause, args);
    }



    public String getData() {
        String[] columns = new String[] {KEY_ROWID, KEY_CLASSROOM, KEY_BUILDING};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
        String result = "";

        int iRow = c.getColumnIndex(KEY_ROWID);
        int iClassroom = c.getColumnIndex(KEY_CLASSROOM);
        int iBuilding = c.getColumnIndex(KEY_BUILDING);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            result +=
                    c.getString(iRow) + " " +
                    c.getString(iClassroom) + " " +
                    c.getString(iBuilding) + "\n";
        }

        return result;
    }



    public ArrayList<String> getDataArray() {
        String[] columns = new String[] {KEY_ROWID, KEY_CLASSROOM, KEY_BUILDING};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
        ArrayList<String>  result = new ArrayList<String>();

        int iRow = c.getColumnIndex(KEY_ROWID);
        int iClassroom = c.getColumnIndex(KEY_CLASSROOM);
        int iBuilding = c.getColumnIndex(KEY_BUILDING);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            result.add(c.getString(iClassroom) + " " + c.getString(iBuilding) );
        }

        return result;
    }


}

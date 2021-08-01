package com.xing.mita.movie.dao.bean;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.identityscope.IdentityScopeType;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/**
 * Master of DAO (schema version 31): knows all DAOs.
 */
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 31;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(Database db, boolean ifNotExists) {
        ChannelHistoryDao.createTable(db, ifNotExists);
        ConnectionDao.createTable(db, ifNotExists);
        DownloadDao.createTable(db, ifNotExists);
        HotListDao.createTable(db, ifNotExists);
        MovieHistoryDao.createTable(db, ifNotExists);
        ProgramDao.createTable(db, ifNotExists);
        SearchHistoryDao.createTable(db, ifNotExists);
        UpdateDao.createTable(db, ifNotExists);
        UserDao.createTable(db, ifNotExists);
    }

    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(Database db, boolean ifExists) {
        ChannelHistoryDao.dropTable(db, ifExists);
        ConnectionDao.dropTable(db, ifExists);
        DownloadDao.dropTable(db, ifExists);
        HotListDao.dropTable(db, ifExists);
        MovieHistoryDao.dropTable(db, ifExists);
        ProgramDao.dropTable(db, ifExists);
        SearchHistoryDao.dropTable(db, ifExists);
        UpdateDao.dropTable(db, ifExists);
        UserDao.dropTable(db, ifExists);
    }

    /**
     * WARNING: Drops all table on Upgrade! Use only during development.
     * Convenience method using a {@link DevOpenHelper}.
     */
    public static DaoSession newDevSession(Context context, String name) {
        Database db = new DevOpenHelper(context, name).getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }

    public DaoMaster(SQLiteDatabase db) {
        this(new StandardDatabase(db));
    }

    public DaoMaster(Database db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(ChannelHistoryDao.class);
        registerDaoClass(ConnectionDao.class);
        registerDaoClass(DownloadDao.class);
        registerDaoClass(HotListDao.class);
        registerDaoClass(MovieHistoryDao.class);
        registerDaoClass(ProgramDao.class);
        registerDaoClass(SearchHistoryDao.class);
        registerDaoClass(UpdateDao.class);
        registerDaoClass(UserDao.class);
    }

    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }

    /**
     * Calls {@link #createAllTables(Database, boolean)} in {@link #onCreate(Database)} -
     */
    public static abstract class OpenHelper extends DatabaseOpenHelper {
        public OpenHelper(Context context, String name) {
            super(context, name, SCHEMA_VERSION);
        }

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(Database db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }

    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name) {
            super(context, name);
        }

        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

}
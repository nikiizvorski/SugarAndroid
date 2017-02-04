# SugarAndroid
SugarORM, Simple MVP Architecture, Dagger, Butterknife

Okay what us SugarORM?

- It is intended to simplify the interaction with SQLite database in Android.
- It eliminates writing SQL queries to interact with SQLite db.
- It takes care of creating your database.
- It manages object relationships too.
- It provides you with clear and simple APIs for db operations

How to start add these?

-
    <meta-data
        android:name="DATABASE"
        android:value="noviqt.db" />
    <meta-data
        android:name="VERSION"
        android:value="2" />
    <meta-data
        android:name="QUERY_LOG"
        android:value="true" />
    <meta-data
        android:name="DOMAIN_PACKAGE_NAME"
        android:value="com.nikiizvorski.sugarandroid.sugar" />
-

Anything else? - Well yes add your App and make the Init of sugar

-
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    } 
-

Any problems with this probably Manifest?

- Yeah you will probably have some problems with this if you don't use some kind of dex guard. All your keys are visible.

Project Structre?

- MVP, Dagger, SugarORM

More Info?

- They provide most of the information but you can see everything clear in the project and how to properly use 
it without any spaggeti code. Left some for you up there to find ^^

- http://satyan.github.io/sugar/index.html

#### Author

- Niki Izvorski (nikiizvorski@gmail.com)

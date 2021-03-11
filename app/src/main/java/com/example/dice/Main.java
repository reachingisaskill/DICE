package com.example.dice;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;


public class Main extends AppCompatActivity implements RollListAdapter.Observer
{
    private RollListAdapter adapter;


    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );

        // Get the tool bar -> action bar for this activity
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        // Load the data
        this.loadConfig( new File( this.getExternalCacheDir().getPath(), getResources().getString( R.string.config_filename ) ) );

        // Load the list adapter to populate the drawer
        adapter = new RollListAdapter( getApplicationContext(), this );

        ListView drawerList = (ListView) findViewById( R.id.roll_list );
        drawerList.setAdapter( adapter );
    }


    @Override
    public void setDiceRoll( DiceRoll dr )
    {
    }


    private void loadConfig( File config_file )
    {
    }
}
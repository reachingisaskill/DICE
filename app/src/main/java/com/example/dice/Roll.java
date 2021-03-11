package com.example.dice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Roll extends Fragment
{
    private View theView;


    public View onCreateView( @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        theView = inflater.inflate( R.layout.fragment_roll, container, false );
        update( null );
        return theView;
    }


    public void update( @Nullable DiceRoll dr )
    {
        TextView message = theView.findViewById( R.id.current_roll_name );
        if ( dr == null )
        {
            message.setText( "NO ROLL SELECTED" );
        }
        else
        {
            message.setText( dr.name );
        }
    }
}
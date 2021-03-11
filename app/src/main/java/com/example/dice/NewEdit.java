package com.example.dice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class NewEdit extends Fragment
{
    private View theView;


    public View onCreateView( @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        theView = inflater.inflate( R.layout.fragment_newedit, container, false );
        return theView;
    }
}
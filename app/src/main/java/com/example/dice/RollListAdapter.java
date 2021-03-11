package com.example.dice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class RollListAdapter extends ArrayAdapter<DiceRoll> implements View.OnClickListener
{
    private Context theContext;
    private final Observer theObserver;
    private DiceRoll currentRoll;


    private static class ViewHolder
    {
        public TextView rollNameText;
        int idNumber;
    }


    public interface Observer
    {
        void setDiceRoll( DiceRoll d );
    }


    public RollListAdapter( Context c, Observer ob  )
    {
        super( c, R.layout.nav_item, new ArrayList<>() );

        this.add( new DiceRoll( "Test1", DiceRoll.RollType.COIN ) );
        this.add( new DiceRoll( "Test2", DiceRoll.RollType.DICE ) );

        theContext = c;
        theObserver = ob;

        notifyDataSetChanged();
    }


    public DiceRoll getCurrentRoll()
    {
        return currentRoll;
    }


    @Override
    public void onClick( View view )
    {
        int position = (int) view.getTag();

        //ViewHolder vh = (ViewHolder) view.getTag();
        //int position = vh.idNumber;
        DiceRoll object = getItem( position );

        currentRoll = object;
        theObserver.setDiceRoll( object );
    }


    @Override
    public View getView( int position, View convertView, ViewGroup parent )
    {
        currentRoll = getItem( position );
        ViewHolder viewHolder;

        View result;

        // If a starting view doesn't exist, create it.
        if ( convertView == null )
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from( theContext );
            convertView = inflater.inflate( R.layout.nav_item, parent, false );
            viewHolder.rollNameText = convertView.findViewById( R.id.roll_name );

            result = convertView;
            convertView.setTag( viewHolder );
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.rollNameText.setText( currentRoll.name );
        viewHolder.idNumber = position;
        viewHolder.rollNameText.setOnClickListener( this );
        viewHolder.rollNameText.setTag( position );

        return result;
    }
}

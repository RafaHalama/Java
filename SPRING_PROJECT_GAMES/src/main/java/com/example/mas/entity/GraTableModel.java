package com.example.mas.entity;



import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class GraTableModel extends AbstractTableModel {
private List<Gra> gry;

	private static final String[] columnNames =
	    {
	        "Id",
	        "Tytul"
	    };
	
	    public GraTableModel()
	    {
	    	gry = new ArrayList<Gra>();
	    }
	 
	    public GraTableModel(List<Gra> gry)
	    {
	        this.gry = gry;
	    }
	
	    @Override
	    public int getColumnCount()
	    {
	        return columnNames.length;
	    }
	 
	    @Override
	    public String getColumnName(int column)
	    {
	        return columnNames[column];
	    }
	 
	    @Override
	    public int getRowCount()
	    {
	        return gry.size();
	    }
	    
	    @Override
	    public Class getColumnClass(int column)
	    {
	        switch (column)
	        {
	        	case 0: return long.class;   
	            default: return String.class;
	        }
	    }
	     
	    
	    @Override
	    public boolean isCellEditable(int row, int column)
	    {
	        switch (column)
	        {
	            default: return false;
	        }
	    }
	     
	    @Override
	    public Object getValueAt(int row, int column)
	    {
	    	Gra gra = getgra(row);
	     
	        switch (column)
	        {
	        	case 0: return gra.getId();
	            case 1: return gra.getTytul(); 
	     
	            default: return null;
	        }
	    }
	     
	    public Gra getgra(int row)
	    {
	        return gry.get( row );
	    }
	  
}

package com.example.mas.entity;



import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class NosnikTableModel extends AbstractTableModel {
private List<Nośnik> nośniki;

	private static final String[] columnNames =
	    {
	        "Nazwa",
	        "Producent"
	    };
	
	    public NosnikTableModel()
	    {
	    	nośniki = new ArrayList<Nośnik>();
	    }
	 
	    public NosnikTableModel(List<Nośnik> nośniki)
	    {
	        this.nośniki = nośniki;
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
	        return nośniki.size();
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
	    	Nośnik nośnik = getnośnik(row);
	     
	        switch (column)
	        {
	        	case 0: return nośnik.getNazwa();
	            case 1: return nośnik.getProducent(); 
	     
	            default: return null;
	        }
	    }
	     
	    public Nośnik getnośnik(int row)
	    {
	        return nośniki.get( row );
	    }
	  
}

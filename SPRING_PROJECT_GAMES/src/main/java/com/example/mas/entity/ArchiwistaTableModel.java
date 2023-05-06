package com.example.mas.entity;



import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ArchiwistaTableModel extends AbstractTableModel {
private List<Archiwista> archiwisci;

	private static final String[] columnNames =
	    {
	    		
	        "Imie",
	        "Nazwisko",
	        "Nr Telefonu"
	    };
	
	    public ArchiwistaTableModel()
	    {
	    	archiwisci = new ArrayList<Archiwista>();
	    }
	 
	    public ArchiwistaTableModel(List<Archiwista> archiwisci)
	    {
	        this.archiwisci = archiwisci;
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
	        return archiwisci.size();
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
	    	Archiwista Archiwista = getArchiwista(row);
	     
	        switch (column)
	        {
	        	case 0: return Archiwista.getImie();
	            case 1: return Archiwista.getNazwisko(); 
	            case 2: return Archiwista.getNrTelefonu(); 

	            default: return null;
	        }
	    }
	     
	    public Archiwista getArchiwista(int row)
	    {
	        return archiwisci.get( row );
	    }
	  
}

package com.example.mas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.example.mas.entity.Archiwista;
import com.example.mas.entity.Gra;
import com.example.mas.entity.Nośnik;
import com.example.mas.entity.Raport;
import com.example.mas.entity.Studio;
import com.example.mas.service.ArchiwistaRecenzentRepository;
import com.example.mas.service.ArchiwistaRepository;
import com.example.mas.service.GraRepository;
import com.example.mas.service.NośnikRepository;
import com.example.mas.service.RaportRepository;
import com.example.mas.service.RecenzentRepository;
import com.example.mas.service.RecenzjaRepository;
import com.example.mas.service.SilnikgraficznyRepository;
import com.example.mas.service.StudioRepository;






@SpringBootApplication
public class Gui implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Gui.class);

	
	@Autowired
	private NośnikRepository nośnikRepository;
	@Autowired
	private GraRepository graRepository;
	@Autowired
	private StudioRepository studioRepository;
	@Autowired
	private SilnikgraficznyRepository silnikRepository;
	@Autowired
	private ArchiwistaRepository archiwistaRepository;
	@Autowired
	private RecenzentRepository recenzentRepository;
	@Autowired
	private RecenzjaRepository recenzjaRepository;
	@Autowired
	private RaportRepository raportRepository;
	@Autowired
	private ArchiwistaRecenzentRepository archiwistaRecenzentRepository;
	
	

	public String[] getListaGier() {
		
		List<Gra> x = graRepository.findAll();
		String[] pom = new String[x.size()]; 
		for(int i=0;i<x.size();i++){
			pom[i] = x.get(i).getTytul().toString();
		}
		
		return pom;
	}
	private Long id_gra;
	private String nazwa;
	private JFrame frame;
	private JTable listagier;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField textField;
	JList list;
	JLabel lblGraNr;
	JLabel label_6;
	JLabel lblDate;
	Date date;
	Iterator<Nośnik> it;
	Gra gra;
	Archiwista archiwista;
	JComboBox archlist;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(Gui.class).headless(false).run(args);	
	}
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("serial")
	@Override
	public void run(String... args) throws Exception {
		
			
		 archiwista = new Archiwista("Kacper", "Baran", date,"663 166 218", 5000);
			archiwistaRepository.save(archiwista);

			
			
		frame = new JFrame();
		frame.setBounds(100, 100, 1049, 659);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	
		
		
		JButton btn = new JButton("Wyszukaj Gry");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				

				List<Gra> x = graRepository.findAll();
				Object[][] pom = new Object[x.size()][x.size()]; 
				for(int i=0;i<x.size();i++){
					pom[i][0] = x.get(i).getId();
					pom[i][1] = x.get(i).getTytul().toString();
					
					
				}
				
				
				listagier.setModel(new DefaultTableModel(
					pom,
					new String[] {
						"id", "nazwa"
					}
				));
			}
		});
		btn.setBounds(0, 575, 129, 23);
		panel.add(btn);
		
		
		listagier = new JTable();
		listagier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				id_gra =  (Long) listagier.getValueAt(listagier.getSelectedRow(), 0);
				List<Gra> x = graRepository.findAll();
				
				Object[][] pom = new Object[x.size()][x.size()]; 
				for(int i=0;i<x.size();i++){
					if(x.get(i).getId() == id_gra){
						gra = x.get(i);
						nazwa = x.get(i).getTytul().toString();
						label_6.setText(nazwa);
						lblGraNr.setText(nazwa);
						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						 date = new Date();
						lblDate.setText((dateFormat.format(date)));
					try {
						table.setModel(new DefaultTableModel(
								new Object[][] {
									{"Nazwa", x.get(i).getTytul()},
									{"Cena", x.get(i).getCena()},
									{"Sprzedane Kopie", x.get(i).getIlosc_sprzedanych_kopii()},
									{"Dlugo\u015B\u0107 kampanii",x.get(i).hasKampania()},
									{"Ilo\u015B\u0107 Serwer\u00F3w", x.get(i).hasSerwery()},
									{"Rekord graczy ", x.get(i).hasIloscGraczy()},
								},
								new String[] {
									"Variable", "Value"
								}
							));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}
				}
				
				

				 pom = new Object[x.size()][x.size()]; 
				for(int i=0;i<x.size();i++){
					if(x.get(i).getId() == id_gra){
					
					
					try {
						table_1.setModel(new DefaultTableModel(
								new Object[][] {
									{"Nazwa", x.get(i).getStudio().getNazwa()},
									{"Lokalizacja", x.get(i).getStudio().getLokalizacja()},
									{"Ilo\u015B\u0107 pracownik\u00F3w", x.get(i).getStudio().getIlosc_pracownikow()},
								},
								new String[] {
									"New column", "New column"
								}
							));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}
				}
				
				pom = new Object[x.size()][x.size()]; 
				for(int i=0;i<x.size();i++){
					if(x.get(i).getId() == id_gra){
					
					
					try {
						table_3.setModel(new DefaultTableModel(
								new Object[][] {
									{"Nazwa", x.get(i).getSilnik().getNazwa()},
									{"Producent", x.get(i).getSilnik().getProducent()},
									{"Aktualna wersja",x.get(i).getSilnik().getAktualna_wersja()},
								},
								new String[] {
									"New column", "New column"
								}
							));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}
				}
				
				
				
				for(int i=0;i<x.size();i++){
					
					if(x.get(i).getId() == id_gra){
					Set<Nośnik> ar= x.get(i).getNośniki();
					List<Nośnik> mainList = new ArrayList<Nośnik>();
					mainList.addAll(ar);

					pom = new Object[mainList.size()][2]; 
					
					for(int j=0;j<mainList.size();j++){
					
					pom[j][0]= mainList.get(j).getNazwa();
					
					pom[j][1]= mainList.get(j).getProducent();
					
					}
					
					try {
						
					       
					       table_2.setModel(new DefaultTableModel(
									pom,
									new String[] {
										"New column", "New column"
									}
								));
					       
					    
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}
				}
				
				
				
				
			}
		});
	
		listagier.setBounds(20, 60, 150, 400);
		panel.add(listagier);
		
		table = new JTable();
	
		table.setBounds(182, 73, 215, 96);
		panel.add(table);
		
		table_1 = new JTable();
		
		table_1.setBounds(407, 73, 223, 48);
		panel.add(table_1);
		
		table_2 = new JTable();
		
		table_2.setBounds(648, 73, 165, 100);
		panel.add(table_2);
		
		
		/*JButton btnn = new JButton("Kolejny Nośnik");
		btnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Gra> x = graRepository.findAll();

				for(int i=0;i<x.size();i++){
					if(x.get(i).getId() == id_gra){
					Set<Nośnik> ar= x.get(i).getNośniki();
					List<Nośnik> mainList = new ArrayList<Nośnik>();
					mainList.addAll(ar);
					
					try {
						
					        
					       table_2.setModel(new DefaultTableModel(
									new Object[][] {
										{"Nazwa", mainList.get(1).getNazwa()},
										{"Producent", mainList.get(1).getProducent()},
									},
									new String[] {
										"New column", "New column"
									}
								));
					   
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					}
				}
			}
		});*/

		/*btnn.setBounds(648, 120, 165, 32);		
		panel.add(btnn);
		*/
		table_3 = new JTable();
		
		table_3.setBounds(841, 73, 182, 48);
		panel.add(table_3);
		
		 lblGraNr = new JLabel("Nazwa gry");
		lblGraNr.setBounds(271, 46, 100, 14);
		panel.add(lblGraNr);
		
		JLabel lblStudio = new JLabel("Studio");
		lblStudio.setBounds(500, 46, 46, 14);
		panel.add(lblStudio);
		
		JLabel lblNonik = new JLabel("Nośnik");
		lblNonik.setBounds(714, 46, 46, 14);
		panel.add(lblNonik);
		
		JLabel lblSilnikGraficzny = new JLabel("Silnik Graficzny");
		lblSilnikGraficzny.setBounds(897, 46, 113, 14);
		panel.add(lblSilnikGraficzny);
		
		JLabel lblStwrzRaport = new JLabel("STWÓRZ RAPORT");
		lblStwrzRaport.setBounds(561, 232, 111, 14);
		panel.add(lblStwrzRaport);
		
		JLabel lblDataStworzenia = new JLabel("Data Stworzenia");
		lblDataStworzenia.setBounds(500, 315, 101, 14);
		panel.add(lblDataStworzenia);
		
		JLabel lblOpis = new JLabel("Opis");
		lblOpis.setBounds(500, 381, 46, 14);
		panel.add(lblOpis);
		
		JLabel lblNazwaGry = new JLabel("Nazwa gry");
		lblNazwaGry.setBounds(500, 267, 61, 14);
		panel.add(lblNazwaGry);
		
		textField = new JTextField();
		textField.setBounds(530, 381, 332, 186);
		panel.add(textField);
		textField.setColumns(10);
		
		//.setText(getListaGier()[1]);
		
		JButton btnStwrzRaport = new JButton("Stwórz Raport");
		btnStwrzRaport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Raport raport = new Raport(date, textField.getText(), gra, archiwista);
				raportRepository.save(raport);
				log.info("Nowe raport został stworzony: " + raport);


			}
		});
		btnStwrzRaport.setBounds(773, 575, 129, 23);
		panel.add(btnStwrzRaport);
		
		 label_6 = new JLabel("Nazwa gry");
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(614, 267, 100, 14);
		panel.add(label_6);
		
		 lblDate = new JLabel("Date");
		lblDate.setBounds(626, 315, 150, 14);
		panel.add(lblDate);
		frame.setVisible(true);
		
	}
	
}

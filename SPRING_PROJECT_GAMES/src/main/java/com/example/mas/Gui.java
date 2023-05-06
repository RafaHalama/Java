package com.example.mas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.example.mas.entity.Archiwista;
import com.example.mas.entity.ArchiwistaTableModel;
import com.example.mas.entity.Gra;
import com.example.mas.entity.GraTableModel;
import com.example.mas.entity.NosnikTableModel;
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

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

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

	List<Gra> gry = new ArrayList<Gra>();
	List<Archiwista> archiwisci = new ArrayList<Archiwista>();

	private JFrame frame;
	private JTable listagier;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField textField;
	JLabel lblGraNr;
	JLabel label_6;
	JLabel lblDate;
	Date date;
	Iterator<Nośnik> it;
	Gra gra;
	Archiwista archiwista;
	private JTable table_4;

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

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		gry = graRepository.findAll();
		archiwisci = archiwistaRepository.findAll();

		frame = new JFrame();
		frame.setBounds(100, 100, 1690, 872);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btn = new JButton("Wyszukaj Gry");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraTableModel graModel = new GraTableModel(gry);
				listagier.setModel(graModel);

				listagier.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						gra = (Gra) graModel.getgra(listagier.getSelectedRow());

						label_6.setText(gra.getTytul());
						lblDate.setText(dateTime.format(formatter));

						try {

							table.setModel(new DefaultTableModel(
									new Object[][] { { gra.getTytul(), gra.getCena(), gra.getIlosc_sprzedanych_kopii(),
											gra.hasKampania(), gra.hasSerwery(), gra.hasIloscGraczy() }, },
									new String[] { "Nazwa", "Cena", "Sprzedane Kopie", "Dlugo\u015B\u0107 kampanii",
											"Ilo\u015B\u0107 Serwer\u00F3w", "Rekord graczy " }));
							
							table.getColumnModel().getColumn(0).setMinWidth(150);
						} catch (Exception e) {
							e.printStackTrace();
						}

						try {
							table_1.setModel(new DefaultTableModel(
									new Object[][] { { gra.getStudio().getNazwa(), gra.getStudio().getLokalizacja(),
											gra.getStudio().getIlosc_pracownikow() }, },
									new String[] { "Nazwa", "Lokalizacja", "Ilo\u015B\u0107 pracownik\u00F3w" }));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							try {
								List<Nośnik> nosniki = new ArrayList<Nośnik>();
								for (Nośnik n : gra.getNośniki()) {
									nosniki.add(n);
								}
								NosnikTableModel nosnikModel = new NosnikTableModel(nosniki);
								table_2.setModel(nosnikModel);

							} catch (Exception e) {
								e.printStackTrace();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						try {
							table_3.setModel(new DefaultTableModel(
									new Object[][] { { gra.getSilnik().getNazwa(), gra.getSilnik().getProducent(),
											gra.getSilnik().getAktualna_wersja() }, },
									new String[] { "Nazwa", "Producent", "Aktualna wersja" }));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						label_6.setVisible(true);
						lblDate.setVisible(true);

					}
				});
				listagier.getColumnModel().getColumn(0).setMaxWidth(30);


			}
		});
		btn.setBounds(61, 791, 129, 23);
		panel.add(btn);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(1140, 678, 426, 127);
		panel.add(scrollPane_5);

		table_4 = new JTable();
		scrollPane_5.setViewportView(table_4);
		table_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JLabel lblArchiwista_1 = new JLabel("Archiwista");
		lblArchiwista_1.setOpaque(true);
		lblArchiwista_1.setVisible(false);
		lblArchiwista_1.setBackground(Color.WHITE);
		lblArchiwista_1.setBounds(1254, 154, 332, 14);
		panel.add(lblArchiwista_1);

		ArchiwistaTableModel archModel = new ArchiwistaTableModel(archiwisci);
		table_4.setModel(archModel);
		table_4.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				archiwista = (Archiwista) archModel.getArchiwista(table_4.getSelectedRow());
				lblArchiwista_1.setText(archiwista.getImie() + archiwista.getNazwisko());

				lblArchiwista_1.setVisible(true);

			}

		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 167, 720, 39);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] { {}, {}, }, new String[] {}));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(318, 284, 720, 39);
		panel.add(scrollPane_2);

		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(318, 532, 720, 135);
		panel.add(scrollPane_3);

		table_2 = new JTable();
		scrollPane_3.setViewportView(table_2);
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(318, 408, 720, 39);
		panel.add(scrollPane_4);

		table_3 = new JTable();
		scrollPane_4.setViewportView(table_3);
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		
		table.setFocusable(false);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table_1.setFocusable(false);
		table_1.setRowSelectionAllowed(false);
		table_1.setEnabled(false);
		table_2.setFocusable(false);
		table_2.setRowSelectionAllowed(false);
		table_2.setEnabled(false);
		table_3.setFocusable(false);
		table_3.setRowSelectionAllowed(false);
		table_3.setEnabled(false);

		
		lblGraNr = new JLabel("Gra:");
		lblGraNr.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGraNr.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraNr.setBackground(Color.LIGHT_GRAY);
		lblGraNr.setOpaque(true);
		lblGraNr.setBounds(318, 132, 720, 36);
		panel.add(lblGraNr);

		JLabel lblStudio = new JLabel("Studio:");
		lblStudio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblStudio.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudio.setBackground(Color.LIGHT_GRAY);
		lblStudio.setOpaque(true);
		lblStudio.setBounds(318, 245, 720, 39);
		panel.add(lblStudio);

		JLabel lblNonik = new JLabel("Nośnik:");
		lblNonik.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNonik.setHorizontalAlignment(SwingConstants.CENTER);
		lblNonik.setBackground(Color.LIGHT_GRAY);
		lblNonik.setOpaque(true);
		lblNonik.setBounds(318, 493, 720, 39);
		panel.add(lblNonik);

		JLabel lblSilnikGraficzny = new JLabel("Silnik Graficzny:");
		lblSilnikGraficzny.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSilnikGraficzny.setHorizontalAlignment(SwingConstants.CENTER);
		lblSilnikGraficzny.setBackground(Color.LIGHT_GRAY);
		lblSilnikGraficzny.setOpaque(true);
		lblSilnikGraficzny.setBounds(318, 371, 720, 39);
		panel.add(lblSilnikGraficzny);

		JLabel lblStwrzRaport = new JLabel("STWÓRZ RAPORT");
		lblStwrzRaport.setOpaque(true);
		lblStwrzRaport.setBackground(Color.LIGHT_GRAY);
		lblStwrzRaport.setHorizontalAlignment(SwingConstants.CENTER);
		lblStwrzRaport.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblStwrzRaport.setBounds(1289, 36, 277, 49);
		panel.add(lblStwrzRaport);

		JLabel lblDataStworzenia = new JLabel("Data Stworzenia");
		lblDataStworzenia.setOpaque(true);
		lblDataStworzenia.setBackground(Color.LIGHT_GRAY);
		lblDataStworzenia.setBounds(1129, 129, 103, 14);
		panel.add(lblDataStworzenia);

		JLabel lblOpis = new JLabel("Opis");
		lblOpis.setOpaque(true);
		lblOpis.setBackground(Color.LIGHT_GRAY);
		lblOpis.setBounds(1129, 180, 103, 14);
		panel.add(lblOpis);

		JLabel lblNazwaGry = new JLabel("Nazwa gry");
		lblNazwaGry.setOpaque(true);
		lblNazwaGry.setBackground(Color.LIGHT_GRAY);
		lblNazwaGry.setBounds(1129, 106, 103, 14);
		panel.add(lblNazwaGry);

		textField = new JTextField();
		textField.setBounds(1254, 176, 332, 186);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnStwrzRaport = new JButton("Stwórz Raport");
		btnStwrzRaport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (archiwista == null || gra == null) {
						JOptionPane.showMessageDialog(null, "Wybierz Grę i Archiwistę aby móc utworzyć raport");
					} else {
						date = new SimpleDateFormat("dd/MM/yyyy").parse(lblDate.getText());

						Raport raport = new Raport(date, textField.getText(), gra, archiwista);
						raportRepository.save(raport);
						log.info("Nowe raport został stworzony: " + raport);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStwrzRaport.setBounds(1457, 371, 129, 23);
		panel.add(btnStwrzRaport);

		label_6 = new JLabel("Nazwa gry");
		label_6.setOpaque(true);
		label_6.setVisible(false);

		label_6.setBackground(Color.WHITE);
		label_6.setBounds(1254, 106, 332, 14);
		panel.add(label_6);

		lblDate = new JLabel("Date");
		lblDate.setVisible(false);
		lblDate.setOpaque(true);
		lblDate.setBackground(Color.WHITE);
		lblDate.setBounds(1254, 129, 332, 14);
		panel.add(lblDate);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(1110, 11, 9, 833);
		panel.add(separator);

		JLabel lblWyszukajGry = new JLabel("LISTA GIER");
		lblWyszukajGry.setOpaque(true);
		lblWyszukajGry.setForeground(Color.BLACK);
		lblWyszukajGry.setBackground(Color.LIGHT_GRAY);
		lblWyszukajGry.setHorizontalAlignment(SwingConstants.CENTER);
		lblWyszukajGry.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblWyszukajGry.setBounds(23, 46, 198, 49);
		panel.add(lblWyszukajGry);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(235, 0, 9, 833);
		panel.add(separator_1);

		JLabel lblOpisGry = new JLabel("OPIS GRY");
		lblOpisGry.setOpaque(true);
		lblOpisGry.setBackground(Color.LIGHT_GRAY);
		lblOpisGry.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpisGry.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblOpisGry.setBounds(547, 46, 277, 49);
		panel.add(lblOpisGry);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 131, 198, 649);
		panel.add(scrollPane_1);

		listagier = new JTable();
		scrollPane_1.setViewportView(listagier);
		listagier.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblWyszukajGry.setLabelFor(listagier);

		JLabel lblWybrArchiwisty = new JLabel("Wybór archiwisty");
		lblWybrArchiwisty.setBackground(Color.LIGHT_GRAY);
		lblWybrArchiwisty.setBounds(1140, 653, 129, 14);
		panel.add(lblWybrArchiwisty);

		JLabel lblArchiwista = new JLabel("Archiwista");
		lblArchiwista.setOpaque(true);
		lblArchiwista.setBackground(Color.LIGHT_GRAY);
		lblArchiwista.setBounds(1129, 154, 103, 14);
		panel.add(lblArchiwista);

		frame.setVisible(true);

	}
}

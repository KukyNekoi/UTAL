

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputAdapter;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
public class Interfaz {

	private JFrame mainWindow = null;  //  @jve:decl-index=0:visual-constraint="90,24"
	private JPanel jContentPane = null;
	private JTabbedPane tabPanel = null;
	private JPanel workspacePanel = null;
	private JButton save01 = null;
	private JButton edit01 = null;
	private JButton erase01 = null;
	private JTextArea instructions01 = null;
	private JPanel glContainer = null;
	private JPanel exclusionPanel = null;
	private JButton save02 = null;
	private JButton edit02 = null;
	private JButton erase02 = null;
	private JTextArea instrucions02 = null;
	private SuperCanvas lienzo = null;
	private JPanel lastPanel = null;
	private JButton startButton = null;
	private JTextArea instrucions03 = null;
	private JLabel Posicion = null;
	private JFrame errorWindow = null;  //  @jve:decl-index=0:visual-constraint="968,110"
	private JPanel jContentPane1 = null;
	private JButton Exit = null;
	private JLabel errorMessage = null;
	private SistemaDeControl sis;
	private JCheckBox jCheckBox = null;
	public boolean seteando1 = false;
	public boolean seteando2 = false;
	public boolean seteando3 = false;
	//private JTextArea puntoInicioText = null;
	private Graphics graficos = null;  //  @jve:decl-index=0:
	private JButton erase021 = null;
	private JLabel Status = null;
	private FileDialog guardarCargar = null;
	private JButton fileLoad01 = null;
	private JButton fileLoad2 = null;
	private JButton fileLoad3 = null;
	private JButton fileSave1 = null;
	private JButton fileSave2 = null;
	private JButton fileSave3 = null;
	private JLabel jLabel = null;
	private JLabel coordenadas = null;
	/**
	 * 
	 */
	public Interfaz(SistemaDeControl sis){
		sis.printLog("Interfaz -> Iniciando GUI");
		this.sis = sis;
		this.mainWindow = this.getMainWindow();
		this.lienzo.obtenerGraficos();
		System.out.println(this.graficos);
		this.lienzo.createBufferStrategy(5);
		this.errorWindow = this.getErrorWindow();
		this.lienzo.pintar();
		sis.printLog("Interfaz -> GUI Iniciada");
	}

	/**
	 * This method initializes mainWindow	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getMainWindow() {
		sis.printLog("Interfaz -> Iniciando vantana principal");
		if (mainWindow == null) {
			mainWindow = new JFrame();
			mainWindow.setSize(new Dimension(845, 446));
			mainWindow.setTitle("BifCo Panel Repair");
			mainWindow.setContentPane(getJContentPane());
			mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainWindow.setVisible(true);
			mainWindow.addFocusListener(new java.awt.event.FocusListener() {
					public void focusGained(java.awt.event.FocusEvent e) {
						repintarLienzo();
					}
					public void focusLost(java.awt.event.FocusEvent e) {
						repintarLienzo();
					}
			});
		}
		return mainWindow;
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Status = new JLabel();
			Status.setBounds(new Rectangle(540, 375, 271, 16));
			Status.setFont(new Font("Dialog", Font.PLAIN, 12));
			Status.setHorizontalAlignment(SwingConstants.RIGHT);
			Status.setText("");
			Posicion = new JLabel();
			Posicion.setBounds(new Rectangle(120, 375, 146, 20));
			Posicion.setText("JLabel");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTabPanel(), null);
			jContentPane.add(getJPanel1(), null);
			jContentPane.add(Posicion, null);
			jContentPane.add(Status, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes tabPanel	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getTabPanel() {
		if (tabPanel == null) {
			tabPanel = new JTabbedPane();
			tabPanel.setBounds(new Rectangle(405, 45, 406, 301));
			tabPanel.setName("Area de Exclusion");
			tabPanel.setEnabled(true);
			tabPanel.addTab("Area de Trabajo", null, getWorkspacePanel(), null);
			tabPanel.addTab("Area de Exclusion", null, getExclusionPanel(), null);
			tabPanel.addTab("Iniciar Trazado", null, getLastPanel(), null);
		}
		return tabPanel;
	}

	/**
	 * This method initializes workspacePanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getWorkspacePanel() {
		if (workspacePanel == null) {
			workspacePanel = new JPanel();
			workspacePanel.setLayout(null);
			workspacePanel.add(getSave01(), null);
			workspacePanel.add(getJButton1(), null);
			workspacePanel.add(getJButton2(), null);
			workspacePanel.add(getJTextArea(), null);
			workspacePanel.add(getFileLoad01(), null);
			workspacePanel.add(getFileSave1(), null);
		}
		return workspacePanel;
	}

	/**
	 * This method initializes save01	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSave01() {
		if (save01 == null) {
			save01 = new JButton();
			save01.setBounds(new Rectangle(15, 15, 136, 16));
			save01.setEnabled(false);
			save01.setText("Guardar");
			save01.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					seteando1 = false;
					startButton.setEnabled(true);
					fileLoad3.setEnabled(true);
					edit01.setEnabled(false);
					Status.setText("Area de trabajo seleccionada!");
					save01.setEnabled(false);
					fileSave1.setEnabled(true);
					fileLoad01.setEnabled(false);
					repintarLienzo();
				}
			});
		}
		return save01;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (edit01 == null) {
			edit01 = new JButton();
			edit01.setBounds(new Rectangle(15, 45, 136, 16));
			edit01.setText("Editar");
			edit01.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					seteando1 = true;
					seteando2 = false;
					seteando3 = false;
					save01.setEnabled(true);
					erase01.setEnabled(true);
					edit01.setEnabled(false);
					fileLoad01.setEnabled(false);
					fileSave1.setEnabled(false);
					Status.setText("Seleccionando area de trabajo...");
					repintarLienzo();
				}
			});
		}
		return edit01;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (erase01 == null) {
			erase01 = new JButton();
			erase01.setBounds(new Rectangle(15, 75, 136, 16));
			erase01.setEnabled(false);
			erase01.setText("Borrar");
			erase01.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					sis.zonas.borrarZT();
					save01.setEnabled(false);
					edit01.setEnabled(true);
					Status.setText("Area de trabajo borrada!");
					erase01.setEnabled(false);
					fileSave1.setEnabled(false);
					fileLoad01.setEnabled(true);
					startButton.setEnabled(false);
					repintarLienzo();
				}
			});
		}
		return erase01;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (instructions01 == null) {
			instructions01 = new JTextArea();
			instructions01.setBounds(new Rectangle(165, 15, 211, 226));
			instructions01.setText("Instrucciones del area de \n" +
					"trabajo:\n" +
					"\n" +
					"Para iniciar el proseso de\n" +
					"seleccion, haga click en el \n" +
					"boton 'Editar'" +
					"\n" +
					"Luego clic en la zona de dibujado, \n" +
					"para iniciar una polilinea para\n" +
					"demarcar el area de trabajo.\n" +
					"\n" +
					"Finalmente, haga clic en guardar para\n" +
			"pasar a la siguente etapa.");
			instructions01.setEditable(false);
			instructions01.setLineWrap(true);
		}
		return instructions01;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (glContainer == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.gridx = 0;
			glContainer = new JPanel();
			glContainer.setLayout(new GridBagLayout());
			glContainer.setPreferredSize(new Dimension(255, 255));
			glContainer.setLocation(new Point(30, 30));
			glContainer.setSize(new Dimension(331, 331));
			glContainer.add(getCanvas(), gridBagConstraints);
		}
		return glContainer;
	}

	/**
	 * This method initializes exclusionPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getExclusionPanel() {
		if (exclusionPanel == null) {
			exclusionPanel = new JPanel();
			exclusionPanel.setLayout(null);
			exclusionPanel.setEnabled(true);
			exclusionPanel.setVisible(true);
			exclusionPanel.add(getJButton3(), null);
			exclusionPanel.add(getJButton11(), null);
			exclusionPanel.add(getJButton21(), null);
			exclusionPanel.add(getJTextArea1(), null);
			exclusionPanel.add(getJCheckBox(), null);
			exclusionPanel.add(getFileLoad2(), null);
			exclusionPanel.add(getFileSave2(), null);
		}
		return exclusionPanel;
	}

	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (save02 == null) {
			save02 = new JButton();
			save02.setBounds(new Rectangle(15, 15, 136, 16));
			save02.setEnabled(false);
			save02.setText("Guardar");
			save02.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					seteando2 = false;
					save02.setEnabled(false);
					edit02.setEnabled(false);
					fileSave2.setEnabled(true);
					fileLoad2.setEnabled(false);
					save02.setEnabled(false);
					erase02.setEnabled(true);
					Status.setText("Area de exclusion seleccionada!");
					repintarLienzo();
				}
			});
		}
		return save02;
	}

	/**
	 * This method initializes jButton11	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton11() {
		if (edit02 == null) {
			edit02 = new JButton();
			edit02.setBounds(new Rectangle(15, 45, 136, 16));
			edit02.setEnabled(false);
			edit02.setText("Editar");
			edit02.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					seteando1 = false;
					seteando2 = true;
					seteando3 = false;
					save02.setEnabled(true);
					edit02.setEnabled(false);
					fileLoad2.setEnabled(false);
					fileSave2.setEnabled(false);
					Status.setText("Seleccionando area de exclusion!");
					repintarLienzo();
				}
			});
		}
		return edit02;
	}

	/**
	 * This method initializes jButton21	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton21() {
		if (erase02 == null) {
			erase02 = new JButton();
			erase02.setBounds(new Rectangle(15, 75, 136, 16));
			erase02.setEnabled(false);
			erase02.setText("Borrar");
			erase02.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					save02.setEnabled(false);
					sis.zonas.borrarEZ();
					edit02.setEnabled(true);
					erase02.setEnabled(false);
					fileLoad2.setEnabled(true);
					fileSave2.setEnabled(false);
					Status.setText("Area de exclusion borrada!");
					repintarLienzo();
				}
			});
		}
		return erase02;
	}

	/**
	 * This method initializes jTextArea1	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea1() {
		if (instrucions02 == null) {
			instrucions02 = new JTextArea();
			instrucions02.setBounds(new Rectangle(165, 15, 211, 226));
			instrucions02.setEditable(false);
			instrucions02.setLineWrap(true);
			instrucions02.setText("Instrucciones del area de \nexclusion:\n\nPara iniciar el proseso de\nseleccion, haga click en el \nboton 'Editar'\nLuego clic en la zona de dibujado, \npara iniciar una polilinea para\ndemarcar el area de trabajo.\n\nFinalmente, haga clic en guardar para\npasar a la siguente etapa.");
		}
		return instrucions02;
	}

	/**
	 * This method initializes Canvas	
	 * 	
	 * @return javax.media.opengl.awt.Canvas	
	 */
	private Canvas getCanvas() {
		if (lienzo == null) {
			lienzo = new SuperCanvas();
			lienzo.obtenerGraficos();
			lienzo.sis = sis;
			lienzo.addMouseListener(new MouseGlListener());
			lienzo.addMouseMotionListener(new MousePositionListener());
			graficos = lienzo.getGraphics();
			
		}
		return lienzo;
	}

	/**
	 * This method initializes lastPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getLastPanel() {
		if (lastPanel == null) {
			coordenadas = new JLabel();
			coordenadas.setBounds(new Rectangle(45, 150, 76, 16));
			coordenadas.setText("JLabel");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(30, 135, 106, 16));
			jLabel.setText("Punto de Inicio:");
			lastPanel = new JPanel();
			lastPanel.setLayout(null);
			lastPanel.setName("");
			lastPanel.setEnabled(true);
			lastPanel.add(getJButton31(), null);
			lastPanel.add(getJTextArea11(), null);
			//lastPanel.add(puntoInicioText, null);
			lastPanel.add(getErase021(), null);
			lastPanel.add(getFileLoad3(), null);
			lastPanel.add(getFileSave3(), null);
			lastPanel.add(jLabel, null);
			lastPanel.add(coordenadas, null);
		}
		return lastPanel;
	}

	/**
	 * This method initializes jButton31	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton31() {
		if (startButton == null) {
			startButton = new JButton();
			startButton.setBounds(new Rectangle(15, 15, 136, 16));
			startButton.setActionCommand("");
			startButton.setEnabled(false);
			startButton.setText("Iniciar");
			startButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(seteando1 ==false && seteando2 ==false && seteando3 ==false){
						startButton.setEnabled(false);
						Status.setText("Trazando ruta de reparacion...");
						fileLoad3.setEnabled(false);
						fileSave3.setEnabled(true);
						sis.controlador.iniciaReparacion();
						sis.controlador = new Controlador(sis, sis.almacenamiento);
						Status.setText("Reparacion completa.");
						repintarLienzo();
						erase021.setEnabled(true);
					}
				}
			});
		}
		return startButton;
	}

	/**
	 * This method initializes jTextArea11	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea11() {
		if (instrucions03 == null) {
			instrucions03 = new JTextArea();
			instrucions03.setBounds(new Rectangle(165, 15, 211, 226));
			instrucions03.setEditable(false);
			instrucions03.setLineWrap(true);
			instrucions03.setText("Instrucciones para iniciar el \ntrazado:" +
					"\n" +
					"Haga click en el boton iniciar," +
					"para comenzar a trazar la simulacion" +
			"de trazado.");
		}
		return instrucions03;
	}

	class MousePositionListener implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			Posicion.setText("X: " + e.getX() + " Y: " + e.getY());
			lienzo.pintar();
			lienzo.graficos.setColor(Color.CYAN);
			if((seteando2)&&(sis.zonas.coordEZ.npoints >= 1)){
				lienzo.graficos.drawLine(e.getX(), e.getY(), sis.zonas.coordEZ.xpoints[0], sis.zonas.coordEZ.ypoints[0]);
				lienzo.graficos.drawLine(e.getX(), e.getY(), sis.zonas.coordEZ.xpoints[sis.zonas.coordEZ.npoints-1], sis.zonas.coordEZ.ypoints[sis.zonas.coordEZ.npoints-1]);
			}
			if((seteando1)&&(sis.zonas.coordZT.npoints >= 1)){
				lienzo.graficos.drawLine(e.getX(), e.getY(), sis.zonas.coordZT.xpoints[0], sis.zonas.coordZT.ypoints[0]);
				lienzo.graficos.drawLine(e.getX(), e.getY(), sis.zonas.coordZT.xpoints[sis.zonas.coordZT.npoints-1], sis.zonas.coordZT.ypoints[sis.zonas.coordZT.npoints-1]);
			}
		}
		
	}
	class MouseGlListener implements MouseListener{

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			if(seteando1==true)
				sis.zonas.coordZT.addPoint(e.getX(), e.getY());
			if(seteando2==true)
				sis.zonas.coordEZ.addPoint(e.getX(), e.getY());
			
			if(!seteando1&&!seteando2){
				sis.puntoInicial.setLocation(e.getX(), e.getY());
				

				if((sis.zonas.coordEZ.contains(e.getX(), e.getY())== false)&&(sis.zonas.coordZT.contains(e.getX(), e.getY()))){
					startButton.setEnabled(true);	
					coordenadas.setText("X: " + e.getX() + " Y: " +e.getX());
				}
				else{
					startButton.setEnabled(false);
					coordenadas.setText("Error");
				}
			}
			lienzo.pintar();
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			Posicion.setText("X: " + e.getX() + " Y: " + e.getY());
			lienzo.pintar();
			if((seteando2)&&(sis.zonas.coordEZ.npoints > 1)){
				lienzo.graficos.setColor(Color.RED);
				lienzo.graficos.drawLine(sis.zonas.coordEZ.xpoints[sis.zonas.coordEZ.npoints-1], 
						sis.zonas.coordEZ.ypoints[sis.zonas.coordEZ.npoints-1], sis.zonas.coordEZ.xpoints[0],
						sis.zonas.coordEZ.ypoints[0]);
			}
			if((seteando1)&&(sis.zonas.coordZT.npoints > 1)){
				lienzo.graficos.setColor(Color.BLUE);
				lienzo.graficos.drawLine(sis.zonas.coordZT.xpoints[sis.zonas.coordZT.npoints-1], 
						sis.zonas.coordZT.ypoints[sis.zonas.coordZT.npoints-1], sis.zonas.coordZT.xpoints[0],
						sis.zonas.coordZT.ypoints[0]);
			}
			

		}

	}

	/**
	 * This method initializes errorWindow	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getErrorWindow() {
		sis.printLog("Interfaz -> Iniciando ventana de error");
		if (errorWindow == null) {
			errorWindow = new JFrame();
			errorWindow.setSize(new Dimension(377, 159));
			errorWindow.setTitle("Error!");
			errorWindow.setContentPane(getJContentPane1());
		}
		return errorWindow;
	}

	/**
	 * This method initializes jContentPane1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane1() {
		if (jContentPane1 == null) {
			errorMessage = new JLabel();
			errorMessage.setBounds(new Rectangle(45, 30, 286, 46));
			errorMessage.setFont(new Font("Dialog", Font.PLAIN, 12));
			errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
			errorMessage.setHorizontalTextPosition(SwingConstants.CENTER);
			errorMessage.setText("JLabel");
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(null);
			jContentPane1.add(getExit(), null);
			jContentPane1.add(errorMessage, null);
		}
		return jContentPane1;
	}

	/**
	 * This method initializes Exit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getExit() {
		if (Exit == null) {
			Exit = new JButton();
			Exit.setBounds(new Rectangle(108, 92, 151, 26));
			Exit.setText("Ok");
			Exit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					errorWindow.setVisible(false);
				}
			});
		}
		return Exit;
	}

	public void showErrorMessage(String error){
		errorMessage.setText(error);
		sis.printLog("Interfaz -> Error Desplegado");
		sis.printLog("Error!: " + error);
		errorWindow.setVisible(true);
	}

	/**
	 * This method initializes jCheckBox	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox() {
		if (jCheckBox == null) {
			jCheckBox = new JCheckBox();
			jCheckBox.setBounds(new Rectangle(20, 242, 183, 27));
			jCheckBox.setText("Habilitar Exclusion");
			jCheckBox.addItemListener(new java.awt.event.ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent e) {
					//save02.setEnabled(jCheckBox.isSelected());
					edit02.setEnabled(jCheckBox.isSelected()&&(sis.zonas.coordZT.npoints>=3));
					sis.tipoReparacion(jCheckBox.isSelected()&&(sis.zonas.coordZT.npoints>=3));
					fileLoad2.setEnabled(jCheckBox.isSelected()&&(sis.zonas.coordZT.npoints>=3));
					repintarLienzo();
				}
			});
		}
		return jCheckBox;
	}
	
	public void repintarLienzo(){
		this.lienzo.pintar();
	}
	
	class SuperCanvas extends Canvas{
		Graphics graficos;
		SistemaDeControl sis;
		
		public void pintar() {
			this.graficos.setColor(Color.WHITE);
			this.graficos.fillRect(0, 0, super.getWidth()-1, super.getHeight()-1);
			this.graficos = this.getGraphics();
			// TODO Auto-generated method stub
			this.graficos.setColor(Color.BLACK);
			this.graficos.drawRect(0, 0, super.getWidth()-1, super.getHeight()-1);
			this.graficos.setColor(Color.BLUE);
			
			if(sis.zonas.coordZT.npoints>1){
				System.out.println("dibujando ZdT");
				graficos.drawPolyline(sis.zonas.coordZT.xpoints, sis.zonas.coordZT.ypoints, sis.zonas.coordZT.npoints);
			}
			this.graficos.setColor(Color.RED);
			if(sis.zonas.coordEZ.npoints>1){
				graficos.drawPolyline(sis.zonas.coordEZ.xpoints, sis.zonas.coordEZ.ypoints, sis.zonas.coordEZ.npoints);
			}
			this.graficos.setColor(Color.GRAY);
			if(sis.puntoInicial != null){
				graficos.fillOval(sis.puntoInicial.x-2, sis.puntoInicial.y-2, 4, 4);
			}
			this.graficos.setColor(Color.GREEN);
			if(sis.almacenamiento.puntos.npoints>2){
				graficos.drawPolyline(sis.almacenamiento.puntos.xpoints, sis.almacenamiento.puntos.ypoints, sis.almacenamiento.puntos.npoints);
			}
			
			if((!seteando2)&&(sis.zonas.coordEZ.npoints > 1)){
				lienzo.graficos.setColor(Color.RED);
				lienzo.graficos.drawLine(sis.zonas.coordEZ.xpoints[sis.zonas.coordEZ.npoints-1], 
						sis.zonas.coordEZ.ypoints[sis.zonas.coordEZ.npoints-1], sis.zonas.coordEZ.xpoints[0],
						sis.zonas.coordEZ.ypoints[0]);
			}
			if((!seteando1)&&(sis.zonas.coordZT.npoints > 1)){
				lienzo.graficos.setColor(Color.BLUE);
				lienzo.graficos.drawLine(sis.zonas.coordZT.xpoints[sis.zonas.coordZT.npoints-1], 
						sis.zonas.coordZT.ypoints[sis.zonas.coordZT.npoints-1], sis.zonas.coordZT.xpoints[0],
						sis.zonas.coordZT.ypoints[0]);
			}
		}
		
		public void obtenerGraficos(){
			this.sis = sis;
			this.graficos = super.getGraphics();
		}
	}

	/**
	 * This method initializes erase021	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getErase021() {
		if (erase021 == null) {
			erase021 = new JButton();
			erase021.setBounds(new Rectangle(15, 45, 136, 16));
			erase021.setEnabled(false);
			erase021.setText("Borrar");
			erase021.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					sis.almacenamiento.borrarPuntos();
					fileLoad3.setEnabled(true);
					fileSave3.setEnabled(false);
					startButton.setEnabled(sis.zonas.coordZT.npoints>2);
					repintarLienzo();
				}
			});
		}
		return erase021;
	}

	/**
	 * This method initializes fileLoad01	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getFileLoad01() {
		if (fileLoad01 == null) {
			fileLoad01 = new JButton();
			fileLoad01.setBounds(new Rectangle(15, 105, 136, 16));
			fileLoad01.setText("Abrir area");
			fileLoad01.setEnabled(true);
			fileLoad01.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					sis.zonas.borrarZT();
					try {
						sis.zonas.coordZT = sis.almacenamiento.abrirZTE(abrirDialogo(FileDialog.LOAD, "Abriendo zona de trabajo", "bzt"));
					} 
					catch (IOException e1) {
						showErrorMessage("Fallo en abrir archivo");
						return;
					}
					seteando2 = false;
					seteando3 = false;
					erase01.setEnabled(true);
					fileLoad3.setEnabled(true);
					seteando1 = false;
					startButton.setEnabled(true);
					edit01.setEnabled(false);
					save01.setEnabled(false);
					fileSave1.setEnabled(true);
					fileLoad01.setEnabled(false);
					repintarLienzo();
					Status.setText("Area de trabajo cargada!");
				}
			});
		}
		return fileLoad01;
	}
	
	private String abrirDialogo(int tipo, String titulo, final String filter){

		FileDialog dialogo = new FileDialog(mainWindow, titulo, tipo);
		dialogo.setFilenameFilter(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if(name.contains("." + filter)){
					return true;
				}
				return false;
			}
		});
		dialogo.setVisible(true);
		return dialogo.getDirectory() + dialogo.getFile();
	}
	/**
	 * This method initializes fileLoad2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getFileLoad2() {
		if (fileLoad2 == null) {
			fileLoad2 = new JButton();
			fileLoad2.setBounds(new Rectangle(15, 105, 136, 16));
			fileLoad2.setText("Abir Area");
			fileLoad2.setEnabled(false);
			fileLoad2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					sis.zonas.borrarEZ();
					try {
						sis.zonas.coordEZ = sis.almacenamiento.abrirZTE(abrirDialogo(FileDialog.LOAD, "Abriendo zona de exclusion", "bze"));
					} 
					catch (IOException e1) {
						showErrorMessage("Fallo en abrir archivo");
						return;
					}
					erase02.setEnabled(false);
					seteando1 = false;
					seteando3 = false;
					save02.setEnabled(true);
					edit02.setEnabled(false);
					erase01.setEnabled(true);
					seteando2 = false;
					edit02.setEnabled(false);
					fileSave2.setEnabled(true);
					fileLoad2.setEnabled(false);
					save02.setEnabled(false);
					Status.setText("Area de exclusion cargada!");
					repintarLienzo();
				}
			});
		}
		return fileLoad2;
	}

	/**
	 * This method initializes fileLoad3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getFileLoad3() {
		if (fileLoad3 == null) {
			fileLoad3 = new JButton();
			fileLoad3.setBounds(new Rectangle(15, 75, 136, 16));
			fileLoad3.setText("Abrir Trazado");
			fileLoad3.setEnabled(false);
			fileLoad3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(seteando1 ==false && seteando2 ==false && seteando3 ==false){
						sis.almacenamiento.borrarPuntos();
						try {
							sis.almacenamiento.abrirTrayectoria(abrirDialogo(FileDialog.LOAD, "Abriendo trayectorias...", "btp"));
						} catch (IOException e1) {
							showErrorMessage("Fallo en abrir archivo");
							return;
						}
						startButton.setEnabled(false);
						fileLoad3.setEnabled(false);
						fileSave3.setEnabled(true);
						sis.controlador = new Controlador(sis, sis.almacenamiento);
						repintarLienzo();
						Status.setText("Puntos de traza cargados!");
						erase021.setEnabled(true);
					}
				}
			});
		}
		return fileLoad3;
	}

	/**
	 * This method initializes fileSave1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getFileSave1() {
		if (fileSave1 == null) {
			fileSave1 = new JButton();
			fileSave1.setBounds(new Rectangle(15, 135, 136, 16));
			fileSave1.setText("Guardar area");
			fileSave1.setEnabled(false);
			fileSave1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						sis.almacenamiento.guardarZTE(
								abrirDialogo(FileDialog.SAVE, "Guardando zona de trabajo", "bzt")+".bzt", 
								sis.zonas.coordZT
								);
					} 
					catch (IOException e1) {
						showErrorMessage("Fallo en guardar archivo");
						return;
					}
					Status.setText("Area de trabajo guardada!");
				}
			});
		}
		return fileSave1;
	}

	/**
	 * This method initializes fileSave2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getFileSave2() {
		if (fileSave2 == null) {
			fileSave2 = new JButton();
			fileSave2.setBounds(new Rectangle(15, 135, 136, 16));
			fileSave2.setText("Guardar area");
			fileSave2.setEnabled(false);
			fileSave2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						sis.almacenamiento.guardarZTE(
								abrirDialogo(FileDialog.SAVE, "Guardando zona de trabajo", "bze")+".bze", 
								sis.zonas.coordEZ
								);
					} 
					catch (IOException e1) {
						showErrorMessage("Fallo en guardar archivo");
						return;
					}
					Status.setText("Area de exclusion guardada!");
				}
			});
		}
		return fileSave2;
	}

	/**
	 * This method initializes fileSave3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getFileSave3() {
		if (fileSave3 == null) {
			fileSave3 = new JButton();
			fileSave3.setBounds(new Rectangle(15, 105, 136, 16));
			fileSave3.setText("Guardar trazado");
			fileSave3.setEnabled(false);
			fileSave3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						sis.almacenamiento.guardarTrayectoria(abrirDialogo(FileDialog.SAVE, "Guardando trayectoria", "btp")+".btp");
					} catch (IOException e1) {
						showErrorMessage("Fallo en guardar archivo");
						return;
					}
					Status.setText("Puntos de traza guardados!");
				}
			});
		}
		return fileSave3;
	}

}



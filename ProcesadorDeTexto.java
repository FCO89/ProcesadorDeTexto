package PracticaProcesadorDeTexto; 

import javax.swing.*; 
import javax.swing.text.*; 
import java.awt.*; 

//Primera version del programa

public class ProcesadorDeTexto {

	public static void main(String[] args) {
		
		FrameProcesador frame=new FrameProcesador(); 
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		frame.setVisible(true); 

	}

}


@SuppressWarnings("serial")
class FrameProcesador extends JFrame{ 
	
	public FrameProcesador(){ 
		
		final int x=600,y=350; 
		
		setTitle("Practica: Procesador de texto"); 
		
		setSize(x, y); 
		
		setLocationRelativeTo(null); 
		
		PanelProcesador panel=new PanelProcesador(); 
		
		add(panel);
	}
} 

@SuppressWarnings("serial")
class PanelProcesador extends JPanel{  
	
	JTextPane textarea; 
	
	JMenu fuente,estilos,tamanio; 
	
	Font letras;
	
	public PanelProcesador(){ 
		
		setLayout(new BorderLayout()); 
		
		JPanel panel2=new JPanel(new FlowLayout(FlowLayout.LEFT)); //PONER LOS ELEMENTOS DEL PANEL2 A LA IZQUIERDA, USANDO LA CLASE FlowLayout
		
		JMenuBar mibarra=new JMenuBar(); 
		//--------DEFINIR LOS OBJETOS DE MENU-------\\
		fuente=new JMenu("Fuente"); 
		
		estilos=new JMenu("Estilos"); 
		
		tamanio=new JMenu("Tamaño");  
		
		configuraMenu("Arial","Fuente","Arial",9,1,""); 
		
		configuraMenu("Courier","Fuente","Courier",9,1,""); 
		
		configuraMenu("Verdana","Fuente","Verdana",9,1,""); 
		
		//--------------------------------------
		configuraMenu("Negrita","Estilos","",Font.BOLD,1,"bin/graficos/negrita.gif");
		
		configuraMenu("Cursiva","Estilos","",Font.ITALIC,1,"bin/graficos/cursiva.gif"); 
		
		//------------------------------------------- 
		configuraMenu("12","Tamaño","",9,12,""); 
		
		configuraMenu("16","Tamaño","",9,16,""); 
		
		configuraMenu("20","Tamaño","",9,20,""); 
		
		configuraMenu("24","Tamaño","",9,24,"");
		
		//--------AGREGAR LOS ELEMENTOS MENU A LA BARRA DEL MENU-----\\
		mibarra.add(fuente); 
		
		mibarra.add(estilos); 
		
		mibarra.add(tamanio); 
		
		//---AGREGAR LA BARRA DE MENU AL SEGUNDO PANEL Y A SU VEZ AGREGAR EL PANEL2 AL PANLE PRIMCIPAL------\\
		panel2.add(mibarra); 
		
		add(panel2,BorderLayout.NORTH); 
		
		textarea=new JTextPane(); 
		
		add(textarea,BorderLayout.CENTER); 
		  
	} 
	
	public void configuraMenu(String etiqueta,String menu,String tip_letra,int estilo, int tam, String icono ){ 
		
		JMenuItem elemento=new JMenuItem(etiqueta, new ImageIcon(icono)); 
		
		if(menu=="Fuente"){ 
			
			fuente.add(elemento); 
			
			elemento.addActionListener(new StyledEditorKit.FontFamilyAction("tipo letra", tip_letra)); 
		}else if(menu=="Estilos"){
			
			if(estilo==Font.BOLD){ 
				elemento.addActionListener(new StyledEditorKit.BoldAction());
			}else if(estilo==Font.ITALIC){ 
				elemento.addActionListener(new StyledEditorKit.ItalicAction());
			}
			
			estilos.add(elemento);
		}else if(menu=="Tamaño"){
			
			tamanio.add(elemento);
		
		elemento.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", tam)); 
		
		}
	} 
}

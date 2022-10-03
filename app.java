package taller020221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class app {

	public static void main(String[] args) throws IOException {
		//extraterrestre
		String [] nombreEsp = new String [10000];
		String [] nombreE = new String [10000];
		int [] identificacionE = new int [10000];
		String [] planetaE = new String [10000];
		int [] edadE = new int [10000];
		Double [] alturaE = new Double[10000];
		Double [] pesoE = new Double[10000];
		String [] tipoE = new String[10000];
		//humano
		String [] nacionalidadH = new String[10000];
		String [] nombreH = new String[10000];
		int [] identificacionH = new int[10000];
		String [] regionH = new String[10000];
		String [] ciudadH = new String[10000];
		int [] edadH = new int[10000];
		Double [] alturaH = new Double[10000];
		Double [] pesoH = new Double[10000];
		String [] planetaH = new String[10000];
		int cantE = LecturaExtraterrestes(nombreEsp, nombreE, identificacionE, planetaE, edadE, alturaE, pesoE, tipoE);
		int cantH = LecturaHumano(nacionalidadH, nombreH, identificacionH, regionH, ciudadH, edadH, alturaH, pesoH, planetaH);
		menu(nombreEsp, nombreE, identificacionE, planetaE, edadE, alturaE, pesoE, tipoE, nacionalidadH, nombreH, identificacionH, regionH, ciudadH, edadH, alturaH, pesoH, planetaH, cantH, cantE);
		salir(nombreEsp, nombreE, identificacionE, planetaE, edadE, alturaE, pesoE, tipoE, nacionalidadH, nombreH, identificacionH, regionH, ciudadH, edadH, alturaH, pesoH, planetaH, cantH, cantE);
	}
	
	/** Read the x.txt file of aliens and save the information in each list
	 * 
	 * @param nombreEspecie save the name of the species
	 * @param nombreE save the name of the alien
	 * @param identificacionE save the universal identification of the alien
	 * @param planetaE save the alien’s planet
	 * @param edadE save the alien’s age
	 * @param alturaE save the alien’s stature
	 * @param pesoE save the weight of the alien
	 * @param tipoE save the type of alien
	 * @return
	 * @throws IOException
	 */
	public static int LecturaExtraterrestes(String [] nombreEspecie, String []nombreE, int []identifacionE, String []planetaE, int[] edadE, Double [] alturaE, Double[] pesoE, String []tipoE) throws IOException {
        int cantE = 0;
        Scanner arch = new Scanner(new File("extraterrestre.txt"));
        while (arch.hasNextLine()) {
            String line = arch.nextLine();
            String[] partes = line.split(",");
            String nombre = transformar(partes[0]);
            String nombree = transformar(partes[1]);
            int identificacion = Integer.parseInt(partes[2]);
            String planeta = partes[3];
            int edad = (Integer.parseInt(partes[4])*8);
            Double altura = (Double.parseDouble(partes[5])/100);
            Double peso = (Double.parseDouble(partes[6])/1000);
            String tipo = partes[7];
            int indexE =index(partes, nombree, cantE);           
            if (indexE == -1) {
            	nombreEspecie[cantE]=nombre;
            	nombreE[cantE]=nombree;
            	identifacionE[cantE]=identificacion;
            	planetaE[cantE]=planeta;
            	edadE[cantE]=edad;
            	alturaE[cantE]=altura;
            	pesoE[cantE]=peso;
            	tipoE[cantE]=tipo;             
                cantE++;
                //20 
            }
           
        }
        arch.close();
        return cantE;
    }
	
	
	/** Read the h.txt file of humans and save the information in each list
	 * 
	 * @param nacionalidadH save the nationality of the human
	 * @param nombreH save the name of the human
	 * @param identificacionH save the identification of the human
	 * @param regionH save the region of the human
	 * @param ciudadH save the city of the human
	 * @param edadH save the age of the human
	 * @param alturaH save the height of the human
	 * @param pesoH save the weight of the human
	 * @param planetaH guards the working planet of the human
	 * @return
	 * @throws IOException
	 */
	public static int LecturaHumano(String [] nacionalidadH, String []nombreH, int []identifacionH, String []regionH, String[] ciudadH, int [] edadH, Double [] alturaH, Double[] pesoH, String []planetaH) throws IOException {	
        int cantH = 0;
        Scanner arch = new Scanner(new File("humano.txt"));
        while (arch.hasNextLine()) {
            String line = arch.nextLine();
            String[] partes = line.split(",");
            String nacionalidad = partes[0];
            String nombre = partes[1];
            int identificacion = Integer.parseInt(partes[2]);
            String region = partes[3];
            String ciudad = partes[4];
            int edad = Integer.parseInt(partes[5]);
            Double altura = (Double.parseDouble(partes[6])/100);
            Double peso = (Double.parseDouble(partes[7])/1000);
            String planeta = partes[8]; 
            int indexH =index(partes, nombre, cantH);           
            if (indexH == -1) {
            	nacionalidadH[cantH]=nacionalidad;
            	nombreH[cantH]=nombre;
            	identifacionH[cantH]=identificacion;
            	regionH[cantH]=region;
            	ciudadH[cantH]=ciudad;
            	edadH[cantH]=edad;
            	alturaH[cantH]=altura;
            	pesoH[cantH]=peso;
            	planetaH[cantH]=planeta	;          
                cantH++;
                //20
            }
           
        }
        arch.close();
        return cantH;
    }
	
	
	 public static int index(String[] lista, String nombre, int cantidad) {
	      for (int i = 0; i < cantidad; i++) {
	          if (lista[i].equals(nombre)) {
	             return i;
             }
	        }
	        return -1;
	    }
	 
	 
	 
	 
	 public static int indexId(int[] lista, int idx, int cantidad) {
	      for (int i = 0; i < cantidad; i++) {
	          if (lista[i]==idx) {
	             return i;
	          }
	        }
	        return -1;
	    }
	 
		public static String transformar(String palabra) {
			char[] nuevaPalabra = new char[palabra.length()];
			for(int i = 0; i<palabra.length();i++) {
				nuevaPalabra[i] = palabra.charAt(i);
				if(Character.toUpperCase(nuevaPalabra[i])=='A') {

					nuevaPalabra[i] = 'E';
				}
				else if(Character.toUpperCase(nuevaPalabra[i])=='E') {
					nuevaPalabra[i] = 'A';
				}
				else if(Character.toUpperCase(nuevaPalabra[i])=='O') {
					nuevaPalabra[i] = 'I';
				}
				else if(Character.toUpperCase(nuevaPalabra[i])=='I') {
					nuevaPalabra[i] = 'O';
				}
			}
			return String.valueOf(nuevaPalabra);
		}
	 
		/**menu, which will give different options depending on what is requested
		  * 
		  * @param nombreEspecie saves the species name read by the aliens txt and entered by keyboard 
		  * @param nombreE saves the name read by the aliens txt and entered by keyboard 
		  * @param identificacionE saves the universal identification read by the txt of the aliens and entered by keyboard 
		  * @param planetaE saves the home planet read by the aliens txt and entered by keyboard 
		  * @param edadE saves age read by aliens txt and entered by keyboard 
		  * @param alturaE saves the height read by the aliens txt and entered by keyboard 
		  * @param pesoE saves the weight read by the aliens txt and entered by keyboard 
		  * @param tipoE saves the type read by the aliens txt and entered by keyboard 
		  * @param nacionalidadH saves the nationality read by the human txt and entered by keyboard 
		  * @param nombreH saves the name read by the human txt and entered by keyboard 
		  * @param identificacionH saves the identification read by the human txt and entered by keyboard 
		  * @param regionH saves the region read by the human txt and entered by keyboard 
		  * @param ciudadH saves the city read by the human txt and entered by keyboard 
		  * @param edadH saves age read by human txt and entered by keyboard 
		  * @param alturaH saves the height read by the human txt and entered by keyboard 
		  * @param pesoH saves the weight read by the human txt and entered by keyboard 
		  * @param planetaH saves the work planet read by humans txt and entered by keyboard 
		  * @param cantH returns the total number of humans read by the txt
		  * @param cantE returns the total number of aliens read by the txt
		  */
	 public static void menu(String [] nombreEsp, String []nombreE, int []identificacionE, String []planetaE, int[] edadE, Double [] alturaE, Double[] pesoE, String []tipoE,
			 String [] nacionalidadH, String []nombreH, int []identificacionH, String []regionH, String[] ciudadH, int [] edadH, Double [] alturaH, Double[] pesoH, String []planetaH,int cantH,int cantE) {
		 Scanner scan = new Scanner(System.in);
		 Random random = new Random(); 
		 System.out.println("-------Menu------");
		 System.out.println("1 Agregar Extraterrestee");
		 System.out.println("2 Modificar Extraterrestee");
		 System.out.println("3 Agregar Humano");
		 System.out.println("4 Modificar Humano");
		 System.out.println("5 Mostar por Nacionalidad");
		 System.out.println("6 Eliminar Extraterrestre");
		 System.out.println("7 Eliminar Humano");
		 System.out.println("8 Buscar por Identificacion(Extraterrestre)");
		 System.out.println("9 Mostar Planeta");
		 System.out.println("10 Mostrar por nacionalidad(Humano)");
		 System.out.println("11 Mostrar Tabla");
		 System.out.println("f para salir");
		 String opcion = scan.nextLine();
		 while(!opcion.equals("f")) {		 
			 if(opcion.equals("1")) {
				 System.out.println("ingrese los datos del extraterrestre");
				 System.out.println("ingrese el nombre de la especie: ");
				 String nombreEspecie = scan.nextLine(); 
				 System.out.println("ingrese el nombre del extraterrestre: ");
				 String nombre = scan.nextLine(); 			 
				 int idE = (random.nextInt(99999999)+10000000);
				 System.out.println("ingrese el planeta de origen del extraterrestre: ");
				 String planetaO = scan.nextLine(); 
				 System.out.println("ingrese la edad del extraterrestre: ");
				 int edadExt = Integer.parseInt(scan.nextLine());  
				 System.out.println("ingrese la altura del extraterrestre (cm): ");
				 double alturaExt = Double.parseDouble(scan.nextLine());  
				 System.out.println("ingrese el peso del extraterrestre (gramos) :");
				 double pesoExt = (Double.parseDouble(scan.nextLine())/1000); 
				 System.out.println("ingrese el tipo de de extrarerrestre: ");
				 String tipo = scan.nextLine(); //8
				 agregarE(cantE,nombreEspecie, nombre, idE, planetaO, edadExt, alturaExt, pesoExt, tipo);
				 break;	 
				 
			 } else if(opcion.equals("2")) {
				 System.out.println("ingrese la id del extraterrestre a modificar");
				 int idBuscarE = Integer.parseInt(scan.nextLine());
				 int i = indexId(identificacionE,idBuscarE,cantE);
				 System.out.println("¿Que desea modificar?"+"\n [1]modificar nombre especie"+"\n [2]nombre"+
				 "\n [3]Planeta de origen"+"\n [4]edad"+"\n [5]altura"+"\n [6]peso"+"\n [7]tipo");
				 int eleccion = Integer.parseInt(scan.nextLine());
				 if(eleccion==1) {
					 System.out.print("nombre de la especie =");
					 nombreEsp[i]=scan.nextLine();
				 }
				 if(eleccion==2) {
						System.out.print("nombre del extraterrestre =");
						nombreE[i]=scan.nextLine();
					}
					if(eleccion==3) {
						System.out.print("planeta de origen =");
						planetaE[i]=scan.nextLine();
					}
					if(eleccion==4) {
						System.out.print("edad =");
						edadE[i] = Integer.parseInt(scan.nextLine());
					}
					if(eleccion==5) {
						System.out.print("altura =");
						alturaE[i]=Double.parseDouble(scan.nextLine());
					}
					if(eleccion==6) {
						System.out.print("peso =");
						pesoE[i]= Double.parseDouble(scan.nextLine());
					}
					if(eleccion==7) {
						System.out.print("tipo =");
						tipoE[i] = scan.nextLine();
					}
			 }else if(opcion.equals("3")) {
				 System.out.println("ingrese los datos del humano");
				 System.out.println("ingrese la nacioalidad del humano: ");
				 String nacioH = scan.nextLine();
				 System.out.println("ingrese el nombre del humano: ");
				 String nombreHum = scan.nextLine();
				 int idH = (random.nextInt(9999999)+1000000);
				 System.out.println("ingrese la region del humano: ");
				 String regionHum = scan.nextLine();
				 System.out.println("ingrese la ciudad del humano: ");
				 String ciudadHum = scan.nextLine();
				 System.out.println("ingrese la edad del humano: ");
				 int edadHum = Integer.parseInt(scan.nextLine());
				 System.out.println("ingrese la altura del humano (cm): ");
				 double alturaHum = Double.parseDouble(scan.nextLine());
				 System.out.println("ingrese el peso del humano (gramos) :");
				 double pesoHum = (Double.parseDouble(scan.nextLine())/1000);
				 System.out.println("ingrese el planeta de trabajo del humano: ");
				 String planetaTrabajo = scan.nextLine();
				 agregarH(cantH,nacioH, nombreHum, idH, regionHum, ciudadHum, edadHum, alturaHum, pesoHum, planetaTrabajo);

				 
			 }else if(opcion.equals("4")) {
				 System.out.println("Ingrese id de humano");
				 int idBuscarH = Integer.parseInt(scan.nextLine());
				 int i = indexId(identificacionE,idBuscarH,cantH);
				 System.out.println("¿Que desea modificar?"+"\n [1]modificar nacionalidad"+"\n [2]modificar nombre"+"\n [3]modificar region"+"\n [4]modificar ciudad "+"\n [5]modificar edad"+"\n [6]modificar altura"+"\n [7]modificar peso"+"\n [8]modificar planeta de trabajo");
				 int eleccion = Integer.parseInt(scan.nextLine());
				 if(eleccion==1) {
					 System.out.print("nacionalidad =");
					 nacionalidadH[i]=scan.nextLine();
				 }
				 if(eleccion==2) {
					 System.out.print("nombre =");
					 nombreH[i]=scan.nextLine();
				 }
				 if(eleccion==3) {
					 System.out.print("region =");
					 regionH[i]=scan.nextLine();
				 }
				 if(eleccion==4) {
					 System.out.print("ciudad =");
					 ciudadH[i]=scan.nextLine();
				 }
				 if(eleccion==5) {
					 System.out.print("edad =");
					 edadH[i]=Integer.parseInt(scan.nextLine());
				 }
				 if(eleccion==6) {
					 System.out.print("altura =");
					 alturaH[i]=Double.parseDouble(scan.nextLine());
				 }
				 if(eleccion==7) {
					 System.out.print("peso =");
					 pesoH[i]=Double.parseDouble(scan.nextLine());
				 }
				 if(eleccion==8) {
					 System.out.print("planeta de trabajo =");
					 planetaH[i]=scan.nextLine();
				 }
				 
				 
			 }else if(opcion.equals("5")) {				
				 System.out.println(mostrarNacionalidad(nacionalidadH, nombreH, cantH));
				 
			 }else if(opcion.equals("6")) {
				 System.out.println("ingrese id de extraterrestre :");			 
				 int id = Integer.parseInt(scan.nextLine());		 
				 int indexBuscar = indexId(identificacionE, id, cantE);
				 if(indexBuscar !=-1) {
					 for(int i = indexBuscar;i<cantE-1;i++) {
						 nombreEsp[i] = nombreEsp[i+1];
						 nombreE[i] = nombreE[i+1];
						 identificacionE[i] = identificacionE[i+1];
						 planetaE[i]= planetaE[i+1];
						 edadE[i] = edadE[i+1];
						 alturaE[i] = alturaE[i+1];
						 pesoE[i] = pesoE[i+1];
						 tipoE[i] = tipoE[i+1];					 
					 }
				 }
				 else {
					 System.out.println("El id ingresado no se encuentra");
				 }
				 
			 }else if(opcion.equals("7")) {
				 System.out.println("ingrese id de humano :");
				 int id = Integer.parseInt(scan.nextLine());
				 int indexBuscar = indexId(identificacionH, id, cantE);
				 if(indexBuscar !=-1) {
					 for(int i=indexBuscar;i<cantH-1;i++) {
						 nacionalidadH[i]=nacionalidadH[i+1];
						 nombreH[i]=nombreH[i+1];
						 identificacionH[i]=identificacionH[i+1];
						 regionH[i]=regionH[i+1];
						 ciudadH[i]=ciudadH[i+1];
						 edadH[i]=edadH[i+1];
						 alturaH[i] = alturaH[i+1];
						 pesoH[i] = pesoH[i+1];
						 planetaH[i] = planetaH[i+1];
						 
					 }
				 }
				 else {
					 System.out.println("El id ingresado no se encuentra");
				 }
				 
			 }else if(opcion.equals("8")) {
				 System.out.println(buscar(nombreEsp, nombreE, identificacionE, planetaE, edadE, alturaE, pesoE, tipoE, cantE));
				 
			 }else if(opcion.equals("9")) {
				 System.out.println(mostrarPlaneta(nombreEsp, nombreE, identificacionE, planetaE,cantE));
				 break;
				 
			 }else if(opcion.equals("10")) {
				 System.out.println(mostrarNacionalidad(nacionalidadH, nombreH, cantH));
				 break;
				 
			 }else if(opcion.equals("11")) {
				 
			 }		 			 					 			 
		 }	 
	 } 
	 
	 public static String mostrarNacionalidad(String [] nacionalidadH, String [] nombreH, int cantH) {
		 String text="";
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Ingrese nacionadalidad que quiere mostrar :");
		 String nacio = scan.nextLine();
		 for(int i =0;i<cantH;i++) {
			 if(nacionalidadH[i].equals(nacio)) {
				 text +="Nombre :"+nombreH[i]+"\n";
			 }
			 else {
					System.out.println("No se encontro nacionalidad ");
					break;
				}
		 }
		 return text;
	 }
	 
	 public static String mostrarPlaneta(String [] nombreEsp, String []nombreE, int []identificacionE, String []planetaE, int cantE) {
		 String text="";
		 int cant=0;
		 int suma = 0;
		 Double promedio;
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Ingrese planeta :");
		 String pla = scan.nextLine();
		 for(int i =0;i<cantE;i++) {
			 System.out.println(nombreEsp[i]+","+nombreE[i]);
			 if(planetaE[i].equals(pla)) {
				 cant++;
				 text +="Nombre Especie :"+nombreEsp[i]+""+", Nombre :"+nombreE[i] + ", Id :"+identificacionE[i]+", Planeta :"+planetaE[i]+"\n";
				 suma+=cant;
			 }
			 else {
				 System.out.println("Planeta no encontrado");
				 break;
			 }
			 //promedio = (double) ((suma/cant)/100);
		 }
		 return text;
		 
	 }
	 
	 /**searches for the alien id in the specified list, returning the alien with all its attributes 
	  * 
	  * @param nombreEspecie name of the species stored
	  * @param nombreE names stored
	  * @param identifacionE stored identification
	  * @param planetaE stored planet of origin
	  * @param edadE stored age
	  * @param alturaE stored height
	  * @param pesoE stored weight
	  * @param tipoE stored type
	  * @param cantE total number of humans stored
	  * @return
	  */
	 public static String buscar(String [] nombreEspecie, String []nombreE, int []identificacionE, String []planetaE, int[] edadE, Double [] alturaE, Double[] pesoE, String []tipoE, int cantE) {		 
		String text="";
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese id a buscar :");
		int id = scan.nextInt();
		for(int i =0;i<cantE;i++) {
			if(identificacionE[i]==id) {
				text +="NombreEspecie :"+nombreEspecie[i]+"NombreE :"+nombreE[i]+"Identificacion :"+identificacionE[i]+"Planeta :"+planetaE[i]+"Edad :"+edadE[i]+"Altura :"+alturaE[i]+
						"Peso :"+pesoE[i]+"Tipo :"+tipoE[i]+"\n";				
			}
			else {
				System.out.println("No se encontro id ");
			}
			 
		}
		return text;
		 
	 }
	 	 	 	 
	 /** new aliens entered by console will be added to the txt
	  * 
	  * @param nombreEsp new species names will be saved in the list
	  * @param nombre new species names will be saved in the list
	  * @param idE new identifications will be saved in the list
	  * @param planetaO the new origin planets will be saved in the list
	  * @param edadExt new ages will be saved in the list
	  * @param alturaExt new heights will be saved in the list
	  * @param pesoExt new weights will be saved in the list
	  * @param tipo new types will be saved in the list
	  */
	 public static void agregarE(int cantE, String nombreEsp, String nombre, int idE, String planetaO, int edadExt, Double alturaExt, Double pesoExt, String tipo) {
		 try {
			 BufferedWriter writes = new BufferedWriter( new OutputStreamWriter( new FileOutputStream("extraterrestre.txt",true)));
			 writes.write("\n"+transformar(nombreEsp)+","+transformar(nombre)+","+idE+","+planetaO+","+edadExt+","+alturaExt+","+pesoExt+","+tipo);
			 System.out.println("Extraterreste agregado");
			 cantE++;
			 writes.close();
		 } catch (Exception ex) {
			 System.out.println(ex.getMessage());
		 }
	 }
	 
	 
	 /** new humans entered by console will be added to the txt
	  * 
	  * @param nacioH the new nationalities will be saved in the list
	  * @param nombreHum new human names will be saved in the list
	  * @param idH new human identifications will be saved in the list
	  * @param regionHum the new regions of humans will be saved in the list
	  * @param ciudadHum the new cities of humans will be saved in the list
	  * @param edadHum the new ages of humans will be saved in the list
	  * @param alturaHum the new heights of humans will be kept on the list
	  * @param pesoHum the new human weights will be saved in the list
	  * @param planetaTrabajo the new working planets of humans will be saved in the list
	  */
	 public static void agregarH(int cantH,String nacioH, String nombreHum, int idH, String regionHum, String ciudadHum,int edadHum ,Double alturaHum, Double pesoHum, String planetaTrabajo) {
		 try {
			 BufferedWriter writes = new BufferedWriter( new OutputStreamWriter( new FileOutputStream("humano.txt",true)));
			 writes.write("\n"+nacioH+","+nombreHum+","+idH+","+regionHum+","+ciudadHum+","+edadHum+","+alturaHum+","+pesoHum+","+planetaTrabajo);
			 System.out.println("Humano agregado");
			 cantH++;
			 writes.close();
		 } catch (Exception ex) {
			 System.out.println(ex.getMessage());
		 }
	 }
	 
	 /** when leaving the menu, the data will be saved in the txt, overwriting the txt
	  * 
	  * @param nombreEspecie add alien species name to txt 
	  * @param nombreE add alien name to txt 
	  * @param identifacionE Alien ID will be added to the txt 
	  * @param planetaE the alien’s home planet will be added to the txt 
	  * @param edadE the alien’s age will be added to the txt 
	  * @param alturaE add alien height to txt 
	  * @param pesoE the alien’s weight will be added to the txt 
	  * @param tipoE add alien type to txt 
	  * @param nacionalidadH adds human nationality to the txt
	  * @param nombreH add human name to txt
	  * @param identifacionH human identification to the txt
	  * @param regionH add human region to txt
	  * @param ciudadH add human city to txt
	  * @param edadH adds human age to the txt
	  * @param alturaH adds human height to the txt
	  * @param pesoH adds human weight to the txt
	  * @param planetaH add human work planet to txt
	  * @param cantH number of humans read in the txt
	  * @param cantE number of aliens read in the txt
	  * @throws IOException
	  */
	 public static void salir(String [] nombreEsp, String []nombreE, int []identificacionE, String []planetaE, int[] edadE, Double [] alturaE, Double[] pesoE, String []tipoE,
			 String [] nacionalidadH, String []nombreH, int []identificacionH, String []regionH, String[] ciudadH, int [] edadH, Double [] alturaH, Double[] pesoH, String []planetaH,int cantH,int cantE) throws IOException {
	        String arch = "extraterrestre1.txt";
	        FileWriter file = new FileWriter(arch);
	        PrintWriter escritura = new PrintWriter(file);
	        for (int i = 0; i < cantE; i++) {
	                escritura.println(nombreEsp[i] + "," + nombreE[i] + "," + identificacionE[i] + "," + planetaE[i] + "," + edadE[i]
	                        + "," + alturaE[i] + "," + pesoE[i] + "," + tipoE[i]);
	            
	        }
	        String arch2 = "humano1.txt";//
	        FileWriter file2 = new FileWriter(arch2);
	        PrintWriter escritura2 = new PrintWriter(file2);
	        for (int j = 0; j < cantH; j++) {
	            escritura2.println(nacionalidadH[j] + "," + nombreH[j] + "," + identificacionH[j] + "," + regionH[j] + "," + ciudadH[j]
                        + "," + edadH[j] + "," + alturaH[j] + "," +pesoH[j] + "," + planetaH[j]);
	        }
 
	        escritura.close();
	        escritura2.close();

	    }

}
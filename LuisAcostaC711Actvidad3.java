package com.mycompany.luisacosta;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Luis Acosta / 30139928
 * 
 */
public class LuisAcostaC711Actvidad3 {
    
    public static void main(String[] args){

       int n;
       String dato; 
       String salida = "";
       
       dato = JOptionPane.showInputDialog("Cantidad maxima de registros: ");
       n = Integer.parseInt(dato);

       float suma = 0;
       float notas[][] = new float[n][4];
       float prom[] = new float[4];
       
       //Ingresar datos
        entrada(n, notas);
       
       //Calculo de la definitiva
        definitiva(n, notas);

       //Calcular del promedio por corte
        CalculoPromedio(n, notas, prom, suma);

       float PrimerCorteAlto = notas[0][0]; 
       float PrimerCorteBajo = notas[0][0]; 
       float SegundoCorteAlto = notas[0][1];
       float SegundoCorteBajo = notas[0][1];
       float TercerCorteAlto = notas[0][2]; 
       float TercerCorteBajo = notas[0][2]; 
       float PromedioAlto = notas[0][3]; 
       float PromedioBajo = notas[0][3];

       //Calcula la nota mas alta y mas baja de cada corte y promedio y muestra los datos
       AltaBaja(prom,salida,n, notas, PrimerCorteAlto, PrimerCorteBajo, SegundoCorteAlto, SegundoCorteBajo, TercerCorteAlto, TercerCorteBajo, PromedioAlto, PromedioBajo);

       
    }//Final main
    

    //Metodos del programa

       //Ingresar datos 
            public static void entrada(int n, float notas[][]){

                String dato;
                int i;
                int j;
                int registro = 1;
                int corte = 1;

            for( i = 0; i < n; i++){
                   for( j = 0; j < 3; j++){
                       dato = JOptionPane.showInputDialog("Estudiante : #" + registro + "\nNota del Corte : " + corte + "\n\nIngrese la nota: ");
                       notas[i][j] = Float.parseFloat(dato);
                       corte = corte + 1;
                   }
                registro = registro + 1;
                corte = 1;
            }
        }

       //Calculo de la definitiva    
            public static void definitiva(int n, float notas[][]){

            int i;

            for(i = 0; i < n; i++){
                   System.out.print("\n");
                   notas[i][3] = notas[i][0] * 0.3f + notas[i][1] * 0.3f + notas[i][2] * 0.4f;
               }
            }
        
       //Calcular del promedio por corte
           public static void CalculoPromedio(int n, float notas[][], float prom[], float suma){
               int i; 
               int j;
               
            for(j = 0; j < 4; j++){
                   suma = 0;
                   for(i = 0; i < n; i++){
                       suma  += notas[i][j];
                   }
                   prom[j] = suma/n;
               }
            }

        //Calcular nota mas alta y mas baja
            public static void AltaBaja(float prom[],String salida,int n,float notas[][], float PrimerCorteAlto, float PrimerCorteBajo, float SegundoCorteAlto, float SegundoCorteBajo, float TercerCorteAlto, float TercerCorteBajo, float PromedioAlto, float PromedioBajo){

                int i;

        //Primer corte mayor y menor
            //Se toma para evaluar el mayor

                for( i = 0; i < n; i++){
                        if (PrimerCorteAlto < notas[i][0]) {
                             PrimerCorteAlto = notas[i][0];
                        }
                }

            //Se toma para evaluar el menor

                for( i = 0; i < n; i++){
                        if (PrimerCorteBajo > notas[i][0]) {
                             PrimerCorteBajo = notas[i][0];
                        }
                }
                

        //Segundo Corte mayor y menor
            //Se toma para evaluar el mayor 

                for( i = 0; i < n; i++){
                        if (SegundoCorteAlto < notas[i][1]) {
                         SegundoCorteAlto = notas[i][1];
                        }
                }
                

            //Se toma para evaluar el menor 

                for( i = 0; i < n; i++){ 
                        if (SegundoCorteBajo > notas[i][1]) {
                         SegundoCorteBajo = notas[i][1];
                        }   
                }

        //Tercer Corte mayor y menor
            //Se toma para evaluar el mayor

                for( i = 0; i < n; i++){  
                        if (TercerCorteAlto < notas[i][2]) {
                         TercerCorteAlto = notas[i][2];
                        }  
                }

            //Se toma para evaluar el menor

                for( i = 0; i < n; i++){  
                        if (TercerCorteBajo > notas[i][2]) {
                         TercerCorteBajo = notas[i][2];
                        }   
                }

        //Promedio mayor y menor
            //Se toma para evaluar el mayor

                for( i = 0; i < n; i++){  
                        if (PromedioAlto < notas[i][3]) {
                         PromedioAlto = notas[i][3];
                     }
                }

            //Se toma para evaluar el menor

                for( i = 0; i < n; i++){ 
                        if (PromedioBajo > notas[i][3]) {
                         PromedioBajo = notas[i][3];
                        } 
                }

                //Presentar datos de resultados en Ventana
        PresentarDatos(n, notas, prom, salida, PrimerCorteAlto, PrimerCorteBajo, SegundoCorteAlto, SegundoCorteBajo, TercerCorteAlto, TercerCorteBajo, PromedioAlto, PromedioBajo);

            }

       //Presentar datos de resultados en Ventana
           public static void PresentarDatos(int n, float notas[][], float prom[], String salida,float PrimerCorteAlto, 
            float PrimerCorteBajo, float SegundoCorteAlto, float SegundoCorteBajo, float TercerCorteAlto, float TercerCorteBajo, float PromedioAlto, float PromedioBajo){

               int i;
               int j;
               int contador = 1;
               JTextArea textArea;
               
           salida += "Cantidad de estudiantes: " + n;
           salida +=  "\n\n------------------------------------------------------------------------------------------------\n";
               salida +=  "Est.                 Corte 1                Corte 2                 Corte 3           Definitiva\n";
               salida +=  "------------------------------------------------------------------------------------------------";
               for(i = 0; i < n; i++){
                   salida += "\n" + "Est["+contador+"]";
                   contador = contador + 1;
                   for(j = 0; j < 4; j++){               
                       salida += "\u0009" + notas[i][j];               
                   }
               }       
               salida += "\n";
               salida +=  "------------------------------------------------------------------------------------------------\n";
               salida += "Def";
               for(i = 0; i < 4; i++){           
                   salida += "\u0009" + prom[i];
               }
               salida +=  "\n------------------------------------------------------------------------------------------------\n";
               salida += "Nota mas alta primer corte :" + PrimerCorteAlto + "        " + "Nota mas alta segundo corte :" + SegundoCorteAlto;
               salida += "\nNota mas baja primer corte :" + PrimerCorteBajo + "       " + "Nota mas bajo segundo corte :" + SegundoCorteBajo;
               salida += "\n\nNota mas alta tercer corte :" + TercerCorteAlto + "        " + "Nota mas alta del Promedio :" + PromedioAlto;
               salida += "\nNota mas baja tercer corte :" + TercerCorteBajo + "       " + "Nota mas bajo del Promedio :" + PromedioBajo;       
               salida += "\n";
               System.out.println(salida);

               textArea = new JTextArea( salida, 10, 30 ); // create textArea1
               JOptionPane.showMessageDialog(null, textArea,
                    "Notas De estudiantes", JOptionPane.PLAIN_MESSAGE);
            
            }

} // Final codigo

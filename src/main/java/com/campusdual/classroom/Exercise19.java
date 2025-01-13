package com.campusdual.classroom;

import java.lang.reflect.Array;

public class Exercise19 {

    //Este metodo genera una representación en String de un arrray tridimensional
    // y su matriz aplanada, flatMatrix.
    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;//Numero de filas na matriz tridimensional.
        StringBuilder sb = new StringBuilder();


        //Iteramos a través de cada fila para construir as cadenas  da matriz plana e tridimensional
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));//Plana
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));//Tridimensional
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());//Elimina el último salto de liña.
        return sb.toString();
    }

    //Convierte unha fila específica da matriz tridi en un String
    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        //Itera sobre cada matris 2D dentro da matriz 3D
        for (int i = 0; i < intArrayTri.length - 1; i++) {
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        //Convierte la última fila de la úñtima matriz 2D en un String.
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length - 1][row]));

        return sb.toString();
    }

    //Convierte una fila específica da flatMatrix nun String
    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);//Convirte a fila da matriz 2D a String usando getUnidimensinalString

    }

    //Recibe a matriz 3D e chama  ao metodo interno
    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);//Aplanamos a matriz 3D en 2D
        return getTridimensionalString(intArrayTri, flatMatrix);//Chama a versión aplanada
    }

    //Completar y usar el metodo flatTridimensionalArray.
//Este metodo recibe un array tridimensional de tipo int y devolverá un array bidimensional de tipo int.
// El array bidimensional que debe devolver es el resultado del "flatting" (aplanamiento) del array tridimiensinal.
// Aplanar un array tridimensional consiste en sumar uno a uno los elementos que tienen la misma posición en cada matriz de nueve elementos.
// De esta forma, partiendo de un array de [3][3][3] se obtiene un array de [3][3].
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {

        int rows = intArrayTri[0].length;
        int colms = intArrayTri[0][0].length;
        int[][] flattenedArray = new int[rows][colms];

        //Suma os elementos de las mismas posiciones a través de las diferentes capas de la matriz 3D
        for (int[][] matrix : intArrayTri) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < colms; j++) {
                    flattenedArray[i][j] += matrix[i][j];
                }
            }

        }
        return flattenedArray;
    }

    //Completar y usar el metodo getBidimensionalString() para invocar desde él al metodo stringFlatMatrixRow() ya proporcionado en el ejercicio.
//El metodo getBidimensionalString() recibe un array bidimensional e invoca a stringFlatMatrixRow(),
//pasándole dicho array bidimensional y un entero correspondiente a cada uno de los elementos de su primera dimensión.
// stringFlatMatrixRow() a su vez invocará al metodo getUnidimensionalString() que se completó previamente.
// Así que es importante completar bien previamente el metodo getUnidimensionalString(), porque será utilizado por otros métodos para convertir a String cada dimensión.
// El metodo getBidimensionalString() finalmente devolverá un String compuesto línea a línea por cada secuencia de elementos.
// Por ejemplo:
//Array de ejemplo de tipo int original: [ [1, 2, 3] , [4, 5, 6], [7, 8, 9] ] → String generado: "1 2 3\n4 5 6\n7 8 9"
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayBi.length; i++) {
            sb.append(stringFlatMatrixRow(intArrayBi, i));//Convirte cada fila nun String
            if (i < intArrayBi.length - 1) sb.append("\n");
        }
        return sb.toString();
    }

    //Completar y usar el metodo getUnidimensionalString() para recorrer el array unidimensional de tipo entero y devolver un String único compuesto por los elementos del array de tipo int (usar la clase StringBuilder). Así:
//Array de tipo int original: [1, 2, 3, 4, 5] → String generado: "1 2 3 4 5"
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < uniArray.length; i++) {
            sb.append(uniArray[i]);
            if (i < uniArray.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();


    }

    //Crear un Array unidimensional de tipo entero e inicializarlo en el metodo createAndPopulateUnidimensionalArray().
// Hacer lo mismo para un array bidimensional y el tridimensional, también de tipo entero, respectivamente.
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] uniArray = new int[5];
        for (int i = 0; i < uniArray.length; i++) {
            uniArray[i] = i + 1;// i + 1  para que empiece desde 1.
        }
        return uniArray;
    }

    //en los métodos createAndPopulateBidimensionalArray()
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] intArrayBi = new int[rows][columns];
        int value = 1;//valor inicial para rellenar a matriz
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                intArrayBi[i][j] = value++;//Asigna valores consecutivos
            }
        }
        return intArrayBi;
    }

    //,  y createAndPopulateTridimensionalArray ()
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] intArrayTri = new int[depth][rows][columns];
        int value = 1;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    intArrayTri[i][j][k] = value++;
                }
            }
        }
        return intArrayTri;
    }

    //Cada metodo de creación de arrays ya está siendo invocado desde el main() recibiendo como parámetros en cada caso números enteros que indican la cantidad de elementos de cada dimensión.
    //Con esos valores, construir los arrays correspondientes (habrá que usar for).
    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}




import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Figura figura = null;

        int opcionFigura;
        do {
            System.out.println("MENU DE FIGURAS");
            System.out.println("1. Triángulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Círculo");
            System.out.println("4. Pirámide");
            System.out.println("5. Esfera");
            System.out.println("6. Cubo");
            System.out.println("7. Salir");
            System.out.print("Ingrese la opción de figura: ");
            opcionFigura = sc.nextInt();

            switch (opcionFigura) {
                case 1:
                    figura = new Triangulo();
                    ((Triangulo) figura).ingresarPuntos();
                    break;
                case 2:
                    figura = new Cuadrado();
                    ((Cuadrado) figura).ingresarLado();
                    break;
                case 3:
                    figura = new Circulo();
                    ((Circulo) figura).ingresarRadio();
                    break;
                case 4:
                    figura = new Piramide();
                    ((Piramide) figura).ingresarPuntos();
                    ((Piramide) figura).ingresarAltura();
                    break;
                case 5:
                    figura = new Esfera();
                    ((Esfera) figura).ingresarRadio();
                    break;
                case 6:
                    figura = new Cubo();
                    ((Cubo) figura).ingresarLado();
                    break;
                case 7:
                    System.out.println("¡Hasta Pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            if (figura != null && opcionFigura != 7) {
                int opcionCalculo;
                do {
                    System.out.println("\nMENU DE CÁLCULO");
                    if (figura instanceof Esfera) {
                        System.out.println("1. No es posible calcular el perímetro de esta figura");
                        System.out.println("2. Calcular área superficial");
                        System.out.println("3. Calcular volumen");
                    } else {
                        System.out.println("1. Calcular perímetro");
                        if (figura instanceof Piramide || figura instanceof Cubo) {
                            System.out.println("2. Calcular área superficial");
                            System.out.println("3. Calcular volumen");
                        } else {
                            System.out.println("2. Calcular área");
                        }
                    }
                    System.out.println("4. Regresar al menú de figuras");
                    System.out.print("Ingrese una opción: ");
                    opcionCalculo = sc.nextInt();

                    switch (opcionCalculo) {
                        case 1:
                            double perimetro = figura.calcularPerimetro();
                            System.out.println("El perímetro es: " + perimetro);
                            break;
                        case 2:
                            if (figura instanceof Piramide) {
                                double areaSuperficial = ((Piramide) figura).calcularArea();
                                System.out.println("El área superficial es: " + areaSuperficial);
                            } else if (figura instanceof Esfera) {
                                double areaSuperficial = ((Esfera) figura).calcularAreaSuperficial();
                                System.out.println("El área superficial es: " + areaSuperficial);
                            } else if (figura instanceof Cubo) {
                                double areaSuperficial = ((Cubo) figura).calcularAreaSuperficial();
                                System.out.println("El área superficial es: " + areaSuperficial);
                            } else {
                                double area = figura.calcularArea();
                                System.out.println("El área es: " + area);
                            }
                            break;
                        case 3:
                            if (figura instanceof Piramide) {
                                double volumen = ((Piramide) figura).calcularVolumen();
                                System.out.println("El volumen es: " + volumen);
                            } else if (figura instanceof Esfera) {
                                double volumen = ((Esfera) figura).calcularVolumen();
                                System.out.println("El volumen es: " + volumen);
                            } else if (figura instanceof Cubo) {
                                double volumen = ((Cubo) figura).calcularVolumen();
                                System.out.println("El volumen es: " + volumen);
                            } else {
                                System.out.println("Opción inválida. Intente nuevamente.");
                            }
                            break;
                        case 4:
                            System.out.println();
                            break;
                        default:
                            System.out.println("Opción inválida. Intente nuevamente.");
                            break;
                    }
                } while (opcionCalculo != 4);
            }

        } while (opcionFigura != 7);
    }
}

public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    
    private int numeroBilletes;
    
    private boolean premios;
    
    private int maximoBilletes;

    private int billetes;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean canjearPremios, int maximoDeBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletes = 0;
        premios = canjearPremios;
        maximoBilletes = maximoDeBilletes;
        billetes = 0;
    }
    
    public MaquinaExpendedoraMejorada(boolean canjearPremios, int maximoDeBilletes) {
        precioBillete = 15;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "Leon";
        estacionDestino = "Barcelona";
        numeroBilletes = 0;
        premios = canjearPremios;
        maximoBilletes = maximoDeBilletes;
        billetes = 0;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (maximoBilletes > billetes){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es cantidad de dinero valida.");
            }
        }
        else{
            System.out.println("Numero maximo de billetes alcanzado");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (maximoBilletes > billetes){
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();    
                
                numeroBilletes += 1;
        
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                
                if (premios == true){
                    if(billetes % 4==0){
                    System.out.println("Has ganado un descuento de "+(precioBillete*0.25)+"€ en un establecimiento.");
                    }
                }
            }
            else {
                System.out.println("Cantidad de dinero que falta: " + cantidadDeDineroQueFalta);
            } 
        }
        else {
            System.out.println("No quedan billetes por imprimir numero maximo alcanzado");
        }
    }
    
    public int getNumeroBilletesVendidos(){
        return numeroBilletes;
    }
    
    public void imprimirNumeroBilletesVendidos(){
        System.out.println("Número de billetes impresos: " + numeroBilletes);
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    public int vaciarDinero() {
        int vaciarDinero;
        vaciarDinero = totalDineroAcumulado + balanceClienteActual;
        if (balanceClienteActual == 0) {
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        else {
            System.out.println("No se puede realizar la acción porque la operación del cliente sigue  activa");
            vaciarDinero = -1;
        }
        return vaciarDinero;
    } 
}
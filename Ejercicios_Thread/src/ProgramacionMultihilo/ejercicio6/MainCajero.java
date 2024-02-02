package ProgramacionMultihilo.ejercicio6;

public class MainCajero {
    Localidades localidades = new Localidades(80000);
    Cajero cajero = new Cajero("Jose");
    Terminal t1 = new Terminal(localidades, cajero);
    
    Terminal t2 = new Terminal(localidades, cajero);
    
    Terminal t3 = new Terminal(localidades, cajero);
}

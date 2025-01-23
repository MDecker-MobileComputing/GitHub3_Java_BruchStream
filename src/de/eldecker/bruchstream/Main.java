package de.eldecker.bruchstream;

import java.util.stream.Stream;


/**
 * Klasse mit main-Methode.
 */
public class Main {
    
	/**
	 * Diese Methode gibt einen Stream mit Brüchen zurück.
	 *  
	 * @return Stream von Brüchen
	 */
    private static Stream<BruchRecord> getBruchStream() {

        return Stream.of(
                            new BruchRecord( 1, 2 ),
                            new BruchRecord( 2, 7 ),
                            new BruchRecord( 8, 9 ),
                            new BruchRecord( 2, 3 ),
                            new BruchRecord( 4, 9 )
                        );
    }	
	
    
    /**
     * Einstiegsmethode.
     *
     * @param args Wird nicht ausgewertet.
     */
    public static void main( String[] args ) {
    	
    	System.out.println();
    	
    	final Stream<BruchRecord> bruchStream = getBruchStream();
    	
    	bruchStream.filter( bruch -> {
    		
    		double zaehler = bruch.zaehler();
    		double nenner  = bruch.nenner();
    		
    		double wert = zaehler / nenner; 
    		
    		boolean istEchtGroesser = wert > 0.5;
    		
    		return istEchtGroesser;
    	})
    	.sorted( (b1, b2) -> b1.zaehler() - b2.zaehler() )
    	.forEach( System.out::println );
    	
    	System.out.println();
    }
    
}
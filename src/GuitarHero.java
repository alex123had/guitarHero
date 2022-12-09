public class GuitarHero {

    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] key = new GuitarString[37];
        
        //calculate frequency for each keyboard letter/number
        for (int i = 0; i<key.length; i++) {
        	int frequency = (int) (440.0* Math.pow(1.05956, i-25));
        	key[i] = new GuitarString(frequency);
        }
        play(keyboard, key);
    }
    
    private static void play(String str, GuitarString[] keys) { 
    	String keyboard = str;
    	GuitarString[] kk = keys;
    	
       // the main input loop
        while(true) {
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
 
                // the user types this character
                char k = StdDraw.nextKeyTyped();              
				int index = keyboard.indexOf(k);
                
                // pluck the corresponding string
                if(index>=0) {
                	kk[index].pluck();
                    StdDraw.text(0.2, 0.6, "You played something.");
                	}
                }
         
            // compute the superposition of the samples
            double sample = 0;
            for (int i = 0; i<kk.length; i++) {
            	sample +=kk[i].sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);
            
            // advance the simulation of each guitar string by one step
            for (int i = 0; i<kk.length; i++) {
            	kk[i].tic();
            }
        }
    }
}


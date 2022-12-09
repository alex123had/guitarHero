public class KeyboardHero{
    public static void main(String[] args) {
    	String music = "a2";
    	char[] notes = new char[music.length()];
    	
    	for (int a = 0; a<notes.length; a++) {
    		notes[a] = music.charAt(a);
    	}
            String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
            GuitarString[] key = new GuitarString[37];
            
            //calculate frequency for each keyboard letter/number
            for (int i = 0; i<key.length; i++) {
            	int frequency = (int) (440.0* Math.pow(1.05956, i-25));
            	key[i] = new GuitarString(frequency);
            }
            
            for (int x = 0; x<notes.length; x++) {
            	play(notes, keyboard, key);
            }
        }
        
        private static void play(char[] note, String str, GuitarString[] keys) {
        	char[] musicNotes = note;
        	String keyboard = str;
        	GuitarString[] kk = keys;
        	int position = 0;
        	char targetNote = musicNotes[position];
        	
        	StdDraw.text(0.1, 0.9, "Please play " + musicNotes[position]);
        	
        	while(true) {
                // check if the user has typed a key, and, if so, process it
                if (StdDraw.hasNextKeyTyped()) {
     
                    // the user types this character
                    char userNote = StdDraw.nextKeyTyped();              
    				int index = keyboard.indexOf(userNote);
    				
                    if (userNote == targetNote){
                    	kk[index].pluck();
                    	position++;
                    }
                    else {
                    	StdDraw.text(0.2, 0.6, "Wrong key");
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
        
    }


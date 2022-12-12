public class KeyboardHero{
    public static void main(String[] args) {
    	String music = "o-[zd[ddx-xxzpzzo-[zd[dbvd[dvvvv";
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
            
           
            	play(notes, keyboard, key);
            
        }
        
    private static void play(char[] notes, String keyboard, GuitarString[]key) {
    // the main input loop
        int position = 0;
        StdDraw.text(0.5, 0.6, "You are going to play In the Hall of the Mountain King");
        StdDraw.text(.5, .5, "Please press " + notes[position] +" on your keyboard");
        while (true) {
        	char targetNote = notes[position];
        	if (StdDraw.hasNextKeyTyped()) {
                // the user types this character
            	char userNote = StdDraw.nextKeyTyped();
            	if(position < notes.length-1)
            	{
                    if(userNote == targetNote)
                    {
                    	position++;
                    }
                    
                    targetNote = notes[position];
                    StdDraw.clear();
            		StdDraw.text(.5,.5, "Please press " + targetNote + " on your keyboard");
            	}
            	else {
            		StdDraw.clear();
            		StdDraw.text(.5, .5, "Finished!");
            	}
                
                int index = keyboard.indexOf(userNote);
                if(index == -1) {
                	StdDraw.text(0.5,0.3, "That is not a key.");
                }
                else {
                	key[index].pluck();
                }
            }

            // compute the superposition of the samples
            // double sample = stringA.sample() + stringC.sample();
            double sample = 0;
            for(int x = 0; x < key.length; x++)
            {
            	sample = sample + key[x].sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);
            
            
            // advance the simulation of each guitar string by one step
            for(int x = 0; x < key.length; x++)
            {
            	key[x].tic();
            }
        }
    }
}
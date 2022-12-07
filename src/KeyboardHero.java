public class KeyboardHero {
	public static void main(String[] args) {
	String music = "qqqqqqqq22222";
	char[] direction = new char[music.length()];
	for (int j = 0; j<direction.length; j++) {
		direction[0] = 
	}
	
	String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
	GuitarString[] notes = new GuitarString [37];
	
	for (int i = 0; i<notes.length; i++) {
		int frequency = (int)(440*Math.pow(1.05960, i-25));
		notes[i] = new GuitarString(frequency);
		double TEXT_POS_X = .2;
        double TEXT_POS_Y = .5;
        
        StdDraw.text(TEXT_POS_X, TEXT_POS_Y, "Play a note!");
	}
	
	while (true) {
		if(StdDraw.hasNextKeyTyped()) {
			char key = StdDraw.nextKeyTyped();
			
			int index = keyboard.indexOf(key);
			
			if (index!=-1) {
				notes[index].pluck();
				StdDraw.text(.2, .6, "You played something");
			}
			
			double sample=0;
			
			//haven't figured out what the for loop should go
			for(int i = 0; i<notes.length; i++) {
				sample+= notes[i].sample();
			}
			
			StdAudio.play(sample);
			for (int i = 0; i<notes.length; i++) {
				notes[i].tic();
			}
			
		}
	}
	
	}
}

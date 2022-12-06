public class GuitarHero {
	public static void main(String[] args) {
	String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
	GuitarString[] notes = new GuitarString [37];
	
	for (int i = 0; i<notes.length; i++) {
		int frequency = (int)(440*Math.pow(1.05960, i-25));
		notes[i] = new GuitarString(frequency);
	}
	
	while (true) {
		if(StdDraw.hasNextKeyTyped()) {
			char key = StdDraw.nextKeyTyped();
			
			int index = keyboard.indexOf(key);
			
			if (index!=-1) {
				notes[index].pluck();
			}
			
			double sample;
			
			for(int i = 0; i; i++) {
				sample+= key[i].sample();
			}
			
			StdAudio.play(sample);
			
			
		}
	}
	
	}
}

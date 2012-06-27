public class VocabTrainer {

	private QuizProcess process;

	public static void main(String[] args) {
		VocabTrainer trainer = new VocabTrainer();
		trainer.start();
	}

	public VocabTrainer() {
		process = new QuizProcess();
	}

	public void start() {
		process.run();
	}
}

